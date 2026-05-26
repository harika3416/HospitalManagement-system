

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
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


@WebServlet("/otpgeneratecontroller")
public class otpgeneratecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=	 response.getWriter();
		
		   String mobile=	request.getParameter("mobile");
		   
		   
		   if(checkmobile(mobile)) {
		   
		    String otp=    GenearteOTP(6);
		    
		       if(storeOTP(mobile, otp)) {
		    	RequestDispatcher rd=    request.getRequestDispatcher("validateotp.html");
		    	    rd.forward(request, response);
		       }
		    
		    
		   }
		   else {
			   out.println("<script type=\"text/javascript\">"); 
	 	        out.println("alert(' Mobile number Not Registration ');"); 
	 	        out.println("location='generateptp.html';"); 
	 	        out.println("</script>");
		   }
			
		}
		
	  //Generate otp
	
	   private static String GenearteOTP(int i) {
		   
		   
		   SecureRandom random=new SecureRandom();
		   
		   StringBuilder otp=new StringBuilder();
		   
		     for(int j=0;j<i;j++) {
		    	 
		    	 otp.append(random.nextInt(10));
		     }
		     System.out.println("Generated OTP: " + otp);

		   return otp.toString();
		   
		   
		   
	   }
//checkmobile
	   
	   private boolean checkmobile(String mobile) {
		   
		   boolean checkmobile=false;
		   
		   try {
			   Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		          Connection conn= 	   DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root", "root");
		     PreparedStatement pst=   conn.prepareStatement("select *from patients where mobile=?");  
			   
		        pst.setString(1, mobile);
		        
		        ResultSet rs=    pst.executeQuery();
		     
		    if(rs.next()) {
		    	checkmobile=true;
		    }
		     
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return checkmobile;
		   
		   
		   
		   
	   }
	   
	   //storeotp
	   
	   
	      private boolean storeOTP(String mobile ,String otp) {
	    	  
	    	  boolean storeOTP=false;
	    	  
	    	  try {
	    		  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		          Connection conn= 	   DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root", "root");
		     PreparedStatement pst=   conn.prepareStatement("update patients set otp='"+otp+"' where mobile='"+mobile+"'");  
			   
		       int i=   pst.executeUpdate();
		           
		       if(i==1) {
		    	   storeOTP=true;
		       }
	    		  
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			return storeOTP;
	    	  
	}

}
