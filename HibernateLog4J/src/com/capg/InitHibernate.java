package com.capg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




/**
 * Servlet implementation class InitHibernate
 */
@WebServlet("/InitHibernate")
public class InitHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	public InitHibernate() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
	Logger log =	Logger.getLogger(InitHibernate.class);	
		
		
			
	      try {
              PrintWriter out = response.getWriter();
              out.println("<html><body>");

              SessionFactory factory = HibernateUtil.getSessionFactory();
               log.info("Session Factory Created");      
              Session session = factory.openSession();
              out.println("Hibernate Session opened.<br>");
              out.print(session);
              	log.info("session created..");
              	log.warn("this is warning...");
              	log.error("sorry invalid user ");;
              	
              session.close();
              out.println("Hibernate Session closed.<br>");
                     
              out.println("</body></html>");
                 
                  
              } catch (Exception ex) {
                      throw ex;
              }

	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
