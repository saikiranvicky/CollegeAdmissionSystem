package com.cas;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	public static Connection getConnect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegeadmission","root","qwerty@123");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
