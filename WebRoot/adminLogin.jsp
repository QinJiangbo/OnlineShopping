<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>YiGou OnlineShopping Administrator Login</title>

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
	font-family: cursive; /*fantasy,Myriad Pro,cursive; 5,12,15 */
	font-size: 100px;
	color: #0055ff;
}

#user_icon{
   position:absolute;
   left:22px;
   top:10px;
}

#password_icon{
   position:absolute;
   left:22px;
   top:10px;
}

.login_input{
   padding-left:25px
}

.password_input{
   padding-left:25px
}
</style>

<script type="text/javascript">
    var req;
	function validate(){
	    var adminName=document.getElementById("inputName3");
	    var url="ajaxAdminServlet?id="+escape(adminName.value);
	    
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
	    if(str=="OK"){
	        var show="<font color='red'>The user doesn't exist!</font>";
	        document.getElementById("info").innerHTML=show;
	    }else if(str=="NO"){
	        var show="";
	        document.getElementById("info").innerHTML=show;
	    }
	}
</script>
</head>

<body style="background:url(Images/Website/img12.jpg) repeat left top">
	<div class="myfont" style="margin-top:140px;margin-left:500px;">
		<span>YiGou Admin</span>
	</div>
	<div style="margin-top:50px;margin-left:540px;width:560px">
		<form class="form-horizontal" name="form" action="adminServlet?method=login" method="post">
			<div class="form-group">
				<label for="inputName3" class="col-sm-2 control-label">Admin</label>
				<div class="col-sm-10">
					<input type="text" class="form-control login_input" id="inputName3" name="adminName"
						style="width:300px;float:left" placeholder="Administrator Name" onblur="validate()">
						<span class="glyphicon glyphicon-user" id="user_icon"></span>
						<span id="info"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control password_input" id="inputPassword3" name="password"
						style="width:300px" placeholder="Password">
						<span class="glyphicon glyphicon-lock" id="password_icon"></span>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success" style="width:300px">Sign
						in</button>
				</div>
			</div>
		</form>
	</div>
	<div style="margin-top:100px;margin-left:580px">
		<span style="font-size:20px;font-family:Georgia;color:black">
			©Copyright 2014 By QinJiangbo All rights reserved </span>
	</div>
</body>
</html>
