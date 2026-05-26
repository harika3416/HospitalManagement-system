

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


@WebServlet("/bookappcontroller")
public class bookappcontroller extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 		  String email=		request.getParameter("email");
		  
		  String name=		request.getParameter("fn");

		  String mobile=		request.getParameter("mobile");
		  String disease=		request.getParameter("disease");
		  String DoctorName=		request.getParameter("doctor");
		  String Demail=		request.getParameter("demail");
		  String TimeSlot=		request.getParameter("time");
		  int userid=0;
		     PrintWriter out=   response.getWriter();
		     try {
					
	        	   Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	        Connection conn= 	   DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root", "root");
	        
	    PreparedStatement pst=    conn.prepareStatement("insert into bookapp(userid,email,name,mobile,disease,DoctorName,Demail,TimeSlot)values(?,?,?,?,?,?,?,?)");
	        
	        pst.setInt(1, userid);
	        pst.setString(2, email);
	        pst.setString(3, name);
	       
	        pst.setString(4, mobile);
	        pst.setString(5, disease);
	        pst.setString(6, DoctorName);
	        pst.setString(7, Demail);
	        pst.setString(8, TimeSlot);
	        
	        
	         int i=   pst.executeUpdate();
	         
	            if(i==1) {
	            	
	            	out.println("<html><body>");
	            	out.println("<script type='text/javascript'>");
	            	out.println("alert('Booked Successfully');");
	            	out.println("window.location.href = 'patientsdashboard.html';");
	            	out.println("</script>");
	            	out.println("</body></html>");

	            	
	            }
	            else {
	            	  out.println("<script type=\"text/javascript\">"); 
	      	        out.println("alert(' Registration  fail');"); 
	      	        out.println("location='bookappointment.jsp';"); 
	      	        out.println("</script>");
	            }


	        
	       } catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	     
	}

}
