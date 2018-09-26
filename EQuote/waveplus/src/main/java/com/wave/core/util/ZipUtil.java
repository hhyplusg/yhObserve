package com.wave.core.util;


/**
 * 功能:使用Apache Ant里提供的org.apache.tools.zip实现zip压缩和解压 (支持中文文件名)
 * 下面是java中的zip压缩代码，用到apache的zip类,在ant.jar里，与java.util.zip不同的是，
 * apache解决了中文字符乱码问题。
 * */
 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import com.wave.base.constant.ErrorConstants;
import com.wave.base.exception.UtilException;
 

public class ZipUtil { 
	protected transient final static Logger log = LogManager.getLogger(ZipUtil.class); 
	/** 
     * 使用GBK编码可以避免压缩中文文件名乱码 
     */  
    private static final String CHINESE_CHARSET = "GBK";  
      
    /** 
     * 文件读取缓冲区大小 
     */  
    private static final int CACHE_SIZE = 1024;  
    public static void main(String[] args) {
            String strDestFullFileName = "d:/ziptest/textZip.zip";
            List<String> list = new ArrayList<String>();
            list.add("D:/ziptest/新建文件夹/新建文件夹/新建文件夹/新建文本文档.txt");
            list.add("D:/ziptest/新建文件夹/新建文件夹1/新建文件夹/新建文本文档.txt");
            list.add("D:/ziptest/新建文件夹/新建文件夹/新建文本文档.txt");
            list.add("D:/ziptest/新建文件夹/新建文件夹1/新建文本文档.txt"); 
            list.add("D:/ziptest/新建文件夹/新建文本文档.txt");
            list.add("D:/ziptest/新建文本文档.txt");
            try {
				//ZipUtil.ZipFiles(list, "D:/ziptest/",strDestFullFileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            log.debug("zip OK");
             
            ZipUtil.unZipFiles(strDestFullFileName, "d:/ziptest/unZip2");
            
            log.debug("unzip OK");
       
    }  
    public static void test() {
        // 压缩
        String baseDirName = "C:\\";
        String[] fileNames = { "中文1.doc", "中文2.doc" };
        String zipFileName = "c:\\中文.zip";
        // 压缩多个指定的文件 到ZIP
         log.debug(ZipUtil.zip(baseDirName, fileNames,zipFileName,"GBK"));

        //压缩一个文件夹 到ZIP
        String sourcePath = "c:\\test\\";
        String zipFilePath = "c:\\中文2.zip";
        ZipUtil.zip(sourcePath, zipFilePath); 
        //解压缩 
    }
    /**
     * @param strFullFileNameList 要压缩的文件列表
     * @param srcFileLocalFolder  要压缩的文件列表 本地根目录
     * @param strDestFullFileName 压缩的目标文件
     * @throws Exception 
     */
    public static void ZipFiles(List<String> strFullFileNameList, String srcFileLocalFolder ,String strDestFullFileName) throws UtilException {
    	log.debug("ZipFiles() Start");
    	ZipUtil zipUtil = new ZipUtil();
        //默认的相对地址，为根路径
        String defaultParentPath = "";
        ZipOutputStream zos = null;
        try {
            //创建一个Zip输出流
            zos = new ZipOutputStream(new FileOutputStream(strDestFullFileName));
            zos.setEncoding(CHINESE_CHARSET);  
            //启动压缩进程
            File file = null;
            for (String fileName : strFullFileNameList) { 
	            file = new File(fileName);
	            // 获取文件相对目录
	            defaultParentPath = FileUtil.getFilePath(fileName).substring(srcFileLocalFolder.length());
	            if (file.isFile()) {
	            	zipUtil.compressFile(zos,defaultParentPath,file);
	            }
            }
        } catch (FileNotFoundException e){
        	log.error("将文件压缩成zip文件时，源文件不存在！",e);
			throw new UtilException("将文件压缩成zip文件时，源文件不存在！",e,
					ErrorConstants.EXCEPTION_SOURCE_DATABASE,
					ErrorConstants.EXCEPTION_SEVERITY_LOW);
        } finally{
        	log.debug("ZipFiles() End");
            try {
                if(zos != null)zos.close();
            } catch (IOException e) {
            	log.error("将文件压缩成zip文件时出错！",e);
    			throw new UtilException("将文件压缩成zip文件时，源文件不存在！",e,
    					ErrorConstants.EXCEPTION_SOURCE_DATABASE,
    					ErrorConstants.EXCEPTION_SEVERITY_LOW);
            }
        }   
       
    }
    /**
     * @param fullFileNameMap 要压缩的文件列表
     * @param strDestFullFileName 压缩的目标文件
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
	public static void ZipFilesByMap(List<Map<String,Object>> docsInfoList,String strDestFullFileName) throws UtilException {
    	log.debug("ZipFiles() Start");
    	ZipUtil zipUtil = new ZipUtil();
        //默认的相对地址，为根路径
        String defaultParentPath = "";
        List<String> fileList = null;
        ZipOutputStream zos = null;
        try {
            //创建一个Zip输出流
            zos = new ZipOutputStream(new FileOutputStream(strDestFullFileName));
            zos.setEncoding("GBK");  
            //启动压缩进程
            File file = null;
            for (Object objSingleDocsInfo : docsInfoList) {
            	Map<String,Object> mapSingleDocsInfo = (Map<String,Object>)objSingleDocsInfo; 
            	defaultParentPath = StringUtil.convNull2Blank(mapSingleDocsInfo.get("subPath"));
            	fileList = (List<String>)mapSingleDocsInfo.get("fileList");
	            for (String fileName : fileList) { 
		            file = new File(fileName);
		            if (file.isFile()) {
		            	zipUtil.compressFile(zos,defaultParentPath,file);
		            }
	            }
            }
        } catch (FileNotFoundException e){
        	log.error("将文件压缩成zip文件时，源文件不存在！",e);
			throw new UtilException("将文件压缩成zip文件时，源文件不存在！",e,
					ErrorConstants.EXCEPTION_SOURCE_DATABASE,
					ErrorConstants.EXCEPTION_SEVERITY_LOW);
        } finally{
        	log.debug("ZipFiles() End");
            try {
                if(zos != null)zos.close();
            } catch (IOException e) {
            	log.error("将文件压缩成zip文件时出错！",e);
    			throw new UtilException("将文件压缩成zip文件时，源文件不存在！",e,
    					ErrorConstants.EXCEPTION_SOURCE_DATABASE,
    					ErrorConstants.EXCEPTION_SEVERITY_LOW);
            }
        }   
       
    }
    public void compressFile(ZipOutputStream zos, String oppositePath, File file) throws UtilException{
    	log.debug("compressFile() Start");
        //创建一个Zip条目，每个Zip条目都是必须相对于根路径
        ZipEntry entry = new ZipEntry(oppositePath + File.separator + file.getName());
        InputStream is = null;
        try{
            //将条目保存到Zip压缩文件当中
            zos.putNextEntry(entry);
            //从文件输入流当中读取数据，并将数据写到输出流当中.
            is = new FileInputStream(file);           
            int length = 0;
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            while((length=is.read(buffer,0,bufferSize))>=0){
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
        }catch(IOException e){
        	log.error("将文件压缩成zip文件时出错！",e);
			throw new UtilException("将文件压缩成zip文件时出错",e,
					ErrorConstants.EXCEPTION_SOURCE_DATABASE,
					ErrorConstants.EXCEPTION_SEVERITY_LOW);
        } finally {
        	log.debug("compressFile() End");
            try{
                if(is != null)is.close();
            }catch(IOException e){
            	log.error("将文件压缩成zip文件时出错！",e);
    			throw new UtilException("将文件压缩成zip文件时出错",e,
    					ErrorConstants.EXCEPTION_SOURCE_DATABASE,
    					ErrorConstants.EXCEPTION_SEVERITY_LOW);
            }
        }       
    }
 
     private static List<String> listFile(String path) {
         List<String> list = new ArrayList<String>();
      File file = new File(path);
      String[] array = null;
      String sTemp = "";

      if (!file.isDirectory()) {
       return null;
      }
      array = file.list();
      if (array.length > 0) {
       for (int i = 0; i < array.length; i++) {
        sTemp = path + array[i];
        file = new File(sTemp);
        if (file.isDirectory()) {
         listFile(sTemp + "/");
        } else
         list.add(sTemp);
       }
      } else {
       return null;
      }

      return list;
     }

    public static void zip(String needtozipfilepath, String zipfilepath) {
        try {
            byte[] b = new byte[512];

            File needtozipfile = new File(needtozipfilepath);

            if (!needtozipfile.exists()) {
                System.err.println("指定的要压缩的文件或目录不存在.");
                return;
            }

            String zipFile = zipfilepath;
            File targetFile = new File(zipFile.substring(0, zipFile.indexOf("\\") + 1));

            if (!targetFile.exists()) {
                log.debug("指定的目标文件或目录不存在.");
                return;
            }

            String filepath = needtozipfilepath;
            List<String> fileList = listFile(filepath);
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            CheckedOutputStream cs = new CheckedOutputStream(fileOutputStream, new CRC32());
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(cs));
            InputStream in;
            for (int i = 0; i < fileList.size(); i++) {
                in = new FileInputStream((String) fileList.get(i));
                String fileName = ((String) fileList.get(i)).replace(File.separatorChar, '/');
                fileName = fileName.substring(fileName.indexOf("/") + 1);
                ZipEntry e = new ZipEntry(fileName);
                out.putNextEntry(e);
                int len = 0;
                while ((len = in.read(b)) != -1) {
                    out.write(b, 0, len);
                }
                out.closeEntry();
            }
            out.close();
        } catch (Exception e) {
            log.error("将文件压缩成zip文件时出错！",e);
            throw new UtilException("将文件压缩成zip文件时出错",e,
                    ErrorConstants.EXCEPTION_SOURCE_DATABASE,
                    ErrorConstants.EXCEPTION_SEVERITY_LOW);
        }
    }

     // ///////////////////////////////////////
     /**
      * 压缩文件 或者 文件夹
      * 
      * @param baseDirName
      *            压缩的根目录
      * @param fileName
      *            根目录下待压缩的文件或文件夹名
      * @param targetFileName
      *            目标ZIP 文件 星号 "*" 表示压缩根目录下的全部文件
      * 
      */
     public static boolean zip(String baseDirName, String[] fileNames,
 String targetFileName, String encoding) {
        boolean flag = false;
        try {
            // 判断 "压缩的根目录"是否存在! 是否是一个文件夹!
            File baseDir = new File(baseDirName);
            if (!baseDir.exists() || (!baseDir.isDirectory())) {
                System.err.println("压缩失败! 根目录不存在: " + baseDirName);
                return false;
            }

            // 得到这个 "压缩的根目录" 的绝对路径
            String baseDirPath = baseDir.getAbsolutePath();

            // 由这个 "目标 ZIP 文件" 文件名得到一个 压缩对象 ZipOutputStream
            File targetFile = new File(targetFileName);
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(targetFile));
            // 中文有乱码，引进下面的改造类
            // CnZipOutputStream out = new CnZipOutputStream(new
            // FileOutputStream(targetFile),encoding);

            // 设置压缩编码Apache Ant有个包专门处理ZIP文件，可以指定文件名的编码方式。由此可以解决问题。例如：用
            // org.apache.tools.zip.ZipOutputStream代替java.util.zip.ZipOutputStream。ZipOutputStream
            // out = .....; out.setEncoding("GBK");
            // out.setEncoding("GBK");//设置为GBK后在windows下就不会乱码了，如果要放到Linux或者Unix下就不要设置了
            out.setEncoding(encoding);

            // "*" 表示压缩包括根目录 baseDirName 在内的全部文件 到 targetFileName文件下
            if (fileNames.equals("*")) {
                ZipUtil.dirToZip(baseDirPath, baseDir, out);
            } else {
                File[] files = new File[fileNames.length];
                for (int i = 0; i < files.length; i++) {
                    // 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
                    files[i] = new File(baseDir, fileNames[i]);
                }
                if (files[0].isFile()) {
                    // 调用本类的一个静态方法 压缩一个文件
                    // CompressUtil.fileToZip(baseDirPath, file, out);
                    ZipUtil.filesToZip(baseDirPath, files, out);
                }

            }
            out.close();
            // log.debug("压缩成功! 目标文件名为: " + targetFileName);
            flag = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

     /**
      * 将文件压缩到Zip 输出流
      * 
      * @param baseDirPath
      *            根目录路径
      * @param file
      *            要压缩的文件
      * @param out
      *            输出流
      * @throws IOException
      */
     private static void fileToZip(String baseDirPath, File file,
 ZipOutputStream out) throws IOException {
        //
        FileInputStream in = null;
        org.apache.tools.zip.ZipEntry entry = null;
        // 创建复制缓冲区 1024*4 = 4K
        byte[] buffer = new byte[1024 * 4];
        int bytes_read = 0;
        if (file.isFile()) {
            in = new FileInputStream(file);
            // 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例
            String zipFileName = getEntryName(baseDirPath, file);
            entry = new org.apache.tools.zip.ZipEntry(zipFileName);
            // "压缩文件" 对象加入 "要压缩的文件" 对象
            out.putNextEntry(entry);
            // 现在是把 "要压缩的文件" 对象中的内容写入到 "压缩文件" 对象
            while ((bytes_read = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytes_read);
            }
            out.closeEntry();
            in.close();
            // log.debug("添加文件" + file.getAbsolutePath()+ "被添加到 ZIP
            // 文件中!");
        }
    }

     /**
      * 多个文件目录压缩到Zip 输出流
      * 
      * @param baseDirPath
      * @param files
      * @param out
      * @throws IOException
      */ 
     private static void filesToZip(String baseDirPath, File[] files,
 ZipOutputStream out) throws IOException {
        // 遍历所有的文件 一个一个地压缩
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isFile()) {
                // 调用本类的一个静态方法 压缩一个文件
                ZipUtil.fileToZip(baseDirPath, file, out);
            } else {
                /*
                 * 这是一个文件夹 所以要再次得到它下面的所有的文件 这里是自己调用自己..............递归..........
                 */
                ZipUtil.dirToZip(baseDirPath, file, out);
            }
        }
    }

     /**
      * 将文件目录压缩到Zip 输出流
      * 
      * @param baseDirPath
      * @param dir
      * @param out
      * @throws IOException
      */
     private static void dirToZip(String baseDirPath, File dir,
 ZipOutputStream out) throws IOException {
        // 得到一个文件列表 (本目录下的所有文件对象集合)
        File[] files = dir.listFiles();
        // 要是这个文件集合数组的长度为 0 , 也就证明了这是一个空的文件夹,虽然没有再循环遍历它的必要,但是也要把这个空文件夹也压缩到目标文件中去
        if (files.length == 0) {
            // 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例
            String zipFileName = getEntryName(baseDirPath, dir);
            org.apache.tools.zip.ZipEntry entry = new org.apache.tools.zip.ZipEntry(zipFileName);
            out.putNextEntry(entry);
            out.closeEntry();
        } else {
            // 遍历所有的文件 一个一个地压缩
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isFile()) {
                    // 调用本类的一个静态方法 压缩一个文件
                    ZipUtil.fileToZip(baseDirPath, file, out);
                } else {
                    /*
                     * 这是一个文件夹 所以要再次得到它下面的所有的文件
                     * 这里是自己调用自己..............递归..........
                     */
                    ZipUtil.dirToZip(baseDirPath, file, out);
                }
            }
        }
    }

     /**
      * 获取 待压缩文件在 ZIP 文件中的 entry的名字，即相对于根目录的相对路径名
      * 
      * @param baseDirPath
      *            根目录
      * @param file
      * @return
      */
    private static String getEntryName(String baseDirPath, File file) {
        /**
         * 改变 baseDirPath 的形式 把 "C:/temp" 变成 "C:/temp/"
         */
        if (!baseDirPath.endsWith(File.separator)) {
            baseDirPath += File.separator;
        }
        String filePath = file.getAbsolutePath();
        /**
         * 测试此抽象路径名表示的文件是否是一个目录。 要是这个文件对象是一个目录 则也要变成 后面带 "/" 这个文件对象类似于
         * "C:/temp/人体写真/1.jpg" 要是这个文件是一个文件夹 则也要变成 后面带 "/"
         * 因为你要是不这样做,它也会被压缩到目标文件中 但是却不能正解显示 也就是说操作系统不能正确识别它的文件类型(是文件还是文件夹)
         */
        if (file.isDirectory()) {
            filePath += "/";
        }
        int index = filePath.indexOf(baseDirPath);
        return filePath.substring(index + baseDirPath.length());
    }

     // //////////////////////////解压缩////////////////////////////////////////
    /**
     * 解压压缩包
     * 调用org.apache.tools.zip实现解压缩，支持目录嵌套和中文名
     * 也可以使用java.util.zip不过如果是中文的话，解压缩的时候文件名字会是乱码。原因是解压缩软件的编码格式跟java.util.zip.ZipInputStream的编码字符集(固定是UTF-8)不同
     *  
     * @param zipFilePath 压缩文件路径 
     * @param destDir 压缩包释放目录 
     * @throws Exception 
     */  
    public static void unZipFiles(String zipFilePath, String destDir) { 
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ZipFile zipFile  = null;
        try {
            zipFile = new ZipFile(zipFilePath, CHINESE_CHARSET);

            Enumeration<?> emu = zipFile.getEntries();
            File file, parentFile;
            ZipEntry entry;
            byte[] cache = new byte[CACHE_SIZE];
            while (emu.hasMoreElements()) {
                entry = (ZipEntry) emu.nextElement();
                if (entry.isDirectory()) {
                    new File(destDir + entry.getName()).mkdirs();
                    continue;
                }
                bis = new BufferedInputStream(zipFile.getInputStream(entry));
                file = new File(destDir + File.separator + entry.getName());
                parentFile = file.getParentFile();
                if (parentFile != null && (!parentFile.exists())) {
                    parentFile.mkdirs();
                }
                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos, CACHE_SIZE);
                int nRead = 0;
                while ((nRead = bis.read(cache, 0, CACHE_SIZE)) != -1) {
                    fos.write(cache, 0, nRead);
                }
                bos.flush();
                bos.close();
                fos.close();
                bis.close();
            }
            zipFile.close();
        } catch (IOException e) { 
            throw new UtilException("解压文件时，文件未找！",e,
                    ErrorConstants.EXCEPTION_SOURCE_DATABASE,
                    ErrorConstants.EXCEPTION_SEVERITY_LOW);
            
        } finally { 
            try {
                if(bos != null) bos.close();
                if(fos != null) fos.close();
                if(bis != null) bis.close();
                zipFile.close();
            } catch (IOException e) {
                 log.error("文件解压缩过程中出错");
            }
        }
    }   
}



