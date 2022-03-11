package com.ecommerce;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class HibernateInit
 */
@WebServlet("/HibernateInit")
public class HibernateInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HibernateInit() {
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

			Transaction tx = session.beginTransaction();

	EProduct  product = new EProduct(new Long(102),"Laptop",new BigDecimal(52000.0),new Date());
			
				Serializable ser =	session.save(product);
			
					System.out.println(ser);
			
			
			// using HQL
			
			List<EProduct> list = session.createQuery("from EProduct").list();

			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<b>Product Listing</b><br>");
			for (EProduct p : list) {
				out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() + ", Price: "
						+ String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");
			}

			out.println("</body></html>");

			/*
			 * EProduct product = new EProduct();
			 * 
			 * product.setID(1); product.setName("Laptop"); product.setPrice(new
			 * BigDecimal(30000)); product.setDateAdded(new Date());
			 */

			// session.save(product); // insert
			// session.update(product);
			// session.delete(product);

			Customer cust = new Customer();

			cust.setCname("Rahul");

			session.save(cust);

			tx.commit();

			session.close();

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
