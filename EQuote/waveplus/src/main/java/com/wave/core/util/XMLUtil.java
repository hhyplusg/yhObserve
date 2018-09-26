package com.wave.core.util;

/**
 * <p>Title: xmlReader</p>
 * <p>Description: 读取XML配置文件</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * @version 1.2
 */
import java.io.File;
import java.util.Properties;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLUtil extends DefaultHandler{

	// 属性列表
	private Properties rec = null;

	// 是否开始读取参数
	private boolean isBegin = false;

	// 参数名称
	private String Name = null;

	// 参数值
	private StringBuffer Value = null;

	// 开始标志
	private String startFlag = "";
	
	// 是否进入了该段
	private boolean entered=false;

	/**
	 * 解析XML文件
	 * 
	 * @param URL
	 *            文件地址
	 * @param startFlag
	 *            开始标志
	 * @throws Exception
	 *             所有异常
	 * @return Properties 属性
	 */
	public java.util.Properties parse(String URL, String startFlag)
			throws Exception {
		this.startFlag = startFlag;
		rec = new java.util.Properties();
		Name = new String();
		Value = new StringBuffer();
		File f = new File(URL);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		saxParser.parse(f, this);

		return rec;
	}

	/**
	 * 开始文档
	 * 
	 * @throws SAXException
	 *             解析异常
	 */
	public void startDocument() throws SAXException {
	}

	/**
	 * 结束文挡
	 * 
	 * @throws SAXException
	 *             解析异常
	 */
	public void endDocument() throws SAXException {
	}

	/**
	 * 开始标记
	 * 
	 * @param name
	 *            String 名称
	 * @param localname
	 *            String 本地名称
	 * @param qname
	 *            String qname
	 * @param attrs
	 *            Attributes 属性
	 * @throws SAXException
	 */
	public void startElement(String name, String localname, String qname,
			Attributes attrs) throws SAXException {

		if(qname.equalsIgnoreCase(startFlag)){
			entered=true;
		}else if (!qname.equalsIgnoreCase(startFlag) && entered) {
			isBegin = true;
			this.Name = qname;
		}
	}

	/**
	 * 结束标志
	 * 
	 * @param uri
	 *            String
	 * @param localName
	 *            String
	 * @param qName
	 *            String
	 * @throws SAXException
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (!qName.equalsIgnoreCase(startFlag) && isBegin && entered) {
			isBegin = false;
			rec.setProperty(Name, Value.toString());
			Value.delete(0, Value.length());
		} else if(qName.equalsIgnoreCase(startFlag) && isBegin && entered){
			entered=false;
		}
			isBegin = false;

	}

	/**
	 * 读取值
	 * 
	 * @param buf
	 *            值
	 * @param offset
	 *            偏移量
	 * @param len
	 *            长度
	 * @throws SAXException
	 *             解析异常
	 */

	public void characters(char buf[], int offset, int len) throws SAXException {
		if (isBegin)
			Value.append(buf, offset, len);

	}

}
