package kr.joao.android.study.activityresultex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends ActionBarActivity implements OnClickListener{
	
	private Button button1, button2;
	private EditText editText1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		Intent i = getIntent();
		String text = i.getStringExtra("text");
		editText1.setText(text);
	}
	
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			
			String editedText = editText1.getText().toString();
			Intent i = new Intent();
			i.putExtra("text", editedText);
			
			setResult(Activity.RESULT_OK,i);
			finish();
			
			break;
		case R.id.button2:
			
			setResult(Activity.RESULT_CANCELED);
			
			finish();
			break;

		default:
			break;
		}
		
		
	}


}
