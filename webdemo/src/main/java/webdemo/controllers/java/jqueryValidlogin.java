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
 * Servlet implementation class jqueryValidlogin
 */
@WebServlet("/jqueryValidlogin")
public class jqueryValidlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jqueryValidlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag=false;
		String msg = "";
		String email=request.getParameter("email");
		String password=request.getParameter("psw");
		try {
			StudentI jqueryObj=new StudentImpl();
			boolean b=jqueryObj.ValidLoginWithJquery(email, password);
			if (b) {
				flag=true;
			} else {
				System.out.println("inside false condition**********");
				msg = email +password +"email already exist please try with another one";
				flag = false;
			}
			response.getWriter().write(msg);
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
