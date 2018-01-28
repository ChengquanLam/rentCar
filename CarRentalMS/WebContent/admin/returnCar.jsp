<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.*,bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆租赁系统</title>

<link rel="stylesheet" href="../css/main.css" type="text/css" />
<link rel="stylesheet" href="../css/index.css" type="text/css" />
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
<script src="../js/tether.js"></script>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/bootstrap.js"></script>

<script type="text/javascript">
	var message = "<%=session.getAttribute("message")%>";
	if(message!="null"){
		alert(message);
	}
	<%session.removeAttribute("message");%>
</script>

</head>

<body>

<div class="head-div">
</div>
	<div class="projectList container">
		<table class="project-talbe">
 		<form class="form-group container" style="width:500px;" method="post" action="${pageContext.request.contextPath}/controller/GetOneRentServlet"> 
        
     			<div class="form-group">
     			<label for="Password1">请输入您的身份证号</label>  
     			<input type="text" class="form-control " id="Password1" name="CID" placeholder="请输入身份证号">  
				</div>

         		<div class="form-group">
     			<input type="submit" class="btn btn-info btn-lg col-sm-3" value="查询我的租车信息"> 
				</div>
 		</form>
		</table>
	</div>

	<div class="foot-div">
	</div>

</body>
</html>