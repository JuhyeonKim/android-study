package kr.joao.android.study.activitylifecycleex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
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
		
		Log.i("SecondActivity", "onCreate");
		
	}
	
	@Override
	protected void onResume() {
		
		Log.i("SecondActivity", "onResume");
		
		Intent i = getIntent();
		String text = i.getStringExtra("text");
		editText1.setText(text);
		
		super.onResume();
		
	};
	
	
	
	@Override
	public void onClick(View v) {
		Log.i("SecondActivity", "onClick");
		
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

	
	@Override
	protected void onStart() {
		
		Log.i("SecondActivity", "onStart");
		
		super.onStart();
	}

	
	@Override
	protected void onStop() {
		 Log.d("SecondActivity", "onStop");
		super.onStop();
	}
	
	@Override
	protected void onPause() {
		 Log.d("SecondActivity", "onPause");
		super.onPause();
	}
	
	@Override
	protected void onDestroy() {
		Log.i("SecondActivity", "onDestory");
		
		super.onDestroy();
	}
	

}
