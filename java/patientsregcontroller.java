

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

@WebServlet("/patientsregcontroller")
public class patientsregcontroller extends HttpServlet {
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String email=	request.getParameter("email");
		   
		    
		   String password=	request.getParameter("password");
		   String fname=	request.getParameter("fn");
		   String lname=	request.getParameter("ln");
		   String mobile=	request.getParameter("mobile");
		   String disease=	request.getParameter("disease");
		   
		 
		  
		   
		      int pt_id =0;
		  PrintWriter out=  response.getWriter();
		  
		  
		  try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection conn=   	DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
	       
	    PreparedStatement pst=     conn.prepareStatement("insert into patients(pt_id,email,password,fname,lname,mobile,disease) values(?,?,?,?,?,?,?)");
	        
	        pst.setInt(1,pt_id);
	        pst.setString(2, email);
	        pst.setString(3, password);
	        pst.setString(4, fname);
	        pst.setString(5, lname);
	        pst.setString(6, mobile);
	        pst.setString(7, disease);
	       
	        
	        
	        
	      int i=  pst.executeUpdate();
	           if(i!=0) {
	        	   out.println("<script type=\"text/javascript\">"); 
	   	        out.println("alert('patient Registration  Successful');"); 
	   	        out.println("location='patientslogin.html';"); 
	   	        out.println("</script>");
	   	   	
	           }
	           else {
	        	   out.println("<script type=\"text/javascript\">"); 
	   	        out.println("alert('Student Register Fail');"); 
	   	        out.println("location='patientreg.html';"); 
	   	        out.println("</script>");
	   	   	
	        	   
	           }
		  } catch (Exception e) {
				
				e.printStackTrace();
			}
	   
	}

}
