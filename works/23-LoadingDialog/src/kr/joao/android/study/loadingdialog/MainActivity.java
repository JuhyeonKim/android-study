package kr.joao.android.study.loadingdialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	Button button1,button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			showLoadingDialog();
			break;
		case R.id.button2:
			showTransLoadingDialog();
			break;

		default:
			break;
		}
	}
	
	public void showLoadingDialog(){
		
		ProgressDialog pd = new ProgressDialog(this);
		
		pd.setMessage("Waiting....");
		
		pd.setOnCancelListener(new OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				Toast.makeText(getApplicationContext(), "Canceld loading", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		pd.show();
		
	}
	
	public void showTransLoadingDialog(){
		
		Dialog dialog = new Dialog(this,R.style.trans_dialog);
		
		
		ProgressBar pb = new ProgressBar(this);
		
		dialog.addContentView(pb, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		dialog.setOnCancelListener(new OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				Toast.makeText(getApplicationContext(), "Canceld", Toast.LENGTH_SHORT).show();
			}
		});
		
		dialog.show();
		
	}

}
