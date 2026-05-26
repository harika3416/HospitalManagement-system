

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


@WebServlet("/doctorregcontroller")
public class doctorregcontroller extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String email=	request.getParameter("email");
		   
		   String password=	request.getParameter("password");
		   String fname=	request.getParameter("fn");
		   String lname=	request.getParameter("ln");
		   String gender=	request.getParameter("gender");
		   String specialization=	request.getParameter("specialization");
		  
		  
		     
		      int id =0;
		  PrintWriter out=  response.getWriter();
		  
		  
		  try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection conn=   	DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
	       
	    PreparedStatement pst=     conn.prepareStatement("insert into docter(id,email,password,fname,lname,gender,specialization) values(?,?,?,?,?,?,?)");
	        
	        pst.setInt(1, id);
	        
	        pst.setString(2, email);
	       
	        pst.setString(3, password);
	        pst.setString(4, fname);
	        pst.setString(5, lname);
	        pst.setString(6, gender);
	        pst.setString(7, specialization);
	     
	        
	        
	        
	      int i=  pst.executeUpdate();
	           if(i!=0) {
	        	   out.println("<script type=\"text/javascript\">"); 
	   	        out.println("alert(' Registration  Successful');"); 
	   	        out.println("location='doctorreg.html';"); 
	   	        out.println("</script>");
	   	   	
	           }
	           else {
	        	   out.println("<script type=\"text/javascript\">"); 
	   	        out.println("alert(' Register Fail');"); 
//	   	        out.println("location='doctorreg.html';"); 
	   	        out.println("</script>");
	   	   	
	        	   
	           }
		  } catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	   
	}

}
