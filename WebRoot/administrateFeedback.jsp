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

.userStyle {
	font-family: cursive;
	font-size: 40px;
	color: purple
}
</style>

<script type="text/javascript">
function deleteProduct(feedbackID) {
		if (confirm('Are you sure to delete?')) {
			// request for adminServlet
			window.location = "adminServlet?method=deleteFeedback&adminFeedbackID=" + feedbackID;
		}
	}
</script>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<a href="administrationIndex.jsp" style="float:left"> <img
					alt="656x134" src="Images/Website/logo.png">
				</a>
				<div style="height:134px;float:left">
					<div style="padding-top:10px">
						<h1
							style="font-family:cursive;font-color:#231233;font-size:65px;color:purple">&nbsp;Administration</h1>
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
							<li class="active"><a href="adminServlet?method=showFeedback">Feedbacks</a></li>
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
				<div
					style="font-family:cursive;font-size:40px;color:purple;text-align:center">The
					Feedback Table</div>

				<div style="margin-left:60px">
					<table class="table table-hover">
						<tr>
						    <td>Feedback ID</td>
							<td>User Email</td>
							<td>Feedback Content</td>
							<td>Edition</td>
						</tr>


						<c:forEach items="${adminFeedbackList}" var="row">
							<tr>
								<td>${row.f_id}</td>
								<td>${row.u_email}</td>
								<td>${row.f_content}</td>
								<td><a href="javascript:deleteProduct('${row.f_id}')">delete</a></td>
							</tr>
						</c:forEach>
					</table>
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
