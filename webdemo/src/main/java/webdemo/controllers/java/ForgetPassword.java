package webdemo.controllers.java;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("user");
		String password=request.getParameter("psw");
try {
	StudentI forgetpassword=new StudentImpl();
	StudentBean bean=forgetpassword.ForgetPassword(userName);
	request.setAttribute("bean", bean);
	System.out.println(bean);
	if (bean!= null) {
		request.setAttribute("bean", bean);
		RequestDispatcher rd=request.getRequestDispatcher("/ForgetPassword.jsp");
		rd.forward(request, response);
	} else {
		out.println("Given User name Wrong. Give correct user name!!!!");
	}
} catch (Exception e) {
	// TODO: handle exception
}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
