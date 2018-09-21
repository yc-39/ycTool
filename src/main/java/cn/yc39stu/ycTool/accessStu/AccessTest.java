package cn.yc39stu.ycTool.accessStu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccessTest {
	
	private Connection connection = null;
	
	public Connection getConnection() {
		String accdbPath = "D:/yc/abc.accdb";
		String dbdrive = "net.ucanaccess.jdbc.UcanaccessDriver";
		String dburl = "jdbc:ucanaccess://" + accdbPath;
		String dbuser = "";
		String dbpass = "";
		
		try {
			Class.forName(dbdrive);
			connection = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}

	
	public static void main(String[] args) {
		try {
			AccessTest accessTest = new AccessTest();
			Connection connection = accessTest.getConnection();
			
			String sql = "create table tb_2 (tb_text text(50));";
//			String sql = "select * from tb_employee";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.executeQuery();
			preparedStatement.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
