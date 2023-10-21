package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myemail=req.getParameter("email1");
		String mypass=req.getParameter("pass1");
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo", "root", "ravi123");
			
			PreparedStatement ps =con.prepareStatement("select * from register where email=? and password=?");
			ps.setString(1, myemail);
			ps.setString(2, mypass);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				HttpSession session=req.getSession();
				session.setAttribute("session_name", rs.getString("name"));
				RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
				rd.include(req, resp);
			}
			else {
				
				out.print("<h3 style=color:green>emailid and password didnt matched</h3>");
				RequestDispatcher rd =req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			
			out.print("<h3 style=color:green>"+e.getMessage()+"</h3>");
			RequestDispatcher rd =req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
		}
	}
}
