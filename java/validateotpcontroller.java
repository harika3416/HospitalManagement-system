

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateotpcontroller")
public class validateotpcontroller extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otp=request.getParameter("otp");
		PrintWriter out= response.getWriter();
		try{
			  Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection 		conn =	  DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			   		PreparedStatement  ps=  conn.prepareStatement("select *from patients where otp='"+otp+"'");	  
		ResultSet rs= ps.executeQuery();
		if(rs.next()){
			RequestDispatcher rtd= request.getRequestDispatcher("patientsdashboard.html");
			rtd.forward(request, response);
			
		}
		else{
			out.println("<script type=\"text/javascript\">"); 
		      out.println("alert('incorrect otp');"); 
		      out.println("location='validateotp.html';"); 
		      out.println("</script>");
		 	
		}

		}
		catch(Exception e ){
			e.printStackTrace();
			
		}

	}

}
