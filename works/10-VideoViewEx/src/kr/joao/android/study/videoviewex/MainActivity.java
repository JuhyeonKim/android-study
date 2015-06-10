package kr.joao.android.study.videoviewex;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends ActionBarActivity {
	
	VideoView vv1;
	MediaController mc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		vv1 = (VideoView) findViewById(R.id.videoView1);
		mc = new MediaController(this);
		
		vv1.setMediaController(mc);
		
		File sdcard = Environment.getExternalStorageDirectory();
		String videoPath = sdcard.getAbsolutePath() + "/BigBuck.mp4";
		
		vv1.setVideoPath(videoPath);
		
		vv1.start();
	}

}
