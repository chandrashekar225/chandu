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
 * Servlet Filter implementation class mbl3
 */
@WebFilter("/fc2")
public class mbl3 implements Filter {

    /**
     * Default constructor. 
     */
    public mbl3() {
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
		String username=request.getParameter("user");
		String password=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		if (username==null|| "".equals(username)||password==null|| "".equals(password)) {
			out.println("plzz...enter user name and password");
			rd=request.getRequestDispatcher("/r2.jsp");
			rd.include(request, response);
		} else {
			imp3 v3=new imp3();
			boolean b=v3.valid(username, password);
			if (b) {
				chain.doFilter(request, response);
			} else {
				out.println("plzz... enter valid information");
				rd=request.getRequestDispatcher("/r2.jsp");
				rd.include(request, response);

			}

		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
