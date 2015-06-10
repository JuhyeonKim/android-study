package kr.joao.android.study.buttonex;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	TextView textView1;
	Button button1, button2;	
	ImageButton imageButton1, imageButton2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textView1 = (TextView) findViewById(R.id.textView1);
		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		
		imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
		imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
		
		int color1 = Color.argb(0, 255, 255, 255);
		imageButton1.setBackgroundColor(color1);
		imageButton2.setBackgroundColor(color1);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		imageButton1.setOnClickListener(this);
		imageButton2.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		
		int id = v.getId();
		
		String message = null;
		
		switch (id) {
		case R.id.button1:
			button1.setText("선택하셨습니다.");
			button2.setText("여자");
			message = "당신은 남자입니다.";
			break;
		case R.id.button2:
			button1.setText("남자");
			button2.setText("선택하셨습니다.");
			message = "당신은 여자입니다.";
			break;
		case R.id.imageButton1:
			imageButton1.setImageResource(R.drawable.ic_launcher);
			imageButton2.setImageResource(R.drawable.btn_girl);
			message = "당신은 남자입니다.";
			break;
		case R.id.imageButton2:
			imageButton1.setImageResource(R.drawable.btn_boy);
			imageButton2.setImageResource(R.drawable.ic_launcher);
			message = "당신은 여자입니다.";
			break;
		}
		
		Toast t = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
		t.show();
		
	}

}
