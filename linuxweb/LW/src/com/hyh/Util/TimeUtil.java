package com.hyh.Util;
/*
 * 时间格式转换
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtil {
	
	public static String getTime(String time){
		String ctime=time;
		String curtime="";
		 String chour=time.substring(11,16);
		//正则匹配
		String ex="[-: ]";//去掉-：
		Pattern p=Pattern.compile(ex);     
        Matcher m=p.matcher(time);     
        String time2=m.replaceAll("").trim(); 
        String year=time2.substring(0, 4);
        String month=time2.substring(4, 6);
        String day=time2.substring(6, 8);
        String hour=time2.substring(8, 10);

		SimpleDateFormat fd=new SimpleDateFormat("yyyyMMddHHmmss");
		String date=fd.format(new Date());
        String year2=date.substring(0, 4);
        String month2=date.substring(4, 6);
        String day2=date.substring(6, 8);
        if(year.equals(year2)){
        	if(month.equals(month2)){
        		switch(Integer.parseInt(day2)-Integer.parseInt(day)){
        		case 1:curtime="昨天";break;
        		case 2:curtime="前天";break;
        		case 0:curtime="今天";break;
        		case 3:curtime="3天前";break;
        		case 4:curtime="4天前";break;
        		case 5:curtime="5天前";break;
        		case 6:curtime="6天前";break;
        		case 7:curtime="7天前";break;
        		case 8:curtime="8天前";break;
        		case 9:curtime="9天前";break;
        		case 10:curtime="10天前";break;
        		}
        			return curtime+=chour;
        		
        	}
        	
        }
        if(year.equals(year2)){
        	
        switch(Integer.parseInt(month2)-Integer.parseInt(month)){
				case 1:curtime="1个月前";break;
				case 2:curtime="2个月前";break;
				case 11:curtime="11个月前";break;
				case 3:curtime="3个月前";break;
				case 4:curtime="4个月前";break;
				case 5:curtime="5个月前";break;
				case 6:curtime="6个月前";break;
				case 7:curtime="7个月前";break;
				case 8:curtime="8个月前";break;
				case 9:curtime="9个月前";break;
				case 10:curtime="10个月前";break;
        	}
        	return curtime+=chour; 
		}
		return ctime;
	}
	public static void main(String[] args) {
		System.out.print(TimeUtil.getTime("2013-02-06 12:12:45"));
	}
}
