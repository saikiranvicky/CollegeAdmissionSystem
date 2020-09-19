package com.cas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		System.out.println("hello");
		UserPojo user = new UserPojo(username, password);
		LoginDao loginDao = new LoginDao();
		boolean checkUser = loginDao.userCheck(user);
		if(!checkUser) {
			System.out.println("hi");
			response.sendRedirect("http://localhost:8080/CollegeAdmissionSystem/register.html");
		}else {
			boolean pwd = loginDao.checkpassword(user);
			if(!pwd) {	
				out.print("<p>Invalid Credentials!</p>");
				response.sendRedirect("http://localhost:8080/CollegeAdmissionSystem/userlogin.html");
				
			}else {
				response.sendRedirect("CollegeServlet"); 		
			}
		}
	}

}
