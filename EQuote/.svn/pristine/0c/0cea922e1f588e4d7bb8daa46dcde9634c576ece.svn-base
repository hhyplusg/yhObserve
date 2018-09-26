package com.wave.core.system;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wave.common.cnstants.Constants;
import com.wave.core.util.DateUtil;
import com.wave.core.util.FileOperateUtil;
import com.wave.core.util.PathUtil;
import com.wave.core.util.StringUtil;
/**
 * 用户系统启动时，检查系统本次启动时间是否最后一次启动之前。 * 
 *
 */
public class CheckSystemTime {
    protected final Logger log = LogManager.getLogger(getClass());

    public void checkSytemTiem() throws Exception {
        log.debug("checkSytemTiem() is start!");
        log.debug("--------------------------------->系统时间检查开始");
        try {
            File sysTimeFile = FileOperateUtil.createFile(PathUtil.getWebServerRoot() + File.separator + "SysTemTiem.data");
            String strLastStartSystemTime = FileOperateUtil.readTxtFile(sysTimeFile);
            long lngcurrtentTime = System.currentTimeMillis();
            if (StringUtil.isEmpty(strLastStartSystemTime)) {
                FileOperateUtil.writeTxtFile(sysTimeFile, "" + lngcurrtentTime);
            } else {
                long lngLastStartSystemTime = Long.parseLong(strLastStartSystemTime.replace(Constants.CRLF, ""));
                Date date = new Date(lngLastStartSystemTime);
                StringBuffer sbMsg = new StringBuffer();
                String strTemp =  DateUtil.format(date, "yyyy年MM月dd日 HH时mm分ss秒SSSSSS毫秒");
                log.info("系统上次启动时间-->{}", strTemp);
                date = new Date(lngcurrtentTime); 
                sbMsg.append("系统启动失败！")
                .append(Constants.CRLF)
                .append("系统时间有误，当前时间在最后一次系统启动时间之前！")
                .append(Constants.CRLF)
                .append("请修改操作系统时间！")
                .append(Constants.CRLF);
                sbMsg.append("系统上次启动时间:" + strTemp).append(Constants.CRLF);
                strTemp = DateUtil.format(date, "yyyy年MM月dd日 HH时mm分ss秒SSSSSS毫秒");
                log.info("系统本次启动时间-->{}", strTemp);
                sbMsg.append("系统本次启动时间:" + strTemp).append(Constants.CRLF);
                if (lngcurrtentTime < lngLastStartSystemTime) {
                    // 提示用户 
                    /* Create and display the form */
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            MsgDialog mdDialog = new MsgDialog();
                            mdDialog.setTitle("系统启动错误提示");
                            mdDialog.setMsg(sbMsg.toString());
                            mdDialog.setVisible(true);
                        }
                    });
                    throw new Exception("系统时间有误，当前时间在最后一次系统启动时间之前！请修改操作系统时间");
                } else {
                    // 记录本次系统启动时间
                    FileOperateUtil.writeTxtFile(sysTimeFile, "" + lngcurrtentTime);
                }
            } 
        } catch (IOException e) {
            log.error(e);
        } finally {
            log.debug("--------------------------------->系统时间检查结束");    
            log.debug("checkSytemTiem() is end!");  
        }
    }
    
    public static void main(String[] args) {
      
         CheckSystemTime cst = new CheckSystemTime();
        try {
            cst.checkSytemTiem();
        } catch (Exception e) { 
            e.printStackTrace();
        } 
        System.out.println("OK");
        
    }
}
