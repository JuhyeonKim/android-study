package kr.joao.android.study.jsonlistex;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import kr.joao.android.study.jsonlistex.model.Device;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MainActivity extends ActionBarActivity implements OnItemClickListener{
	
	DeviceAdapter adapter;
	
	ListView listView1;
	
	String URL = "http://itpaper.co.kr/demo/android/json/list.json";
	
	
	AsyncHttpClient client;
	
	DeviceResponse response;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView1 = (ListView) findViewById(R.id.listView1);
		
		adapter = new DeviceAdapter(this, R.layout.item_layout, new ArrayList<Device>());
		
		listView1.setAdapter(adapter);
		listView1.setOnItemClickListener(this);
		
		response = new DeviceResponse();
		client = new AsyncHttpClient();
		

	}
	
	@Override
	protected void onResume() {
		adapter.clear();
		client.get(URL, response);
		
		super.onResume();
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		Device item = adapter.getItem(position);
		Toast.makeText(getApplicationContext(), "Name : " + item.getName() + ", Type : " + item.getType(), Toast.LENGTH_SHORT).show();
		
	}

	public class DeviceAdapter extends ArrayAdapter<Device>{
		
		int resource;
		
		public DeviceAdapter(Context context, int resource, List<Device> objects) {
			super(context, resource, objects);
			
			this.resource = resource;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View itemView = convertView;
			
			if(itemView == null){
				itemView = getLayoutInflater().inflate(resource, null);
			}
			
			Device item = getItem(position);
			
			if(item != null){
				TextView textView1 = (TextView)itemView.findViewById(R.id.textView1);
				TextView textView2 = (TextView)itemView.findViewById(R.id.textView2);
				
				textView1.setText(item.getName());
				textView2.setText(item.getType());
				
			}
			
			return itemView;
		}
		
	}
	
	
	
	public class DeviceResponse extends AsyncHttpResponseHandler{
		
		ProgressDialog dialog;
		
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
				JSONObject jsonObj = new JSONObject(result);
				
				JSONArray device = jsonObj.getJSONArray("device");
				
				for(int i=0;i<device.length();i++){
					JSONObject tmp = device.getJSONObject(i);
					String name = tmp.getString("name");
					String type = tmp.getString("type");
					
					Device tmpDevice = new Device();
					tmpDevice.setName(name);
					tmpDevice.setType(type);
					
					adapter.add(tmpDevice);
				}
				
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch(Exception e){
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
