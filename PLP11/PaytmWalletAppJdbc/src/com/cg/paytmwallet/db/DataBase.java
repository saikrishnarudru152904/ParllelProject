package com.cg.paytmwallet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.paytmwallet.exception.AccountException;

public class DataBase {
	
	public static Connection getConnection() throws AccountException{
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url,"system","orcl11g");
		}catch(ClassNotFoundException e){
			throw new AccountException(e.getMessage());
		}catch(SQLException e1){
			throw new AccountException(e1.getMessage());
		}
		
		
	}
}
