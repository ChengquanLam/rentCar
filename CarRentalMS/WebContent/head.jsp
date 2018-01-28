<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./css/main.css" type="text/css" />
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">
<script src="./js/tether.js"></script>
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/bootstrap.js"></script>

<script type="text/javascript">
	var message = "<%=session.getAttribute("message")%>";
	if(message!="null"){
		alert(message);
	}
	<%session.removeAttribute("message");%>
</script>

<script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img");
        img.src = "${pageContext.request.contextPath}/controller/AuthImageServlet";
    }
</script>

</head>
<body>
<div class="page-header">
    <h1><a class="text-header" href="/CarRentalMS/index.jsp">车辆租赁系统</a></h1>
</div>

<div class="text-login signin-header text-right">
		<%
	   	if(request.getSession().getAttribute("username") == null){
	   	%>
	   	<a id="adminlogin" href="/CarRentalMS/admin/adminLogin.jsp"><span class="glyphicon glyphicon-log-in">管理员登录</span></a>
	   	<%
	   	}else{
	   	%>
	   	<span class="glyphicon glyphicon-log-in">欢迎你！<%=request.getSession().getAttribute("username") %></span>
	   	<a id="adminsignout" href="/CarRentalMS/controller/SignOutServlet"><span class="glyphicon glyphicon-log-in">退出</span></a>
	   	<%
	   	}
	    %>
</div>

</body>
</html>