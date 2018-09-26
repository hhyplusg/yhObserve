package com.wave.core.plugin.mybatis;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcUtils;
import com.wave.base.vo.BaseVo;
import com.wave.core.util.ClassUtil;
import com.wave.core.util.StringUtil;
 

 
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class MybatisPagePlugin implements Interceptor {
	private  Logger log = LogManager.getLogger(getClass()); 
	private static String dialect = "";	//数据库方言
	private static String pageVoName = "";	//数据库方言
	private static String totalResultsCountName = "";
	private static String pageSqlId = ""; //mapper.xml中需要拦截的ID(正则匹配)
	
	
	public Object intercept(Invocation ivk) throws Throwable {
		if(ivk.getTarget() instanceof RoutingStatementHandler){
			RoutingStatementHandler statementHandler = (RoutingStatementHandler)ivk.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");
			
			if(mappedStatement.getId().matches(pageSqlId+"aaaaa")){ //拦截需要分页的SQL
				BoundSql boundSql = delegate.getBoundSql();
				Object parameterObject = boundSql.getParameterObject();//分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
				if(parameterObject==null){
					//throw new NullPointerException("parameterObject尚未实例化！");
					log.error("方法" + mappedStatement.getId() + "调用时,违法反分页规则!1 必须有参数,2 参数必须就是pageVo或包含pageVo的object.");
				}else{
					
					Connection connection = (Connection) ivk.getArgs()[0];
					String sql = boundSql.getSql();
					// 获取总记录数
					int count = getCount(mappedStatement, boundSql, parameterObject, connection, sql);
				 
					PageVo page = null;
					// 判断被拦截的方法参数是否为PageVo
					if(parameterObject instanceof PageVo){	//参数就是PageVo实体
						 page = (PageVo) parameterObject; 
						 page.setTotalResultsCount(count);
					}else{
					    log.debug("pageVoName===>{}",pageVoName);
					    String pageVoContentName = "";
                        Object pageVoContentValue = null; 
                        Map parameterObjectMap = new HashMap();
                        if (!(parameterObject instanceof BaseVo) && !(parameterObject instanceof PageVo)) {
                            parameterObjectMap = (Map)parameterObject; 
                            for (Object key : parameterObjectMap.keySet()) { 
                                if(key != null && !key.toString().startsWith("param") && 
                                        parameterObjectMap.get(key) != null && parameterObjectMap.get(key) instanceof BaseVo) {
                                    pageVoContentName = key.toString();
                                    pageVoContentValue = parameterObjectMap.get(key);
                                    break;
                                }
                            }
                        }
                        Field pageField = null;
                        // 参数为某个实体，该实体拥有PageVo属性，则取出PageVo属性名称
                        if(pageVoContentValue!= null && pageVoContentValue instanceof BaseVo) {
                            pageField = ReflectHelper.getFieldByFieldName(pageVoContentValue,pageVoName);
                        } else {
                            pageField = ReflectHelper.getFieldByFieldName(parameterObject,pageVoName);
                        }
						 
						// 参数为某个实体中如果PageVo存在，初始化PageVo
						if(pageField!=null){ 
						    if(pageVoContentValue instanceof BaseVo) {
						        // 如果PageVo存在，初始化PageVo,当pageVo中的段在参数中有值时,而pageVo没有设置，调用parameterObject的getPageVo初始化。
	                            page = (PageVo) ClassUtil.invokeMethod(pageVoContentValue, createPageVoGeter() ,null);
	                            page = setTotalReulsCount(count, page);
                                ClassUtil.invokeMethod(pageVoContentValue, createPageVoSeter(),page);
                                parameterObjectMap.put(pageVoContentName, pageVoContentValue);
                               // ReflectHelper.setValueByFieldName(parameterObject,pageVoContentName, pageVoContentValue); //通过反射，对实体对象设置分页对象
						    } else {
						        page = (PageVo) ReflectHelper.getValueByFieldName(parameterObject,pageVoName);
                                if (page == null) {
                                    page = (PageVo) ClassUtil.invokeMethod(parameterObject, createPageVoGeter() ,null);
                                } 
                                 
    							page = setTotalReulsCount(count, page); 
    							ReflectHelper.setValueByFieldName(parameterObject,pageVoName, page); //通过反射，对实体对象设置分页对象
    							Field totalResultsCountField = ReflectHelper.getFieldByFieldName(parameterObject,totalResultsCountName);
    							// 如果参数中有总记当数字段，将值也对其设置
    							if (totalResultsCountField != null) {
    							    ReflectHelper.setValueByFieldName(parameterObject,totalResultsCountName, count); 
    							}
						    }
						}else{
							throw new NoSuchFieldException(parameterObject.getClass().getName()+"不存在 page 属性！");
						}
					}
					String pageSql = generatePageVoSql(sql,page);
					ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); //将分页sql语句反射回BoundSql.
				}
			}
		}
		return ivk.proceed();
	}


	private int getCount(MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject,
			Connection connection, String sql) throws SQLException { 
		String countSql = generateCountSql(sql); //记录统计
		PreparedStatement countStmt = connection.prepareStatement(countSql);
		Configuration configuration = mappedStatement.getConfiguration();
		ParameterHandler parameterHandler = configuration.newParameterHandler(mappedStatement, parameterObject, boundSql);
		
		parameterHandler.setParameters(countStmt);  
		ResultSet rs = countStmt.executeQuery();
		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		rs.close();
		countStmt.close();
		return count;
	}


    private PageVo setTotalReulsCount(int count, PageVo page) {
        if(page == null){ 
            page = new PageVo(); 
        }
        page.setTotalResultsCount(count);
        return page;
    }


    private String createPageVoGeter() {
        return "get" + pageVoName.substring(0,1).toUpperCase() + pageVoName.substring(1, pageVoName.length());
    }

    private String createPageVoSeter() {
        return "set" + pageVoName.substring(0,1).toUpperCase() + pageVoName.substring(1, pageVoName.length());
    }
	  
	/**
	 * pageSize < 1 时，表示不分页
	 * 根据数据库方言，生成特定的分页sql
	 * @param sql
	 * @param page
	 * @return
	 */
	private String generatePageVoSql(String sql,PageVo page){
	    // pageSize < 1 时，表示不分页
		String pageSql = sql;
		if(page!=null && page.getPagesize() > 0 && !StringUtil.isEmpty(dialect)){
			// 起始行数
			int intCurrentRows = page.getPagenum() * page.getPagesize() ;
			if("mysql".equals(dialect)){
				pageSql = PagerUtils.limit(sql, JdbcUtils.MYSQL, intCurrentRows, page.getPagesize());
			}else if("oracle".equals(dialect)){
				pageSql = PagerUtils.limit(sql, JdbcUtils.ORACLE, intCurrentRows, page.getPagesize()); 
			}
		}  
		return pageSql;
	}
	
	/** 
	 * 根据数据库方言，生成count sql,生成的sql中会去掉order by 
	 * @param sql 
	 * @return
	 */
	private String generateCountSql(String sql){
		String countSql;
		if("mysql".equals(dialect)){
			countSql = PagerUtils.count(sql, JdbcUtils.MYSQL);
		}else if("oracle".equals(dialect)){
			countSql = PagerUtils.count(sql, JdbcUtils.ORACLE); 
		} else {
			countSql = "select count(*) from (" + sql+ ")  ALIAS_COUNT";
		} 
		return countSql;
	}
 
	public Object plugin(Object arg0) { 
		return Plugin.wrap(arg0, this);
	}

	public void setProperties(Properties p) {
		dialect = p.getProperty("dialect");
		if (StringUtil.isEmpty(dialect)) {
			try {
				throw new PropertyException("dialect property is not found!");
			} catch (PropertyException e) {
			}
		}
		pageSqlId = p.getProperty("pageSqlId");
		if (StringUtil.isEmpty(pageSqlId)) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			} 
		}
		
		pageVoName = p.getProperty("pageVoName");
        if (StringUtil.isEmpty(pageVoName)) {
            try {
                throw new PropertyException("pageVoName property is not found!");
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }
        
        totalResultsCountName = p.getProperty("totalResultsCountName");
        if (StringUtil.isEmpty(totalResultsCountName)) {
            try {
                throw new PropertyException("totalResultsCountName property is not found!");
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }
	}
	
}
