package com.simpli.app;

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
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns = "/LoginFilter",servletNames = "/home")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		
		PrintWriter out =	response.getWriter();
		
			response.setContentType("text/html");
		
		out.print("Filter executed....");
		
	String username =	request.getParameter("uname");
		
	String password =	request.getParameter("pwd");

		if(username.equals("javeed@gmail.com") && password.equals("tiger") )
		{
		//chain.doFilter(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("/home");
			
			rd.forward(request, response);
			
		}
		else {
			
	out.print("<h1 style='color:red'>Not a Authorized User , Please sign up</h1>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
