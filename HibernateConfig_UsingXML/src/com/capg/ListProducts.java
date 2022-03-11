package com.capg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class ListProducts
 */
@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListProducts() {
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

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();

			Session session = factory.openSession();
			// using HQL
			List<String>  list = session.createQuery("select  E.name FROM EProduct E").list();
		
			System.out.println(list);
			
				List<EProduct> productList = session.createCriteria(EProduct.class).list();

				
					//session.createCriteria("price");
				
				System.out.println(productList);
			
			/*
			 * EProduct product = new EProduct(); product.setName("mobile");
			 * product.setPrice(new BigDecimal(60000));
			 */
			// product.setDateAdded(date);

			// session.save(product);

			//session.close();

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>Product Listing</b><br>");

			out.print("<table border='1'>");
			
			for (EProduct product : productList) {
				
				
				
				out.print("<tr>  <td>"+product.getID()+"</td> <td>"+product.getName()+"</td>  <td>"+product.getPrice()+"</td>        </tr>");
			
				
			}
			out.print("</table>");
			
			
			 

			/*
			 * for(EProduct p: list) { out.println("ID: " + String.valueOf(p.getID()) +
			 * ", Name: " + p.getName() + ", Price: " + String.valueOf(p.getPrice()) +
			 * ", Date Added: " + p.getDateAdded().toString() + "<br>"); }
			 */
			 
			out.println("</body></html>");

		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
