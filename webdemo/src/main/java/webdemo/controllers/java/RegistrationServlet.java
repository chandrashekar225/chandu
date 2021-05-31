package webdemo.controllers.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webdemo.daoimpl.java.StudentImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("user");
		String email=request.getParameter("email");
		String password=request.getParameter("psw");
		try {
			StudentImpl stdRecord=new StudentImpl(); 
			boolean b=stdRecord.addStudent(userName, password, email);
			System.out.println("details submited by acount holder===="+b);
			if (b) {
				System.out.println("given details are succesfully recorded!!!"+b);
				RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
				dis.forward(request, response);
				
			} else {
				System.out.println("somthing fishing!!!! try again later!!!!!");
				RequestDispatcher dis = request.getRequestDispatcher("/RegistrationForm.jsp");
				dis.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		doGet(request, response);
	}

}
