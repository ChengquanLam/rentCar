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
	function editCar(Cplatenum,obj) {  
	    //向模态框中传值
	    $('#carnum').val(Cplatenum);
	}  
</script>  

</head>
<body>

<div class="container projectList">
<form method="post" action="${pageContext.request.contextPath}/controller/CarInsertServlet">
	<table class="project-talbe">
	    <tr>
	    	<th>#</th>
	        <th>车牌号</th>
	        <th>车辆类型</th>
	        <th>购买时间</th>
	        <th>车辆状态</th>
	        <th>操作</th>
	    </tr>
		<%
	    CarDao cardao = new CarDao();
	    List<CarBean> list = cardao.getAll();
	    request.setAttribute("cars",list);
		%>
		<c:forEach var="car" items="${cars}" varStatus="num">
			<tr>
		   		<td>${num.index+1}</td>
		       	<td>${car.getCplatenum()}</td>
		       	<td>${car.getCtype()}</td>
		       	<td>${car.getCpurdate()}</td>
		       	<td>${car.getCcondition()}</td>
		       	<td>
		       	<a class="form-control" href=""data-toggle="modal" data-target="#update_car" onclick="editCar('${car.getCplatenum()}')"><span class="glyphicon glyphicon-log-in">修改</span></a>
		       	<a class="form-control" href="${pageContext.request.contextPath}/controller/CarDeleteServlet?Cplatenum=${car.getCplatenum()}">删除</a>
		       	</td>
	   		</tr>
		</c:forEach>
			<tr>
				<td>#</td>
		   		<td><input type="text" name="Cplatenum"/></td>
		       	<td>
		       		<%
		       		CarTypeDao cartypedao = new CarTypeDao();
		       		List<CarTypeBean> cartypes = cartypedao.getAll();
		       		request.setAttribute("cartypes", cartypes);
		       		%>
		       		<select id="car_type" name="Ctype">
  						<c:forEach var="cartype" items="${cartypes }">
  						<option value="${cartype.getCtype() }">${cartype.getCtype() }</option>
  						</c:forEach>		
  
					</select>
		       	</td>
		       	<td><input type="date" class="form-control" name="Cpurdate"/></td>
		       	<td><input type="text" class="form-control" name="Ccondition" value="空闲"/></td>
		       	<td><input type="submit" class="form-control" value="添加"></td>
	   		</tr>
	</table>
</form>
</div>

<!-- 修改Car -->
<div class="modal fade" id="update_car" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改车辆信息</h4>
      </div>
      <div class="modal-body">
      		<form class="form-group" method="post" action="${pageContext.request.contextPath }/controller/CarUpdateServlet">
                 <div class="form-group">
                 	<label for="">车牌号</label>
                    <input id="carnum" type="text" class="form-control" name="Cplatenum" readonly="readonly"/>
                 </div>
                 <div class="form-group">
                     <label for="">车辆型号</label>
                     <select id="car_type" name="Ctype" class="form-control">
  						<c:forEach var="cartype" items="${cartypes }">
  						<option value="${cartype.getCtype() }">${cartype.getCtype() }</option>
  						</c:forEach>		
					</select>
                 </div>
                 <div class="form-group">
                     <label for="">购买时间</label>
                     <span class="form-control"><input type="date" name="Cpurdate" style="border:none;"/></span>
                 </div>
                 <div class="form-group">
                     <label for="">车辆状态</label>
                     <input class="form-control" type="data" placeholder="" name="Ccondition">
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