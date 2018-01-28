<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/console.css" type="text/css">
<link rel="stylesheet" href="../css/main.css" type="text/css">
<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">  
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/bootstrap.js"></script>

</head>

<jsp:include page="../head.jsp"></jsp:include>

<body>

	<div class="operator-list">
		<a class="list-group-item" href="${pageContext.request.contextPath}/admin/carManager.jsp" target="console-iframe">现有车辆管理</a><br>
		<a class="list-group-item" href="${pageContext.request.contextPath}/admin/carTypeManager.jsp" target="console-iframe">车辆类型管理</a><br>
		<a class="list-group-item" href="${pageContext.request.contextPath}/admin/customerManager.jsp" target="console-iframe">客户信息管理</a><br>
<%-- 		<a class="list-group-item" href="${pageContext.request.contextPath}/admin/subscribeManager.jsp" target="console-iframe">预约信息管理</a><br> --%>
		<a class="list-group-item" href="${pageContext.request.contextPath}/admin/getCar.jsp" target="console-iframe">用户提车</a><br>
		<a class="list-group-item" href="${pageContext.request.contextPath}/admin/returnCar.jsp" target="console-iframe">用户还车</a><br>
		<a class="list-group-item" href="${pageContext.request.contextPath}/admin/otherManager.jsp" target="console-iframe">租金统计</a><br>
	</div>
	
<iframe name="console-iframe" src="${pageContext.request.contextPath}/admin/carManager.jsp" width="74%" height="700px" style="border:none;">

</iframe>

<jsp:include page="../foot.jsp"></jsp:include>

</body>
</html>