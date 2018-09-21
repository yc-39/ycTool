package cn.yc39stu.ycTool.util;

public class StringUtil {

	// 下划线
	private static final char UNDERLINE = '_';
	
	/**
	 *  驼峰式 转 下划线式
	 * @param str
	 * @return
	 */
	public static String camel2Underline(String str) {
		if (CheckUtil.isEmpty(str)) return "";
		int length = str.length();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			char c = str.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 *  下划线式 转 驼峰式
	 * @param str
	 * @return
	 */
	public static String underline2Camel(String str) {
		if (CheckUtil.isEmpty(str)) return "";
		int length = str.length();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			char c = str.charAt(i);
			if (c == UNDERLINE) {
				i++;
				sb.append(Character.toUpperCase(str.charAt(i)));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		String str1 = "ab_cd";
		System.out.println(underline2Camel(str1));
		String str2 = "aBcDe";
		System.out.println(camel2Underline(str2));
	}
	
	
	
}
