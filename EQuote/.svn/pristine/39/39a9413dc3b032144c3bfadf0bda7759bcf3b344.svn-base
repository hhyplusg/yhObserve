package com.wave.core.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 数学工具类
 * @author zgd
 *
 */
public class RandomUtil {
    /**
     * 取得指定长度的由数字组成的随机字符串
     * @param length 长度
     * @return 返回值
     */
    public static String getRandomNum(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }
    
    /**
     * 生成固定长度的随机字符
     * @param len
     * @return
     */
    public static String generateRandomChar(Integer len) {
        // 生成字母A-Z,a-z 之间的随机字符
    
        StringBuffer sb = new StringBuffer();
        for (Integer i = 0; i < len; i++) {
            int intRand = (int) (Math.random() * 52);
            char base = (intRand < 26) ? 'A' : 'a';
            char c = (char) (base + intRand % 26);
            sb.append(c);
        }
        return sb.toString();
    }
    /**
     * 生成固定长度的随机字符和数字
     * @param len
     * @return
     */
    public static String generateRandomCharAndNumber(Integer len) {
        StringBuffer sb = new StringBuffer();
        for (Integer i = 0; i < len; i++) {
            int intRand = (int) (Math.random() * 52);
            int numValue = (int) (Math.random() * 10);
            char base = (intRand < 26) ? 'A' : 'a';
            char c = (char) (base + intRand % 26);
            if(numValue%2==0){
                sb.append(c);
            }else{
                sb.append(numValue);
            }
        }
        return sb.toString();
    }

    public static String getCharAndNumr(Integer length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)){// 字符串
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                sb.append((char) (choice + random.nextInt(26)));
            } else if ("num".equalsIgnoreCase(charOrNum)){// 数字
                sb.append(String.valueOf(random.nextInt(10)));
            }
        }
        return sb.toString();
    } 
     
     //两个大正数相加第一种方法
    //return x+y. Have not considered the negative number yet.  
    public static String add(String x,String y){  
        if(x==null||y==null){  
            return null;  
        }  
        if(!isNumeric(x)||!isNumeric(y)){  
            return null;  
        }  
        if(x.equals("0")){  
            return y;  
        }  
        if(y.equals("0")){  
            return x;  
        }  
        int num = y.length();
        if(x.length()>y.length()){  
            num = x.length(); 
        }  
        x=addZeroToFirst(x,num); 
        y=addZeroToFirst(y,num);
        String z=addHelp(x,y);  
        return z;  
    }  
    public static String addHelp(String x,String y){  
        String z="";  
        int len=x.length();  
        int[] a=toIntArray(x);  
        int[] b=toIntArray(y);  
        int[] c=new int[len+1];  
        int d=0;//to carry. No need to use int[]  
        for(int i=0;i<len;i++){  
            int tmpSum=a[len-1-i]+b[len-1-i]+d;  
            c[len-i]=tmpSum%10;  
            d=tmpSum/10;  
        }  
        c[0]=d;  
        StringBuilder sb=new StringBuilder();  
        for(int i=0;i<=len;i++){  
            sb.append(c[i]);  
        }  
        if(c[0]==0){//delete the first '0' in result string  
            z=sb.substring(1);  
        }else{  
            z=sb.toString();  
        }  
        return z;  
    }  
    //String - toCharArray - toIntArray  
    public static int[] toIntArray(String str){  
        int len=str.length();  
        int[] result=new int[len];  
        for(int i=0;i<len;i++){  
            result[i]=str.charAt(i)-'0';  
        }  
        return result;  
    }  
    //("123",5)-->"00123"  
    public static String addZeroToFirst(String str,int length){  
        StringBuilder sb=new StringBuilder();  
        int diff=length-str.length();  
        while(diff>0){  
            sb.append("0");  
            diff--;  
        }  
        sb.append(str);  
        return sb.toString();  
    }  
    public static boolean isNumeric(String str){  
        Pattern p=Pattern.compile("[0-9]*");  
        Matcher isNum=p.matcher(str);  
        return isNum.matches();  
    }  
  
    
    //两个大数字相加第二种方法 
    public static String add2(String a, String b) {  
        //检查输入  
        if (!a.matches("\\d+") || !a.matches("\\d+")) {  
            return null;  
        }  
        final int BASE = 10;//10进制  
        int lenA = a.length();//加数的长度  
        int lenB = b.length();//被加数的长度  
        int maxLen, partialSum, carry = 0;//大数的长度，和，进位  
        maxLen = (lenA > lenB) ? lenA : lenB;  
        StringBuffer sum = new StringBuffer();  
        int temA, temB = 0;  
        for (int i = 0; i < maxLen; i++) {  
            if (i >= lenA) {  
                temA = 0;  
            } else {  
                temA = Integer.valueOf(a.charAt(lenA - i - 1) - 48);  
            }  
            if (i >= lenB) {  
                temB = 0;  
            } else {  
                temB = Integer.valueOf(b.charAt(lenB - i - 1) - 48);  
            }  
            partialSum = temA + temB + carry;  
            carry = partialSum / BASE;  
            sum.append(partialSum % BASE);  
        }  
        if (carry == 1)  
            sum.append(carry);  
        return sum.reverse().toString();  
    }  
    
    //两个大数字相加第三种方法 
   public static String add3(String a, String b) {  
        String str = "";  
        int lenA = a.length();  
        int lenB = b.length();  
        int maxLen = (lenA > lenB) ? lenA : lenB;  
        int minLen = (lenA < lenB) ? lenA : lenB;  
        String strTmp = "";  
        for (int i = maxLen - minLen; i > 0; i--) {  
            strTmp += "0";  
        }  
        // 把长度调整到相同  
        if (maxLen == lenA) {  
            b = strTmp + b;  
        } else  
            a = strTmp + a;  
        int JW = 10;// 进位  
        for (int i = maxLen - 1; i >= 0; i--) {  
            int tempA = Integer.parseInt(String.valueOf(a.charAt(i)));  
            int tempB = Integer.parseInt(String.valueOf(b.charAt(i)));  
            int temp;  
            if (tempA + tempB + JW >= 10 && i != 0) {  
                temp = tempA + tempB + JW - 10;  
                JW = 1;  
            } else {  
                temp = tempA + tempB + JW;  
                JW = 0;  
            }  
            str = String.valueOf(temp) + str;  
        }  
        return str;  
    }  
   
    /**
     *  32、16、10、8、2进制字符串转换为10 进制数字
    */
    static int CONVERT_ERROR = -1;
    private final static char[][] RADIX_BM = {
       {'0', '1' },
       {'0', '1', '2', '3', '4', '5', '6', '7' },
       {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'},
       {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f' },
       {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n','o', 'p', 'q', 'r', 's', 't', 'u' , 'v'}
    };
    private static int binCk(int num, char bin[], int len, char ch) {
        if (num == 0) {
            if (!Character.isDigit(ch) || ch < '0' || ch > '1') {
                return CONVERT_ERROR;
            }
        } else if (num == 1) {
            if (!Character.isDigit(ch) || ch < '0' || ch > '7') {
                   return CONVERT_ERROR;
            }
        } else if (num == 2) {
            if (!Character.isDigit(ch) || ch < '0' || ch > '9') {
                return CONVERT_ERROR;
            }
        } else if (num == 3) {
            if (!Character.isLetterOrDigit(ch)) {
                   return CONVERT_ERROR;
            }
            if (Character.isLetter(ch)) {
                ch = String.valueOf(ch).toLowerCase().toCharArray()[0];
            }
        } else if (num == 4) {
            if (!Character.isLetterOrDigit(ch)) {
                return CONVERT_ERROR;
            }
            if (Character.isLetter(ch)) {
                ch = String.valueOf(ch).toLowerCase().toCharArray()[0];
            }
        } else {
            if (!Character.isDigit(ch) || ch < '0' || ch > '1') {
                return CONVERT_ERROR;
            }
        }
        for (int k = 0; k < len; k++) {
            if (ch == bin[k]) {
                return k;
            }
        }
        return CONVERT_ERROR;
    }
    
   /**
    *  2 8 10 16 32 转10
    * @param str
    * @param num
    * @return
    */
    public static BigInteger binChar(char[] str, int num) {
        int len = 2;
        char bin[] = null;
        len = RADIX_BM[num].length;
        bin = RADIX_BM[num];
        boolean flag = true;
        int lenStr = str.length;
        String getRes = "0";
        BigInteger dec = new BigInteger("0");
        int oneStr ='0';
        for (int i = 0; i < lenStr; i++) {
            oneStr = binCk(num, bin, len, str[i]);
            if (oneStr == CONVERT_ERROR) {
                flag = false;
                break;
            }
            getRes = String.valueOf(oneStr * Math.pow(len, lenStr - 1 - i));
            dec = dec.add(new BigInteger(getRes.substring(0, getRes.length() - 2 )));
        }
        return flag == true ? dec : new BigInteger("0");
    }
       
   /**
    * 10进制 转 2 8 10 16 32 
    * @param strInfo
    * @param jinzhi
    * @param num
    */
    public static String charBin(String strInfo, String jinzhi, int num) {   
        int i = 0;
        BigInteger str = new BigInteger(strInfo);
        List<String> name = new ArrayList<String>();
        do {  
            BigInteger result[] = str.divideAndRemainder(new BigInteger(jinzhi));
            if(!result[0].toString().equals("0")) {   
                i = 1;  
                str = result[0];
            } else {
                i = 0;
            }
            char numsss = RADIX_BM[num][Integer.parseInt(result[1].toString())];
            name.add(String.valueOf(numsss));
        }while(i==1);  
        Collections.reverse(name);
        StringBuffer sb = new StringBuffer("");
        for (int h = 0; h < name.size();h ++ ){
            sb.append(name.get(h));   
        }
        return sb.toString();
    }  
    
    /**
     * 提供 自动编码 
     * @param seed 种子，即当前最大的该类编码
     * @param bmlen 代长，每代的长度
     * @param radix 进制，按照什么进制进行编码
     * @param radixlen 进制的长度
     * @param auto 自动增长长度
     **/
    public synchronized static String generateBM(String seed, int bmlen, int radix, String radixlen, String auto){
        //转换进制 10
        String newMaxNum = add2(seed, auto);
        String nowNum = charBin(newMaxNum, radixlen, radix);
        return nowNum;
    } 
    
    /**
     * 制定长度的数字 自动加一  前面自动补0 
     * @param len 长度 
     * @param num 制定数字
     * @return
     */
    public static String getAutoCkNum(int len, String autoNum) {
            int autoLen = autoNum.length();
            StringBuilder STR_FORMAT = new StringBuilder(len);
            for (int k = 0; k < len-autoLen; k++) {
                STR_FORMAT.append("0");
            }
            STR_FORMAT.append(autoNum);
            return STR_FORMAT.toString();
//        DecimalFormat df = new DecimalFormat(STR_FORMAT.toString());
//        return df.format(autoNum);
    }
    
    public static int RADIX_HEX = 3;
    public static String RADIX_NUM = "16";
    public static String AUTO_NUM = "1";
    public static int ORG_LEN = 6;
       /** 
        * 题目：java实现两个大数相加，可能存在溢出。 
        * 如123456789 + 987654321 返回 1111111110 
        * 1.直接用BigInteger 
        * 2.模拟手算加法，进位相加（暂时没有考虑负数的情况） 
        */  
       public static void main(String[] args) {
           
           Long t1 = System.currentTimeMillis();
           String x="9";  
           String y="3";  
           String d=add(x,y);  
           Long t2 = System.currentTimeMillis();
           System.out.println("result:1  " +d +"---------"+ (t2-t1));  
           
           Long t3 = System.currentTimeMillis();
           String a = "9";  
           String b = "3";  
           String result = add2(a, b); 
           Long t4 = System.currentTimeMillis();
           System.out.println("result:2  " + result + "---------"+ (t4-t3));  
           
           Long t5 = System.currentTimeMillis();
           String a3 = "9";  
           String b3 = "3";  
           String result3 = add3(a3, b3); 
           Long t6 = System.currentTimeMillis();
           System.out.println("result:3  " + result3 + "---------"+(t6-t5));  
           System.out.println("-------------------------------------------------------------");
           
           // 10 进制 转 2 8 16 32
           Long t7 = System.currentTimeMillis();
           String s1 = charBin("0018", "2", 0);
           Long t8 = System.currentTimeMillis();
           System.out.println(s1 + "------------"+ (t8-t7));
           Long t9 = System.currentTimeMillis();
           String s2 = charBin("0018", "8", 1);
           Long t10 = System.currentTimeMillis();
           System.out.println(s2+ "------------"+ (t10-t9));
           Long t11 = System.currentTimeMillis();
           String s3 = charBin("0018", "10", 2);
           Long t12 = System.currentTimeMillis();
           System.out.println(s3+ "------------"+ (t12-t11));
           Long t13 = System.currentTimeMillis();
           String s4 = charBin("0018", "16", 3);
           Long t14 = System.currentTimeMillis();
           System.out.println(s4+ "------------"+ (t14-t13));
           Long t133 = System.currentTimeMillis();
           String s5 = charBin("0018", "32", 4);
           Long t144 = System.currentTimeMillis();
           System.out.println(s5+ "------------"+ (t144-t133));
           System.out.println("-----------------------------------------");
           // 2 8 16 32 转10
            char str1[] = "10010".toCharArray();
            char str2[] = "22".toCharArray();
            char str3[] = "18".toCharArray();
            char str4[] = "12".toCharArray();
            char str5[] = "i".toCharArray();
            BigInteger info1 = binChar(str1, 0);
            System.out.println(info1);
            BigInteger info2 = binChar(str2, 1);
            System.out.println(info2);
            BigInteger info3 = binChar(str3, 2);
            System.out.println(info3);
            BigInteger info4 = binChar(str4, 3);
            System.out.println(info4);
            BigInteger info5 = binChar(str5, 4);
            System.out.println(info5);
            System.out.println("-----------------------------------------");
            
            // 进制  2 8 10 16 32 转 10 
            BigInteger test1=new BigInteger("10010", 2);
            System.out.println(test1.toString(10)+"-------sss-----");  
            BigInteger test2=new BigInteger("22", 8);
            System.out.println(test2.toString(10)+"-------sss-----"); 
            BigInteger test22=new BigInteger("18", 10);
            System.out.println(test22.toString(10)+"-------sss-----"); 
            BigInteger test3=new BigInteger("12", 16);
            System.out.println(test3.toString(10)+"-------sss-----");  
            BigInteger test4=new BigInteger("i", 32);
            System.out.println(test4.toString(10)+"-------sss-----");  
            System.out.println("-----------------------------------------");
            // 进制 10  转 2 8 10 16 32 
            Long t15 = System.currentTimeMillis();
            BigInteger test5=new BigInteger("123453243455535634535252345234677576252241234123523453664563634", 10);
            System.out.println(test5.toString(2)+"-------sss-----"); 
            Long t16 = System.currentTimeMillis();
            System.out.println((t16-t15)+"-------sss-----"); 
            Long t17 = System.currentTimeMillis();
            BigInteger test6=new BigInteger("123453243455535634535252345234677576252241234123523453664563634", 10);
            System.out.println(test6.toString(8)+"-------sss-----"); 
            Long t18 = System.currentTimeMillis();
            System.out.println((t18-t17)+"-------sss-----"); 
            Long t177 = System.currentTimeMillis();
            BigInteger test66=new BigInteger("123453243455535634535252345234677576252241234123523453664563634", 10);
            System.out.println(test66.toString(10)+"-------sss-----"); 
            Long t188 = System.currentTimeMillis();
            System.out.println((t188-t177)+"-------sss-----"); 
            Long t19 = System.currentTimeMillis();
            BigInteger test7=new BigInteger("123453243455535634535252345234677576252241234123523453664563634", 10);
            System.out.println(test7.toString(16)+"-------sss-----"); 
            Long t20 = System.currentTimeMillis();
            System.out.println((t20-t19)+"-------sss-----"); 
            Long t21 = System.currentTimeMillis();
            BigInteger test8=new BigInteger("123453243455535634535252345234677576252241234123523453664563634", 10);
            System.out.println(test8.toString(32)+"-------sss-----"); 
            Long t22 = System.currentTimeMillis();
            System.out.println((t21-t22)+"-------sss-----"); 
            
            BigInteger test111=new BigInteger("1000", 10);
            System.out.println(test111.toString(16)+"---dddddddd----sss-----"); 
            
            
            
       }
}
