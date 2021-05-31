package webdemo.dao.java;

import webdemo.bean.java.StudentBean;

public interface StudentI {

	public boolean addStudent(String userName,String password,String email);
	public boolean isValidLogin(String email,String password);
	public StudentBean ForgetPassword(String userName);
	public boolean isExistEmailId(String email);
	public boolean ValidLoginWithJquery(String email,String password);
}
