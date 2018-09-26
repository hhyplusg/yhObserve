package com.wave.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 文件操作的工具类
 *
 */
public class FileUtil extends BaseFileUtil{
    protected transient final static Logger log = LogManager.getLogger(FileUtil.class); 
 
    /**
     * 获取文件创建时间,出错时，取得文件的最终修改日期
     * 
     *	在命令提示符下，执行命令：”cmd.exe /c dir C:\Regx.xml  /tc“ 可以得到如下结果：其中，第四行为文件的创建日期加时间
	 *	 驱动器 C 中的卷是 WINXP
	 *	 卷的序列号是 CC0E-C33B
	 *	
	 *	 C:\ 的目录
	 *	
	 *	2011-06-22  上午 00:22               981 Regx.xml
	 *	               1 个文件            981 字节
	 *	               0 个目录 15,253,053,440 可用字节
     *          
     * @param File _file
     * @return datetime datetime
     */

    public static String getFileCreateDate(File _file) {
        File file = _file;
        try {
        	// 执行命令
            Process ls_proc = Runtime.getRuntime().exec("cmd.exe /c dir " + file.getAbsolutePath() + " /tc");
            // 读取命令执行结果
            BufferedReader br = new BufferedReader(new InputStreamReader(ls_proc.getInputStream()));
            // 跳过前五行
            for (int i = 0; i < 5; i++) {
                br.readLine();
            }
            // 读取第6行中的文件创建日期
            String stuff = br.readLine();
            StringTokenizer st = new StringTokenizer(stuff);
            String dateC = st.nextToken();
            br.close(); 
    		
            return dateC;
        } catch (Exception e) {
        	Date date = new Date();
        	date.setTime(file.lastModified());
            return date.toString();
        }
    }
    
    /**
     * 获取文件创建时间,出错时，取得文件的最终修改日期
     * 
     *  在命令提示符下，执行命令：”cmd.exe /c dir C:\Regx.xml  /tc“ 可以得到如下结果：其中，第四行为文件的创建日期加时间
     *   驱动器 C 中的卷是 WINXP
     *   卷的序列号是 CC0E-C33B
     *  
     *   C:\ 的目录
     *  
     *  2011-06-22  上午 00:22               981 Regx.xml
     *                 1 个文件            981 字节
     *                 0 个目录 15,253,053,440 可用字节
     *          
     * @param File _file
     * @return datetime datetime
     */

    public static Date getFileCreateDateTime(File _file) {
        File file = _file;
        try {
            // 执行命令
            Process ls_proc = Runtime.getRuntime().exec("cmd.exe /c dir " + file.getAbsolutePath() + " /tc");
            // 读取命令执行结果
            BufferedReader br = new BufferedReader(new InputStreamReader(ls_proc.getInputStream()));
            // 跳过前五行
            for (int i = 0; i < 5; i++) {
                br.readLine();
            }
            // 读取第6行中的文件创建日期
            String stuff = br.readLine();
            StringTokenizer st = new StringTokenizer(stuff);
            String dateC = st.nextToken();
            String timeAPm = st.nextToken();
            String time = st.nextToken();
            String datetime = dateC.concat(" " + timeAPm + " ").concat(time).concat(":00");
            br.close();
            
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
            Date date = formater.parse(datetime);
            
            return date;
        } catch (Exception e) {
            Date date = new Date();
            date.setTime(file.lastModified());
            return date;
        }
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inFullFileName= "C:\\Regx.xml";
		//String inFullFileName1= "C:\\000000000000616_1.doc";
		/*System.out.println(FileUtil.changeSuffix(inFullFileName, ".temp"));
		System.out.println(FileUtil.changeSuffix(inFullFileName, "temp"));
		System.out.println(FileUtil.changeSuffix(inFullFileName, ""));
		System.out.println(FileUtil.changeSuffix(inFullFileName, null));*/
		File f = new File(inFullFileName);
		Date date = new Date();
		System.out.println(date); 
    	date.setTime(f.lastModified());
    	System.out.println(date); 
	/*	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		Date date = FileUtil.getFileCreateDate(f);
	 
		System.out.println(date);
		
		 File f1 = new File(inFullFileName1);
	 
		Date date1 = FileUtil.getFileCreateDate(f1);
	 
		System.out.println(date1); 
		*/
		 
		/*Calendar c = Calendar.getInstance(Locale.CHINA);
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");

		
			Date date = formater.parse(datetime);
			System.out.println(date);
		 
		c.setTime(date);
		
		//Date d = new Date("2011-06-22 上午 00:22");
		System.out.println(c.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
	
}


