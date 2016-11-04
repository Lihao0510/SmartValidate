package com.example.widge;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.example.smartvalidator.Annotations;
import com.example.smartvalidator.Annotations.Inject;
import com.example.smartvalidator.Annotations.Validated;

import android.app.Activity;
import android.util.Log;

public class InputValidator {

	public static List<SmartEditText> inputList;
	public static boolean isChecked;

	public static void init(Activity activity) {
		if (inputList != null) {
			inputList.clear();
		} else {
			inputList = new ArrayList<SmartEditText>();
		}

		Class<? extends Activity> clazz = activity.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Inject.class)) {
				Inject annotation = field.getAnnotation(Inject.class);
				int id = annotation.value();
				if (id >= 0) {
					try {
						field.set(activity, activity.findViewById(id));
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (field.isAnnotationPresent(Validated.class)) {
				Validated annotation = field.getAnnotation(Validated.class);
				boolean canNull = annotation.canNull();
				String regex = annotation.regex().equals(Annotations.NO_REGEX) ? null : annotation.regex();
				Log.d("Lihao", canNull + regex);
				SmartEditText editText;
				try {
					editText = (SmartEditText) (field.get(activity));
					editText.setSmartInputListener(canNull, regex);
					inputList.add(editText);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	public static boolean validate() {
		isChecked = true;
		if (inputList == null) {
			return false;
		} else {
			Log.d("Lihao", inputList.toString());
			for (SmartEditText editText : inputList) {
				if (!editText.validate()) {

					isChecked = false;
				}
			}
			return isChecked;
		}
	}
}
