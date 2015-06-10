package kr.joao.android.study.simplehttpex;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	Button button1;
	
	TextView textView1;
	
	AsyncHttpClient client;
	
	HttpResponse response;
	
//	String URL = "http://itpaper.co.kr/demo/android/txt/simple_text.txt";
	String URL = "http://www.naver.com";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		button1 = (Button) findViewById(R.id.button1);
		textView1 = (TextView) findViewById(R.id.textView1);
		
		client = new AsyncHttpClient();
		response = new HttpResponse();
		
		button1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		client.get(URL,response);
		
	}
	
	public class HttpResponse extends AsyncHttpResponseHandler{

		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2,
				Throwable arg3) {
			
			String errMsg = "Status Code : " + arg0 + "\n " + "Error Message : " + arg3.getMessage();
			
			textView1.setText(errMsg);
			
		}

		@Override
		public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
			
			try {
				String result = "Status Code : " + arg0 + " \n";
				result += new String(arg2,"UTF-8");
				textView1.setText(result);
				
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

}
