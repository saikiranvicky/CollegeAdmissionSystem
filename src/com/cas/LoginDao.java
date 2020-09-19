package com.cas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {
	
	static Connection con = null;
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
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
		
	}

	public boolean checkpassword(UserPojo user) {
		try {
			String name = user.getUsername();
			String password = user.getPassword();
			System.out.println(password);
			con = JdbcConnection.getConnect();
			Statement statement = con.createStatement();
			String userNameDB = "";
			String userNamePwd = "";
			resultSet = statement.executeQuery("select username,password from collegeadmission.users");
			while(resultSet.next()) {
				userNameDB = resultSet.getString("username");
				userNamePwd = resultSet.getString("password");
				if(name.equalsIgnoreCase(userNameDB) && password.equalsIgnoreCase(userNamePwd)) {
					System.out.println(userNameDB);
					System.out.println(userNamePwd);
					return true;
				}		
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public static List<CollegesPojo> getAllColleges(){  
        List<CollegesPojo> college_list=new ArrayList<CollegesPojo>();  
          
        try{  
        	con = JdbcConnection.getConnect(); 
            PreparedStatement ps=con.prepareStatement("select * from  collegeadmission.colleges");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	CollegesPojo cp=new CollegesPojo();
            	cp.setCollegeId(rs.getInt(1));
            	cp.setCollegeName(rs.getString(2));
            	cp.setCity(rs.getString(3));
            	cp.setState(rs.getString(4));
            	cp.setZipcode(rs.getString(5));  
            	college_list.add(cp);  
            }    
        }
        catch(Exception e){
        	e.printStackTrace();
        }  
        finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}     
        return college_list;  
    }
	
	public boolean delete(int id) {
		try {
			con = JdbcConnection.getConnect(); 
            PreparedStatement ps=con.prepareStatement("delete from  collegeadmission.colleges where collegeid=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	}