package com.joao.android.study.singlechoicedialogex;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	
	private Button button1;
	
	private int checkedIdx=0;
	
	
	private String[] items={"item1","item2","item3"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		showSingleChoiceDialog();
	}
	
	public void showSingleChoiceDialog(){
		final int tempIdx=checkedIdx;
		Builder builder = new Builder(this);
		
		builder.setTitle("Single Choice Dialog.");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setCancelable(false);
		
		
		builder.setSingleChoiceItems(items, checkedIdx, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				checkedIdx = which;
				Toast.makeText(getApplicationContext(), items[which], Toast.LENGTH_SHORT).show();
				
				
			}
		});
		
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				Toast.makeText(getApplicationContext(), items[checkedIdx], Toast.LENGTH_SHORT).show();
				
				
			}
		});
		
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				checkedIdx = tempIdx;
				Toast.makeText(getApplicationContext(), "Clicked Cancle Button.", Toast.LENGTH_SHORT).show();
			}
		});
		
		
		builder.create();
		builder.show();
		
		
	}
	
}