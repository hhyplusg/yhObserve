package com.wave.core.mail;
import java.io.Serializable;
import java.util.Vector;

public class Mail implements Serializable { 
    /**
	 * 
	 */
	private static final long serialVersionUID = -1925450379895282490L;
	/** 
     * 定义邮件的优先级. Mail priority definition.
     */
    public transient static final int LOW_PRIORITY = 5;
    public transient static final int NORMAL_PRIORITY = 3;
    public transient static final int HIGH_PRIORITY = 1;
    /**
     * 定义邮件的发送格式. Sending format definition.
     */
    public transient static final int TEXT = 1;
    public transient static final int HTML = 2;
    /**
     * @since 2.0
     */
    public int priority = NORMAL_PRIORITY;
    public int format = TEXT;
    /**
     * The DNS server name.
     */
    public String server;
    public String from;
    public String to;
    public String time;
    public String copy;
    public String subject;
    public String body;
    
    public Vector<?> attachments;// Attachment files
    public Mail(String server, String from, String to,String time,String copy, String subject,
            String body, Vector<?> attachments, int priority, int format) {
        this.server = server;
        this.from = from;
        this.to = to;
        this.time=time;
        this.copy=copy;
        this.subject = subject;
        this.body = body;
        this.attachments = attachments;
        this.priority = priority;
        this.format = format;
    }
}
