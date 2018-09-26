package com.wave.core.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wave.common.cnstants.Constants;
 
  

public class DateUtil {

	protected static transient final  Logger log = LogManager.getLogger(DateUtil.class); 
	
	public static final String LONG_DATE = "yyyyMMdd HH:mm:ss";
	
	public static final String HHmmss = "HH:mm:ss";
	
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	public static final String yyyy_MM_dd_ZH = "yyyy年MM月dd日";
	
    public static final long SECOND = 1000;

    public static final long MINUTE = SECOND * 60;

    public static final long HOUR = MINUTE * 60;

    public static final long DAY = HOUR * 24;

    public static final long WEEK = DAY * 7;

    public static final long YEAR = DAY * 365;
 
    private static DateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    /** 格式化器存储器 */
    private static Map<String, SimpleDateFormat> formats = resetFormats();
    
    /**
     * 将10位日期中的“-”与“/”去除,当为空时，默认返回当前日期
     * eg. 2015/01/01 或 2015-01-01 转换成  20150101
     * @param strDate 
     * @return
     */
    public static String convtDateLongToShort(String strDate) {
        if (StringUtil.isNull(strDate)) {
            strDate = DateUtil.getNowDate("yyyyMMdd");
        }
        strDate = strDate.replaceAll(Constants.STRIGULA, Constants.BLANK);
        strDate = strDate.replaceAll(Constants.BACKSLASH, Constants.BLANK);
        return strDate;
    }
    
	public static SimpleDateFormat getDateFormat(String str) {
		return new java.text.SimpleDateFormat(str);
	}

	/**
	 * 得到系统当前时间 格式为yyyyMMdd HH:ss:mm
	 * @return 当前时间
	 */
	public static String getNowDate() {
		return DateUtil.getDateFormat("yyyyMMdd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 按照输入的时间格式返回当前时间
	 * @param format
	 * @return 当前时间
	 */
	public static String getNowDate(String format) {
		return DateUtil.getDateFormat(format).format(new Date());
	}
	
	/**
	 * 比较两个字符串上期的大小（格式：yyyyMMdd）
	 * @param strFirstDate
	 * @param strSecondDate
	 * @return strFirstDate > strSecondDate 返回1，strFirstDate = strSecondDate 返回0，strFirstDate < strSecondDate 返回-1
	 * @throws Exception 
	 */
	public static int dateCompare(String strFirstDate,String strSecondDate) throws Exception {
		int day = 0; 
		int inRS = 0;
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
		Date datFirstDate=new Date();
		Date datSecondDate=new Date();
		try {
			datFirstDate = sf.parse(strFirstDate);
			datSecondDate = sf.parse(strSecondDate);
			day = (int) ((datFirstDate.getTime() - datSecondDate.getTime()) /1000 / 3600 / 24  );
		} catch (Exception e) {
			throw new Exception("无效的日期");
		}
		if(day > 0){
			inRS = 1;
		}else if(day == 0){
			inRS = 0;
		}else if(day < 0){
			inRS = -1;
		}
		return inRS;
	}
	
	
	
	/**
	 * 按照输入的格式格式化输入的时间
	 * @param date 时间
	 * @param formateStr 格式
	 * @return 格式化后的字符串
	 */
	public static String formatDate(Date date,String formateStr){
		SimpleDateFormat sdf = new SimpleDateFormat(formateStr);
		
		return sdf.format(date);
	}
	/**
	 * 字符串日期格式转换
	 * @param oldFormat 字符串原有的日期格式
	 * @param newFormat 转化后的日期格式
	 * @param source 要转化的字符串
	 * @return 转化后的字符串
	 * @throws ParseException
	 * @author sdh 
	 */
	public static String changeDateFormat(String oldFormat,String newFormat,String source) throws ParseException{
		String out=null;
		DateFormat df=new SimpleDateFormat(oldFormat);
		Date date=df.parse(source);
		df=new SimpleDateFormat(newFormat);
		out=df.format(date);
		return out;
	}
	
	/**
	 * 将符合日期格式的字符串转变成日期格式
	 * @param format
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date String2Date(String strDate,String format)throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}
	
		return date;
	}
	
	/**
	 * 获得指定月份的下一个月
	 * @param date
	 * @return
	 */
	public static Date getNextMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH,1);
		Date newDate = new Date(c.getTime().getTime());
		return newDate;
	}
	/**
	 * 取提得系统中用到的时候戳 
	 * @return 当前时间 
	 * @throws InterruptedException 
	 */
	public static synchronized String  getTimeStamp() {
		try { 
			Thread.sleep(0, 1);
		} catch (InterruptedException e) {}
		return DateUtil.getDateFormat("yyyyMMdd HH:mm:ss.SSSSSS").format(new Date());
		
	}
	
	/**
     * 取提得系统中用到的时候戳 
     * @return 当前时间 
     * @throws InterruptedException 
     */
    public static synchronized String  getTimeStampFileName() {
        try { 
            Thread.sleep(0, 1);
        } catch (InterruptedException e) {}
        return DateUtil.getDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
        
    }
	/**
	 * 获得指定日期的下一天
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH,1);
		Date newDate = new Date(c.getTime().getTime());
		return newDate;
	}
	
	/**
	 * 获得指定日期若干天后的日期
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date,int i) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH,i);
		Date newDate = new Date(c.getTime().getTime());
		return newDate;
	}
	
	/**
	 * 获取给定日期的年份
	 * @param date  给定日期
	 * @return 给定日期的年份
	 */
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	/**
	 * 获取给定日期的月份
	 * @param date  给定日期
	 * @return 给定日期的月份
	 */
	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}
	/**
	 * 判断日期是否符合格式要求
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static boolean checkDateFormat(String strDate,String format)throws Exception{
		boolean flag = false;
		try{
			SimpleDateFormat df = new SimpleDateFormat(format);
			if(strDate.equals(df.format(df.parse(strDate)))){
				flag = true;
			}
		}catch(Exception e){
			flag = false;
		}
		return flag;
	}
 

    /** Reset the supported formats to the default set. */
	public static Map<String, SimpleDateFormat> resetFormats() {
       HashMap<String, SimpleDateFormat> formats = new HashMap<String, SimpleDateFormat>();

        // alternative formats
        formats.put("yyyy-MM-dd HH:mm:ss", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        // alternative formats
        formats.put("yyyy-MM-dd", new SimpleDateFormat("yyyy-MM-dd"));

        // XPDL examples format
        formats.put("MM/dd/yyyy HH:mm:ss a", new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a"));

        // alternative formats
        formats.put("yyyy-MM-dd HH:mm:ss a", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a"));

        // ISO formats
        formats.put("yyyy-MM-dd'T'HH:mm:ss'Z'", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        formats.put("yyyy-MM-dd'T'HH:mm:ssZ", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));
        formats.put("yyyy-MM-dd'T'HH:mm:ssz", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz"));
        formats.put("yyyyMMdd HH:mm:ss.SSSSSS", new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSSSSS"));
        return formats;
    }

    /**
     * 对日期进行格式化 格式为：yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     *            需格式化的日期
     * @return 格式化后的字符串
     */
    public static String format(Date date) {
        Object obj = formats.get("yyyy-MM-dd HH:mm:ss");
        if (obj == null) {
            obj = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return ((DateFormat) obj).format(date);
    }

    /**
     * 解析字符串到日期型
     * 
     * @param dateString
     *            日期字符串
     * @return 返回日期型对象
     */
    public static Date parse(String dateString) {
        Iterator<SimpleDateFormat> iter = formats.values().iterator();
        while (iter.hasNext()) {
            try {
                return ((DateFormat) iter.next()).parse(dateString);
            } catch (ParseException e) {
                log.equals(e);
            }
        }
        return null;
    }

    /**
     * 解析字符串为日期类型，如果解析失败并且不抛出异常，那么返回为null； 如果抛出异常，那么抛出DateFormatException。
     * 
     * @param dateStr
     *            需解析的日期字符串
     * @param isThrowException
     *            是否允许抛出异常
     * @return <code>Date</code>
     * @throws DateFormatException
     */
    public static Date parse(String dateStr, boolean isThrowException) throws Exception {
        Date date = parse(dateStr);
        if (date == null && isThrowException) {
            throw new Exception("Date Format Error:" + dateStr);
        }
        return date;
    }
 
    /**
     * 解析日期
     * 
     * @param date
     *            日期字符串
     * @param pattern
     *            日期格式
     * @return
     */
    public static Date parse(String date, String pattern) {
        Date resultDate = null;
        try {
            resultDate = new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            log.error(e);
        }
        return resultDate;
    }

    /**
     * 解析日期 yyyy-MM-dd
     * 
     * @param date
     *            日期字符串
     * @param pattern
     *            日期格式
     * @return
     */
    public static Date parseSimple(String date) {
        Date resultDate = null;
        try {
            resultDate = YYYY_MM_DD.parse(date);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return resultDate;
    }

    /**
     * 格式化日期字符串
     * 
     * @param date
     *            日期
     * @param pattern
     *            日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 格式化日期字符串
     * 
     * @param date
     *            日期
     * @param pattern
     *            日期格式
     * @return
     */
    public static String format(String strDate, String oldPattern, String newPattern) { 
        DateFormat format = new SimpleDateFormat(newPattern); 
        try {
            strDate = format.format(String2Date(strDate, oldPattern));
        } catch (ParseException e) {}
        return strDate;
    }

    /**
     * 取得当前日期
     * 
     * @return
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * @param offsetYear
     * @return 当前时间 + offsetYear
     */
    public static Timestamp getTimestampExpiredYear(int offsetYear) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, offsetYear);
        return new Timestamp(now.getTime().getTime());
    }

    /**
     * @param offsetMonth
     * @return 当前时间 + offsetMonth
     */
    public static Timestamp getCurrentTimestampExpiredMonth(int offsetMonth) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, offsetMonth);
        return new Timestamp(now.getTime().getTime());
    }

    /**
     * @param offsetDay
     * @return 当前时间 + offsetDay
     */
    public static Timestamp getCurrentTimestampExpiredDay(int offsetDay) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, offsetDay);
        return new Timestamp(now.getTime().getTime());
    }

    /**
     * @param offsetSecond
     * @return 当前时间 + offsetSecond
     */
    public static Timestamp getCurrentTimestampExpiredSecond(int offsetSecond) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.SECOND, offsetSecond);
        return new Timestamp(now.getTime().getTime());
    }

    /**
     * @param offsetDay
     * @return 指定时间 + offsetDay
     */
    public static Timestamp getTimestampExpiredDay(Date givenDate, int offsetDay) {
        Calendar date = Calendar.getInstance();
        date.setTime(givenDate);
        date.add(Calendar.DATE, offsetDay);
        return new Timestamp(date.getTime().getTime());
    }

    /**
     * 实现ORACLE中ADD_MONTHS函数功能
     * 
     * @param offsetMonth
     * @return 指定时间 + offsetMonth
     */
    public static Timestamp getTimestampExpiredMonth(Date givenDate, int offsetMonth) {
        Calendar date = Calendar.getInstance();
        date.setTime(givenDate);
        date.add(Calendar.MONTH, offsetMonth);
        return new Timestamp(date.getTime().getTime());
    }

    /**
     * @param offsetSecond
     * @return 指定时间 + offsetSecond
     */
    public static Timestamp getTimestampExpiredSecond(Date givenDate, int offsetSecond) {
        Calendar date = Calendar.getInstance();
        date.setTime(givenDate);
        date.add(Calendar.SECOND, offsetSecond);
        return new Timestamp(date.getTime().getTime());
    }
    
    /**
     * @param offsetSecond
     * @return 指定时间 + offsetSecond
     */
    public static Timestamp getTimestampExpiredHour(Date givenDate, int offsetHour) {
        Calendar date = Calendar.getInstance();
        date.setTime(givenDate);
        date.add(Calendar.HOUR, offsetHour);
        return new Timestamp(date.getTime().getTime());
    }

    /**
     * @return 当前日期 yyyy-MM-dd
     */
    public static String getCurrentDay() {
        return DateUtil.format(new Date(), "yyyy-MM-dd");
    }

    /**
     * @return 当前的时间戳 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowTime() {
        return DateUtil.format(new Date());
    }

    /**
     * @return 给出指定日期的月份的第一天
     */
    public static Date getMonthFirstDay(Date givenDate) {
        Date date = DateUtil.parse(DateUtil.format(givenDate, "yyyy-MM"), "yyyy-MM");
        return date;
    }

    /**
     * @return 给出指定日期的月份的最后一天
     */
    public static Date getMonthLastDay(Date givenDate) {
        Date firstDay = getMonthFirstDay(givenDate);
        Date lastMonthFirstDay = DateUtil.getTimestampExpiredMonth(firstDay, 1);
        Date lastDay = DateUtil.getTimestampExpiredDay(lastMonthFirstDay, -1);
        return lastDay;
    } 
    /**
     * @return 取得当前日期N(年，月、天...)前后的日期。N为正年是表示以后的，为负数时表示以前。
     * offset 偏移量。
     * offsetType 表示：年、月、日.... 其值为：ChronoUnit.YEARS ChronoUnit.MONTHS ChronoUnit.DAYS
     */
    public static String getNowDateOffset(int offset,TemporalUnit offsetType, String format) {
    	LocalDateTime today = LocalDateTime.now(); 
    	LocalDateTime dateOffsetDay = today.plus(offset, offsetType);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);   
        return dateOffsetDay.format(formatter);
    } 
public static void main(String[] args) throws Exception { 
   /* 
    Date tate1 = DateUtil.String2Date("20161213 14:00:00", "yyyyMMdd HH:mm:ss");
    
    
    Date tate2 = DateUtil.String2Date("20161213 15:39:30", "yyyyMMdd HH:mm:ss");
    
    System.out.println("-------------------------/60*60*10000"); 
    long start = tate1.getTime();  
    long end =  tate2.getTime();  
    System.out.println("start："+ start);
    System.out.println("end："+ end);
    System.out.println("运行时间："+(end - start)/3600000.0);
    System.out.println("-------------------------");*/
    
	 System.out.println(DateUtil.getTimeStamp().substring(0,17));
	String str = DateUtil.format(DateUtil.getTimestampExpiredSecond(new Date(),- 3600),DateUtil.LONG_DATE);
    System.out.println(str);
    System.out.println(3600*24);
	//String strFrontTime  = DateUtil.getNowDateOffset(-1, ChronoUnit.HOURS, "yyyyMMddHH");
	//String strCurrentTime = DateUtil.getNowDate("HH:mm:ss");
   // System.out.println(strFrontTime);
	 
    
    ///System.out.println(getNowDate("yyyy年MM月dd日 HH时mm分ss秒SSSSSS毫秒"));
    
    //System.out.println(DateUtil.format(DateUtil.parse("20150101","yyyyMMdd"),"yyyy-MM-dd"));
    //System.out.println(DateUtil.format(DateUtil.parse("20150827 18:52:27.000449"),"yyyy-MM-dd HH:mm:ss"));
	/*System.out.println(DateUtil.String2Date("20150101 12:00:00", "yyyyMMdd HH:mm:ss"));
	
	System.out.println(DateUtil.getNowDate("yyyyMMdd"));*/
	//System.out.println(new Timestamp (System.nanoTime()));
	//System.out.println(getCurrentTimestamp());
	//	for(int i=0;i < 0; i++) {
	//		System.out.println(DateUtil.getTimeStamp() );
		 
	//	}
		
		/*System.out.println(new SimpleDateFormat("yyyyMMdd HH:mm:ssSSS").format(new Date()));

		System.out.println(getNowDate("yyyyMMdd HH:mm:ssSSS"));
		
		System.out.println("-------------------------");
		System.out.println(System.currentTimeMillis());
		long start = System.currentTimeMillis(); //获取系统当前时间   
		//Thread.sleep(5134);
		System.out.println(System.currentTimeMillis());
		long end = System.currentTimeMillis(); //获取系统当前时间  
		
		System.out.println("运行时间："+(end - start));
		System.out.println("-------------------------");
		
		System.out.println(getNowDate("yyyyMMdd HH:mm:ss.SSS"));
		System.out.println(getNowDate("yyyyMMdd HH:mm:ss.SSSSSS"));
		System.out.println(getNowDate("yyyy-MM-dd_HHmmssSSS"));
		System.out.println(getNowDate("HHmmss"));
		System.out.println(getNowDate("yyyy-MM-dd HH:mm:ss SSSS"));
		
		System.out.println(getNowDate("yyyy年MM月dd日"));
		System.out.println(getNowDate("yyyy年MM月"));
		
		
		System.out.println("20111210 19:03:33".substring(0, 6));
		
		
		
		System.currentTimeMillis(); //可以提取到当前时间的毫秒数
		
		
		
		System.out.println(dateCompare("20110624",getNowDate("yyyyMMdd")));*/

	}
	
}
