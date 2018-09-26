package com.wave.core.plugin.mybatis;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLObject;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelect;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.parser.SQLParserUtils;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.alibaba.druid.util.JdbcUtils;
/**
SELECT语句的完整语法为： 
SELECT[ALL|DISTINCT|DISTINCTROW|TOP] 
{*|talbe.*|[table.]field1[AS alias1][,[table.]field2[AS alias2][,…]]} 
FROM tableexpression[,…][IN externaldatabase] 
[WHERE…] 
[GROUP BY…] 
[HAVING…] 
[ORDER BY…] 
[WITH OWNERACCESS OPTION] 
 * */
public class SQLUtil { 
	 
	 public static String getPaginationSql (String sql, String dbType) {
		 String strSql = "";
		 //
		 if (JdbcUtils.ORACLE.equals(dbType)) {
			 
			 strSql = SQLUtils.addSelectItem(sql, "ROWNUM", "row_id", JdbcUtils.MYSQL);
			 
		 } else if (JdbcUtils.MYSQL.equals(dbType)) {
			 
		 } else {
			 strSql = sql;
		 }
		 
		return strSql;
		 
		 
	 }
	 
	 
	 public static String getCountSql (String sql, String dbType) {
		 String strSql = "";
		 //
		 if (JdbcUtils.ORACLE.equals(dbType)) {
			 
			 strSql = SQLUtils.addSelectItem(sql, "ROWNUM", "row_id", JdbcUtils.MYSQL);
			 SQLStatementParser parser = SQLParserUtils.createSQLStatementParser(sql, JdbcUtils.MYSQL);
			 SQLSelectStatement stmt = (SQLSelectStatement)parser.parseSelect();
			 SQLSelect sqlSelect = stmt.getSelect();
			 SQLSelectQueryBlock selectQuery = (SQLSelectQueryBlock) sqlSelect.getQuery();
			 // 去掉order by 
			 selectQuery.setOrderBy(null);
			  
			 
		 } else if (JdbcUtils.MYSQL.equals(dbType)) {
			 
		 } else {
			 strSql = sql;
		 }
		 
		return strSql;
		 
		 
	 }
	public static void main(String[] args) {
		String sql = "select p, s.count as views, (select count(*) from Comments rc where rc.linkedId=p.id and rc.classcode='InfoPublishs') as commentNumber, (select count(*) from CollectIndexs rci where rci.toId=p.id and rci.classcode='InfoPublishs' and rci.type='favorite') as favorite FROM InfoPublishs p,UserScores s where p.id=s.linkedId and p.userInfo.id=s.userInfo.id and s.classCode='InfoPublishs' AND p.status=? group by p ORDER BY p.createtime DESC";
		StringBuffer select = new StringBuffer();
		StringBuffer from = new StringBuffer();
		StringBuffer where = new StringBuffer();
		StringBuffer groupby = new StringBuffer();
		StringBuffer orderby = new StringBuffer();
		String strsql = SQLUtils.addSelectItem(sql, "ROWNUM", "row_id", JdbcUtils.ORACLE);
		
		 
		System.out.println(strsql);
		// parser得到AST
		SQLStatementParser parser = SQLParserUtils.createSQLStatementParser(sql, JdbcUtils.ORACLE);
		SQLSelectStatement stmt = (SQLSelectStatement)parser.parseSelect();
		List<SQLStatement> stmtList = new ArrayList<SQLStatement>();
		stmtList.add(stmt); 
		// 将AST通过visitor输出 
		SQLASTOutputVisitor fromVisitor = SQLUtils.createFormatOutputVisitor(from, stmtList, JdbcUtils.ORACLE);
		SQLASTOutputVisitor whereVisitor = SQLUtils.createFormatOutputVisitor(where, stmtList, JdbcUtils.ORACLE); 
		SQLASTOutputVisitor groupbyVisitor = SQLUtils.createFormatOutputVisitor(groupby, stmtList, JdbcUtils.ORACLE); 
		SQLASTOutputVisitor orderbyVisitor = SQLUtils.createFormatOutputVisitor(orderby, stmtList, JdbcUtils.ORACLE); 
		SQLSelect sqlSelect = stmt.getSelect();
		SQLSelectQueryBlock selectQuery = (SQLSelectQueryBlock) sqlSelect.getQuery();
		
		// 获取字段别名
		List<SQLSelectItem> itemList = selectQuery.getSelectList();
		for (int i = itemList.size(); i < itemList.size(); i--) {
			itemList.remove(i);
		}
		System.out.println("filed===>>>");
		String filedAlia;
		for(SQLSelectItem sQLSelectItem:itemList){
			filedAlia = sQLSelectItem.getAlias();
			if (filedAlia == null) {
				filedAlia = sQLSelectItem.toString();
			} 
			System.out.println(filedAlia);
		}
		System.out.println("***************");
		SQLObject sQLObject;
		sQLObject = selectQuery.getFrom();
		outPutAccept(fromVisitor, sQLObject);
		sQLObject = selectQuery.getWhere();
		outPutAccept(whereVisitor, sQLObject);
		sQLObject = selectQuery.getGroupBy();
		outPutAccept(groupbyVisitor, sQLObject);
		sQLObject = selectQuery.getOrderBy(); 
		outPutAccept(orderbyVisitor, sQLObject);
		System.out.println("from===>\r\n" + from);
		System.out.println("where===>\r\n" + where);
		System.out.println("groupby===>\r\n" + groupby);
		System.out.println("orderby===>\r\n" + orderby);
		
		// 去掉order by 
		selectQuery.setOrderBy(null);
		System.out.println("sql===>\r\n" + selectQuery.toString());
		
		String pageSql = PagerUtils.limit(strsql, JdbcUtils.ORACLE, 10, 10);
		String countSql = PagerUtils.count(strsql, JdbcUtils.ORACLE);
		System.out.println("pageSql===>\r\n" + pageSql);
		System.out.println("pageSql===>\r\n" + countSql);
		/*List<SQLSelectItem> items = null;
		 
		for (SQLStatement stmt : stmtList) {
			// stmt.accept(visitor);
			if (stmt instanceof SQLSelectStatement) {
				SQLSelectStatement sstmt = (SQLSelectStatement) stmt;
				SQLSelect sqlselect = sstmt.getSelect();
				SQLSelectQueryBlock query = (SQLSelectQueryBlock) sqlselect
						.getQuery();

				query.getFrom().accept(visitor);
				query.getWhere().accept(whereVisitor);
				List<SQLSelectItem> ss = query.getSelectList();
				for (int i = 0; i < ss.size(); i++) {
				 
					SQLSelectItem sqlSelectItem = (SQLSelectItem) ss.get(i);
					String str= sqlSelectItem.getAlias();
					 
					//System.out.println("i====>" + str);
				}
				items = query.getSelectList();
			}
		}
		for(SQLSelectItem s:items){
			System.out.println(s.getAlias());
		}*/
		
		System.out.println("--------------------------------");

	/*	System.out.println("from=="+from.toString());
		System.out.println("select=="+select);
		System.out.println("where=="+where);*/
	}
	private static void outPutAccept(SQLASTOutputVisitor fromVisitor, SQLObject sQLObject) {
		if (sQLObject != null) {
			sQLObject.accept(fromVisitor);
		}
	}
 
	

}
