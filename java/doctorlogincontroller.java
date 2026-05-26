

import java.io.IOException;
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
import javax.servlet.http.HttpSession;


@WebServlet("/doctorlogincontroller")
public class doctorlogincontroller extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=	request.getParameter("email");
		   String password=	request.getParameter("password");
		   
		   
		      try {
		    	  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		          Connection conn= 	   DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root", "root");
		          
		        PreparedStatement pst=  conn.prepareStatement("select *from docter where email=? AND password=?");
		    	  
		        
		          pst.setString(1, email);
		          pst.setString(2, password);
		          
		        ResultSet rs=  pst.executeQuery();
		       
//		        
		             if(rs.next()) {
		            	String dbemail= rs.getString("email");
		            	String dbpassword= rs.getString("password");
		            	
		            	 HttpSession httpSession=    request.getSession();
		            	      httpSession.setAttribute("email", dbemail);
		            	
		            	   if(email.equals(dbemail) && password.equals(dbpassword)) {
		            		
		            		 RequestDispatcher rd=   request.getRequestDispatcher("doctordashboard.html");
		            	       rd.forward(request, response);
		            	      
		            	   
		            	   }
		            	  

		             }
		             else {
		            	 RequestDispatcher rd=   request.getRequestDispatcher("doctorlogin.html");
	          	       rd.include(request, response);
		             }
	       
		            
		            	   
//		        
//		    	  
		    	  
			} 
		             catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			
	}

}
