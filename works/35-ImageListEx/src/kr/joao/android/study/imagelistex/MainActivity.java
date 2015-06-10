package kr.joao.android.study.imagelistex;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import kr.joao.android.study.imagelistex.helper.ImageHelper;
import kr.joao.android.study.imagelistex.model.Column;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends ActionBarActivity {
	
	private ListView listView1;
	
	private String URL="http://itpaper.co.kr/demo/android/json/column.json";
	

	private DisplayImageOptions options;
	
	private ColumnAdapter adapter;
	
	private ColumnResponse response;
	
	private AsyncHttpClient client;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		response = new ColumnResponse();
		client = new AsyncHttpClient();
		
		adapter = new ColumnAdapter(this, R.layout.item_layout, new ArrayList<Column>());
		options = ImageHelper.getInstance().getImageOptions(this);
		
		listView1 = (ListView) findViewById(R.id.listView1);
		listView1.setAdapter(adapter);
		
	}
	
	@Override
	protected void onResume() {
		client.get(URL, response);
		
		super.onResume();
		
	}
	
	
	private class ColumnAdapter extends ArrayAdapter<Column>{
		
		private int resource;
		
		public ColumnAdapter(Context context, int resource, List<Column> objects) {
			super(context, resource, objects);
			
			this.resource = resource;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View item = convertView;
			
			if(item == null){
				item = getLayoutInflater().inflate(resource, null);
			}
			
			
			if(item != null){
				Column column = adapter.getItem(position);
				
				ImageView imageView1 = (ImageView)item.findViewById(R.id.imageView1);
				TextView textView1 = (TextView)item.findViewById(R.id.textView1);
				TextView textView2 = (TextView)item.findViewById(R.id.textView2);
				
				int num = column.getNum();
				String subject = column.getSubject();
				String contents = column.getContents();
				
				textView1.setText(subject);
				textView2.setText(contents);
				
				ImageLoader.getInstance().displayImage(column.getImg(), imageView1);
			}

			return item;
			
			
		}
	}
	
	private class ColumnResponse extends AsyncHttpResponseHandler{
		
		private ProgressDialog dialog;
		
		@Override
		public void onStart() {
			dialog = new ProgressDialog(MainActivity.this);
			dialog.setMessage("Pleas waiting....");
			dialog.setCancelable(false);
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
				String result = new String(arg2,"UTF-8");
				JSONObject jsonObject = new JSONObject(result);
				JSONObject column = jsonObject.getJSONObject("column");
				JSONArray items = column.getJSONArray("item");
				
				for(int i=0;i<items.length();i++){
					JSONObject item = items.getJSONObject(i);
					
					int num = item.getInt("num");
					String img = item.getString("img");
					String subject = item.getString("subject");
					String contents = item.getString("content");
					
					adapter.add(new Column(num,img,subject,contents));
					
				}
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch(Exception e){
				
			}
			
			
			
		}
		
		@Override
		public void onFinish() {
			dialog.dismiss();
			dialog = null;
			
		}
		
	}
	
}
