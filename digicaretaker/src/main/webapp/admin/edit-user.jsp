<%@ page import="com.digicaretaker.entity.Users"%>

<%
Users user = (Users) request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
</head>
<body>

<h2>Edit User</h2>

<form action="<%= request.getContextPath() %>/UpdateUserServlet" method="post">
<input type="hidden"
       name="user_id"
       value="<%=user.getUserId()%>">

First Name:<br>
<input type="text"
       name="firstName"
       value="<%=user.getFirstName()%>">

<br><br>

Last Name:<br>
<input type="text"
       name="lastName"
       value="<%=user.getLastName()%>">

<br><br>

Phone:<br>
<input type="text"
       name="phone"
       value="<%=user.getPhone()%>">

<br><br>

Address:<br>
<textarea name="address"><%=user.getAddress()%></textarea>

<br><br>

Status:<br>

<select name="status">

<option value="ACTIVE"
<%= "ACTIVE".equals(user.getStatus())
? "selected" : "" %>>
ACTIVE
</option>

<option value="INACTIVE"
<%= "INACTIVE".equals(user.getStatus())
? "selected" : "" %>>
INACTIVE
</option>

</select>

<br><br>

<input type="submit"
       value="Update User">

</form>

</body>
</html>