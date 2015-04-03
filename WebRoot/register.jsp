<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en-us">
<head>
<base href="<%=basePath%>">
<title>YiGou OnlineShopping Register</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="Style/bootstrap.css">
<link rel="stylesheet" href="Style/bootstrap-theme.css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="Style/jquery-2.0.2.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="Style/bootstrap.js"></script>
<link rel="shortcut icon" href="Images/Website/favicon.ico">
<style type="text/css">
.myfont {
	font-family: cursive; /*fantasy,Myriad Pro; */
	font-size: 100px;
	color: #0055ff;
}
</style>

<script type="text/javascript">
function check() {
		var v_password = document.getElementById("inputPassword3");
		var v_confirmPassword = document.getElementById("inputPassword4");
		var password = v_password.value;
		var confirmPassword = v_confirmPassword.value;
		if (password == "") {
		    var show="<font color='red'>Password can't be empty!</font>";
	        document.getElementById("password").innerHTML=show;
			v_password.focus();
			return false;
		}else if (password != confirmPassword) {
		    var show="<font color='red'>The password is not consistent!</font>";
	        document.getElementById("password").innerHTML=show;
			v_password.focus();
			return false;
		}else if (password == confirmPassword) {
		    var show="";
	        document.getElementById("password").innerHTML=show;
	        return true;
		}
		return true;
	}
	
	var req;
	function validate(){
	    var userEmail=document.getElementById("inputEmail3");
	    var url="ajaxRegisterServlet?id="+escape(userEmail.value);
	    
	    if(window.XMLHttpRequest)
	    {
	        req=new XMLHttpRequest();
	    }else if(window.ActiveXObject)
	    { 
	        req=new ActiveXObject("Microsoft.XMLHttp");
	    }
	    
	    req.open("GET",url,true);
	    req.onreadystatechange=callback;
	    req.send(null);
	}
	
	function callback(){
	    if(req.readyState==4&&req.status==200){
	        var check=req.responseText;
	        show(check);
	    }
	}
	
	function show(str){
	    var v_email=document.getElementById("inputEmail3");
	    if(str=="OK"){
	        var show="<font color='green'>The email is valid!</font>";
	        document.getElementById("info").innerHTML=show;
	    }
	    else if(str=="NO")
	    {
	        var show="<font color='red'>The email has been registered!</font>";
	        document.getElementById("info").innerHTML=show;
	        v_email.focus(); 
	    }
	}
</script>
</head>

<body style="background:url(Images/Website/img16.jpg) repeat left top">
	<div class="myfont" style="margin-top:60px;margin-left:355px;">
		<span>YiGou Register</span>
	</div>
	
	<div style="margin-top:30px;margin-left:470px;width:650px">
		<form class="form-horizontal" name="form" action="userServlet?method=userRegister" method="post" onsubmit="return check()">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="inputEmail3" name="email"
						style="width:300px;float:left" placeholder="Email" onblur="validate()">
						<span id="info"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="inputUserName" class="col-sm-2 control-label">UserName</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputUserName" name="userName"
						style="width:300px" placeholder="User Name">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword3" name="password"
						style="width:300px;float:left" placeholder="Password">
						<span id="password"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword4" class="col-sm-2 control-label">Confirm</label> 
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword4" name="confirmPassword"
						style="width:300px" placeholder="Confirm Password">
				</div>
			</div>
			<div class="form-group">
				<label for="inputSex" class="col-sm-2 control-label">Sex</label>
				<div class="col-sm-10">
					<input type="radio" name="sex" value="Male" />Male 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="sex" value="Female"/>Female
				</div>
			</div>
			<div class="form-group">
				<label for="inputTelephone" class="col-sm-2 control-label">Telephone</label>
				<div class="col-sm-10">
					<input type="tel" class="form-control" id="inputTelephone" name="telephone"
						style="width:300px" placeholder="Telephone [optional]">
				</div>
			</div>
			<div class="form-group">
				<label for="inputQQ" class="col-sm-2 control-label">QQ</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputQQ" name="QQ"
						style="width:300px" placeholder="QQ number [optional]">
				</div>
			</div>
			<div class="form-group">
				<label for="inputAddress" class="col-sm-2 control-label">Address</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputAddress" name="Address"
						style="width:300px" placeholder="Address">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success" style="width:140px;float:left">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-danger" style="width:140px" onclick="window.location.href='userLogin.jsp'">Cancel</button>
				</div>
			</div>
		</form>
		${Msg}
	</div>
	<div style="margin-top:35px;margin-left:470px">
		<span style="font-size:20px;font-family:Georgia;color:black">
			©Copyright 2014 By QinJiangbo  All rights reserved </span>
	</div>
</body>
</html>
