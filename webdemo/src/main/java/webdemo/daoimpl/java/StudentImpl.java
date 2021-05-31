package webdemo.daoimpl.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import webdemo.bean.java.StudentBean;
import webdemo.dao.java.StudentI;
import webdemo.log4j.java.log4jservlet;
import webdemo.util.java.Dbutil;

public class StudentImpl implements StudentI {
	static final Logger LOGGER = Logger.getLogger(log4jservlet.class);
Connection con=null;
	@Override
	public boolean addStudent(String userName, String password, String email) {

		String sql="insert into student(userName,password,email) values (?,?,?)";
		boolean flag=false;
		try {
			Dbutil dbutils=new Dbutil();
			con=dbutils.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, email);
			int i=ps.executeUpdate();
			if (i==1) {
				flag=true;
			} else {
				flag=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if (con!=null) {
				try {
					con.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return flag;
	}
	@Override
	public boolean isValidLogin(String email, String password) {
		LOGGER.info("is valid method is called");
			StudentBean bean=new StudentBean();
		
		String sql="select * from student where email=? and password=?";
		ResultSet rs=null;
		PreparedStatement ps=null;
		boolean flag=false;
		try {
			Dbutil dbutils=new Dbutil();
			con=dbutils.getConnection();
			System.out.println("connection success"+con);
			
			
			 ps=con.prepareStatement(sql);
			ps.setString(1, email);    //laptop
			ps.setString(2, password);   //123
			
			rs=ps.executeQuery();
			if (rs.next()) {
				flag=true;
			} else {
				flag=false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();		
		}finally {
			if (con!=null) {
		try {
			con.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
			}
	
		}

		return flag;


		
		//return null;
	}
	@Override
	public StudentBean ForgetPassword(String userName) {
		String sql="select * from student where userName=?";		
		StudentBean bean=new StudentBean();
		ResultSet rs=null;
		
		try {
		Dbutil dbutils=new Dbutil();
			con=dbutils.getConnection();
			System.out.println("connection success"+con);
			
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userName);
			 rs=ps.executeQuery();
				
			
			if (rs.next()) {
				bean.setUserName(rs.getString(1));
				bean.setPassword(rs.getString(2));
				bean.setEmail(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return bean;
	}
	@Override
	public boolean isExistEmailId(String email) {
//StudentBean bean=new StudentBean();
		
		String sql="select * from student where email=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
			Dbutil dbutils=new Dbutil();
			con=dbutils.getConnection();
			System.out.println("connection success"+con);
			
			
			 ps=con.prepareStatement(sql);
			ps.setString(1, email);    //laptop
			
			
			rs=ps.executeQuery();
			if (rs.next()) {
				flag=true;
			} else {
				flag=false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();		
		}finally {
			if (con!=null) {
		try {
			con.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
			}
	
		

		}		return flag;
	}
	@Override
	public boolean ValidLoginWithJquery(String email, String password) {
		StudentBean bean=new StudentBean();
		
		String sql="select * from student where email=? and password=?";
		ResultSet rs=null;
		PreparedStatement ps=null;
		boolean flag=false;
		try {
			Dbutil dbutils=new Dbutil();
			con=dbutils.getConnection();
			System.out.println("connection success"+con);
			
			
			 ps=con.prepareStatement(sql);
			ps.setString(1, email);    //laptop
			ps.setString(2, password);   //123
			
			rs=ps.executeQuery();
			if (rs.next()) {
				flag=true;
			} else {
				flag=false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();		
		}finally {
			if (con!=null) {
		try {
			con.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
			}
	
		}
		return flag;
	}
	
	

}
