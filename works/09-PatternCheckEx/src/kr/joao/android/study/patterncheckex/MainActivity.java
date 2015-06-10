package kr.joao.android.study.patterncheckex;

import kr.joao.android.study.helper.RegexHelper;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	
	EditText name;
	EditText email;
	EditText address;
	EditText phone;
	Button button1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		name = (EditText) findViewById(R.id.name);
		email = (EditText) findViewById(R.id.email);
		address = (EditText) findViewById(R.id.address);
		phone = (EditText) findViewById(R.id.phone);
		
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		
		String strName = name.getText().toString();
		String strEmail = email.getText().toString();
		String strAddress = address.getText().toString();
		String strPhone = phone.getText().toString();
		
		String err_msg=null;
		
		if(err_msg == null && !RegexHelper.getInstance().isValue(strName) ){
			err_msg = "이름을 입력해";
		}
		if(err_msg == null && !RegexHelper.getInstance().isKor(strName) ){
			err_msg = "이름은 한글이";
		}
		if(err_msg == null && !RegexHelper.getInstance().isValue(strEmail) ){
			err_msg = "이멜주솔입력";
		}
		if(err_msg == null && !RegexHelper.getInstance().isEmail(strEmail) ){
			err_msg = "이멜이 이상하";
		}
		if(err_msg == null && !RegexHelper.getInstance().isValue(strAddress) ){
			err_msg = "주솔 입력해";
		}
		if(err_msg == null && !RegexHelper.getInstance().isValue(strPhone) ){
			err_msg = "전화번호 입력";
		}
		if(err_msg == null && !RegexHelper.getInstance().isTel(strPhone) ){
			err_msg = "전화번호 형식이 이상";
		}
		
		 if(err_msg != null){
			 Toast.makeText(getApplicationContext(), err_msg, Toast.LENGTH_SHORT).show();
			 return ;
		 }
		 
		 StringBuffer sb = new StringBuffer();
		 sb.append("이름 : ");
		 sb.append(strName);
		 sb.append("\n");
		 sb.append("Email : ");
		 sb.append(strEmail);
		 sb.append("\n");
		 sb.append("Address : ");
		 sb.append(strAddress);
		 sb.append("\n");
		 sb.append("Phone : ");
		 sb.append(strPhone);
		 sb.append("\n");
		
		 
		 Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
	}
	
	

}
