package webdemo.controllers.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webdemo.bean.java.StudentBean;
import webdemo.dao.java.StudentI;
import webdemo.daoimpl.java.StudentImpl;

/**
 * Servlet implementation class GetDetilsBYEmailAndPass
 */
@WebServlet("/GetDetilsBYEmailAndPass")
public class GetDetilsBYEmailAndPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDetilsBYEmailAndPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String password=request.getParameter("psw");
String email=request.getParameter("email");

try {
	
	StudentI getRecord=new StudentImpl();
	boolean bean=getRecord.isValidLogin(email, password);
	//System.out.println("get details by email and password====="+bean);
	request.setAttribute("bean", bean);
	//System.out.println("succesfully logged in " +bean);
	if (bean) {
		System.out.println("succesfully logged in " );
		RequestDispatcher dis=request.getRequestDispatcher("/welcome.jsp");
		dis.forward(request, response);
		
	} else {
		System.out.println("somthing fishing plese try again!!!!!!!");
		RequestDispatcher dis=request.getRequestDispatcher("/SignInPage.jsp");
		dis.forward(request, response);

	}
	//RequestDispatcher dis=request.getRequestDispatcher("welcome.jsp");
	//dis.forward(request, response);

} catch (Exception e) {
e.printStackTrace();
}
	
		doGet(request, response);
	}

}
