package kr.joao.android.study.timepickerdialogex;

import java.util.Calendar;


public class TimePickerHelper {
	private static TimePickerHelper current = null;
	
	
	public static TimePickerHelper getInstance(){
		if(current == null){
			current = new TimePickerHelper();
		}
		
		return current;
	}
	
	public 	static void restoreInstance(){
		current = null;
	}

	private TimePickerHelper() {
		super();
	}
	
	public int[] getDate(){
		Calendar cal = Calendar.getInstance();
		int h = cal.get(Calendar.HOUR_OF_DAY);
		int mm = cal.get(Calendar.MINUTE);
		
		int[] result = {h,mm};
		
		return result;
	}
}
