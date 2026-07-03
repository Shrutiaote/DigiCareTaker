<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.digicaretaker.entity.Users"%>
<%@ page import="com.digicaretaker.entity.Users" %>

<%
Users loggedInUser = (Users) session.getAttribute("loggedInUser");

if (loggedInUser == null) {
    response.sendRedirect("../login.jsp");
    return;
}

if (!"ADMIN".equalsIgnoreCase(loggedInUser.getRole().getRole_name())) {
    response.sendRedirect("../login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>

<style>

table{
    border-collapse:collapse;
    width:100%;
}

th,td{
    border:1px solid black;
    padding:10px;
    text-align:center;
}

th{
    background:#dddddd;
}

</style>

</head>
<body>

<h2>Registered Users</h2>

<%
List<Users> users =
(List<Users>)request.getAttribute("users");
%>

<%
if(users == null){
    users = new java.util.ArrayList<>();
}
%>

<div style="margin-bottom:20px;">

    <form action="<%= request.getContextPath() %>/SearchUserServlet" method="get">

        <input type="text"
               name="keyword"
               placeholder="Search by Name, Email or Phone"
               style="width:300px;height:35px;padding-left:10px;">

        <input type="submit"
               value="Search"
               style="height:35px;">

        <a href="<%= request.getContextPath() %>/ViewUserServlet">
          <style="margin-left:10px;">
           Show All
        </a>

    </form>

</div>

<br><br>

<table>

<tr>

<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th>Role</th>
<th>Status</th>
<th>Action</th>
</tr>

<%

for(Users user : users){

%>

<tr>

<td><%=user.getUserId()%></td>

<td>
<%=user.getFirstName()%>
<%=user.getLastName()%>
</td>

<td><%=user.getEmail()%></td>

<td><%=user.getPhone()%></td>

<td><%=user.getRole().getRole_name()%></td>

<td><%=user.getStatus()%></td>

<td>
   <a href="<%= request.getContextPath() %>/EditUserServlet?id=<%=user.getUserId()%>"
    style="background:#ffc107;
          color:black;
          padding:6px 12px;
          text-decoration:none;
          border-radius:5px;
          margin-right:10px;">
   >
    Edit
</a>


<a href="<%= request.getContextPath() %>/DeleteUserServlet?id=<%=user.getUserId()%>"
   onclick="return confirm('Are you sure you want to delete this user?');"
    style="background:#dc3545;
          color:white;
          padding:6px 12px;
          text-decoration:none;
          border-radius:5px;"
   >
    Delete
</a>
    
</td>

</tr>

<%

}

%>

</table>

</body>
</html>