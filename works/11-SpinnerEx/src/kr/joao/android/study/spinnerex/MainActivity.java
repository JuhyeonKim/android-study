package kr.joao.android.study.spinnerex;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener, OnItemSelectedListener{
	
	Spinner spinner1;
	
	Button button1;
	
	TextView textView1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView1 = (TextView) findViewById(R.id.textView1);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		button1 = (Button) findViewById(R.id.button1);
		
		
		spinner1.setSelection(1);
		spinner1.setOnItemSelectedListener(this);
		
		button1.setOnClickListener(this);
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		switch (parent.getId()) {
		case R.id.spinner1:
			
			String selectedItem = parent.getSelectedItem().toString();
			
			String result = position+"번째 항목 " + selectedItem + "가 선택됨";
			
			textView1.setText(selectedItem);
			break;

		default:
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		Toast.makeText(getApplicationContext(), "onNothingSelected Called", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onClick(View v) {
		int selectedIdx = spinner1.getSelectedItemPosition();
		
		Resources r = getResources();
		
		String[] data = r.getStringArray(R.array.stringArray);
		
		Toast.makeText(getApplicationContext(), "선택된건 " + data[selectedIdx] + "이다", Toast.LENGTH_SHORT).show();
		
	}
	

}
