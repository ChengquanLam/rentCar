<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/main.css" type="text/css" />
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
<script src="../js/tether.js"></script>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/bootstrap.js"></script>

<title>Insert title here</title>

<script type="text/javascript">
	var message = "<%=session.getAttribute("message")%>";
	if(message!="null"){
		alert(message);
	}
	<%session.removeAttribute("message");%>
</script>

<!-- 触发JS刷新-->
 <script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img"); 
        img.src = "${pageContext.request.contextPath}/controller/AuthImage";
    }
</script>

</head>
<body>
<div class="projectList container" style="border:1px solid balck;">  
     	<h1 align="center">欢迎登录</h1>  
      <form class="form-group container" style="width:500px;" method="post" action="${pageContext.request.contextPath}/controller/LogInServlet"> 
         
           	<div class="form-group" >  
	       		<label for="user">用户名</label>  
	       		<input type="text" class="form-control" id="user" placeholder="请输入账号" name="Username">
   			</div>
   		
      		<div class="form-group">
      			<label for="Password1">密码</label>  
      			<input type="password" class="form-control " id="Password1" name="Password" placeholder="请输入密码">  
			</div>
	
			<div class="form-group">
      			验证码：<input type="text" class="form-control" name="Verify_code" placeholder="请输入验证码">
      			<br>
				<!-- 验证码 -->
      			<img id="img" src="${pageContext.request.contextPath}/controller/AuthImageServlet" />
      			<a href='' onclick="javascript:changeImg()">看不清,换一张？</a><br><br>
			</div>
		
          	<div class="form-group">
      			<input type="submit" class="btn btn-info btn-lg col-sm-3" value="登录"> 
			</div>
  	</form>
</div>
</body>
</html>