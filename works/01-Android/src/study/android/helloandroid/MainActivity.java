package study.android.helloandroid;

import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils.TruncateAt;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	TextView textView1;
	TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        
        textView1.setText("안녕합니다.");
        textView2.setText(R.string.testText);
        
        textView1.setTextColor(Color.rgb(255, 0, 255));
        Resources r = getResources();
        int color = r.getColor(R.color.my_blue);
        
        textView2.setTextSize(30.0f);
        
        textView1.setSingleLine(true);
        textView1.setEllipsize(TruncateAt.END);
        textView2.setSingleLine(true);
        textView2.setEllipsize(TruncateAt.END);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
