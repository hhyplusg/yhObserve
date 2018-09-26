package com.wave.core.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;

/**
 * 提供附件支持, 保存一个附件的名字和数据.
 */
public class Attachment implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 附件文件名
     */
    private String fileName;
    /**
     * 附件文件数据
     */
    private byte[] data;

    /**
     * 给定本地文件读取文件内容并设置文件名和数据.
     */
    public Attachment(String fileName) {
        try {
            FileInputStream in = new FileInputStream(fileName);
            data = new byte[in.available()];
            in.read(data);
            in.close();
            File file = new File(fileName);
            fileName = file.getAbsolutePath();
        } catch (Exception ex) {
            System.out.println("Not a valid attachment file.");
            ex.printStackTrace();
            data = null;
        }
        char separator = File.separatorChar;
        if (fileName.lastIndexOf(separator) >= 0)
            setFileName(fileName.substring(fileName.lastIndexOf(separator) + 1));
        else
            setFileName(fileName);
    }

    /**
     * 根据已知附件文件名和数据构造附件.
     */
    public Attachment(String fileName, byte[] data) {
        setFileName(fileName);
        setFileData(data);
    }

    public Attachment() {
    }

    /**
     * 返回附件文件名.
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * 设置附件文件名.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 返回附件数据.
     */
    public byte[] getFileData() {
        return this.data;
    }

    /**
     * 设置附件数据.
     */
    public void setFileData(byte[] data) {
        this.data = data;
    }

    /**
     * 返回附件描述字符串.
     */
    public String toString() {
        return getFileName() + "(" + getFileData().length + " 字节)";
    }
}
