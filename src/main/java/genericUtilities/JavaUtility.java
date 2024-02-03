package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class contains reusable methods to perform java related operations
 * @author Yasaswini
 */
public class JavaUtility {
	/**
	 * This method fetches current date and time in specified format
	 * @return
	 */
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_mm_ss");
		return sdf.format(date);
		
	}
}
