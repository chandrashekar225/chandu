<%@page import="webdemo.bean.java.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//request.getAttribute("bean");
//StudentBean bean=request.getAttribute("bean");
//String UserName=bean.getUserName();
/* String empName=bean.getEmpName();
String empSalary=bean.getEmpSalary();
String empDept=bean.getEmpDept(); */

//out.println("Hello Ms/Ms."+UserName);
 /*  StudentBean bean=(StudentBean) request.getAttribute("bean");
  String user=bean.getUserName();
 // HttpSession session=request.getSession();
  HttpSession session1=request.getSession();
  session1.getAttribute("bean.getUserName()");
  out.println("hello !!!"+session1.getAttribute("bean.getUserName()")); */
%>
<%= "Hello Ms/Mr."+request.getAttribute("email") %>
<a href="home.jsp">logout</a>
</body>
</html>