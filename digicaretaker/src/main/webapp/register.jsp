<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<style>

body{
    font-family: Arial, sans-serif;
    background:#f4f4f4;
}

.container{
    width:450px;
    margin:40px auto;
    background:white;
    padding:25px;
    border-radius:8px;
    box-shadow:0px 0px 10px gray;
}

input,select,textarea{
    width:100%;
    padding:10px;
    margin-top:5px;
    margin-bottom:15px;
}

button{
    width:100%;
    padding:10px;
    background:#2196F3;
    color:white;
    border:none;
    cursor:pointer;
}

button:hover{
    background:#1976D2;
}

</style>

</head>

<body>

<div class="container">

<h2>User Registration</h2>

<form action="RegisterServlet" method="post">

<label>First Name</label>
<input type="text" name="firstName" required>

<label>Last Name</label>
<input type="text" name="lastName">

<label>Email</label>
<input type="email" name="email" required>

<label>Password</label>
<input type="password" name="password" required>

<label>Phone</label>
<input type="text" name="phone">

<label>Gender</label>

<select name="gender">
    <option>Male</option>
    <option>Female</option>
    <option>Other</option>
</select>

<label>Date of Birth</label>

<input type="date" name="dateOfBirth">

<label>Address</label>

<textarea name="address"></textarea>

<button type="submit">
Register
</button>

</form>

</div>

</body>
</html>