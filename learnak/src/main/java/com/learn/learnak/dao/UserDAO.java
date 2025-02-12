package com.learn.learnak.dao;

import java.beans.Encoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.learnak.model.User;

@Repository
public class UserDAO {

	
	private static final String url="jdbc:mysql://localhost:3306/learn";
	private static final String username="root";
	private static final String password = "";
	
	public PreparedStatement pt;
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	private Connection con() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Fail to Connect!",e);
		}
	}
	
	public String addUser(User user) {
		//encrypt the password before saving to the database 5d103d27-d101-4e46-a3a8-4add0399e181
		//String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		
		String userPassword = bCryptPasswordEncoder.encode(user.getPassword());
		
		String userCheck = "select * from user where email = ? ;";
		String st = "insert into user(name,lastname,number,email,password) values(?,?,?,?,?)";
		
		Connection con = con();
		try {
			if(user.getName() == null || user.getLastname()==null || user.getNumber()==null || user.getEmail() == null || userPassword == null || userPassword.isEmpty() || bCryptPasswordEncoder.encode(user.getPassword()).isEmpty()) {
				
				return "You are not enter name , last name , number , email or password";
			}
			pt = con.prepareStatement(userCheck);
			if(user.getEmail() != null && userPassword != null) {
				pt.setString(1, user.getEmail());
				ResultSet rs = pt.executeQuery();
				
				if(!rs.next()) {
					pt = con.prepareStatement(st);
					pt.setString(1, user.getName());
					pt.setString(2, user.getLastname());
					pt.setString(3, user.getNumber());
					pt.setString(4, user.getEmail());
					pt.setString(5, userPassword);
					pt.executeUpdate();
					return "Sign up Done!";
				}
				else {
					return "Already Exist";
				}
			}else {
				return "Email or Password is Not enter";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Not able to Add user",e);
		}
	}
	
	public String enterUser(User user) {
		
		String st = "select * from user where email =?;" ;
		String enterPassword = user.getPassword();
		Connection con = con();
		
		try {
			if(user.getEmail() == null || user.getPassword() == null ) {
				return "Email or Password is not entered !";
			}
			pt = con.prepareStatement(st);
			pt.setString(1, user.getEmail());
			
			ResultSet rs = pt.executeQuery();
			if(rs.next()) {
				String userStorePassword = rs.getString("password");
				if(bCryptPasswordEncoder.matches(enterPassword, userStorePassword)) {

					return "Sign-In Done!";
				}
				else {
					return "User name or password is wrong!";
				}
			}
			else {
				return "User dose not Exists";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("User Unable to Sign - In",e);
		}finally {
		    try {
		        if (pt != null) pt.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
	}
	
//	public String upadateUser
}
