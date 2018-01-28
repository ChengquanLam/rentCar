<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*,dao.*,java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="../css/index.css" type="text/css">
<script src="../js/tether.js"></script>
<script src="../js/jquery-3.2.1.js"></script>
<script src="../js/bootstrap.js"></script>

<script> 
	function editCartype(Ctype) {  
	    //向模态框中传值
	    $('#cartype').val(Ctype);
	}  
</script>  

</head>
<body>

<div class="container projectList">
<form method="post" action="${pageContext.request.contextPath}/controller/CarTypeInsertServlet">
	<table class="project-talbe">
	    <tr>
	    	<th>#</th>
	        <th>车辆类型</th>
	        <th>日租金</th>
	        <th>月租金</th>
	        <th>操作</th>
	    </tr>
		<%
	    CarTypeDao cartypedao = new CarTypeDao();
	    List<CarTypeBean> list = cartypedao.getAll();
	    request.setAttribute("cartypes",list);
		%>
		<c:forEach var="cartype" items="${cartypes}" varStatus="num">
			<tr>
		   		<td>${num.index+1}</td>
		       	<td>${cartype.getCtype()}</td>
		       	<td>${cartype.getDrent()}</td>
		       	<td>${cartype.getMrent()}</td>
		       	<td>
		       	<a class="form-control" href=""data-toggle="modal" data-target="#update_cartype" onclick="editCartype('${cartype.getCtype()}')"><span class="glyphicon glyphicon-log-in">修改</span></a>
		       	<a class="form-control" href="${pageContext.request.contextPath}/controller/CarTypeDeleteServlet?Ctype=${cartype.getCtype()}">删除</a>
		       	</td>
	   		</tr>
		</c:forEach>
			<tr>
				<td>#</td>
		   		<td><input type="text" name="Ctype"/></td>
		       	<td><input type="number" name="Drent"/></td>
		       	<td><input type="number" name="Mrent"/></td>
		       	<td><input class="form-control" type="submit" value="添加"></td>
	   		</tr>
	</table>
</form>
</div>

<!-- 修改Cartype -->
<div class="modal fade" id="update_cartype" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改车辆类型信息</h4>
      </div>
      <div class="modal-body">
      		<form class="form-group" method="post" action="${pageContext.request.contextPath }/controller/CarTypeUpdateServlet">
                 <div class="form-group">
                 	<label for="">车辆类型</label>
                    <input id="cartype" type="text" class="form-control" name="Ctype" readonly="readonly"/>
                 </div>
                 <div class="form-group">
                     <label for="">日租金</label>
                     <input type="number" class="form-control" name="Drent"/>
                 </div>
                 <div class="form-group">
                     <label for="">月租金</label>
                     <input type="number" class="form-control" name="Mrent"/>
                 </div>
                 <div class="text-right">
                     <button class="btn btn-primary" type="submit">修改</button>
                     <button class="btn btn-danger" data-dismiss="modal">取消</button>
                 </div>
            </form>
      </div>
    </div>
  </div>
</div>

</body>
</html>