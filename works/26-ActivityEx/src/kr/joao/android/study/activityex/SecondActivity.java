package kr.joao.android.study.activityex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends ActionBarActivity implements OnClickListener{
	
	TextView textView1;
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent intent = getIntent();
		
		String name = intent.getStringExtra("name");
		
		textView1 = (TextView) findViewById(R.id.textView1);
		button1 = (Button) findViewById(R.id.button1);
		textView1.setText(name);
		
		button1.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View v) {
		
		finish();
		
	}

}
