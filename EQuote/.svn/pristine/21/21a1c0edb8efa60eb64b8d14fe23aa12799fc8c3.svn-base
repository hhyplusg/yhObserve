package com.wave.core.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 本工具用于生成指定数据库的表与视图对应的VO类，支持全库生成或指定某些表生成。
 * vo类中包含
 * package、import、private 字段声明、get set 方法、toString、compareTo等方法;
 * 字段声明z注释包含以下内容：
 * 1、默认的列的标题:navigator->对应导航,ebm字段
 * 2、字段名称:navigator
 * 3、数据类型名:VARCHAR
 * 4、数据类型的类:String
 * 5、数据库中类型的最大字符个数:20
 * 6、类型的精确度(类型的长度):20
 * 7、小数点后的位数:0
 * 8、是否为空:0表示不空空，1表示可为空
 * 
 * */
public class VoToolUtil { 
    public static void main(String[] args) {
  
    	try {
    		System.out.println("Start"); 
	    	VoToolUtil vt = new VoToolUtil();
	    	vt.setDbDrive("oracle.jdbc.OracleDriver");
	    	vt.setDbUrl("jdbc:oracle:thin:@59.175.207.42:1521:smz");
	    	vt.setDbUser("hbbb");
	    	vt.setDbPassword("hbbb");
	    	// 要去掉的表名前缀 
	    	TABLES_INITIALS = new ArrayList<String>();
	    	TABLES_INITIALS.add("hs_"); 
	    	// BaseVo中的字段列表,用于生成toString()
	    	BASE_VO_FIELDS = new ArrayList<String>();
	    	BASE_VO_FIELDS.add("creater");
	    	BASE_VO_FIELDS.add("createtime");
	    	BASE_VO_FIELDS.add("updater");
	    	BASE_VO_FIELDS.add("updateTime"); 
	        
	    	// 生成的vo的package  
	    	String strVoPackage = "sqlite"; 
	   		List<String> tablesLst = new ArrayList<String>();
	   		// 全库生成Vo类
	   		//tablesLst = vt.getAllTables(vt.getConnection());
	   		//tablesLst.add("hs_et_subject_course");
	   		// 指定表名或视图名生成Vo类
	   		String tables = "B_BIANZHI_DISASSEMBLE_REC,B_BIANZHI_DISASSEMBLE_TOTAL,B_UNDISTRIBUTED_ADJUSTMENT_REC,COUNTRY,C_APPROVAL,C_AREA_INFO,C_AREA_SYS,C_BIZ_PIWEN_INFO,C_CLOB_CONTENT,C_DICT,C_FILE_INFO,C_PIWEN_INFO,J_DATA_SWAP,J_INNER_ORG,J_INNER_ORG_REC,J_ORG_HISTORY_REC,J_ORG_INFO,J_ORG_INFO_REC,R_LAYOFFS_RETIREMENT_STAFF,R_LAYOFFS_RETIREMENT_STAFF_REC,R_NON_PLANED_STAFF,R_NON_PLANED_STAFF_REC,R_PHOTO,R_PLANED_STAFF,R_PLANED_STAFF_REC,R_STAFF_CHANGE,R_STAFF_RESUME,S_FUNCTION_INFO,S_LOGS,S_OPERATION_LOGS_INFO,S_ROLE,S_ROLE_FUNCTION,S_ROLE_ORG,S_ROLE_USER,S_USER,Y_YONGBIAN_APPLY,Y_YONGBIAN_FILE";
	   		tablesLst = Arrays.asList(tables.split(","));
	   		// tablesLst.add("r_planed_staff"); 
	   	    // tablesLst.add("r_non_planed_staff"); 
	   	    // tablesLst.add("r_layoffs_retirement_staff"); 
	   		
	   		
	   		 // 生成VOjson类
   			//vt.CrateVoJSON(vt.getConnection(), tablesLst,strVoPackage);
   			// 生成VO类
   			// vt.CrateVo(vt.getConnection(), tablesLst,strVoPackage);
	   	     //生成vo类型对应的sql表结构
   			vt.CrateVoSqlite(vt.getConnection(), tablesLst,strVoPackage);
   			
   			System.out.println("End");  
   		} catch (Exception e) { 
   			e.printStackTrace();
   		}  
   	}
    
	/**
	 * 获取数据库链接
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		System.out.println("dbDrive=" + dbDrive);
		System.out.println("dbUrl=" + dbUrl);
		System.out.println("dbUser=" + dbUser);
		System.out.println("dbPassword=" + dbPassword);
		Class.forName(dbDrive);
		conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return conn;
	}
	/**
	 * 获取数据库中所有表名与视图名
	 * @param conn Connection
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * */
	public List<String> getAllTables(Connection conn) throws SQLException {
		DatabaseMetaData md = conn.getMetaData();
		ResultSet rs = md.getTables(null, null, null, null);
		try { 
			int i = 1;
			List<String> tablelst = new ArrayList<String>();
			String strTablename = null;
			while (rs.next()) {
				if (i == 1) {
					System.out.println("|库名：" + rs.getString(1));
				}
				strTablename = rs.getString("TABLE_NAME");
				System.out.println("|表" + (i++) + ":" + strTablename);
				tablelst.add(strTablename);
			}
			return tablelst;
		} finally {
			if (rs != null) {
				rs.close();
			} 
		} 
	}  
	/**
     * 生成表Vo对应的sqlite数据库脚本模型
     * @throws Exception 
     * */
    public void CrateVoSqlite(Connection conn,List<String> tablesLst,String strPackage) throws Exception {
        if (tablesLst.size() < 1) {
            throw new Exception("数据库中没有表信息或未指定表名或视图名！");
        }
        // 如果未指定包名，则默认为“vo”
        if (strPackage == null || strPackage == "") {
            strPackage = "voSQL";
        }
        PreparedStatement stmt;
        ResultSet rs;
        ResultSetMetaData data;
        // 查询所有表的sql
        String sql;
        // Vo类中所有字段信息
        StringBuilder sbFildsInfo ;  

        StringBuilder sbFile ; 
        // 表名
        String strTableName;
        // 
        String strVoClassname = "createSqlite";
        // 每张表的字段注释信息
        Map<String,String> fieldsComment;
        // 默认的列的标题
        String columnLabel; 
        String columnComment;
        // 获得指定列的列名
        String columnName;
        // 对应数据类型的类
        String columnClassName;
        // 生成每张表的vo类
        
        sbFildsInfo = new StringBuilder(); 
        for (int i = 0; i < tablesLst.size(); i++) { 
            // 获取表名
            strTableName = tablesLst.get(i);
            System.out.println("表" + strTableName + "的VOJSON生成开始!"); 
            
            sql = SELECT_SQL + strTableName + " where 1=0";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            data = rs.getMetaData();
            
            sbFile = new StringBuilder(); 
           
             fieldsComment = getFieldsComment(conn,strTableName);  
             
             
             //db.createTable('people', 'name TEXT, age INTEGER');
             sbFildsInfo.append("db.createTable('").append(strTableName).append("', '");
            for (int j = 1; j <= data.getColumnCount(); j++) { 
                // 默认的列的标题
                columnLabel = data.getColumnLabel(j); 
                columnComment = fieldsComment.get(columnLabel.toLowerCase());
                
                // 对应数据类型的类
               // columnClassName = data.getColumnClassName(j);
               // columnClassName = columnClassName.substring(columnClassName.lastIndexOf(".")+1);
                 
                // 获得指定列的列名
                columnName = fieldsFormat(data.getColumnName(j));
                
                // 过滤在BaseVo中存在的字段
                if (BASE_VO_FIELDS.contains(columnName.toLowerCase())) {
                    continue;
                }
                sbFildsInfo.append(columnName).append(" TEXT, ");  
            }  
            sbFildsInfo.deleteCharAt(sbFildsInfo.length() - 2);
            sbFildsInfo.append("');");
            sbFildsInfo.append("\r\n");
            System.out.println("表" + strTableName + "的sqlite数据库脚本生成结束!"); 
        }
        createFile(strPackage,strVoClassname,sbFildsInfo.toString());
        System.out.println("vo:" + strVoClassname + ".sql已生成!"); 
        
        
        
    }
    /**
     * 生成表Vo对应的json模型
     * @throws Exception 
     * */
    public void CrateVoJSON(Connection conn,List<String> tablesLst,String strPackage) throws Exception {
        if (tablesLst.size() < 1) {
            throw new Exception("数据库中没有表信息或未指定表名或视图名！");
        }
        // 如果未指定包名，则默认为“vo”
        if (strPackage == null || strPackage == "") {
            strPackage = "voJSON";
        }
        PreparedStatement stmt;
        ResultSet rs;
        ResultSetMetaData data;
        // 查询所有表的sql
        String sql;
        // Vo类中所有字段信息
        StringBuilder sbFildsInfo ;  

        StringBuilder sbFile ; 
        // 表名
        String strTableName;
        // 类型
        String strVoClassname;
        // 每张表的字段注释信息
        Map<String,String> fieldsComment;
        // 默认的列的标题
        String columnLabel; 
        String columnComment;
        // 获得指定列的列名
        String columnName;
        
        // 生成每张表的vo类
        for (int i = 0; i < tablesLst.size(); i++) { 
            // 获取表名
            strTableName = tablesLst.get(i);
            System.out.println("表" + strTableName + "的VOJSON生成开始!"); 
            
            sql = SELECT_SQL + strTableName + " where 1=0";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            data = rs.getMetaData();
            sbFildsInfo = new StringBuilder(); 
            sbFile = new StringBuilder(); 
             fieldsComment = getFieldsComment(conn,strTableName); 
             strVoClassname = createVoClassName(strTableName);
            for (int j = 1; j <= data.getColumnCount(); j++) { 
                // 默认的列的标题
                columnLabel = data.getColumnLabel(j); 
                columnComment = fieldsComment.get(columnLabel.toLowerCase());
                // 获得指定列的列名
                columnName = fieldsFormat(data.getColumnName(j));
                // 过滤在BaseVo中存在的字段
                if (BASE_VO_FIELDS.contains(columnName.toLowerCase())) {
                    continue;
                }
               
                sbFildsInfo.append("{\"text\":\"").append(columnComment).append("\",\"datafield\":\"").append(columnName).append("\"},");
               
     
            }  
            createFile(strPackage,strVoClassname,sbFildsInfo.toString());
            System.out.println("vo:" + strVoClassname + ".java已生成!"); 
            
            System.out.println("表" + strTableName + "的json生成结束!"); 
        }
    }	
	/**
	 * 获取数据库中所有表名
	 * @throws Exception 
	 * */
	public void CrateVo(Connection conn,List<String> tablesLst,String strPackage) throws Exception {
		if (tablesLst.size() < 1) {
   			throw new Exception("数据库中没有表信息或未指定表名或视图名！");
   		}
		// 如果未指定包名，则默认为“vo”
		if (strPackage == null || strPackage == "") {
			strPackage = "vo";
   		}
		PreparedStatement stmt;
		ResultSet rs;
		ResultSetMetaData data;
		// 查询所有表的sql
		String sql;
		// Vo类中所有字段信息
		StringBuilder sbFildsInfo ; 
		// Vo类中，所以GetSet方法信息
		StringBuilder sbFildsGetSetMethod ;
		// Vo类中，toString()方法信息
		StringBuilder sbFildsToStringMethod ;
		// Vo类中，compareTo()方法信息
		StringBuilder sbFildscompareToMethod ;
		// Vo类信息
		StringBuilder sbFile ;
		// Vo类中所有字段的数据java类型，用于import
		Set<String> importClassSet;
		// 表名
		String strTableName;
		// 类型
		String strVoClassname;
		// 每张表的字段注释信息
		Map<String,String> fieldsComment;
		// 默认的列的标题
		String columnLabel; 
		String columnComment;
		// 获得指定列的列名
		String columnName;
		// 获得指定列的数据类型名
		String columnTypeName;
		// 对应数据类型的类
		String columnClassName;;
		// 在数据库中类型的最大字符个数
		int columnDisplaySize;
		// 某列类型的精确度(类型的长度)
		int precision;
		// 小数点后的位数
		int scale;  
		// 是否为空
		int isNullable;
		// 临时字符串
		String strTemp;
		// 生成每张表的vo类
		for (int i = 0; i < tablesLst.size(); i++) { 
			// 获取表名
			strTableName = tablesLst.get(i);
			System.out.println("表" + strTableName + "的VO生成开始!"); 
			
			sql = SELECT_SQL + strTableName + " where 1=0";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			data = rs.getMetaData();
			sbFildsInfo = new StringBuilder();
			sbFildsGetSetMethod = new StringBuilder(); 
			sbFile = new StringBuilder();
			sbFildsToStringMethod = new StringBuilder();
			sbFildsToStringMethod
			.append("	/**").append(CRLF)
			.append("	 * @see java.lang.Object#toString()").append(CRLF)
			.append("	 * @return String").append(CRLF)
			.append("	 * */").append(CRLF)
			.append("	public String toString() {").append(CRLF)
			.append("		return new ToStringBuilder(this)").append(CRLF);
			strVoClassname = createVoClassName(strTableName);
			sbFildscompareToMethod = new StringBuilder(); 
			sbFildscompareToMethod
			.append("	/**").append(CRLF)
			.append("	 * @see java.lang.Comparable#compareTo(Object)").append(CRLF)
			.append("	 * @return int").append(CRLF)
			.append("	 * */").append(CRLF)
			.append("	public int compareTo(Object object) {").append(CRLF)
			.append("		").append(strVoClassname).append(" myClass = (").append(strVoClassname).append(") object;").append(CRLF)
			.append("		return new CompareToBuilder().appendSuper(super.compareTo(object))").append(CRLF);
			 fieldsComment = getFieldsComment(conn,strTableName);
			 importClassSet = new HashSet<String>();
			for (int j = 1; j <= data.getColumnCount(); j++) { 
				// 默认的列的标题
				columnLabel = data.getColumnLabel(j); 
				columnComment = fieldsComment.get(columnLabel.toLowerCase());
				// 获得指定列的列名
				columnName = fieldsFormat(data.getColumnName(j));
				// 过滤在BaseVo中存在的字段
				if (BASE_VO_FIELDS.contains(columnName.toLowerCase())) {
					continue;
				}
				// 获得指定列的数据类型名
				columnTypeName = data.getColumnTypeName(j);
				// 对应数据类型的类
				columnClassName = data.getColumnClassName(j);
				// 字段类型名，含包结构。用于类的import
				importClassSet.add(columnClassName);
				// 字段类型名，去除包结构。用于生成set方法
				columnClassName = columnClassName.substring(columnClassName.lastIndexOf(".")+1);
				// 在数据库中类型的最大字符个数
				columnDisplaySize = data.getColumnDisplaySize(j);
				// 某列类型的精确度(类型的长度)
				precision = data.getPrecision(j);
				// 小数点后的位数
				scale = data.getScale(j);  
				// 是否为空 
				isNullable = data.isNullable(j);
				sbFildsInfo.append("	/*").append(CRLF)
				.append("	 * 默认的列的标题:").append(columnLabel).append("->").append(columnComment).append(CRLF)
				.append("	 * 字段名称:").append(columnName).append(CRLF)
				.append("	 * 数据类型名:").append(columnTypeName).append(CRLF)
				.append("	 * 数据类型的类:").append(columnClassName).append(CRLF)
				.append("	 * 数据库中类型的最大字符个数:").append(columnDisplaySize).append(CRLF)
				.append("	 * 类型的精确度(类型的长度):").append(precision).append(CRLF)
				.append("	 * 小数点后的位数:").append(scale).append(CRLF) 
				.append("	 * 是否为空(0表示不空空，1表示可为空):").append(isNullable).append(CRLF)
				.append("	 * */").append(CRLF)
				.append("	private ").append(columnClassName).append(DBC_CASE_SPACE).append(columnName).append(SEMICOLON).append(CRLF).append(CRLF);
				 
				sbFildsGetSetMethod
				.append("	/**").append(CRLF)
				.append("	* 取得 ").append(columnLabel).append(":").append(columnComment).append(CRLF)
				.append("	* @return ").append(columnName).append(DBC_CASE_SPACE).append(columnClassName).append(CRLF)
				.append("	* @param ").append(columnName).append(DBC_CASE_SPACE).append(columnClassName).append(CRLF)
				.append("	 * */").append(CRLF)
				.append("	public void set").append(initialsToUpperCase(columnName)).append("(").append(columnClassName).append(DBC_CASE_SPACE).append(columnName).append(") {").append(CRLF)
				.append("	    this.").append(columnName).append(" = ").append(columnName).append(SEMICOLON).append(CRLF)
				.append("	}").append(CRLF).append(CRLF)
				 
				.append("	/**").append(CRLF)
				.append("	* 设置 ").append(columnLabel).append(":").append(columnComment).append(CRLF)
				.append("	* @return ").append(columnName).append(DBC_CASE_SPACE).append(columnClassName).append(CRLF)
				.append("	 * */").append(CRLF)
				.append("	public ").append(columnClassName).append(" get").append(initialsToUpperCase(columnName)).append("() {").append(CRLF)
				.append("	    return  this.").append(columnName).append(SEMICOLON).append(CRLF)
				.append("	}").append(CRLF).append(CRLF);
				
				sbFildsToStringMethod
				.append("		.append(\"").append(columnName).append("\", this.").append(columnName).append(")").append(CRLF);
				
				sbFildscompareToMethod
				.append("		.append(this.").append(columnName).append(", myClass.").append(columnName).append(")").append(CRLF);
	 
			} 
			 
			 
			for (int k = 0; k < VoToolUtil.BASE_VO_FIELDS.size(); k++) {
				strTemp = BASE_VO_FIELDS.get(k);
				sbFildsToStringMethod.append("		.append(\"" + strTemp + "\", super.get" + VoToolUtil.initialsToUpperCase(strTemp) + "())").append(CRLF);
			}
			sbFildsToStringMethod.append("		.toString();").append(CRLF);
			sbFildsToStringMethod.append("	}");
			
			sbFildscompareToMethod
			.append("		.toComparison();").append(CRLF)
			.append("	}").append(CRLF);
			 
			sbFile.append(VO_FILE_HEAD.toString()
					.replace("{VoName}", strVoClassname)
					.replace("{columnClassName}", getImportClass(importClassSet))
					.replace("{package}", strPackage));
			
			sbFile
			.append(sbFildsInfo)
			.append(sbFildsGetSetMethod)
			.append(sbFildsToStringMethod)
			.append(sbFildscompareToMethod)
			.append("}"); 
			createFile(strPackage,strVoClassname,sbFile.toString());
			System.out.println("vo:" + strVoClassname + ".java已生成!"); 
			
			System.out.println("表" + strTableName + "的VO生成结束!"); 
		}
 
	}
	/**
	 * 取得字段的类名，用于导入类
	 * @param importClassSet HashSet
	 * */
	public static String getImportClass(Set<String> importClassSet) {
		StringBuilder sbImportClass = new StringBuilder();
		Iterator<String> iterator = importClassSet.iterator();
		while(iterator.hasNext()){ 
			sbImportClass.append("import ").append(iterator.next()).append(SEMICOLON).append(CRLF);
		}
		return sbImportClass.toString(); 
	}
	
	/**
	 * 将字段首字母大写
	 * @param strFieldName String
	 * */
	public static String initialsToUpperCase(String strFieldName) {
		if (strFieldName == null || strFieldName == "") {
			return strFieldName;
		}
		strFieldName = strFieldName.substring(0,1).toUpperCase() + strFieldName.substring(1);
		return strFieldName; 
	}
		
	/**
	 *  
	 * 取得表中字段的注释
	 * @param conn Connection
	 * @param strTableName String
	 * @throws SQLException 
	 * */
	public static Map<String,String> getFieldsComment(Connection conn,String strTableName) throws SQLException {
		 Map<String,String> tableMap = new HashMap<String,String>();
		if (strTableName == null || strTableName == "") {
			return tableMap;
		} 
		String sql = "SELECT * FROM user_col_comments WHERE TABLE_NAME ='" + strTableName.toUpperCase() + "'";
		 
		PreparedStatement  stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
		 
		while(rs.next()) {
			tableMap.put(rs.getString("COLUMN_NAME").toLowerCase(), rs.getString("COMMENTS"));
		} 
		if (rs != null) {
			rs.close();
		}
		return tableMap; 
	}	
	/**
	 *  
	 * 生成vo类名
	 * @param strTableName String
	 * */
	public static String createVoClassName(String strTableName) {
		if (strTableName == null || strTableName == "") {
			return strTableName;
		} 
		String strTablesInitials;
		strTableName = strTableName.toLowerCase();
		for(int i = 0; i < TABLES_INITIALS.size(); i++ ) {
			strTablesInitials = TABLES_INITIALS.get(i).toLowerCase();
			if (strTableName.startsWith(strTablesInitials)) {
				strTableName = strTableName.substring(strTablesInitials.length());
				break;
			}
		}
		StringBuilder sbVoName = new StringBuilder();
		String strWord[] = strTableName.split("_");
		for (int i = 0; i < strWord.length; i++ ) {
			sbVoName.append(initialsToUpperCase(strWord[i]));
		}
		sbVoName.append("Vo");
		 
		return sbVoName.toString(); 
	}
	/**
	 * 生成vo类文件 
	 * @param strPackage String
	 * @param strVoName String
	 * @param strData String
	 * */ 
	public void createFile(String strPackage,String strVoName,String strData) throws IOException {
		if (VO_PATH == null || VO_PATH == "") {
			VO_PATH = this.getclassPath();
		} 
		File filePath = new File(VO_PATH + "src/" + strPackage.replace(".", "/"));
		
		// 如果文件夹不存在，创建文件夹
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		// fileName表示你创建的文件名；为java类型； 
		File vofile = new File(filePath, strVoName+".java");
		System.out.println(vofile.getPath());
		// 如果文件存在，则删除它
		if (vofile.exists()) { 
			vofile.delete(); 
		}
		// 创建一个新文件
		vofile.createNewFile(); 
		FileWriter writer = new FileWriter(vofile); 
		PrintWriter pw = new PrintWriter(writer);
		pw.println(strData);
		pw.flush();
		writer.close(); 

	}
	/**
	 * CLASSPATH路径
	 * D:/Workspaces/Test/
	 * @return
	 */
	 public String getclassPath() {
	       String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	       if (path.startsWith("/")) {
	           path = path.substring(1,path.length()); 
	       }
	       if (path.indexOf("/bin/")> 1) {
	           path = path.substring(0,path.indexOf("/bin/") + 1);
	       } else if (path.indexOf("WebRoot/")> 1) {
	           path = path.substring(0,path.indexOf("/WebRoot/") + 1);
	       } else if (path.indexOf("/target/")> 1) {
	           path = path.substring(0,path.indexOf("/target/") + 1) + PROJECT_NAME;
        }
	       
	       return path; 
	    } 

	
    /**
     * 回车换行
     */
    public static String CRLF = "\r\n";
    /**
     * 半角空格
     */
    public static String  DBC_CASE_SPACE = " ";
    /**
     * 英文分号 ";"
     */
    public static String  SEMICOLON = ";";
    
    /**
     * select * from
     */
    public static String SELECT_SQL  = "select * from ";
    
    /**
     * 要去掉的表名前缀 
     */
    public static List<String> TABLES_INITIALS;
    
    /**
     *  生成VO的文件夹 
     */
    public static String VO_PATH;
    
    /**
     * file title
     */
    public static StringBuilder VO_FILE_HEAD;
    
    /**
     * file title
     */
    public static String PROJECT_NAME = "";
    
    
    /**
     * BaseVo中的字段列表
     */
    public static List<String> BASE_VO_FIELDS;
    static {
    	VO_FILE_HEAD = new StringBuilder();
    	VO_FILE_HEAD
    	.append("package {package};").append(CRLF).append(CRLF)
    	.append("import com.hbbb.base.vo.BaseVo;").append(CRLF)
    	.append("import org.apache.commons.lang.builder.ToStringBuilder;").append(CRLF)
    	.append("import org.apache.commons.lang.builder.CompareToBuilder;").append(CRLF)
    	.append("{columnClassName}")
    	.append("/**").append(CRLF)
    	.append(" * {VoName} entity. ").append(CRLF)
    	.append(" * @author wave Persistence Tools").append(CRLF)
    	.append(" */").append(CRLF)
    	.append("public class {VoName}  extends BaseVo {").append(CRLF);  
    } 
    
    public static String fieldsFormat(String strField){
        strField = strField.toLowerCase();
        String[] arrTemp = strField.split("_");
        StringBuffer sBuffer = new StringBuffer();
       for (int i = 0; i < arrTemp.length; i++) {
           String str = arrTemp[i];
           if ( i > 0) {
               str = initialsToUpperCase(str);
           }
           sBuffer.append(str);
       }
        return sBuffer.toString();
    }
    
	private String dbDrive;
	private String dbUrl;
	private String dbUser;
	private String dbPassword;

	public String getDbDrive() {
		return dbDrive;
	}
	
	public void setDbDrive(String dbDrive) {
		this.dbDrive = dbDrive;
	}
	
	public String getDbUrl() {
		return dbUrl;
	}
	
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	
	public String getDbUser() {
		return dbUser;
	}
	
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	
	public String getDbPassword() {
		return dbPassword;
	}
	
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
}
