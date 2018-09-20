package cn.yc39stu.ycTool.util;

public class CheckUtil {


	public static boolean isEmpty(String str) {
		if(str==null)return true;
		str = str.trim();
		if(str.length()==0)return true;
		return false;
	}
	

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	
	
	
	public static boolean isAccount(String str) {
		if(isEmpty(str))return false;
		if(!isCharString(str))return false;
		if(str.length()<6) return false;
		if(str.length()>20) return false;
		return true ;
		
	}
	
	
	public static boolean isPassword(String str) {
		if(isEmpty(str))return false;
		if(!isCharString(str))return false;
		if(str.length()<6) return false;
		if(str.length()>20) return false;
		return true ;
	}
	
	
	public static boolean isMail(String str) {
		if(isEmpty(str))return false;
		String mailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean b = str.matches(mailRegex);
		return b;
	}
	

	public static boolean isNickname(String str) {
		if(isEmpty(str))return false;
		if(str.length()<2) return false;
		if(str.length()>50) return false;
		return true;
	}
	
	
	
	
	public static boolean isCharString(String str) {
		if(isEmpty(str))return false;
		return str.matches("[a-zA-Z0-9]*") ;
		
	}
	
	
	
	public static boolean isInteger(String str) {
		if(isEmpty(str)) return false;
		try {
			Integer.valueOf(str);
			return true;
		} catch (Exception e) {}
		return false;
	}
	
	
	public  static boolean isDouble(String str) {
		if(isEmpty(str)) return false;
		try {
			Double.valueOf(str);
			return true;
		} catch (Exception e) {}
		return false;
	}
	
	
	public static boolean isNumeric(String str) {
		if(isEmpty(str)) return false;
		return str.matches("[0-9]*") ;
	}
	
	/**
	 * 正整数
	 * @param str
	 * @return
	 */
	public static boolean isPositiveInteger(String str) {
		if(isEmpty(str)) return false;
		return str.matches("^[1-9][0-9]*$");
	}
	
	/**
	 * 日期
	 * 格式：yyyyMMdd
	 * @param str
	 * @return
	 */
	public static boolean isDateYMD(String str) {
		if(isEmpty(str)) return false;
		return str.matches("^\\d{4}[0-1][0-9][0-3][0-9]$");
	}
	
	/**
	 * 日期
	 * 格式：yyyy-MM-dd 或 yyyy/MM/dd 或 yyyy.MM.dd
	 * @param str
	 * @return
	 */
	public static boolean isDateYMD_(String str) {
		if(isEmpty(str))return false;
		return str.matches("^\\d{4}(-|.|/)\\d{2}(-|.|/)\\d{2}$");
	}
	
	/**
	 * 日期
	 * 格式：yyyy-MM-dd
	 * @param str
	 * @return
	 */
	public static boolean isDateYMD_45(String str) {
		if(isEmpty(str))return false;
		return str.matches("^\\d{4}(-)\\d{2}(-)\\d{2}$");
	}
	
	
	/**
	 * 日期
	 * 格式：yyyy.MM.dd
	 * @param str
	 * @return
	 */
	public static boolean isDateYMD_46(String str) {
		if(isEmpty(str)) return false;
		return str.matches("^\\d{4}(.)\\d{2}(.)\\d{2}$");
		
	}
	
	
	/**
	 * 日期
	 * 格式：yyyy/MM/dd
	 * @param str
	 * @return
	 */
	public static boolean isDateYMD_47(String str) {
		if(isEmpty(str)) return false;
		return str.matches("^\\d{4}(/)\\d{2}(/)\\d{2}$");
	}
	
	/**
	 * 日期
	 * 格式：yyyyMM
	 * @param str
	 * @return
	 */
	public static boolean isDateYM(String str) {
		if(isEmpty(str)) return false;
		return str.matches("^\\d{4}[0-1][0-9]$");
	}
	
	/**
	 * 日期
	 * 格式：yyyy-MM 或 yyyy/MM 或 yyyy.MM
	 * @param str
	 * @return
	 */
	public static boolean isDateYM_(String str) {
		if(isEmpty(str)) return false;
		return str.matches("^\\d{4}(-|.|/)[0-1][0-9]$");
	}
	/**
	 * 日期
	 * 格式：yyyy-MM
	 * @param str
	 * @return
	 */
	public static boolean isDateYM_45(String str) {
		if(isEmpty(str)) return false;
		return str.matches("^\\d{4}(-)[0-1][0-9]$");
	}
	
	/**
	 * 日期
	 * 格式：yyyy.MM
	 * @param str
	 * @return
	 */
	public static boolean isDateYM_46(String str) {
		if(isEmpty(str)) return false;
		return str.matches("^\\d{4}(.)[0-1][0-9]$");
	}
	
	/**
	 * 日期
	 * 格式：yyyy/MM
	 * @param str
	 * @return
	 */
	public static boolean isDateYM_47(String str) {
		if(isEmpty(str)) return false;
		return str.matches("^\\d{4}(/)[0-1][0-9]$");
	}
	
	
	
	/**
	 * 11位的手机号码
	 * @param str
	 * @return
	 */
	public static boolean isActionPhone(String str) {
		if(isEmpty(str))return false;
		return str.matches("^1[0-9]{10}$");
	}



	public static void main(String[] args) {
		String str = "19920531";
		boolean flag = CheckUtil.isDateYMD(str);
		System.out.println(flag);
	}
}
