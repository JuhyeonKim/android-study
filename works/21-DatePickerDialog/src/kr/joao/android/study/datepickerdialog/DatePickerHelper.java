package kr.joao.android.study.datepickerdialog;

import java.util.Calendar;

public class DatePickerHelper {

	
	private static DatePickerHelper datePickerHelper = null;
	
	
	public static DatePickerHelper getInstance(){
		if(datePickerHelper == null){
			datePickerHelper = new DatePickerHelper();
		}
		
		return datePickerHelper;
	}
	
	public 	static void restoreInstance(){
		datePickerHelper = null;
	}

	private DatePickerHelper() {
		super();
	}
	
	public int[] getDate(){
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		int d = cal.get(Calendar.DAY_OF_MONTH);
		
		int[] result = {y,m,d};
		
		return result;
	}
	
}
