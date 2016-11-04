package com.example.smartvalidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * 注释类,包含控件注入ID和添加验证
 * @Author Lihao
 * @Edition v001
 */
public class Annotations {
	
	public static final String NO_REGEX = "NullContent";
	
	//用于实现向控件注入ID,类似于ButterKnife的用法
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface Inject{
		
		int value() default -1;
		
	}
	
	//用于标记需要进行输入验证的控件,canNull控制是否可以为空,regex为正则表达式
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface Validated{
		
		boolean canNull() default true;
		String regex() default NO_REGEX;
		
	}
}
