package kr.joao.android.study.daumimagesearchex;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import kr.joao.android.study.daumimagesearchex.model.Image;
import kr.joao.android.study.helper.ImageHelper;
import kr.joao.android.study.helper.RegexHelper;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends ActionBarActivity implements OnClickListener, OnItemClickListener, OnScrollListener{
	
	private final String URL = "https://apis.daum.net/search/image";
	
	private ListView listView1;
	private Button button1;
	private EditText editText1;
	
	private ImageAdapter adapter;
	
	private DisplayImageOptions option;
	
	private View footerView;
	private LinearLayout footer;
	
	private AsyncHttpClient client;
	private ImageResponse response;
	
	private int page = 1;
	private String keyword;
	
	// 화면 마직막이니?
	private boolean lastItemVisibleFlag = false;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView1 = (ListView)findViewById(R.id.listView1);
		button1 = (Button)findViewById(R.id.button1);
		editText1 = (EditText)findViewById(R.id.editText1);
		
		button1.setOnClickListener(this);
		listView1.setOnItemClickListener(this);
		
		option = ImageHelper.getInstance().getImageOptions(this);
		adapter = new ImageAdapter(this, R.layout.item_layout, new ArrayList<Image>());
		listView1.setAdapter(adapter);
		
		footerView = getLayoutInflater().inflate(R.layout.list_footer, null);
		footer = (LinearLayout)footerView.findViewById(R.id.llFooterContainer);
		listView1.addFooterView(footerView);
		footer.setVisibility(View.GONE);
		
		client = new AsyncHttpClient();
		response = new ImageResponse();
		
		listView1.setOnScrollListener(this);
	}
	
	
	private class ImageResponse extends AsyncHttpResponseHandler{
		
//		private ProgressDialog dialog;
		
		@Override
		public void onStart() {
//			dialog = new ProgressDialog(MainActivity.this);
//			dialog.setMessage("Now is Loading...");
//			dialog.setCancelable(false);
//			dialog.show();
			
			footer.setVisibility(View.VISIBLE);
			// TODO : 뭔소리임?
			listView1.setSelectionFromTop(adapter.getCount(), 0);
			
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
				JSONObject json = new JSONObject(result);
				JSONObject channel = json.getJSONObject("channel");
				JSONArray items = channel.getJSONArray("item");
				
				Image.totalCount = channel.getInt("totalCount");
				Image.pageCount = channel.getInt("pageCount");
				Image.result = channel.getInt("result");
				
				for(int i=0;i<items.length();i++){
					JSONObject tmpObj = items.getJSONObject(i);
					
					String title = tmpObj.getString("title");
					title = RegexHelper.getInstance().removeHtmlTagSpecialChars(title);
					String link = tmpObj.getString("link");
					String thumbnail = tmpObj.getString("thumbnail");
					int width = tmpObj.getInt("width");
					int height = tmpObj.getInt("height");
					
					Image image = new Image(title,link,thumbnail,width,height);
					
					adapter.add(image);
					
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
			footer.setVisibility(View.GONE);
		}
	}
	
	private class ImageAdapter extends ArrayAdapter<Image>{
		
		private int resource;
		
		public ImageAdapter(Context context, int resource, List<Image> objects) {
			super(context, resource, objects);
			
			this.resource = resource;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View item = convertView;
			
			if(item == null){
				item = getLayoutInflater().inflate(resource, null);
			}
			
			
			Image image = adapter.getItem(position);
			if(image != null){
				
				ImageView imageView1 = (ImageView)item.findViewById(R.id.imageView1);
				TextView textView1 = (TextView)item.findViewById(R.id.textView1);
				TextView textView2 = (TextView)item.findViewById(R.id.textView2);
				
				textView1.setText(image.getTitle());
				textView2.setText(image.getWidth() + "*" + image.getHeight());
				
				ImageLoader.getInstance().displayImage(image.getThumbnail(), imageView1, option);
				
			}
			return item;
		}
	}
	
	

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Image image = adapter.getItem(position);
		
		Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(image.getLink()));
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		keyword = editText1.getText().toString().trim();
		
		if(keyword.equals("")){
			Toast.makeText(getApplicationContext(), "Inputs the kyewords..", Toast.LENGTH_SHORT).show();
			return;
		}

		page=1;
		adapter.clear();
		this.connect();
		
	}
	
	public void connect(){
		
		
		RequestParams param = new RequestParams();
		param.put("q", keyword);
		param.put("apikey","856dbb74c649b9df07fc83f26493f15e");
		param.put("output","json");
		param.put("result",20);
		param.put("pageno",page);
		
		client.get(URL, param, response);
		
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		
		if(scrollState == OnScrollListener.SCROLL_STATE_IDLE && lastItemVisibleFlag){
			
			if(page < Image.pageCount){
				page++;
				connect();
			}
		}
		
	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		
		lastItemVisibleFlag = (totalItemCount > 0) && (firstVisibleItem + visibleItemCount >= totalItemCount);
		
	}
	
}
