package kr.joao.android.study.edittext;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	Button button1;
	EditText editText1, editText2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		
		button1.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		String id = editText1.getText().toString().trim();
		String password = editText2.getText().toString().trim();
		
		if(id.equals("") && password.equals("")){
			Toast.makeText(getApplicationContext(), "아이디와 패스워드를 입력해라", Toast.LENGTH_SHORT).show();
			
		}else{
			Toast.makeText(getApplicationContext(), id + "/" + password, Toast.LENGTH_SHORT).show();
		}
		
	}


}
