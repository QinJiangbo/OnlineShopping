<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
<meta charset=utf-8>
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
	function deleteProduct(productID) {
		if (confirm('Are you sure to delete?')) {
			// request for adminServlet
			window.location = "adminServlet?method=deleteProduct&adminProductID="
					+ productID;
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
							<li class="active"><a href="adminServlet?method=showProduct">Products</a></li>
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
				<div>
					<span
						style="font-family:Myriad Pro;font-size:40px;display:block;text-align:center">Modify
						the Product</span> <br />
					<hr style="border: 1.5px solid purple;margin-top:-20px" />
				</div>

				<div style="margin-left:330px">
					<form class="form-horizontal" name="form" action="adminServlet?method=modifyProduct" method="post">
						<div class="form-group">
							<label for="modifyProductID" class="col-sm-2 control-label">Product
								ID</label>
							<div class="col-sm-10">
								<input readonly class="form-control" id="modifyProductID" name="modifyProductID" style="width:300px" value="${param.p_id }">
							</div>
						</div>

						<div class="form-group">
							<label for="modifyProductType" class="col-sm-2 control-label">Product
								Type</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="modifyProductType"
									name="modifyProductType" style="width:300px"
									value="${param.p_type }">
							</div>
						</div>

						<div class="form-group">
							<label for="modifyProductName" class="col-sm-2 control-label">Product
								Name</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="modifyProductName"
									name="modifyProductName" style="width:300px"
									value="${param.p_name }">
							</div>
						</div>

						<div class="form-group">
							<label for="modifyProductPrice" class="col-sm-2 control-label">Product
								Price</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="modifyProductPrice"
									name="modifyProductPrice" style="width:300px"
									value="${param.p_price }">
							</div>
						</div>

						<div class="form-group">
							<label for="modifyProductQuantity" class="col-sm-2 control-label">Product
								Quantity</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									id="modifyProductQuantity" name="modifyProductQuantity"
									style="width:300px" value="${param.p_quantity }">
							</div>
						</div>

						<div class="form-group">
							<label for="modifyProductImage" class="col-sm-2 control-label">Product
								Image</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="modifyProductImage"
									name="modifyProductImage" style="width:300px"
									value="${param.p_image }">
							</div>
						</div>

						<div class="form-group">
							<label for="modifyProductDescription"
								class="col-sm-2 control-label">Product Description</label>
							<div class="col-sm-10">
								<input type="text" class="form-control"
									id="modifyProductDescription" name="modifyProductDescription"
									style="width:300px" value="${param.p_description }">
							</div>
						</div>

						<div class="form-group">
							<label for="modifyProductTime" class="col-sm-2 control-label">Product
								Added Time</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="modifyProductTime"
									name="modifyProductTime" style="width:300px"
									value="${param.p_time }">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-success"
									style="width:140px;float:left">Save Modifications</button>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn btn-danger" style="width:140px"
									onclick="window.location.href='adminServlet?method=showProduct'">Cancel</button>
							</div>
						</div>

					</form>
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
