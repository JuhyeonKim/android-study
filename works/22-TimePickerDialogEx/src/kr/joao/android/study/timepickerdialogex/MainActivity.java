package kr.joao.android.study.timepickerdialogex;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	Button button1;
	
	int HOUR=0;
	int MINUTE=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		showTimePickerDialog();
	}
	
public void showTimePickerDialog(){
		
		final int tmpH, tmpM;
		TimePickerHelper dph = TimePickerHelper.getInstance();
		tmpH=dph.getDate()[0];
		tmpM=dph.getDate()[1];
		
		TimePickerDialog dpd = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener() {
			
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				HOUR=tmpH;
				MINUTE=tmpM;
				
				button1.setText(HOUR + "-" + MINUTE);				
			}
		},HOUR,MINUTE,true);
		
		
		
		dpd.setTitle("TimePickerDialog");
		dpd.setIcon(R.drawable.ic_launcher);
		
		dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				HOUR = tmpH;
				MINUTE = tmpM;
			}
		});
		
		dpd.show();
		
	}
	

}
