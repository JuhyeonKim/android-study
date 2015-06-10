package kr.joao.android.study.datepickerdialog;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	Button button1;
	
	int y=0;
	int m=0;
	int d=0;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		showDatePickerDialog();
	}
	
	public void showDatePickerDialog(){
		
		final int tmpY, tmpM, tmpD;
		DatePickerHelper dph = DatePickerHelper.getInstance();
		tmpY=dph.getDate()[0];
		tmpM=dph.getDate()[1];
		tmpD=dph.getDate()[2];
		
		DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
			
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				y=year;
				m=monthOfYear;
				d=dayOfMonth;
				
				button1.setText(y + "-" + (m+1) + "-" + d);
				
			}
		}, tmpY, tmpM, tmpD);
		
		dpd.setTitle("DatePickerDialog");
		dpd.setIcon(R.drawable.ic_launcher);
		
		dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				y = tmpY;
				m = tmpM;
				d = tmpD;
			}
		});
		
		
		dpd.show();
		
	}
	
	
	
	
	
	

}
