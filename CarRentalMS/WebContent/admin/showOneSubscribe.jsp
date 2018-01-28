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

<script> 
	function editCar(Cplatenum,CID) {  
	    //向模态框中传值
	    $('#carnum').val(Cplatenum);
	    $('#CID').val(CID);
	}  
</script>  

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
		    <tr>
		        <th>身份证号</th>
		        <th>车辆类型</th>
		        <th>车牌号</th>
		        <th>预约时间</th>
		        <th>预约提车时间</th>
		        <th>预约还车时间</th>
		        <th>操作</th>
		    </tr>
		    <c:forEach var="subscribe" items="${sessionScope.subscribes}" varStatus="num">
			<tr>
		       	<td>${subscribe.getCID()}</td>
		       	<td>${subscribe.getCtype()}</td>
		       	<td>${subscribe.getCplatenum()}</td>
		       	<td>${subscribe.getBook_date()}</td>
		       	<td>${subscribe.getRent_date()}</td>
		       	<td>${subscribe.getBack_date()}</td>
		       	<td>
		       	<a class="form-control" href=""data-toggle="modal" data-target="#get_car" onclick="editCar('${subscribe.getCplatenum()}','${subscribe.getCID() }')"><span class="glyphicon glyphicon-log-in">提车</span></a>
		       	</td>
	   		</tr>
		</c:forEach>
		</table>
	</div>

	<div class="foot-div">
	</div>

	<!-- 修改Car -->
<div class="modal fade" id="get_car" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">填写提车信息</h4>
      </div>
      <div class="modal-body">
      		<form class="form-group" method="post" action="${pageContext.request.contextPath }/controller/RentInsertServlet">
      			<div class="form-group">
                 	<label for="">身份证</label>
                    <input id="CID" type="text" class="form-control" name="CID" readonly="readonly"/>
                 </div>
                 <div class="form-group">
                 	<label for="">车牌号</label>
                    <input id="carnum" type="text" class="form-control" name="Cplatenum" readonly="readonly"/>
                 </div>
                 <div class="form-group">
                     <label for="">租车方式</label>
                     <select id="rent_type" name="RentType" class="form-control">
  						<option value="日租">日租</option>
  						<option value="月租">月租</option>
					</select>
                 </div>
                 <div class="form-group">
                     <label for="">预计归还时间</label>
                     <span class="form-control"><input type="date" name="SubBack_date" style="border:none;"/></span>
                 </div>
                 <div class="form-group">
                     <label for="">预计租金</label>
                     <input class="form-control" type="number" placeholder="" name="SubRent">
                 </div>
                 <div class="form-group">
                     <label for="">押金</label>
                     <input class="form-control" type="number" placeholder="" name="Deposit">
                 </div>
                 <div class="text-right">
                     <button class="btn btn-primary" type="submit">确定提车</button>
                     <button class="btn btn-danger" data-dismiss="modal">取消</button>
                 </div>
            </form>
      </div>
    </div>
  </div>
</div>

</body>
</html>