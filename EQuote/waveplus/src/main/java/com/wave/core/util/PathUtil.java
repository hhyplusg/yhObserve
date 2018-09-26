package com.wave.core.util;

/**
* java类获取web应用的根目录
*/
public class PathUtil { 
	/**
	   * @param args
	   */
	public static void main(String[] args)throws Exception { 
	   System.out.println();
	   System.out.println(PathUtil.getWebClassesPath());
	   System.out.println(PathUtil.getWebInfPath());
	   System.out.println(PathUtil.getWebRoot());
	}
	
	
	/**
	 * /G:/UAMC/SRC/ULServer/WebRoot/WEB-INF/classes/
	 * @return
	 */
	public static String getWebClassesPath() {
	   String path = PathUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	   if (path.startsWith("/")) {
		   path = path.substring(1,path.length()); 
	   }
	   if (path.indexOf("classes")> 1) {
		   path = path.substring(0,path.indexOf("classes")+ 8);
	   }
	   return path;
	  
	}
	
	/**
	 * /G:/UAMC/SRC/ULServer/WebRoot/WEB-INF/
	 * @return
	 * @throws IllegalAccessException
	 */
	public static String getWebInfPath(){
	   String path = getWebClassesPath();
	   if (path.indexOf("WEB-INF") > 0) {
		   path = path.substring(0, path.indexOf("WEB-INF")+8);
	   }
	   if (path.startsWith("/")) {
		   path = path.substring(1,path.length()); 
	   }
	   return path;
	}
	
	/**
	 * /G:/UAMC/SRC/ULServer/WebRoot/
	 * /G:/tomcat/webapps/xh/
	 * @return 服务部署根目录
	 * @throws IllegalAccessException
	 */
	public static String getWebRoot(){
	   String path = getWebClassesPath();
	   if (path.indexOf("WEB-INF") > 0) {
		   path = path.substring(0, path.indexOf("WEB-INF/classes"));
	   } 
	   if (path.startsWith("/")) {
		   path = path.substring(1,path.length()); 
	   }
	   return path;
	}
	
	/**
     * Tomcat 安装目录
     */
    public static String getWebServerRoot(){
       String path = System.getProperty("catalina.home"); 
       return path;
    }
	 /**
     * /G:/UAMC/SRC/ULServer/WebRoot/
     * /G:/tomcat/webapps/xh/
     * @return 服务部署根盘符G:/
     * @throws IllegalAccessException
     */
    public static String getAppRoot(){
       String path = getWebClassesPath(); 
       return path.substring(0,3);
    }
} 
