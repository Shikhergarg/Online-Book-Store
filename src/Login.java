

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
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
				 String str=request.getParameter("username");
				 String pass=request.getParameter("password");
				 String sql="Select * from customer where id  ='"+str+"'and password='"+pass+"'";
				 ResultSet rs = stmt.executeQuery(sql);
				 if(rs.first()!=false)
				 {
					 HttpSession session=request.getSession();
					 session.setAttribute("username",str);
					 session.setAttribute("con", con);
				
				 RequestDispatcher view = request.getRequestDispatcher("books.jsp");
				    view.forward(request, response);
				 }
				 else
				 {
					 response.setContentType("text/html");
					out =response.getWriter();
					request.setAttribute("Error","Sorry! Username or Password Error. plz Enter Correct Detail or Register");
					//out.println ("<html><body><script>alert('6666e');</script></body></html>");
					System.out.println("Not found");
					RequestDispatcher view = request.getRequestDispatcher("index.jsp");
				    view.forward(request, response);
					
				 }
				 
				 
				 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}

}
