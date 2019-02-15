package cn.java.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * yyyy-MM-dd
 * @author 1
 *
 */
public class GetNowtime {

	public static String getNowDate() {
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return sdf.format(d);
	}
	 public static long getDaySub(String beginDateStr,String endDateStr)
	    {
	        long day=0;
	        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("MM-dd");    
	        java.util.Date beginDate;
	        java.util.Date endDate;
	        try
	        {
	            beginDate = format.parse(beginDateStr);
	            endDate= format.parse(endDateStr);    
	            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);    
	            
	        } catch (ParseException e)
	        {
	          
	            e.printStackTrace();
	        }   
	        return day;
	    }
}
