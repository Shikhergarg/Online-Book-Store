package new1;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class XmlServlet
 */
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		if(request.getRequestURL().equals("")){
		PrintWriter out=response.getWriter();
		String username=request.getParameter("uname");
		String psw=request.getParameter("psw");
		HttpSession session=request.getSession();
		
		if(username!=null &&username!="")
		session.setAttribute("savename", username);
		out.println("Hello"+username);
		out.println("Hello"+(String)session.getAttribute("savename"));
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "8233848005");
			//PreparedStatement s = con.prepareStatement("create table pp(name varchar(25))");
			 String sql = "insert into registration values(1,'jkhj','tuky',25)"; 
			 Statement stmt = null;
			 stmt =  con.createStatement();
	      stmt.execute(sql);
	      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		else
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");	
		out.println("Hello df"+username);
	}

}
