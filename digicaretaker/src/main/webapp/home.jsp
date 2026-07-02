<%@ page import="com.digicaretaker.entity.Users" %>

<%
Users user = (Users) session.getAttribute("loggedInUser");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

<h2>Welcome <%= user.getFirstName() %></h2>

<p>Email : <%= user.getEmail() %></p>

<p>Role : <%= user.getRole().getRole_name() %></p>

</body>
</html>