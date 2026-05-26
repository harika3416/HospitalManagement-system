

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updatespeccontroller")
public class updatespeccontroller extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String email=	request.getParameter("email");
		   
		   String specialization=	request.getParameter("specialization");
		  
		  
		     
		     
		  PrintWriter out=  response.getWriter();
		  
		  
		  try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection conn=   	DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
	       
	      PreparedStatement pst=	  conn.prepareStatement("update docter set specialization='"+specialization+"' where email='"+email+"'");
	        
	       
	        
	       
	        
	        
	        
	      int i=  pst.executeUpdate();
	           if(i!=0) {
	        	   out.println("<script type=\"text/javascript\">"); 
	   	        out.println("alert(' upadated  Successful');"); 
	   	        out.println("location='updatespec.html';"); 
	   	        out.println("</script>");
	   	   	
	           }
	           else {
	        	   out.println("<script type=\"text/javascript\">"); 
	   	        out.println("alert(' update Fail');"); 
//	   	        out.println("location='doctorreg.html';"); 
	   	        out.println("</script>");
	   	   	
	        	   
	           }
		  } catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	   
	}

}
