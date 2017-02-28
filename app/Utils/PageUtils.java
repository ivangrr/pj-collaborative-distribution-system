package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PageUtils {
	public final static String ARTICLE_CODE = "ART";
	
	public static String generateID(final String code){
//		int randomInt = (int)(1000000.0 * Math.random());
		DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss-yyyy-MM-dd");
		Date date = new Date();
//		return code + "-" + Integer.toString(randomInt) +"-" + dateFormat.format(date);
		return code + "-" + dateFormat.format(date);
	}
}
