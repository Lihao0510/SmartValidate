package com.example.smartvalidator;

/*
 * 正则表达式常量类
 * @Author Lihao
 * @Edition v001
 */
public class RegexUtil {
	
	//手机号码正则表达式
	public static final String PHONE = "^(0{0,1}(13[0-9]|15[0-9]|17[0-9]|18[0-9])[0-9]{8})$";
	
	//小数/整数正则表达式
	public static final String NUM_FLOAT = "\\d+(\\.\\d+)?$";
}
