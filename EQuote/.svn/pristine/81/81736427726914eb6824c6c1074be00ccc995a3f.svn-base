package com.wave.core.mail;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Random;
import java.util.Vector;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.imap.protocol.BASE64MailboxEncoder;
import com.sun.mail.util.BASE64EncoderStream;
import com.wave.core.util.Attachment;

/**
 * 对指定的 Mail 对象进行 MIME 编码并返回编码结果.
 */
public class MailEncoder {
	private Mail mail;
	// The mail to be encoded
	private MessageDigest digest;
	// Used to genarate a boundary string 

	// Encode content to BASE64 character
	public MailEncoder(Mail mail,HttpServletResponse response,String fileNames) {
		this.mail = mail;
		try {
			digest = MessageDigest.getInstance("MD5");// MD5 is 16 bit message 
			response.reset();
			response.setContentType("application/octec-stream");
			response.setHeader("Content-Disposition","attachment;filename="+new String(fileNames.getBytes(),"iso8859-1"));
			OutputStream out = response.getOutputStream();
			out.write(encode().getBytes());
			out.flush();
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	public String encode() {
		String result = "";
		byte[] data;
		digest.update(((new Random()).nextInt() + "").getBytes());
		data = digest.digest(); 
		String mainBoundary = "****MAIN_BOUNDARY****" + byte2hex(data);
		String subBoundary = "****SUB_BOUNDARY****" + byte2hex(data);
		result += "To:" + encodeText(mail.to) + "\r\n" 
		       + "Date:" + encodeText(mail.time)+"\r\n"
		       + "Copy to:" + encodeText(mail.copy)+"\r\n"
		       + "From:" + encodeText(mail.from) + "\r\n" 
		       + "Subject: " + encodeText(mail.subject) + "\r\n";
		// The mail priority
		if (mail.priority == Mail.LOW_PRIORITY) {
			result += "X-Priority: 5\r\n";
			result += "X-MSMail-Priority: Low\r\n";
		} else if (mail.priority == Mail.HIGH_PRIORITY) {
			result += "X-Priority: 1\r\n";
			result += "X-MSMail-Priority: High\r\n";
		} else if (mail.priority == Mail.NORMAL_PRIORITY) {
			result += "X-Priority: 3\r\n";
			result += "X-MSMail-Priority: Normal\r\n";
		}

		result += "MIME-Version: 1.0\r\n"
				+ "Content-Type: multipart/mixed;\r\n" + "\tboundary=\""
				+ mainBoundary + "\"\r\n" + "\r\n"
				+ "This is a multi-part message in MIME format.\r\n" + "\r\n"
				+ "--" + mainBoundary + "\r\n"
				+ "Content-Type: multipart/alternative;\r\n" + "\tboundary=\""
				+ subBoundary + "\"\r\n" + "\r\n" + "--" + subBoundary + "\r\n";
		if (mail.format == Mail.TEXT) {
			result += "Content-Type: text/plain;\r\n";
		} else if (mail.format == Mail.HTML) {
			result += "Content-Type: text/html;\r\n";
		}
		result += "\tcharset=\"gb2312\"\r\n"
				+ "Content-Transfer-Encoding: base64\r\n" + "\r\n"
				+ BASE64MailboxEncoder.encode(mail.body) + "\r\n" + "\r\n" + "--"
				+ subBoundary + "--\r\n"// End of sub boundary
				+ "\r\n";
		// Start attach files
		if (mail.attachments != null)
			for (int i = 0; i < mail.attachments.size(); i++) {
				Attachment attachment = (Attachment) mail.attachments.elementAt(i);
				result += "--" + mainBoundary + "\r\n" + "Content-Type:"
						+ getMimeType(attachment.getFileName()) + ";\r\n"
						+ "\tname=\"" + encodeText(attachment.getFileName())
						+ "\"\r\n" + "Content-Transfer-Encoding: base64\r\n"
						+ "Content-Disposition: attachment;\r\n"
						+ "\tfilename=\""
						+ encodeText(attachment.getFileName()) + "\"\r\n"
						+ "\r\n" + BASE64EncoderStream.encode(attachment.getFileData())
						+ "\r\n" + "\r\n";
			}

		result += "--" + mainBoundary + "--";
		// End of main boundary and the mail
		return result;
	}

	private String getMimeType(String fileName) {
		MimetypesFileTypeMap map = new MimetypesFileTypeMap();
		return map.getContentType(fileName);
	}

	/**
	 * Convert the bytes to hexadecimal string.
	 */
	public String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	public String encodeText(String text) {
		return encodeText(text, "gb2312");
	}

	public String encodeText(String text, String encoding) {
		boolean isAllAscii = true;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) <= ' ' || text.charAt(i) >= '~') {
				isAllAscii = false;
				break;
			}
		}
		if (isAllAscii)
			return text;

		try { 
			if (encoding == null || encoding.length() == 0) {
				encoding = "gb2312";
			} 
			return "=?" + encoding + "?B?" + BASE64MailboxEncoder.encode(text) + "?=";
		} catch (Exception ex) {
			return text;
		}
	}

	public static void main(String[] args) {
		Vector<Attachment> attachments=new Vector<Attachment>();
		Attachment at=new Attachment("E:\\a.rar"); 
		attachments.add(at); 
		Mail mail = new Mail("server", "发件人11111111111", "收件人22222222","2012-01-01","llx,我们大家", "主题222", "正文222", attachments,Mail.HIGH_PRIORITY, Mail.HTML);
		String path="d:\\aaa.eml"; 
	}
}
