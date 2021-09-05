package handlingUploadAndDownloadSelenium;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class convertStringTodateFormat {

	public static void main(String[] args) throws ParseException {
		//String date = "Tue Jul 04 17:47:29 IST 2023";

		//SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		//Date date6 = formatter6.parse(date);
		
		//  System.out.println(date+"\t"+date6);  
		  
		  
		  SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		  String dateInString = "Thu Oct 15 10:20:56 IST 2015";
		  Date date = sdf.parse(dateInString);
		  System.out.println(date);
		  
		  
	}

}
