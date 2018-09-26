package com.wave.core.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringUtil {
    static Logger log = LogManager.getLogger(StringUtil.class); 
    
	/**
	 * 私有构造方法，防止类的实例化，因为工具类不需要实例化。
	 */
	private StringUtil() {
	}
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return true;
		} else{
			return false;
		} 
	}
	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Object str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return true;
		} else{
			return false;
		} 
	}
	/**
	 * 判断字符串不是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str == null || "".equals(str)) {
			return false;
		} else{
			return true;
		} 
	}
	
	/**
	 * 判断字符串不是否为空("null")
	 * 
	 * @param str
	 * @return 不这空时返回true
	 */
	public static boolean isNotNull(String str) {
		if (str == null || "".equals(str) || "null".equals(str.toLowerCase())) {
			return false;
		} else{
			return true;
		} 
	}
	
	/**
     * 判断字符串不是否为空("null")
     * 
     * @param str
     * @return 为空时返回ture
     */
    public static boolean isNull(String str) {
        if (str == null || "".equals(str)  || "null".equals(str.toLowerCase())) {
            return true ;
        } else{
            return false;
        } 
    }
	
	/**
	 * 判断字符串不是否Float
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotFloat(String str) {
		try {
			Float.valueOf(str);
		} catch (Exception e) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否Float
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isFloat(String str) {
		try {
			Float.valueOf(str);
		} catch (Exception e) {
			return false;
		}
		return true ;
	}
	
	/**
	 * 判断字符串不是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(Object str) {
		if (str == null || "".equals(str)) {
			return false;
		} else{
			return true;
		} 
	}
	
	/**
	 * 判断字符串是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("[0-9]*");
		java.util.regex.Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}
    /**
     * sqlite一些特殊的字符需要进行转义
     * @param strData
     * @return
     */
    public static String sqliteEscape(String strData){ 
        if (StringUtil.isEmpty(strData)) {
            return strData;
        } else {
            return strData.replace("'", "‘");   
        } 
    } 
	/**
	 * 将字符串为null时，转换为空白
	 * 
	 * @param str
	 * @return
	 */
	public static String convNull2Blank(String str) {
		if (StringUtil.isEmpty(str) || "null".equals(str.toLowerCase())) {
			return "";
		} else {
			return str;
		}
	}
	
	/**
	 * 将字符串为null时，转换为空白
	 * 
	 * @param str
	 * @return
	 */
	public static String convNull2Blank(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString().trim();
		}
	}
	
	/**
	 * 将字符串为null时，转换为零
	 * 
	 * @param obj
	 * @return
	 */
	public static String convNull2Zero(Object obj) {
		if (obj == null) {
			return "0";
		} else {
			return obj.toString().trim();
		}
	}
	
	/**
	 * 将字符串为空时，转换为零
	 * 
	 * @param obj
	 * @return
	 */
	public static String convEmpty2Zero(Object obj) {
		if (obj == null || obj.toString().trim() == "") {
			return "0";
		} else {
			return obj.toString().trim();
		}
	}
	/**
	 * 判断有几个中文字符
	 * 
	 * @param str
	 * @return
	 */
	public static int getChineseCount(String str) {
		String temp = null;
		Pattern p = Pattern.compile("[\u4E00-\u9FA5]+");
		Matcher m = p.matcher(str);
		int count = 0;
		while (m.find()) {
			temp = m.group(0);
			count += temp.length();
			System.out.println(temp + ":" + temp.length());
		}
		return count;
	}

	/**
	 * 设置填充字符
	 * 
	 * @param str
	 *            原字符
	 * @param fill
	 *            填充字符
	 * @param digit
	 *            填充后总位数
	 * @param startOrend
	 *            填充在原字符首尾(1,-1)
	 * @return
	 * @throws Exception
	 */
	public static String fChar(String str, String fill, int digit,int startOrend) throws Exception {
		if (!(str.length() > digit)) {
			// 处理中文问题
			// int slength=new String(str.getBytes(),"ISO-8859-1").length();
			int slength = str.length();
			int i = digit - slength;
			StringBuffer fillStr = new StringBuffer();
			for (int x = 0; x < i; x++)
				fillStr.append(fill);
			if (startOrend >= 0)
				return fillStr + str;
			else
				return str + fillStr;
		} else {
			throw new Exception("填充字符过程中出现异常");
		}
	}

	/**
	 * 得到字符串的字节长度
	 * 
	 * @param source
	 *            字符串
	 * @return 字符串的字节长度
	 */
	public static int getByteLength(String source) {
		int len = 0;
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			int highByte = c >>> 8;
			len += highByte == 0 ? 1 : 2;
		}
		return len;
	}

	/**
	 * 去除右边多余的空格。
	 * 
	 * @param value
	 *            待去右边空格的字符串
	 * @return 去右边空格的字符串
	 */
	public static String trimRight(String value) {
		String result = value;
		if (result == null)
			return result;
		char ch[] = result.toCharArray();
		int endIndex = -1;
		for (int i = ch.length - 1; i > -1; i--) {
			if (Character.isWhitespace(ch[i])) {
				endIndex = i;
			} else {
				break;
			}
		}
		if (endIndex != -1) {
			result = result.substring(0, endIndex);
		}
		return result;
	}

	/**
	 * 去除左边多余的空格。
	 * 
	 * @param value
	 *            待去左边空格的字符串
	 * @return 去掉左边空格后的字符串
	 */
	public static String trimLeft(String value) {
		String result = value;
		if (result == null)
			return result;
		char ch[] = result.toCharArray();
		int index = -1;
		for (int i = 0; i < ch.length; i++) {
			if (Character.isWhitespace(ch[i])) {
				index = i;
			} else {
				break;
			}
		}
		if (index != -1) {
			result = result.substring(index + 1);
		}
		return result;
	}

	/**
	 * 将字符串数组使用指定的分隔符合并成一个字符串。
	 * 
	 * @param array
	 *            字符串数组
	 * @param delim
	 *            分隔符，为null的时候使用""作为分隔符（即没有分隔符）
	 * @return 合并后的字符串
	 */
	public static String combineStringArray(String[] array, String delim) {
		int length = array.length - 1;
		if (delim == null) {
			delim = "";
		}
		StringBuffer result = new StringBuffer(length * 8);
		for (int i = 0; i < length; i++) {
			result.append(array[i]);
			result.append(delim);
		}
		result.append(array[length]);
		return result.toString();
	}

	/**
	 * 字符串数组中是否包含指定的字符串。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @param caseSensitive
	 *            是否大小写敏感
	 * @return 包含时返回true，否则返回false
	 */
	public static boolean contains(String[] strings, String string,
			boolean caseSensitive) {
		for (int i = 0; i < strings.length; i++) {
			if (caseSensitive == true) {
				if (strings[i].equals(string)) {
					return true;
				}
			} else {
				if (strings[i].equalsIgnoreCase(string)) {
					return true;
				}
			}
		}
		return false;
	}

	public static InputStream parseInputStream(String str) {
		InputStream is = new ByteArrayInputStream(str.getBytes());
		return is;
	}


	/**
	 * @author sdh
	 * @param request
	 * @return 类似于http://localhost:8099/utmpost/这样的路径即项目的根路径
	 */
	public static String getBasePath(HttpServletRequest request){
		String basePath=null;
		String path =request.getContextPath();
		basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
		return basePath;
	}
	/**
	 * 得到网站的根路径
	 * @param request
	 * @return
	 */
	public static String getWebRoot(HttpServletRequest request){
		return request.getServerName();
	}
	/**
	 * 得到一个属性的get方法名
	 * @param str bean的一个属性
	 * @return
	 */
	public static String getMethodByStr(String str){
		String methodName=null;
		String firstLetter = str.substring(0, 1).toUpperCase();
		methodName = "get" + firstLetter + str.substring(1);
		return methodName;
	}
	/**
	 * 得到一个属性的set方法名
	 * @param str bean的一个属性
	 * @return
	 */
	public static String setMethodByStr(String str){
		String methodName=null;
		String firstLetter = str.substring(0, 1).toUpperCase();
		methodName = "set" + firstLetter + str.substring(1);
		return methodName;
	}
	/**
	 * 检验一个字符串是否是纯英文的字符串
	 * @param str
	 * @return
	 */
	public static boolean isWord(String str){
		return str.matches("[[a-z]|[A-Z]]*");
	}
	public static String getRandomNum(int len){
		StringBuffer sb=new StringBuffer();
		Random rd = new Random();
		for(int i=0;i<len;i++){
			sb.append(rd.nextInt(10));
		}
		return sb.toString();
	}

	/**
	 * 在字答串左边添加字符到指定长度
	 * @param src  指定字符串
	 * @param intLength 字符串目标长度
	 * @param character 添加字符
	 * @return
	 */
	public static String appendLeft(String src,int intLength,String character){
			if (StringUtil.isEmpty(src) || src.length() > intLength) {
				return src;
			}
			StringBuffer sb = new StringBuffer();
			int intAppendLength =intLength - src.length();
			for (int i = 0; i < intAppendLength; i++) {
				sb.append(character);
			}
			sb.append(src);
			src = sb.toString();
		
		return src;
	}
	
	
	/**
	 * 在字答串右边添加字符到指定长度
	 * @param src  指定字符串
	 * @param intLength 字符串目标长度
	 * @param character 添加字符
	 * @return
	 */
	public static String appendRight(String src,int intLength,String character){
			if (StringUtil.isEmpty(src) || src.length() > intLength) {
				return src;
			}
			StringBuffer sb = new StringBuffer();
			sb.append(src);
			int intAppendLength =intLength - src.length();
			for (int i = 0; i < intAppendLength; i++) {
				sb.append(character);
			}
			src = sb.toString();
		
		return src;
	}
	public static String splitStr(String str, int length) {
		List<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		String strAll="";
		while (str.length() >= length) {
			list.add(str.substring(0, length));
			str = str.substring(length);
		}
		if (str.length() > 0) {
			list.add(str);
		}
		for (int i = 0, size = list.size(); i < size; i++) {
			sb.append(list.get(i));
			sb.append(",");
		}
		if(sb.toString().length()>0){
			strAll=sb.toString().substring(0,sb.toString().length()-1);
		}
		return strAll;
	}
	
	
	/**
	 * 将一个大字符串按指定长度换行，行尾为英语单词或数值时不换行
	 * @param src 原始字符串
	 * @param lineBeytesCount 一个的比特位数。一个汉字两个比特。
	 * @return 换行后的字符串
	 * */
	public static String strCRLFByLineCount(String src, int lineBeytesCount) {
		
		try {
			
			if (StringUtil.isEmpty(src)) {
				return "";
			}
			
			String regEx = "[0-9a-z,.]";// 条件限制在小写0 to 9或a to
										// 范围中一个字符,不包含小数点与前卫分割符，用于换行。
			String strData = src;
			boolean endFlag = false;
			// 添加换行符号后的字符串
			StringBuffer strCRLFsb = new StringBuffer();
			// 每次截取的字符串
			String subStr;
			while (!endFlag) {
				// 按照指定长度取得一个字符串。
				subStr = subStr(strData, lineBeytesCount);
				// 取得beytes长度
				int subStrBytesLength = subStr.getBytes("GBK").length;
				// 如果取得的长度小于行指定长度，或取得长度加1小于指定长度，表示取得结束。如：指令定长度是7，那么取得的3个
				if (subStrBytesLength < lineBeytesCount
						&& (subStrBytesLength + 1) < lineBeytesCount) {
					strCRLFsb.append(subStr);
					endFlag = true;
					break;
				}
				// 截取原始字符串中被截取掉的部分。
				strData = strData.substring(subStr.length());
				int i;
				// 如果截取的字符串是以数字或小数点或前卫分割符号，需要将其换到下一行，当截取取的一个整行都为数字或字母时，将其视为一个整行
				for (i = subStr.length(); i > 0; i--) {
					String c = subStr.substring(i - 1, i);
					if (c.matches(regEx)) {
						continue;
					} else {
						break;
					}
				}
				// 将截取的字母或数字换行。
				if (i != 0) {
					strData = subStr.substring(i, subStr.length()) + strData;
					strCRLFsb.append(subStr.subSequence(0, i)).append("\r\n");
				} else {
					strCRLFsb.append(subStr).append("\r\n");
				}
			}
			return strCRLFsb.toString();
		} catch (Exception e) {
			return src;
		}
	}

	public static String subStr(String str, int num) {
		int max = num;
		try {
			max = trimGBK(str.getBytes("GBK"), num);
		} catch (UnsupportedEncodingException e) {
			return str;
		}
		int sum = 0;
		if (str != null && str.length() > max) {
			StringBuilder sb = new StringBuilder(max);
			for (int i = 0; i < str.length(); i++) {
				int c = str.charAt(i);
				sum += 1;
				if (sum <= max) {
					sb.append((char) c);
				} else {
					break;
				}
			}
			return sb.toString();
		} else
			return str != null ? str : "";
	}

	public static int trimGBK(byte[] buf, int n) {
		int num = 0;
		boolean bChineseFirstHalf = false;
		if (buf.length < n)
			return buf.length;
		for (int i = 0; i < n; i++) {
			if (buf[i] < 0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;
			} else {
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}
	
	
	public static boolean isEquals(Object actual, Object expected) {
        return actual == expected || (actual == null ? expected == null : actual.equals(expected));
    }
	
	public static void main(String[] args) throws Exception {
	    log.debug(StringUtil.isNull(null));
	    log.debug(StringUtil.isNull(""));
	    log.debug(StringUtil.isNull("null"));
	    log.debug(StringUtil.isNull("sdfsadf"));
	    
	    log.debug(StringUtil.isNotNull(null));
        log.debug(StringUtil.isNotNull(""));
        log.debug(StringUtil.isNotNull("null"));
        log.debug(StringUtil.isNotNull("sdfsadf"));
        
	    /*Marker SQL_MARKER = MarkerManager.getMarker("SQL");
	    Marker UPDATE_MARKER = MarkerManager.getMarker("SQL_UPDATE").setParents(SQL_MARKER);
	    Marker QUERY_MARKER = MarkerManager.getMarker("SQL_QUERY").setParents(SQL_MARKER);
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("a1", "1111");
	    map.put("a2", "2222");
	    map.put("a3", "3333");
	    map.put("a4", "4444");
	    String[] str = new String[2];
	    str[0] = "xx";
	    str[1] = "yy";
	    log.debug(Arrays.toString(str));
	    log.debug("asdfadsf-->",1345465474);
	    log.debug("aaaaaaaaaaa{}fffffffffff" , (Object)str);
	    log.debug(QUERY_MARKER, "SELECT * FROM {}", "table_a");
	    log.debug(UPDATE_MARKER, "UPDATE {} SET {}", "table_a", StringUtil.formatCols(map));
        System.out.println(new String());*/
   }
	
	 private static String formatCols(Map<String, String> cols) {
	        StringBuilder sb = new StringBuilder();
	        boolean first = true;
	        for (Map.Entry<String, String> entry : cols.entrySet()) {
	            if (!first) {
	                sb.append(", ");
	            }
	            sb.append(entry.getKey()).append("=").append(entry.getValue());
	            first = false;
	        }
	        return sb.toString();
	    }
	 
	 /**
	  * 根据","分隔字符串返回数组
	  * */
	 public static String[] conv2Array(String str) {
		 String [] strArray = new String[0];
		 if(str != null && !str.equals("")) {
			 strArray = str.split("\\,");
		 } 
		 return strArray;
	 }
}
