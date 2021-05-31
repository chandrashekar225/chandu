package webdemo.util.java;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dbutil {
	String url="jdbc:mysql://localhost:3306/chandu";
	String driverClass="com.mysql.jdbc.Driver";
	String user="root";
	String pass="chandu225";
	Connection con=null;
		public Connection getConnection() {
			try {
				//data base connection
				Class.forName(driverClass);
				 con=DriverManager.getConnection(url, user, pass);
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			return con;
			
			
		} 
		
		
		/*
		 * public static void main(String[] args) { Dbutil obj=new Dbutil(); Connection
		 * con=obj.getConnection();
		 * System.out.println("connection successfully done"+con); }
		 */
		 
}