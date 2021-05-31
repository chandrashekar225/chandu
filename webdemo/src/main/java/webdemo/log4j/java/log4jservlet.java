package webdemo.log4j.java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import webdemo.dao.java.StudentI;
import webdemo.daoimpl.java.StudentImpl;

/**
 * Servlet implementation class log4jservlet
 */
@WebServlet("/log4jservlet")
public class log4jservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static final Logger LOGGER = Logger.getLogger(log4jservlet.class);
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("this is a logging statement from log4j");
		String html = "<html><h2>Log4j has been initialized successfully!</h2></html>";
        response.getWriter().println(html);
        StudentI obj=new StudentImpl();
        obj.isValidLogin("email", "password");
		 response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
