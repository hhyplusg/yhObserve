package com.wave.core.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

/**
 * 把汉字转化为拼音的类
 * 只转换汉字，其它保持原样
 * @author likaiyong
 * @date 2009-10-09
 * 
 */
public class PinyinUtil {

	/**
	 * 汉字转换为汉语拼音首字母，英文字符不变
	 * 只转换汉字，其它保持原样
	 * @param chines 汉字
	 * @return 拼音首字母
	 */
	public static String converterToFirstSpell(String chines) {
		StringBuffer pinyinName = new StringBuffer();
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					String[] psa=PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
					if(psa!=null){
						pinyinName.append(psa[0].charAt(0));
					}
				} catch (Exception e) {
					pinyinName.append(nameChar[i]);
				}
			} else {
				pinyinName.append(nameChar[i]);
			}
		}
		return pinyinName.toString();
	}

	/**
	 * 汉字转换为汉语拼音，英文字符不变
	 * 只转换汉字，其它保持原样
	 * @param chines 汉字
	 * @return 拼音
	 */
	public static String converterToSpell(String chines) {
		StringBuffer pinyinName = new StringBuffer();
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	 
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					pinyinName.append(PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0]);
				} catch (Exception e) {
					pinyinName.append(nameChar[i]);
				}
			} else {
				pinyinName.append(nameChar[i]);
			}
		}
		return pinyinName.toString();
	}
}
