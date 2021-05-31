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
<% StudentBean bean=(StudentBean)request.getAttribute("bean");
String password=bean.getPassword();
out.println("your forgeton password is =="+password);

%><br>
<a href="SignInPage.jsp">SignIn</a>
</body>
</html>