package com.example.smartvalidator;

import com.example.smartvalidator.Annotations.Inject;
import com.example.smartvalidator.Annotations.Validated;
import com.example.widge.InputValidator;
import com.example.widge.SmartEditText;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SmartValidateActivity extends Activity {

	@Inject(R.id.et_input0)
	@Validated(canNull = false, regex = RegexUtil.PHONE)
	public SmartEditText input0;
	
	@Inject(R.id.et_input1)
	@Validated(canNull = false, regex = RegexUtil.NUM_FLOAT)
	public SmartEditText input1;
	
	@Inject(R.id.et_input2)
	@Validated(regex = RegexUtil.PHONE)
	public SmartEditText input2;
	
	@Inject(R.id.et_input3)
	@Validated(canNull = false)
	public SmartEditText input3;
	
	@Inject(R.id.et_input4)
	public SmartEditText input4;
	
	@Inject(R.id.et_input5)
	@Validated(canNull = true, regex = RegexUtil.NUM_FLOAT)
	public SmartEditText input5;
	
	@Inject(R.id.bt_submit)
	public Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_smart_validate);
		initData();
	}

	private void initData() {
		InputValidator.init(this);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(InputValidator.validate()){
					Toast.makeText(SmartValidateActivity.this, "��֤�ɹ�!", 0).show();
				}else{
					Toast.makeText(SmartValidateActivity.this, "��֤ʧ��,�����д���!", 0).show();
				}
			}
		});
	}

}
