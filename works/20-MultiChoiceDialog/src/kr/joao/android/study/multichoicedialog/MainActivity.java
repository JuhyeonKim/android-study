package kr.joao.android.study.multichoicedialog;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener{
	
	String[] items = {"item1","item2","item3"};
	boolean[] checkedArr = {false,false,false};
	
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
		
		showMultiChoiceDialog();
	}
	
	public void showMultiChoiceDialog(){
		
		final boolean[] tmpCheckedArr = new boolean[checkedArr.length];
		
		System.arraycopy(checkedArr, 0, tmpCheckedArr, 0, checkedArr.length);
		
		Builder builder = new Builder(this);
		
		builder.setTitle("Multichoide Dialog.");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setCancelable(false);
		
		builder.setMultiChoiceItems(items,checkedArr,new DialogInterface.OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				checkedArr[which] = isChecked;
				
				
			}
		});
		
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String result ="";
				
				for(int i=0;i<checkedArr.length;i++){
					boolean b = checkedArr[i];
					if(b){
						result += ("," + items[i]);
					}
				}
				
				Toast.makeText(getApplicationContext(), result.substring(1,result.length()), Toast.LENGTH_SHORT).show();;
			}
		});
		
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				System.arraycopy(tmpCheckedArr, 0, checkedArr, 0, checkedArr.length);
			}
		});
				
		builder.create();
		builder.show();
		
	}

}
