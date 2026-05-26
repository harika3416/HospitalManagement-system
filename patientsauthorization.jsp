<%@ page import="java.sql.*" %>
<html>
<head><title>Authorize Patients</title></head>
<body>
<h2>Pending Patients (Need Authorization)</h2>

<table border="1" cellpadding="8">
<tr>
  <th>ID</th>
  <th>email</th>
  <th>password</th>
  <th>fname</th>
  <th>lname</th>
  <th>mobile</th>
  <th>disease</th>
  
  <th>status</th>
  
</tr>

<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
    PreparedStatement pst=  conn.prepareStatement("select *from patients ");
    ResultSet rs=  pst.executeQuery();
    while(rs.next()){
%>
<tr>
  <td><%= rs.getInt("pt_id") %></td>
  <td><%= rs.getString("email") %></td>
  <td><%= rs.getString("password") %></td>
  <td><%= rs.getString("fname") %></td>
  <td><%= rs.getString("lname") %></td>
  <td><%= rs.getString("mobile") %></td>
  <td><%= rs.getString("disease") %></td>
                                                                                                                                                                                                      
  <td><%= rs.getString("is_authorization") %></td>
  <td>
    <form action="givingauthorizecontroller" method="post">
        <input type="hidden" name="pt_id" value="<%= rs.getInt("pt_id") %>">
        <button type="submit">Authorize</button>
    </form>
  </td>
</tr>
<% } %>
</table>
<br>
<a href="admindashboard.html">Back to admindashboard</a>
</body>
</html>
