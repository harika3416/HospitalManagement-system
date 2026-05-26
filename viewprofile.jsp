<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>patients profile</title>
</head>
<body>
            <center>
            
                <br>
                <br>
                
                <table border="2">
                
                <tr>
                  <th>PT_ID</th>
                  
                 
                  <th>EMAIL</th>
                
                  <th>FNAME</th>
                  <th>LNAME</th>
                  <th>mobile</th>
                  <th>Disease</th>
                  
                <%
                

                HttpSession httpSession=   request.getSession();
                 String email=(String)  httpSession.getAttribute("email");
                   
                   
                   try{
                 	  Class.forName("com.mysql.cj.jdbc.Driver");
                			Connection conn=   DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
                	    	
                		PreparedStatement pst=	conn.prepareStatement("select *from patients where email='"+email+"'");
                	     
                    ResultSet rs=	   pst.executeQuery();
             	    
             	     while(rs.next()
             	    		 ){
             	    	 
             	    	 %>
             	    	 
             	    	 <tr>
             	    	 <td><%=rs.getInt("pt_id") %></td>
             	    	
             	    	              	    	 
             	    	              	    	 <td><%=rs.getString("email") %></td>
             	    	              	    	  <td><%=rs.getString("fname") %></td>
             	    	              	    	 <td><%=rs.getString("lname") %></td>
             	    	              	    	 <td><%=rs.getString("mobile") %></td>
             	    	              	    	 <td><%=rs.getString("disease") %></td>
             	    	              	    	 
             	    	 
             	    	 </tr>
             	    	 
             	    	 
             	    	 
             	    	 
             	    	 
             	    	 <% 
             	    	 
             	    	 
             	    	 
             	    	 
             	     }
             	       
             	  
             	   
                	
                }catch(Exception e)
                {
                	e.printStackTrace();
                	
                }
                
                
                %>
          
                
                
                
                
                
                </table>
                
                   <a href="patientsdashboard.html">Back</a>
            
            
            </center>
</body>
</html>