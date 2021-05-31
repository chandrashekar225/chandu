package webdemo.controllers.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webdemo.dao.java.StudentI;
import webdemo.daoimpl.java.StudentImpl;

/**
 * Servlet implementation class ControlSignUpPage
 */
@WebServlet("/ControlSignUpPage")
public class ControlSignUpPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlSignUpPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			boolean flag = false;
			String msg = "";
			String email = request.getParameter("email");
			StudentI isValid = new StudentImpl();
			boolean b = isValid.isExistEmailId(email);
			if (b) {
				System.out.println("inside if condition**********");
				msg = email + "email already exist please try with another one";
				flag = true;
			} else {
				flag = false;
			}
			response.getWriter().write(msg);
		} catch (Exception e) {
			e.printStackTrace();

		}

		doGet(request, response);
	}

}
