package kr.joao.android.study.prefex;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	
	TextView textView1;
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView1 = (TextView) findViewById(R.id.textView1);
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(this,ConfigActivity.class);
		
		startActivity(i);
		
	}
	
	@Override
	protected void onResume() {
		
		
		SharedPreferences pref = getSharedPreferences("config", Context.MODE_PRIVATE);
		
		String id = pref.getString("id", "없는데이터입니다.");
		String name = pref.getString("name", "초기화되었음.");
		
		textView1.setText("ID : " + id + ",Name : " + name);
		
		super.onResume();
	}

	
}
