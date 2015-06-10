package kr.joao.android.study.intentex;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements OnItemClickListener{
	
	ListView listView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		listView1 = (ListView) findViewById(R.id.listView1);
		
		listView1.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			Intent intent1 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:01012345678"));
			startActivity(intent1);
			break;
		case 1:
			Intent intent2 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:01012345678"));
			startActivity(intent2);
			break;
		case 2:
			Intent intent3 = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:01012345678"));
			intent3.putExtra("sms_body", "Contents... Contents...");
			startActivity(intent3);
			break;
		case 3:
			Intent intent4 = new Intent(Intent.ACTION_SENDTO,Uri.parse("jhkiri@gmail.com"));
			intent4.putExtra(Intent.EXTRA_SUBJECT,"Title....");
			intent4.putExtra(Intent.EXTRA_TEXT,"TEXTEXTEXTEXTEXTEX");
			startActivity(intent4);
			break;
		case 4:
			Intent intent5 = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.naver.com"));
			startActivity(intent5);
			break;
		case 5:
			Intent intent6 = new Intent(Intent.ACTION_WEB_SEARCH);
			intent6.putExtra(SearchManager.QUERY, "android");
			startActivity(intent6);
			break;
		case 6:
			Intent intent7 = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=deakyo.libro"));
			startActivity(intent7);
			break;
		case 7:
			String videoPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/BigBuck.mp4";
			Intent intent8 = new Intent(Intent.ACTION_VIEW);
			intent8.setDataAndType(Uri.parse("file://"+videoPath), "video/*");
			break;
		case 8:
			String audioPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/music.mp3";
			Intent intent9 = new Intent(Intent.ACTION_VIEW);
			intent9.setDataAndType(Uri.parse("file://"+audioPath), "audio/*");			
			break;
		case 9:
			startActivity(new Intent(Settings.ACTION_SETTINGS));
			break;
		case 10:
			startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
			break;
		case 11:
			startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
			break;

		default:
			break;
		}
		
	}
	
	
}
