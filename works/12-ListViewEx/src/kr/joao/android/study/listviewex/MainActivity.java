package kr.joao.android.study.listviewex;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
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
		
		switch (parent.getId()) {
		case R.id.listView1:
			
			Resources r = getResources();
			
			String[] data =  r.getStringArray(R.array.myArray);
			
			String selectedItem = data[position];
			
			Toast.makeText(getApplicationContext(), "Selected, " + selectedItem + ", position : " + position, Toast.LENGTH_SHORT).show();
			
			break;

		default:
			break;
		}
		
	}
	
	
	

}
