package com.suxiangyu.utils;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
	
	public static int nextInt(){
		int value = ThreadLocalRandom.current().nextInt();
		return (value & 0x7FFFFFFF) | 0x1000100; 
	}
	
	public static int nextInt(int max){
		int value = ThreadLocalRandom.current().nextInt(max + 1);
		return value; 
	}
	
	public static int nextInt(int min, int max){
		int value = ThreadLocalRandom.current().nextInt((max + 1) - min);
		return min + value;
	}
	
	public static int[] nextIntegers(int min, int max, int subLength){
		
		int size = max - min;

		int[] array = new int[size];

		for(int i = 0; i < size; i++){
			array[i] = min + i;
		}

		if(size <= subLength){
			return array;
		}

		int temp1, temp2, len = array.length;

		int subRandoms[] = new int[subLength];

		for(int i = 0; i < subLength; i++)  {
			temp1 = Math.abs(nextInt()) % len;
			subRandoms[i] = array[temp1];
			temp2 = array[temp1];
			array[temp1] = array[len-1];
			array[len-1] = temp2;
			len--;
		}
		
		return subRandoms;
	}
	
	static char[] tables = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	public static char nextCharacter(){
		int index = nextInt(tables.length - 1);
		return tables[index];
	}
	
	public static String nextString(int length){
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			result.append(nextCharacter());
		}
		return result.toString();
	}
	
	public static String nextSimplifiedChineseCharacter(){
		//TODO 实现代码
		String str = null;
		int hightPos,lowPos;
		
		hightPos = (176 + Math.abs(nextInt(39)));
		lowPos   = (161 + Math.abs(nextInt(93)));
		
		byte[] b = new byte[2];
		b[0] = (Integer.valueOf(hightPos)).byteValue();
		b[1] = (Integer.valueOf(lowPos)).byteValue();
		
		try {
			str = new String(b, "GBK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("错误");
		}
		
		return str;
	}
	
	public static String nextSimplifiedChineseString(int length){
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			result.append(nextSimplifiedChineseCharacter());
		}
		return result.toString();
	}
	
	public static String generateChinesePersonName(){
		//TODO 实现代码
		int index = nextInt(SURNAME_ALL.length - 1);
		String name = SURNAME_ALL[index];
		
		int size  = nextInt(1, 2);
		for (int i = 0; i < size; i++) {
			name += nextSimplifiedChineseCharacter();
		}
		
		return name;
	}
	
	public static String uuid(){
		//TODO 实现代码
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
	final static String SURNAME_ALL  [] = {  
			"赵","钱","孙","李","周","吴","郑","王","冯","陈","楮","卫","蒋","沈","韩","杨",  
			"朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜",  
			"戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎",  
			"鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐",  
			"费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常",  
			"乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄",  
			"和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧",  
			"计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁",  
			"杜","阮","蓝","闽","席","季","麻","强","贾","路","娄","危","江","童","颜","郭",  
			"梅","盛","林","刁","锺","徐","丘","骆","高","夏","蔡","田","樊","胡","凌","霍",  
			"虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应","宗",  
			"丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚",  
			"程","嵇","邢","滑","裴","陆","荣","翁","荀","羊","於","惠","甄","麹","家","封",  
			"芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓",  
			"牧","隗","山","谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫",  
			"宁","仇","栾","暴","甘","斜","厉","戎","祖","武","符","刘","景","詹","束","龙",  
			"叶","幸","司","韶","郜","黎","蓟","薄","印","宿","白","怀","蒲","邰","从","鄂",  
			"索","咸","籍","赖","卓","蔺","屠","蒙","池","乔","阴","郁","胥","能","苍","双",  
			"闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍",  
			"郤","璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","郏","浦","尚","农",  
			"温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习","宦","艾","鱼","容",  
			"向","古","易","慎","戈","廖","庾","终","暨","居","衡","步","都","耿","满","弘",  
			"匡","国","文","寇","广","禄","阙","东","欧","殳","沃","利","蔚","越","夔","隆",  
			"师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空",  
			"曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","后","荆","红",  
			"游","竺","权","逑","盖","益","桓","公","晋","楚","阎","法","汝","鄢","涂","钦",  
			"岳","帅","缑","亢","况","后","有","琴","商","牟","佘","佴","伯","赏","墨","哈",  
			"谯","笪","年","爱","阳","佟","万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方",  
			"赫连","皇甫","尉迟","公羊","澹台","公冶","宗政","濮阳","淳于","单于","太叔","申屠",  
			"公孙","仲孙","轩辕","令狐","锺离","宇文","长孙","慕容","鲜于","闾丘","司徒","司空",  
			"丌官","司寇","仉","督","子车","颛孙","端木","巫马","公西","漆雕","乐正","壤驷","公良",  
			"拓拔","夹谷","宰父","谷梁","段干","百里","东郭","南门","呼延","归","海","羊舌","微生",  
			"梁丘","左丘","东门","西门","南宫"
			};
}
