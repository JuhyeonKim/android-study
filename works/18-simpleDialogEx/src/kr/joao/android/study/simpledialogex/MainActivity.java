package kr.joao.android.study.simpledialogex;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	
	private Button button1, button2, button3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			showAlertDialog();
			break;
		case R.id.button2:
			showConfirmDialog();
			break;
		case R.id.button3:
			showListDialog();
			break;

		default:
			break;
		}
		
	}
	
	
	public void showAlertDialog(){
		
		Builder builder = new Builder(this);
		
		builder.setTitle("Alert!");
		builder.setMessage("Invalid value!");
		builder.setCancelable(false);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				Toast.makeText(getApplicationContext(), "Pressed OK Button.", Toast.LENGTH_SHORT).show();
			}
		});
		
		builder.create();
		builder.show();
		
	}
	public void showConfirmDialog(){
		Builder builder = new Builder(this);
		
		builder.setTitle("Confirm.");
		builder.setMessage("Are U OK?");
		builder.setCancelable(false);
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				Toast.makeText(getApplicationContext(), "I'm OK.", Toast.LENGTH_SHORT).show();
			}
		});
		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				Toast.makeText(getApplicationContext(), "I'm not OK.", Toast.LENGTH_SHORT).show();
			}
		});
		
		builder.create();
		builder.show();		
	}
	public void showListDialog(){
		
		Builder builder = new Builder(this);
		builder.setTitle("Confirm.");
		builder.setCancelable(false);
		builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				Toast.makeText(getApplicationContext(), "I will go close.", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		final String[] items = {"Java","Android","Object C","Phython"};
		builder.setItems(items, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), items[which], Toast.LENGTH_SHORT).show();
				
			}
		});
		
		builder.create();
		builder.show();		
		
	}

}
