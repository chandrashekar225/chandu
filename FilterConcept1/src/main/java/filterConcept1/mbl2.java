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
 * Servlet Filter implementation class mbl2
 */
@WebFilter("/fc1")
public class mbl2 implements Filter {

    /**
     * Default constructor. 
     */
    public mbl2() {
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
		String userName=request.getParameter("user");
		String password=request.getParameter("pwd");
		RequestDispatcher rd=null;
		if (userName==null|| "".equals(userName)||password==null|| "".equals(password)) {
			out.println("plzz..enter username and password");
			rd=request.getRequestDispatcher("/r1.jsp");
			rd.include(request, response);
		} else {
			imp2 v2=new imp2();
			boolean b=v2.valid(userName, password);
			if (b) {
				chain.doFilter(request, response);
			} else {
				out.println("plzz..enter valid information");
				rd=request.getRequestDispatcher("/r1.jsp");
				rd.include(request, response);

			}
		}
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
