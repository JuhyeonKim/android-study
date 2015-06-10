package kr.joao.android.study.fileioex;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	private EditText editText1;
	private Button button1, button2;
	private TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		textView1 = (TextView) findViewById(R.id.textView1);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		
		String fileName = "myFile.txt";
		String encoding = "UTF-8";
		
		File f = Environment.getExternalStorageDirectory();
		String path = f.getAbsolutePath() + "/" + fileName;
		
		switch (v.getId()) {
		case R.id.button1:
			boolean result = FileHelper.getInstance().writeString(path, editText1.getText().toString(), encoding);
			
			String msg = "Success!!";
			if(!result){
				msg = "Failed!!";
			}
			
			Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
			
			break;
			
		case R.id.button2:
			
			String read = FileHelper.getInstance().readString(path, encoding);
			textView1.setText(read);
			
			break;

		default:
			break;
		}
		
		
	}

}
