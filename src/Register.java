

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PrintWriter out;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/obs3","root", "8233848005");
			Statement stmt = null;
			stmt =  con.createStatement();
			String name=request.getParameter("name");
			String user=request.getParameter("username");
			String pass=request.getParameter("password");
			String conpass=request.getParameter("password1");
			String sql="Select * from customer where id='"+user+"';";
			ResultSet rs = stmt.executeQuery(sql);
			if(pass.equals(conpass)&&rs.isFirst()==false)
			{
				
				String sql1="insert into customer (id,password,name) values ('"+user+"','"+pass+ "','"+name+"');";
				stmt.executeUpdate(sql1);
				HttpSession session=request.getSession();
				 session.setAttribute("user",user);
				 session.setAttribute("con", con);
			
				 RequestDispatcher view = request.getRequestDispatcher("books.jsp");
				 
			    view.forward(request, response);
			}
			else
			{
				response.setContentType("text/html");
				out =response.getWriter();
				request.setAttribute("Error","Sorry! Username or Password Error. plz Enter Correct Detail or Register");
				RequestDispatcher view = request.getRequestDispatcher("register.jsp");
				 
			    view.forward(request, response);
				System.out.println("Not foundddd");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
