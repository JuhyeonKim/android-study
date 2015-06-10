package kr.joao.android.study.imageviewex;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	Button button1, button2;
	ImageView imageView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			
			imageView1.setImageResource(R.drawable.img1);
			imageView1.setScaleType(ScaleType.CENTER_CROP);
			
			break;
		case R.id.button2:
			
			imageView1.setImageResource(R.drawable.img2);
			imageView1.setScaleType(ScaleType.CENTER_INSIDE);
			
			break;

		}
	}

}
