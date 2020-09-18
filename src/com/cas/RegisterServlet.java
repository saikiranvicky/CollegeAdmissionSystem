package com.cas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserPojo user = new UserPojo(email,username,password);
		
		LoginDao loginDao = new LoginDao();
		boolean checkUser = loginDao.userCheck(user);
		System.out.println(checkUser);
		
		if(!checkUser) {
			String inserted = loginDao.insertUser(user);
			System.out.println(inserted);
			System.out.println(request.getContextPath());
			response.sendRedirect("http://localhost:8080/CollegeAdmissionSystem/colleges.html");
			//request.getRequestDispatcher("listofcolleges.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("http://localhost:8080/CollegeAdmissionSystem/colleges.html");
			
		}
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
//		 
//		    try
//		    {
//		        String validateUser = loginDao.userValidate(user);
//		 
//		        if(validateUser.equals("Admin_Role"))
//		        {
//		            System.out.println("Admin's Home");
//		 
//		            HttpSession session = request.getSession(); //Creating a session
//		            session.setAttribute("Admin", username); //setting session attribute
//		            request.setAttribute("userName", username);
//		 
//		           // request.getRequestDispatcher("/JSP/Admin.jsp").forward(request, response);
//		        }
//		        else if(validateUser.equals("User_Role"))
//		        {
//		            System.out.println("User's Home");
//		 
//		            HttpSession session = request.getSession();
//		            session.setMaxInactiveInterval(10*60);
//		            session.setAttribute("User", username);
//		            request.setAttribute("userName", username);
//		 
//		           // request.getRequestDispatcher("/JSP/User.jsp").forward(request, response);
//		        }
//		        else
//		        {
//		            System.out.println("Error message = "+validateUser);
//		            request.setAttribute("errMessage", validateUser);
//		 
//		           // request.getRequestDispatcher("/JSP/Login.jsp").forward(request, response);
//		        }
//		    }
////		    catch (IOException e1)
////		    {
////		        e1.printStackTrace();
////		    }
//		    catch (Exception e2)
//		    {
//		        e2.printStackTrace();
//		    }
	}

}
