package com.example.smartvalidator;

/*
 * ������ʽ������
 * @Author Lihao
 * @Edition v001
 */
public class RegexUtil {
	
	//�ֻ�����������ʽ
	public static final String PHONE = "^(0{0,1}(13[0-9]|15[0-9]|17[0-9]|18[0-9])[0-9]{8})$";
	
	//С��/����������ʽ
	public static final String NUM_FLOAT = "\\d+(\\.\\d+)?$";
}
