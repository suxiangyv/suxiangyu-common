package com.suxiangyu.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 
	    * @Title: getAge
	    * @Description: 计算年龄的方法
	    * @param @param 生日
	    * @param @return    参数
	    * @return int    年龄
	    * @throws
	 */
	public static int getAge(Date date) {
		return Period.between(getLocalDate(date), LocalDate.now()).getYears();
	}
	/**
	 * 
	    * @Title: randomDate
	    * @Description: 在日期区间内生成随机日期
	    * @param @param startDate
	    * @param @param endDate
	    * @param @return    参数
	    * @return Date    返回类型
	    * @throws
	 */
	public static Date randomDate(Date startDate,Date endDate) {
		//1.8新特性,Date->Instant->ZonedDateTime->LocalDate，反之亦然
		  LocalDateTime start = getLocalDateTime(startDate);
		  LocalDateTime end = getLocalDateTime(endDate);
		  long period = ChronoUnit.SECONDS.between(start, end); 
		  long toPlus = (long)(Math.random()*period);
		  LocalDateTime result = start.plusSeconds(toPlus);
		  return getDate(result);
		
	}
	/**
	 * 
	    * @Title: getInitMonth
	    * @Description: 返回传入日期的月初，如传入2020/03/27,返回2020/03/01 00:00:00
	    * @param @param date
	    * @param @return    参数
	    * @return Date    返回类型
	    * @throws
	 */
	public static Date getInitMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 1,0,0,0);
		return c.getTime();
	}
	/**
	 * 
	    * @Title: getEndMonth
	    * @Description: 返回传入日期的月初，如传入2020/03/27,返回2020/03/01 00:00:00
	    * @param @param date
	    * @param @return    参数
	    * @return Date    返回类型
	    * @throws
	 */
	public static Date getEndMonth(Date date) {
		Calendar c = Calendar.getInstance();
		//初始化时间
		c.setTime(date);
		//年保留，月加一，日时分秒清空
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, 1,0,0,0);
		//减一秒
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}
	/**
	 * 
	    * @Title: getRemainingDays
	    * @Description: 计算剩余天数
	    * @param @param starDate
	    * @param @param endDate
	    * @param @return    参数
	    * @return long    返回类型
	    * @throws
	 */
	public static long getRemainingDays(Date starDate,Date endDate) {
		LocalDate start = getLocalDate(starDate);
		LocalDate end = getLocalDate(endDate);
		return ChronoUnit.DAYS.between(start, end);
	}
	/**
	 * 
	    * @Title: isToday
	    * @Description: 判断是否为今天
	    * @param @param date
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isToday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar now = Calendar.getInstance();
		return (now.get(Calendar.YEAR)==calendar.get(Calendar.YEAR)
			&& now.get(Calendar.MONTH)==calendar.get(Calendar.MONTH)
			&& now.get(Calendar.DAY_OF_MONTH)==calendar.get(Calendar.DAY_OF_MONTH)
			);
	}
	/**
	 * 
	    * @Title: inThisWeek
	    * @Description: 判断是否在本周
	    * @param @param date
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean inThisWeek(Date date) {
		LocalDate thisMonday = LocalDate.now().with(DayOfWeek.MONDAY);
		LocalDate localMonday = getLocalDate(date).with(DayOfWeek.MONDAY);
		return Period.between(thisMonday, localMonday).getDays()==0;
	}
	/**
	 * 
	    * @Title: inThisMonth
	    * @Description: 判断是否在本月
	    * @param @param date
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean inThisMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar now = Calendar.getInstance();
		return (now.get(Calendar.YEAR)==calendar.get(Calendar.YEAR)
			&& now.get(Calendar.MONTH)==calendar.get(Calendar.MONTH)
			);
	}
	/**
	 * 
	    * @Title: inThisYear
	    * @Description: 判断是否在本年
	    * @param @param date
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean inThisYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR)==calendar.get(Calendar.YEAR);
	}
	/**
	 * 
	    * @Title: getDate
	    * @Description: LocalDate转Date，LocalDate->ZonedDateTime->Instant->Date
	    * @param @param localDate
	    * @param @return    参数
	    * @return Date    返回类型
	    * @throws
	 */
	public static Date getDate(LocalDate localDate) {
		if(null==localDate) {
			return null;
		}
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	/**
	 * 
	    * @Title: getDate
	    * @Description: LocalDateTime转Date，LocalDateTime->ZonedDateTime->Instant->Date
	    * @param @param localDateTime
	    * @param @return    参数
	    * @return Date    返回类型
	    * @throws
	 */
	public static Date getDate(LocalDateTime localDateTime) {
		if(null==localDateTime) {
			return null;
		}
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	/**
	 * 
	    * @Title: getLocalDate
	    * @Description: Date转LocalDate，Date->Instant->ZonedDateTime->LocalDate
	    * @param @param date
	    * @param @return    参数
	    * @return LocalDate    返回类型
	    * @throws
	 */
	public static LocalDate getLocalDate(Date date) {
		if(null==date) {
			return null;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	/**
	 * 
	    * @Title: getLocalDateTime
	    * @Description: Date转LocalDateTime，Date->Instant->ZonedDateTime->LocalDateTime
	    * @param @param date
	    * @param @return    参数
	    * @return LocalDateTime    返回类型
	    * @throws
	 */
	public static LocalDateTime getLocalDateTime(Date date) {
		if(null==date) {
			return null;
		}
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}
