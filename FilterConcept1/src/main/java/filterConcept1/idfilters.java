package filterConcept1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class idfilters
 */
@WebFilter("/filterConcept1")
public class idfilters implements Filter {

    /**
     * Default constructor. 
     */
    public idfilters() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
PrintWriter out=response.getWriter();
RequestDispatcher rd=null;
try {
	String userName=request.getParameter("user");
	String password=request.getParameter("pwd");
	
	if (userName==null || "".equals(userName) && password==null || "".equals(password)) {
	out.println("UserName or password Are Required !!!!!");
		rd=request.getRequestDispatcher("/f1.html");
		rd.include(request, response);
	} else {
		Authentication obj=new AuthenticationImpl();
		boolean b=obj.validLogin(userName, password);
		if (b) {
			
			chain.doFilter(request, response);
		} else {
			out.println("UserName or password Are InValid Try Again... !!!!!");
			rd=request.getRequestDispatcher("/f1.html");
			rd.include(request, response);

		}
	}
	} catch (Exception e) {
	// TODO: handle exception
}

		
		
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
