package com.cas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	
	Connection con = null;
    ResultSet resultSet = null;
	
	
	public String insertUser(UserPojo user) {
		String result = "Successfully inserted";
		try {
			con = JdbcConnection.getConnect();
			PreparedStatement pst = con.prepareStatement("insert into collegeadmission.users values(?,?,?)");
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			//pst.setString(4, user.getRole());
			pst.executeUpdate();
		} catch (SQLException e) {
			result = "Failed to insert details.";
			e.printStackTrace();
		}
		return result;
		
	}
	public boolean userCheck(UserPojo user) {
		try {
			String name = user.getUsername();
			System.out.println(name);
			con = JdbcConnection.getConnect();
			Statement statement = con.createStatement();
			String userNameDB = "";
			resultSet = statement.executeQuery("select username from collegeadmission.users");
			while(resultSet.next()) {
				userNameDB = resultSet.getString("username");
				if(name.equalsIgnoreCase(userNameDB)) {
					System.out.println(name);
					return true;
				}
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkpassword(UserPojo user) {
		try {
			//String name = user.getUsername();
			String password = user.getPassword();
			System.out.println(password);
			con = JdbcConnection.getConnect();
			Statement statement = con.createStatement();
			String userNamePwd = "";
			resultSet = statement.executeQuery("select password from collegeadmission.users");
			while(resultSet.next()) {
				userNamePwd = resultSet.getString("password");
				if(password.equalsIgnoreCase(userNamePwd)) {
					System.out.println(userNamePwd);
					return true;
				}		
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	}