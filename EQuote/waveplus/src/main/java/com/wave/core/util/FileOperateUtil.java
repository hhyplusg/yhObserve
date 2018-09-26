package com.wave.core.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wave.common.cnstants.Constants;

/**
 * <b>文件读取类</b><br />
 * 1、按字节读取文件内容<br />
 * 2、按字符读取文件内容<br />
 * 3、按行读取文件内容<br />
 * 
 * @author qin_xijuan
 * 
 */
public class FileOperateUtil {
    final static Logger log = LogManager.getLogger(FileOperateUtil.class);
    /**
     * 以字节为单位读写文件内容
     * 
     * @param filePath
     *            ：需要读取的文件路径
     */
    public static void readFileByByte(String filePath) {
        File file = new File(filePath);
        // InputStream:此抽象类是表示字节输入流的所有类的超类。
        InputStream ins = null;
        OutputStream outs = null;
        try {
            // FileInputStream:从文件系统中的某个文件中获得输入字节。
            ins = new FileInputStream(file);
            outs = new FileOutputStream("d:/work/readFileByByte.txt");
            int temp;
            // read():从输入流中读取数据的下一个字节。
            while ((temp = ins.read()) != -1) {
                outs.write(temp);
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (ins != null && outs != null) {
                try {
                    outs.close();
                    ins.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }
    }

    /**
     * 以字符为单位读写文件内容
     * 
     * @param filePath
     */
    public static String readFileByCharacter(String filePath) {
        File file = new File(filePath);
        // FileReader:用来读取字符文件的便捷类。
        FileReader reader = null; 
        StringBuffer strContent = new StringBuffer();
        try {
            reader = new FileReader(file); 
            int temp;
            while ((temp = reader.read()) != -1) {
                strContent.append(temp);
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            if (reader != null  ) {
                try {
                    reader.close(); 
                } catch (IOException e) {
                    log.error(e);
                }
            }
        }
        return strContent.toString();
    }

    /**
     * 以行为单位读写文件内容
     * @param filePath
     */
    public static void readFileByLine(File file,String newFilePath) { 
        // BufferedReader:从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
        BufferedReader bufReader = null;
        BufferedWriter bufWriter = null;
        try {
            // FileReader:用来读取字符文件的便捷类。
            bufReader = new BufferedReader(new FileReader(file));
            bufWriter = new BufferedWriter(new FileWriter(newFilePath)); 
            String temp = null;
            while ((temp = bufReader.readLine()) != null) {
                bufWriter.write(temp+"\n");
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (bufReader != null && bufWriter != null) {
                try {
                    bufReader.close();
                    bufWriter.close();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }
        }
    }

    /**
     * 使用Java.nio ByteBuffer字节将一个文件输出至另一文件
     * 
     * @param filePath
     */
    public static void readFileByBybeBuffer(String filePath,String newFilePath) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            // 获取源文件和目标文件的输入输出流  
            in = new FileInputStream(filePath);
            out = new FileOutputStream(newFilePath);
            // 获取输入输出通道
            FileChannel fcIn = in.getChannel();
            FileChannel fcOut = out.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                // clear方法重设缓冲区，使它可以接受读入的数据
                buffer.clear();
                // 从输入通道中将数据读到缓冲区
                int r = fcIn.read(buffer);
                if (r == -1) {
                    break;
                }
                // flip方法让缓冲区可以将新读入的数据写入另一个通道  
                buffer.flip();
                fcOut.write(buffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null && out != null) {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
     
    /**
     * 创建文件.
     * @throws IOException 
     * 
     */
    public static File createFile(String strFileName) throws IOException{
        File file = new File(strFileName);
        if (!file.exists()) {
            file.createNewFile(); 
        }
        return file;
    }
    
    /**
     * 读取文本文件.
     * @throws IOException 
     * 
     */
    public static String readTxtFile(File file) throws IOException{ 
        StringBuffer sbContents = new StringBuffer(); 
        FileReader fileRead = null;
        BufferedReader bufRead = null;
        try {
            fileRead = new FileReader(file);
            bufRead = new BufferedReader(fileRead);
            String read;
            while ((read = bufRead.readLine()) != null) {
                sbContents.append(read+ Constants.CRLF );
            } 
        } finally {
            if (fileRead != null) {
                fileRead.close();
            }
            if (bufRead != null) {
                bufRead.close();
            }
        }
        return sbContents.toString();
    }
    
    /**
     * 写文件.
     * 
     */
    public static void writeTxtFile(File file, String strContent) throws IOException{
        //先读取原有文件内容，然后进行写入操作
        RandomAccessFile raFile = null;
        try {
            raFile = new RandomAccessFile(file, "rw");
            raFile.writeBytes(strContent);
         
        } finally {
            if (raFile != null) {
                try {
                    raFile.close();
                } catch (IOException e2) {
                   log.error(e2);
                }
            }
        }
    }
    
    /**
     * 将文件中指定内容的第一行替换为其它内容.
     * 
     * @param oldStr
     *            查找内容
     * @param replaceStr
     *            替换内容
     */
    public static void replaceTxtByStr(File file,String oldStr,String replaceStr) {
        String temp = "";
        try { 
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();

            // 保存该行前面的内容
            for (; (temp = br.readLine()) != null
                    && !temp.equals(oldStr);) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }

            // 将内容插入
            buf = buf.append(replaceStr);

            // 保存该行后面的内容
            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }

            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            log.error(e);
        }
    }
    public static void main(String args[]) {
        String file_path = "d:/work/A.txt";
        String new_file_path = "d:/work/B.txt";
        long time1 = System.currentTimeMillis();
        // readFileByByte(FILE_PATH);// 8734,8281,8000,7781,8047
        // readFileByCharacter(FILE_PATH);// 734, 437, 437, 438, 422
        // readFileByLine(FILE_PATH);// 110, 94,  94,  110, 93
        readFileByBybeBuffer(file_path,new_file_path);// 125, 78,  62,  78, 62
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
    }
}