/**
 * 
 */
package sorting;

/**
 * Class that follows a simple date format. For example in radix sort
 * @author NeilDG
 *
 */
public class CustomDateFormat {
	private final static String TAG = "DateFormat";
	
	public enum SortingType {
		MONTH,
		DAY,
		YEAR
	}
	
	private String dateString;
	
	private int month;
	private int day;
	private int year;
	
	/*
	 * Should follow the MM/DD/YYYY format
	 */
	public CustomDateFormat(String dateString) {
		this.dateString = dateString;
		
		//parse
		String[] dateFormat = dateString.split("/");
		
		this.month = Integer.parseInt(dateFormat[0]);
		this.day = Integer.parseInt(dateFormat[1]);
		this.year = Integer.parseInt(dateFormat[2]);
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String getString() {
		return this.dateString;
	}
	
	public static String convertDateFormatsToString(CustomDateFormat[] dates) {
		String text = "";
		for(int i = 0; i < dates.length; i++){
			text += dates[i].getString() +" ";
		}
		
		return text;
	}
}
