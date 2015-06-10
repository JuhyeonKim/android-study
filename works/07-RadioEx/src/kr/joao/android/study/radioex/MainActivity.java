package kr.joao.android.study.radioex;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener, OnCheckedChangeListener {
	
	RadioGroup radioGroup1;
	TextView textView2;
	Button button1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
		textView2 = (TextView) findViewById(R.id.textView2);
		button1 = (Button) findViewById(R.id.button1);
		
		radioGroup1.setOnCheckedChangeListener(this);
		button1.setOnClickListener(this);
		
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		
		if (group.getId() == R.id.radioGroup1) {
			RadioButton checkedRadio = (RadioButton) findViewById(group.getCheckedRadioButtonId());
			textView2.setText(checkedRadio.getText().toString());
		}
	}

	@Override
	public void onClick(View v) {
		RadioButton checkedRadio = (RadioButton) findViewById(radioGroup1.getCheckedRadioButtonId());
		
		Toast.makeText(getApplicationContext(), checkedRadio.getText(), Toast.LENGTH_SHORT).show();
		
	}
	
	
}
