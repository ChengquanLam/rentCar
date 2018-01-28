package util;
 
import java.sql.Timestamp;
 
public class TimeTrans {
	public static Timestamp StringToTimestamp(String date) {
		Timestamp ts = Timestamp.valueOf(date + " 00:00:00");
		return ts;	
	}
}
