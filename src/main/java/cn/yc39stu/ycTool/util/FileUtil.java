package cn.yc39stu.ycTool.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	/**
	 * 删除文件
	 * @param file
	 */
	public static void deleteFile(File file) {
		System.out.println("开始删除：" + file.getAbsolutePath());
		if (!file.exists()) {
			System.out.println("错误！！！文件或文件夹不存在！");
			return;
		}
		
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File childFile : files) {
				deleteFile(childFile);
			}
		}
		if (file.delete()) {
			System.out.println("删除成功！" + file.getAbsolutePath());
		} else {
			System.out.println("删除失败！" + file.getAbsolutePath());
		}
	}
	
	/**
	 * 读取文本文件
	 * @param file
	 * @return
	 */
	public static List<String> readTxtFile(File file) {
		System.out.println("读取文件内容：" + file.getAbsolutePath());
		if (!file.exists()) {
			System.out.println("错误！！！文件或文件夹不存在！");
			if (!file.isFile()) {
				return null;
			}
		
			System.out.println("错误！文件类型！");
			return null;
		}
		
		List<String> results = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String temp = br.readLine();
			while (temp != null) {
				
				results.add(temp);
				temp = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
	
	/**
	 * 复制文件
	 * @param source
	 * @param dest
	 */
	public void copy(String source, String dest) {
		
	}
}
