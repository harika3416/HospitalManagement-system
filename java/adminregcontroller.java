

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminregcontroller")
public class adminregcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		  String email=		request.getParameter("email");
		  String password=		request.getParameter("password");
		  
		 

		
		     try {
					
	        	   Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        Connection conn= 	   DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root", "root");
	        
	    PreparedStatement pst=    conn.prepareStatement("insert into admin(email,password)values(?,?)");
	        
	       
	        pst.setString(1, email);
	        pst.setString(2, password);
	       
	        
	         int i=   pst.executeUpdate();
	         
	            if(i==1) {
	            	
	            	 RequestDispatcher rd=   request.getRequestDispatcher("Admin.html");
          	       rd.forward(request, response);
	            	
	            	
	            }
	            else {
	            	 RequestDispatcher rd=   request.getRequestDispatcher("adminreg.html");
	          	       rd.include(request, response);
		             }
	           


	        
	       } catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	     
	}
		}
	
	


