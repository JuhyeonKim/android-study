package kr.joao.android.study.helper;

import kr.joao.android.study.daumimagesearchex.R;
import android.content.Context;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class ImageHelper {
	
	private static ImageHelper current;
	
	public static ImageHelper getInstance(){
		if(current == null){
			current = new ImageHelper();
		}
		
		return current;
	}
	
	public static void freeInstance(){
		current = null;
	}
	
	private ImageHelper(){
		super();
	}
	
	public static DisplayImageOptions getImageOptions(Context context){
		
		ImageLoader imageLoader = ImageLoader.getInstance();
		if(!imageLoader.isInited()){
			ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(context);
			imageLoader.init(config);
		}
		
		DisplayImageOptions options = new DisplayImageOptions.Builder()
										.showImageOnLoading(R.drawable.ic_stub)
										.showImageForEmptyUri(R.drawable.ic_empty)
										.showImageOnFail(R.drawable.ic_error)
										.cacheInMemory(true)
										.cacheOnDisk(true)
										.build();
										
		
		return options;
	}

}
