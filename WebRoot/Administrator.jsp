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
	function deleteAdmin(adminID) {
		if (confirm('Are you sure to delete?')) {
			// request for adminServlet
			window.location = "adminServlet?method=deleteAdmin&adminID="
					+ adminID;
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
							<li class="active"><a href="adminServlet?method=showAdmin">Administrators</a></li>
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
				<div
					style="font-family:cursive;font-size:40px;color:purple;text-align:center">The
					Administrator Table</div>

				<div style="margin-left:60px">
					<table class="table table-hover">
						<tr>
							<td>Administrator ID</td>
							<td>Administrator Name</td>
							<td>Administrator Password</td>
							<td>Administrator QQ</td>
							<td>Administrator Added Date</td>
							<td>Administrator level</td>
							<c:set var="admin" value="${adminName}" />
							<c:choose>
								<c:when test="${admin=='root' }">
									<td>Edition</td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</tr>


						<c:forEach items="${administratorsList}" var="row">
							<tr>
								<td>${row.a_id}</td>
								<td>${row.a_name}</td>
								<td>${row.a_password}</td>
								<td>${row.a_QQ}</td>
								<td>${row.a_date}</td>
								<td>${row.a_level}</td>
								<c:set var="admin" value="${adminName}" />
								<c:choose>
									<c:when test="${admin=='root' }">
										<td><a href="javascript:deleteAdmin('${row.a_id}')">delete</a></td>
									</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</table>

					<c:set var="admin" value="${adminName}" />
					<c:choose>
						<c:when test="${admin=='root' }">
							<form class="form-horizontal" name="form" action="adminServlet?method=addAdmin" method="post">
								<div class="form-group">
									<label for="adminInputName" class="col-sm-2 control-label">Administrator
										Name</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="adminInputName"
											name="adminInputName" style="width:300px" placeholder="adminName">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
									<div class="col-sm-10">
										<input type="password" class="form-control"
											id="inputPassword3" name="password" style="width:300px"
											placeholder="Password">
									</div>
								</div>

								<div class="form-group">
									<label for="adminQQ" class="col-sm-2 control-label">Administrator
										QQ</label>
									<div class="col-sm-10">
										<input type="number" class="form-control" id="adminQQ"
											name="adminQQ" style="width:300px" placeholder="adminQQ">
									</div>
								</div>

								<div class="form-group">
									<label for="adminLevel" class="col-sm-2 control-label">Administrator
										Level</label>
									<div class="col-sm-10">
										<input type="number" class="form-control" name="adminLevel" id="adminLevel"
											style="width:300px" placeholder="adminLevel">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-success"
											style="width:300px">Add Administrators</button>
									</div>
								</div>
							</form>
						</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
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
