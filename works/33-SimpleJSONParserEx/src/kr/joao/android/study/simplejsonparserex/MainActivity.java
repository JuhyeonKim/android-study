package kr.joao.android.study.simplejsonparserex;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	
	TextView textView1;
	Button button1;
	String URL = "http://itpaper.co.kr/demo/android/json/simple.json";
	
	HttpResponse response;
	AsyncHttpClient client;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		textView1 = (TextView) findViewById(R.id.textView1);
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(this);
		
		response = new HttpResponse();
		client = new AsyncHttpClient();
	}

	@Override
	public void onClick(View v) {
		
		client.get(URL, response);
		
		
	}
	
	public class HttpResponse extends AsyncHttpResponseHandler{
		
		ProgressDialog dialog;
		
		@Override
		public void onStart() {
			
			dialog = new ProgressDialog(MainActivity.this);
			dialog.setCancelable(false);
			dialog.setMessage("Loding....");
			dialog.show();
			
			
		}

		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2,
				Throwable arg3) {
			
			Toast.makeText(getApplicationContext(), "Error Code : " + arg0 + "Error Message"  + arg3.getMessage(), Toast.LENGTH_SHORT).show();
			
		}

		@Override
		public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
			
			try {
				String str = new String(arg2,"UTF-8");
				JSONObject json = new JSONObject(str);
				JSONObject device = json.getJSONObject("device");
				String name = device.getString("name");
				String type = device.getString("type");
				
				textView1.setText(name + " / " + type);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e){
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
