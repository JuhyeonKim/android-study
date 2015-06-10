package kr.joao.android.study.prefex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;

public class ConfigActivity extends ActionBarActivity {
	
	EditText editText1, editText2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_config);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
	}
	
	@Override
	public void onBackPressed() {
		
		String id = editText1.getText().toString();
		String name = editText2.getText().toString();

		SharedPreferences pref = getSharedPreferences("config", Context.MODE_PRIVATE);
		
		Editor edit = pref.edit();
		
		edit.putString("name", name);
		edit.putString("id", id);
		
		edit.commit();
		
		finish();
	}
}
