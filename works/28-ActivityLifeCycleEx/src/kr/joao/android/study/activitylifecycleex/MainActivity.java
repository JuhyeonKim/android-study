package kr.joao.android.study.activitylifecycleex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	private Button button1;
	private TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.d("MainActivity", "onCreate");
		
		button1 = (Button) findViewById(R.id.button1);
		textView1 = (TextView) findViewById(R.id.textView1);
		
		button1.setOnClickListener(this);
		
	}
	
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(this,SecondActivity.class);
		
		String text = textView1.getText().toString();
		
		i.putExtra("text", text);
		
		Log.d("MainActivity", "onClick");
		
		startActivityForResult(i, 100);
	}
	
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		
		Log.d("MainActivity", "onActivityResult");
		
		switch (arg0) {
		case 100:
			
			if(arg1 == Activity.RESULT_OK){
				String editedText = arg2.getStringExtra("text");
				textView1.setText(editedText);
			}
			
			break;

		default:
			break;
		}
		
		super.onActivityResult(arg0, arg1, arg2);
		
		
		
	}
	
	@Override
	protected void onStart() {
		
		Log.d("MainActivity", "onStart");
		
		super.onStart();
	}
	
	@Override
	protected void onResume() {
		
		Log.d("MainActivity", "onResume");
		
		super.onResume();
	}
	
	@Override
	protected void onStop() {
		 Log.d("MainActivity", "onStop");
		super.onStop();
	}
	
	@Override
	protected void onPause() {
		 Log.d("MainActivity", "onPause");
		super.onPause();
	}
	
	
	@Override
	protected void onDestroy() {
		Log.d("MainActivity", "onDestory");
		
		super.onDestroy();
	}

}
