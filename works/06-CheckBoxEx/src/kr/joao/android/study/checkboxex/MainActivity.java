package kr.joao.android.study.checkboxex;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener, OnCheckedChangeListener {
	
	TextView textView2;
	
	CheckBox checkBox1;
	CheckBox checkBox2;
	CheckBox checkBox3;
	
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView2 = (TextView) findViewById(R.id.textView2);
		
		checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
		checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
		checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
		
		button1 = (Button) findViewById(R.id.button1);
		
		checkBox1.setOnCheckedChangeListener(this);
		checkBox2.setOnCheckedChangeListener(this);
		checkBox3.setOnCheckedChangeListener(this);
		
		button1.setOnClickListener(this);
				
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		
		String msg = buttonView.getText().toString();
		
		if(isChecked){
			textView2.setText(msg+"입니다.");
		}
	}

	@Override
	public void onClick(View v) {
		StringBuffer sb = new StringBuffer();
		
		if(checkBox1.isChecked()){
			sb.append(checkBox1.getText().toString());
			sb.append(",");
		}
		if(checkBox2.isChecked()){
			sb.append(checkBox2.getText().toString());
			sb.append(",");
			
		}
		if(checkBox3.isChecked()){
			sb.append(checkBox3.getText().toString());
			sb.append(",");
			
		}
		
		Toast.makeText(getApplicationContext(), sb.toString() + "이 선택되었다", Toast.LENGTH_SHORT).show();
		
	}
	
	
	
	
	
	

}
