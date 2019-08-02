package 日期处理;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.Test;


/**
 * @ClassName： CalendarTest
 * @Author: dhSu
 * @Description: Calendar学习
 * @Date:Created in 2018年12月24日
 */

public class Calendar_DateTest {
	
	/**
	 * 生成yyyymmddhhmiss格式的系统时间
	 */
	@Test
	public void get() {
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "902" +
				String.format("%08d", new Random().nextInt(10000000)));
	}
	
	
	
	
	/**
	 * 判断一个日期（yyyy/MM/dd HH:mm:ss）是否在近半年内
	 */
	@Test
	public void isINHalfYears() {
		String date = "2019/01/28 13:00:00";
		//转化成yyyy年MM月dd日
		date = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(date));
		System.out.println(date);
		//半年前的日期
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -6);
		Date d = cal.getTime();
		String beginDate = new SimpleDateFormat("yyyy年MM月dd日").format(d);
		System.out.println(beginDate);
		System.out.println(date.compareTo(beginDate) > 0);
		
	}
	
	/**
	 * 获取上月年月yyyyMM
	 */
	@Test
	public void getLastMon() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date d = cal.getTime();
		System.out.println(new SimpleDateFormat("yyyyMM").format(d));
	}
	
	/**
	 * 方法2 2019/01/18 13:00:00 转化成 2019年01月18日
	 */
	@Test
	public void test2() {
		String d = "2019/01/18 13:00:00";
		Date date = new Date(d);
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日").format(date));
	}
	
	/**
	 * 方法22019/01/18 13:00:00 转化成 2019年01月18日
	 * @throws ParseException 
	 */
	@Test
	public void test22() throws ParseException {
		String d = "2019/01/18 13:00:00";
		Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(d);
		System.out.println(new SimpleDateFormat("yyyy年MM月dd日").format(date));
	}
	
	
	/**
	 * 获取当前系统年月日（yyyyMMdd）
	 */
	@Test
	public void testNowYMD() {
		//当前系统年月日（yyyyMMdd）
		String endDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
		System.out.println(endDate);
		
	}
	
	/**
	 * 获取当前系统年月日的前7天
	 */
	@Test
	public void get7DaysBefore() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -7);
		Date date = cal.getTime();
		String beginDate = new SimpleDateFormat("yyyyMMdd").format(date);
		System.out.println(beginDate);
		
	}
	
	/**
	 * 获取当前系统年月日（yyyyMMdd）和半年前的年月日（yyyyMMdd）
	 */
	@Test
	public void testHalfYears() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -6);
		Date date = cal.getTime();
		String beginDate = new SimpleDateFormat("yyyyMMdd").format(date);
		System.out.println(beginDate);
		
	}
	
	//根据当前年月，获取本月，上月和下月的年月
	@Test
	public void getLastAndNextMonth() {
		Calendar calendar = Calendar.getInstance();
		//本月
		String nowMonth = new SimpleDateFormat("yyyyMM").format(calendar.getTime());
		System.out.println("上月：" + nowMonth);
		//上月
		calendar.add(Calendar.MONTH, -1);
		String lastMonth = new SimpleDateFormat("yyyyMM").format(calendar.getTime());
		System.out.println("上月：" + lastMonth);
		//下月
		calendar.add(Calendar.MONTH, 2);
		String nextMonth = new SimpleDateFormat("yyyyMM").format(calendar.getTime());
		System.out.println("下月：" + nextMonth);
		
	}
	
	
	//获取当前年月
	@Test
	public void printCurYearMon() {
		System.out.println(new SimpleDateFormat("yyyyMM").format(new Date()));
	}
	
	//截取日期字符串
	@Test
	public void testDate() throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-02-24 04:29:09");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String dString = sdf.format(date);
		//dString = dString.replaceAll("0", replacement)
		System.out.println(dString);
	}
	
	
	/**使用Date近两小时的表示方法，startTime表示两小时前,endTime表示现在*/
	@Test
	public void twoHoursBefore() {
		/*Date d = new Date();
		int hours = d.getHours();
		String endTime = d.toLocaleString();
		d.setHours(hours - 2);
		String startTime = d.toLocaleString();
		System.out.println(startTime + "\n" + endTime);*/
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.MONTH + 1));
		String s = Integer.toString(c.get(Calendar.YEAR) * 100 + c.get(Calendar.MONTH) + 1);
		System.out.println(s);
	}
	
	
	/**使用LocalDate，近两小时的表示方法，startTime表示两小时前,endTime表示现在*/
	@Test
	public void twoHoursBeforeUseLocalDate() {
		//定义日期格式
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") ;
		LocalDateTime lDate = LocalDateTime.now();//获取当前日期和时间
		String endTime = df.format(lDate);//现在的时间
		//获取两小时前
		String startTime = df.format(lDate.minusHours(2));//两小时前
		System.out.println(endTime + "\n" + startTime);
	}
	
	/**使用SimpleDateFormat，近两小时的表示方法，startTime表示两小时前,endTime表示现在*/
	@Test
	public void twoHoursBeforeUseSimpleDateFormat() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String endTime = sd.format(d);
		int hours = d.getHours();
		d.setHours(hours - 2);
		String startTime = sd.format(d);
		System.out.println(startTime + "\n" + endTime);
	}
	
	/**
	* @Description: TODO(使用Date，近两小时的表示方法，startTime表示两小时前,endTime表示现在*)  
	* @param @param args 
	* @return void 
	* @throws
	*/
	@Test
	public void twohoursBeforeUseDate() {
		//声明日期格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//当前日期
		String endTime = sd.format(new Date());
		//当前至两小时前的间隔毫秒数
		long t = System.currentTimeMillis() - 2*3600*1000;
		//
		String startTime = sd.format(new Date(t));
		System.out.println(endTime);
		System.out.println(startTime);
	}
	
	/**
	* @Description: TODO(使用Date，近两小时的表示方法，startTime表示两小时前,endTime表示现在*)  
	* @param @param args 
	* @return void 
	* @throws
	*/
	@Test
	public void getYearStr() {
		//声明日期格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy");
		//当前日期
		String year = sd.format(new Date());
		System.out.println(year);
		String yearMonth = "201901";
		System.out.println(yearMonth.substring(0, 4));
		
	}
	
	@Test
	public void addN2() {
		//声明日期格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日");
		//当前日期
		String year = sd.format(new Date());
		System.out.println(year);
		year = year.substring(0, 5) + "[n2]" + year.substring(5);
		System.out.println(year);
	}
	
	
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
