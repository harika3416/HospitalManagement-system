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
                  <th>userid</th>
                  
                 
                  <th>email</th>
                
                  <th>name</th>
                 
                  <th>mobile</th>
                  <th>Disease</th>
                  <th>DoctorName</th>
                  <th>TimeSlot</th>
                  
                  
                <%
                

                HttpSession httpSession=   request.getSession();
                 String email=(String)  httpSession.getAttribute("email");
                   
                   
                   try{
                 	  Class.forName("com.mysql.cj.jdbc.Driver");
                			Connection conn=   DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
                	    	
                		PreparedStatement pst=	conn.prepareStatement("select *from bookapp where demail='"+email+"'");
                	     
                    ResultSet rs=	   pst.executeQuery();
             	    
             	     while(rs.next()
             	    		 ){
             	    	 
             	    	 %>
             	    	 
             	    	 <tr>
             	    	 <td><%=rs.getInt("userid") %></td>
             	    	
             	    	              	    	 
             	    	              	    	 <td><%=rs.getString("email") %></td>
             	    	              	    	  <td><%=rs.getString("name") %></td>
             	    	              	    	 
             	    	              	    	 <td><%=rs.getString("mobile") %></td>
             	    	              	    	 <td><%=rs.getString("disease") %></td>
             	    	              	    	 <td><%=rs.getString("DoctorName") %></td>
             	    	              	    	<td><%=rs.getString("TimeSlot") %></td>
             	    	              	    	<td><a href="solution.jsp">Give Solution</a>
             	    	              	    	 
             	    	 
             	    	 </tr>
             	    	 
             	    	 
             	    	 
             	    	 
             	    	 
             	    	 <% 
             	    	 
             	    	 
             	    	 
             	    	 
             	     }
             	       
             	  
             	   
                	
                }catch(Exception e)
                {
                	e.printStackTrace();
                	
                }
                
                
                %>
          
                
                
                
                
                
                </table>
                
                   <a href="doctordashboard.html">Back</a>
            
            
            </center>
</body>
</html>