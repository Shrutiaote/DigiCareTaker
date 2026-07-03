```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.digicaretaker.entity.Users"%>

<%
Users user = (Users) session.getAttribute("loggedInUser");

if(user == null){
    response.sendRedirect("../login.jsp");
    return;
}

if(!"ADMIN".equalsIgnoreCase(user.getRole().getRole_name())){
    response.sendRedirect("../login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DigiCareTaker | Admin Dashboard</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" rel="stylesheet">

<style>

body{
    background:#f5f7fb;
}

.sidebar{
    width:250px;
    height:100vh;
    position:fixed;
    left:0;
    top:0;
    background:#0d6efd;
}

.sidebar h3{
    color:white;
    text-align:center;
    padding:20px;
    border-bottom:1px solid rgba(255,255,255,.2);
}

.sidebar a{
    display:block;
    color:white;
    padding:15px 25px;
    text-decoration:none;
    transition:.3s;
}

.sidebar a:hover{
    background:white;
    color:#0d6efd;
}

.main{
    margin-left:250px;
}

.topbar{
    background:white;
    padding:18px 30px;
    box-shadow:0 2px 8px rgba(0,0,0,.08);
}

.card{
    border:none;
    border-radius:15px;
    box-shadow:0 2px 10px rgba(0,0,0,.08);
}

.stat{
    font-size:35px;
    font-weight:bold;
}

.footer{
    text-align:center;
    color:gray;
    margin-top:40px;
}

</style>

</head>

<body>

<div class="sidebar">

<h3>DigiCareTaker</h3>

<a href="admin-dashboard.jsp">
<i class="bi bi-speedometer2"></i>
Dashboard
</a>

<a href="../ViewUserServlet">
<i class="bi bi-people-fill"></i>
User Management
</a>

<a href="#">
<i class="bi bi-person-heart"></i>
Manage Elders
</a>

<a href="#">
<i class="bi bi-people"></i>
Family Members
</a>

<a href="#">
<i class="bi bi-heart-pulse-fill"></i>
Caregivers
</a>

<a href="#">
<i class="bi bi-person-workspace"></i>
Volunteers
</a>

<a href="#">
<i class="bi bi-calendar-event"></i>
Appointments
</a>

<a href="#">
<i class="bi bi-chat-left-text"></i>
Feedback
</a>

<a href="#">
<i class="bi bi-bar-chart-fill"></i>
Reports
</a>

<a href="#">
<i class="bi bi-person-circle"></i>
My Profile
</a>

<a href="#">
<i class="bi bi-key-fill"></i>
Change Password
</a>

<a href="../LogoutServlet">
<i class="bi bi-box-arrow-right"></i>
Logout
</a>

</div>

<div class="main">

<div class="topbar d-flex justify-content-between align-items-center">

<div>

<h3>Admin Dashboard</h3>

<p class="text-muted mb-0">

Welcome,
<strong><%= user.getFirstName() %> <%= user.getLastName() %></strong>

</p>

</div>

<div>

<span class="badge bg-success p-3">

Administrator

</span>

</div>

</div>

<div class="container-fluid mt-4">

<div class="row">

<div class="col-md-4 mb-4">

<div class="card p-4">

<h5>Total Users</h5>

<div class="stat text-primary">
25
</div>

<p class="text-muted">
Registered users
</p>

</div>

</div>

<div class="col-md-4 mb-4">

<div class="card p-4">

<h5>Total Elders</h5>

<div class="stat text-success">
10
</div>

<p class="text-muted">
Active elder accounts
</p>

</div>

</div>

<div class="col-md-4 mb-4">

<div class="card p-4">

<h5>Appointments</h5>

<div class="stat text-danger">
8
</div>

<p class="text-muted">
Today's appointments
</p>

</div>

</div>

<div class="col-md-4 mb-4">

<div class="card p-4">

<h5>User Management</h5>

<p>
Manage users, update profiles, search, activate/deactivate and delete users.
</p>

<a href="../ViewUserServlet"
class="btn btn-primary">

Open Module

</a>

</div>

</div>

<div class="col-md-4 mb-4">

<div class="card p-4">

<h5>Volunteer Management</h5>

<p>
Manage volunteer registrations.
</p>

<a href="#"
class="btn btn-success">

Coming Soon

</a>

</div>

</div>

<div class="col-md-4 mb-4">

<div class="card p-4">

<h5>Caregiver Management</h5>

<p>
Manage caregiver information and assignments.
</p>

<a href="#"
class="btn btn-warning">

Coming Soon

</a>

</div>

</div>

<div class="col-md-4 mb-4">

<div class="card p-4">

<h5>Reports</h5>

<p>
Generate system reports and analytics.
</p>

<a href="#"
class="btn btn-info text-white">

Coming Soon

</a>

</div>

</div>

<div class="col-md-4 mb-4">

<div class="card p-4">

<h5>Feedback</h5>

<p>
View feedback submitted by users.
</p>

<a href="#"
class="btn btn-secondary">

Coming Soon

</a>

</div>

</div>

<div class="col-md-4 mb-4">

<div class="card p-4">

<h5>Profile</h5>

<p>
Update your profile and change password.
</p>

<a href="#"
class="btn btn-dark">

Coming Soon

</a>

</div>

</div>

</div>

<div class="footer">

<hr>

<p>© 2026 DigiCareTaker | Admin Panel</p>

</div>

</div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
```
