package com.pt.ssm.util;

import java.util.List;



import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class rentJS {
	/**
	 * 
	 * @param jsstarttime 计算开始时间
	 * @param jsendtime   合同结束时间
	 * @param fz          合同房租
	 * @param zy          增幅
	 * @param statue      类型：0-季，1-半年，2-年 
	 * @return            list
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static final  List<String>  rent(String jsstarttime,String jsendtime,double fz,double zy,int statue) throws ParseException, java.text.ParseException{
		//合同结束时间-计算开始时间
		String pattern="yyyy-MM-dd";
		int month=countMonths(jsstarttime,jsendtime,pattern);
		
		//赋值newtime 每一一条数据的开始时间
		Date newstarttime=StringtoData(jsstarttime,pattern);
		//赋值endtime 每一一条数据的结束时间
		Date newendtime=StringtoData(jsendtime,pattern);
		
		//计算开始时间，合同结束时间转化为date类型
		Date hetongend=StringtoData(jsendtime,pattern);
//		Date jsks=StringtoData(jsstarttime,pattern);
		
		List<String>  list = new ArrayList<String> ();
		
		//每一次的房租
		double fzafter=fz;
		//最大限度的进行循环
		int i=0;
		if((month%3)==0){
			i=month/3;
		}else{
			i=month/3+1;
		}
		for(int j=0;j<=i;j++){
			
			//计算开始时间与合同结束时间进行比较
			if(newstarttime.getTime()<hetongend.getTime()){
				if(statue==0){
					//季
					//为了日期的加减
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(newstarttime);
					calendar.add(Calendar.MONTH,3);
					newendtime=calendar.getTime();
				}else if(statue==1){
					//半年
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(newstarttime);
					calendar.add(Calendar.MONTH,6);
					newendtime=calendar.getTime();	
				}else if(statue==2){
					//年
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(newstarttime);
					calendar.add(Calendar.MONTH,12);
					newendtime=calendar.getTime();
				}
	            //房租的计算
				//1 newendtime 与 jsks 相差多长时间
				int a=0;
				int b=0;
				String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(newstarttime);
				int month2=countMonths(jsstarttime,dateStr,pattern);
				if((month2/12)>0){
					b=month2/12;
					fzafter=fz*(Math.pow((1+(zy/100.00)),b));
				}
				
				String time1=new SimpleDateFormat("yyyy-MM-dd").format(newstarttime);
				String time2=new SimpleDateFormat("yyyy-MM-dd").format(newendtime);
				//最后一个日期
				if(newendtime.getTime()>hetongend.getTime()){
					time2=new SimpleDateFormat("yyyy-MM-dd").format(hetongend);
				}
				list.add(time1);
				list.add(time2);
				list.add(fzafter+"");
				
				newstarttime=newendtime;	
			}else{
				//超出，跳出循环
				break;
			}
			
		}
		
		return list;
		
	} 
	
	/*
	 * 两个时间相差的月数
	 */
    public static int countMonths(String date1,String date2,String pattern) throws ParseException, java.text.ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        
        int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
        
        //开始日期若小月结束日期
        if(year<0){
            year=-year;
            return year*12+c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH);
        }
        return year*12+c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);
    }
    
    
    public static Date StringtoData(String date1,String pattern) throws java.text.ParseException{
    	        SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
    	        Date date = sdf.parse(date1);
				return date;  	        
    }
    
    public static void main(String[] args) throws ParseException, java.text.ParseException{
    	List<String> list=rent("2017-01-01","2025-04-01",100,10,2);
    	System.out.print(list);

    }

}
