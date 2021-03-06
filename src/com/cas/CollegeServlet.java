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
 * Servlet implementation class CollegeServlet
 */
@WebServlet("/CollegeServlet")
public class CollegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body style='background-color:#C5E1A5;'>");
		out.print("<h2>List of Colleges</h2>");         
        List<CollegesPojo> list= LoginDao.getAllColleges();
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>College ID</th><th>CollegeName</th><th>City</th><th>State</th><th>Zipcode</th></tr>");  
        for(CollegesPojo c:list){  
        	out.print("<tr><td>"+c.getCollegeId()+"</td><td>"+c.getCollegeName()+"</td><td>"+c.getCity()+"</td><td>"+c.getState()+
        			"</td><td>"+c.getZipcode()+"</td><td><a href='DeleteCollegeServlet?id="+c.getCollegeId()+"'>Delete</a></td></tr>");  
        }  
        out.print("</table>");   
        out.print("</body>");
        out.print("</html>");
        out.close();  		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
