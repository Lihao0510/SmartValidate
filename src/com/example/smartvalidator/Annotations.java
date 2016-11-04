package com.example.smartvalidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * ע����,�����ؼ�ע��ID�������֤
 * @Author Lihao
 * @Edition v001
 */
public class Annotations {
	
	public static final String NO_REGEX = "NullContent";
	
	//����ʵ����ؼ�ע��ID,������ButterKnife���÷�
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface Inject{
		
		int value() default -1;
		
	}
	
	//���ڱ����Ҫ����������֤�Ŀؼ�,canNull�����Ƿ����Ϊ��,regexΪ������ʽ
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface Validated{
		
		boolean canNull() default true;
		String regex() default NO_REGEX;
		
	}
}
