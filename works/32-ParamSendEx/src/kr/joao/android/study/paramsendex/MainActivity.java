package kr.joao.android.study.paramsendex;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	Button button1,button2;
	EditText editText1, editText2;
	
	TextView textView1;
	
	AsyncHttpClient client;
	
	HttpResponse response;
	
	
	final String URL_GET="http://itpaper.co.kr/demo/android/txt/send_get.php";
	final String URL_POST="http://itpaper.co.kr/demo/android/txt/send_post.php";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		textView1 = (TextView) findViewById(R.id.textView1);
		
		client = new AsyncHttpClient();
		response = new HttpResponse();
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		String id = editText1.getText().toString();
		String password = editText2.getText().toString();
		
		RequestParams param = new RequestParams();
		param.put("user_id", id);
		param.put("user_pw", password);
		

		switch (v.getId()) {
		case R.id.button1:
			
			client.get(URL_GET, param ,response);
			
			
			break;
		case R.id.button2:
			
			client.post(URL_POST, param ,response);
			
			break;

		default:
			break;
		}
		
	}
	
	public class HttpResponse extends AsyncHttpResponseHandler{
		
		ProgressDialog dialog;
		
		@Override
		public void onStart() {
			
			dialog = new ProgressDialog(MainActivity.this);
			dialog.setMessage("잠시만 기달.");
			dialog.setCancelable(false);
			dialog.show();
			
		};

		
		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2,
				Throwable arg3) {
			
			String errMsg = "Status Code : " + arg0 + "\n " + "Error Message : " + arg3.getMessage();
			
			textView1.setText(errMsg);
			
		}

		@Override
		public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
			
			try {
				String result = new String(arg2,"UTF-8");
				String displayString = "";
				
				if(result.equals("OK")){
					displayString = "Login Success.";
				}else if(result.equals("FAIL")){
					displayString = "Login Failed.";
				}
				
				textView1.setText(displayString);
				
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void onFinish() {
			
			dialog.dismiss();
			dialog = null;
		}
		
	}

}
