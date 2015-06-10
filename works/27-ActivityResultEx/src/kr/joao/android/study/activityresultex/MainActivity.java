package kr.joao.android.study.activityresultex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	private Button button1;
	private TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		textView1 = (TextView) findViewById(R.id.textView1);
		
		button1.setOnClickListener(this);
		
	}
	
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(this,SecondActivity.class);
		
		String text = textView1.getText().toString();
		
		i.putExtra("text", text);
		
		startActivityForResult(i, 100);
	}
	
	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		
		switch (arg0) {
		case 100:
			
			if(arg1 == Activity.RESULT_OK){
				String editedText = arg2.getStringExtra("text");
				textView1.setText(editedText);
			}
			
			break;

		default:
			break;
		}
		
		super.onActivityResult(arg0, arg1, arg2);
		
		
		
	}

}
