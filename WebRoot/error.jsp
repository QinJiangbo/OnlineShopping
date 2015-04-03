<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta http-equiv="refresh" content="5;url='userLogin.jsp'"/>
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
</style>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<a href="index.jsp" style="float:left"> <img alt="656x134"
					src="Images/Website/logo.png">
				</a>
				<div style="height:134px;float:left">
					<div style="padding-top:10px">
						<h1 style="font-family:cursive;font-color:#231233">&nbsp;Welcome
							to YiGou!</h1>
					</div>
					<div style="padding-top:0px">
						<form class="navbar-form navbar-left">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search.."
									style="width:260px">
							</div>
							<button type="submit" class="btn btn-success">Search</button>
						</form>
					</div>
				</div>
				<div style="height:134px;">
					<div style="padding-top:15px">
						<h3 style="font-family:Myriad Pro">
							<a href="userLogin.jsp" style="text-decoration:none">Login</a>
						</h3>
					</div>
					<div style="padding-top:0px">
						<h3 style="font-family:Myriad Pro">
							<a href="register.jsp" style="text-decoration:none">Register</a>
						</h3>
					</div>
				</div>
				<nav class="navbar navbar-default">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index.jsp"
							style="font-style:italic;background:purple">YiGou</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Category<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a
										href="productServlet?method=queryProduct&category=Book">Books</a></li>
									<li><a
										href="productServlet?method=queryProduct&category=Clothes">Clothes</a></li>
									<li><a
										href="productServlet?method=queryProduct&category=DailyDeals">Daily
											Deals</a></li>
									<li><a
										href="productServlet?method=queryProduct&category=Electronics">Electronics</a></li>
									<li><a
										href="productServlet?method=queryProduct&category=Homes">Homes</a></li>
									<li><a
										href="productServlet?method=queryProduct&category=Motors">Motor</a></li>
									<li><a
										href="productServlet?method=queryProduct&category=Sports Goods">Sports
											Goods</a></li>
								</ul></li>
							<li><a
								href="productServlet?method=queryProduct&category=Book">Books</a></li>
							<li><a
								href="productServlet?method=queryProduct&category=Clothes">Clothes</a></li>
							<li><a
								href="productServlet?method=queryProduct&category=DailyDeals">Daily
									Deals</a></li>
							<li><a
								href="productServlet?method=queryProduct&category=Electronics">Electronics</a></li>
							<li><a
								href="productServlet?method=queryProduct&category=Homes">Homes</a></li>
							<li><a
								href="productServlet?method=queryProduct&category=Motors">Motor</a></li>
							<li><a
								href="productServlet?method=queryProduct&category=Sports Goods">Sports
									Goods</a></li>
						</ul>

						<ul class="nav navbar-nav navbar-right">
							<li><a href="AboutMe.jsp">About me</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">UserCenter<strong class="caret"></strong></a>
								<ul class="dropdown-menu">
									<li><a href="productServlet?method=showMyProducts">MyShoppingCart</a></li>
									<li><a
										href="userServlet?method=userInfo&userEmail=${userEmail }">MyAccount</a></li>
									<li><a href="Feedback.jsp">My Suggestions</a></li>
								</ul></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
			      <div style="font-family:cursive;color:red;font-size:40px">&nbsp;&nbsp;&nbsp;&nbsp;Sorry your password and username are not consistent!The page will jump back in 5 seconds...</div>
			</div>
		</div>
	</div>
	<div style="margin-top:30px;margin-left:450px">
		<span style="font-size:20px;font-family:Georgia;color:black">
			©Copyright 2014 By QinJiangbo All rights reserved </span>
	</div>
</body>
</html>
