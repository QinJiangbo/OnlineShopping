<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en-us">
<head>
<meta charset="utf-8">
<title>YiGou OnLine Index</title>
<link rel="stylesheet" href="Style/bootstrap.min.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<link rel="shortcut icon" href="Images/Website/favicon.ico">
<script type="text/javascript" src="Style/jquery-2.0.2.js"></script>
<script type="text/javascript" src="Style/bootstrap.min.js"></script>
<script type="text/javascript" src="Style/scripts.js"></script>

<style type="text/css">
a:hover {
	color: purple;
	text-decoration: none
}

.userStyle{
font-family:cursive;
font-size:40px;
color:purple
}

</style>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<a href="administrationIndex.jsp" style="float:left"> <img alt="656x134"
					src="Images/Website/logo.png">
				</a>
				<div style="height:134px;float:left">
					<div style="padding-top:10px">
						<h1 style="font-family:cursive;font-color:#231233;font-size:65px;color:purple">&nbsp;Administration</h1>
					</div>
					
				</div>
				<div style="height:134px;"></div>
				<nav class="navbar navbar-default">
					<div class="navbar-header">
						<a class="navbar-brand" href="administrationIndex.jsp"
							style="font-style:italic;background:purple">YiGou</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
						    <li><a href="adminServlet?method=showAdmin">Administrators</a></li>
							<li><a href="adminServlet?method=showUser">Users</a></li>
							<li><a href="adminServlet?method=showProduct">Products</a></li>
							<li><a href="adminServlet?method=showFeedback">Feedbacks</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
						    <li><a href="adminServlet?method=logout">Logout</a></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div style="font-family:cursive;font-size:40px;color:purple;text-align:center">Welcome Administrator ${adminName } !</div>
				
				<div>
				       <div><button class="btn btn-success" style="width:300px;height:50px;margin-top:40px;margin-left:430px" onclick="window.location.href='adminServlet?method=showAdmin'">Manage the Administrators</button></div>
				       <div><button class="btn btn-success" style="width:300px;height:50px;margin-top:40px;margin-left:430px" onclick="window.location.href='adminServlet?method=showUser'">Manage the Users</button></div>
				       <div><button class="btn btn-success" style="width:300px;height:50px;margin-top:40px;margin-left:430px" onclick="window.location.href='adminServlet?method=showProduct'">Manage the Products</button></div>
				       <div><button class="btn btn-success" style="width:300px;height:50px;margin-top:40px;margin-left:430px" onclick="window.location.href='adminServlet?method=showFeedback'">Manage the Feedbacks</button></div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top:60px;margin-left:450px">
		<span style="font-size:20px;font-family:Georgia;color:black">
			©Copyright 2014 By QinJiangbo All rights reserved </span>
	</div>
</body>
</html>
