package com.msr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcurl="jdbc:mysql://localhost:3306/hibernate_one_to_one?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			
			Connection myCon=DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("successful");
			
		}catch(Exception exc){
			exc.printStackTrace();
		}

	}

}
