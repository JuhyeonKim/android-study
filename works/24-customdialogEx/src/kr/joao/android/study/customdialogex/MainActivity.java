package kr.joao.android.study.customdialogex;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		showCustomDialog();
	}
	
	public void showCustomDialog(){
		
		Builder builder = new Builder(this);
		
		builder.setTitle("Custom Dialog");
		builder.setCancelable(false);
		
		LayoutInflater li = getLayoutInflater();
		
		final View dialogView = li.inflate(R.layout.dialog, null);
		
		builder.setView(dialogView);
		
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "Pressed Cancel button.", Toast.LENGTH_SHORT).show();
				
			}
			
		});
		
		builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				String id = ((EditText)dialogView.findViewById(R.id.editText1)).getText().toString();
				String password = ((EditText)dialogView.findViewById(R.id.editText2)).getText().toString();
				
				Toast.makeText(getApplicationContext(), "ID/Password : " + id + " / " + password, Toast.LENGTH_SHORT).show();				
				
			}
		});
		
		builder.create();
		builder.show();
	}

	
	
}
