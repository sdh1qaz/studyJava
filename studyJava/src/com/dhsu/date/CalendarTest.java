package com.dhsu.date;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


/**
 * @ClassName： CalendarTest
 * @Author: dhSu
 * @Description: Calendar学习
 * @Date:Created in 2018年12月24日
 */

public class CalendarTest {
	public static void main(String[] args) {
		String yearMonth = "201901";
		Date proDate = null;
		try {
			proDate = ConcurrentDateUtil.parseDateYYYYMM(yearMonth);
			System.out.println(proDate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date mixDate = new Date();
		System.out.println("mixDate:" + mixDate.toString());
		Calendar minDate = Calendar.getInstance();
		minDate.add(Calendar.MONTH, -13);
		System.out.println("minDate:" + minDate.getTime().toString());
		if (minDate.getTime().after(proDate) || proDate.after(mixDate)) {
			throw new RuntimeException("只能查询过往12个月的账单信息以及本月账单信息");
		}
		else {
			System.out.println("可以查");
		}
		System.out.println(proDate.after(minDate.getTime()));
		/*Calendar minDate = Calendar.getInstance();
		System.out.println(minDate.getTime());
		minDate.add(Calendar.MONTH, -12);
		System.out.println(minDate.getTime());*/
	}

}
