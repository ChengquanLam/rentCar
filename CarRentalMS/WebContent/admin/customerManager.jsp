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
	function editcustomer(CID) {  
	    //向模态框中传值
	    $('#CID').val(CID);
	}  
</script>  

</head>
<body>

<div class="container projectList">
<form method="post" action="${pageContext.request.contextPath}/controller/CustomerInsertServlet">
	<table class="project-talbe">
	    <tr>
	    	<th>#</th>
	        <th>身份证号</th>
	        <th>姓名</th>
	        <th>工作地址</th>
	        <th>电话</th>
	        <th>首次登记时间</th>
	        <th>操作</th>
	    </tr>
		<%
	    CustomerDao customerdao = new CustomerDao();
	    List<CustomerBean> list = customerdao.getAll();
	    request.setAttribute("customers",list);
		%>
		<c:forEach var="customer" items="${customers}" varStatus="num">
			<tr>
		   		<td>${num.index+1}</td>
		       	<td>${customer.getCID()}</td>
		       	<td>${customer.getCname()}</td>
		       	<td>${customer.getWorkAddress()}</td>
		       	<td>${customer.getTell()}</td>
		       	<td>${customer.getFirstDate()}</td>
		       	<td>
		       	<a class="form-control" href=""data-toggle="modal" data-target="#update_customer" onclick="editcustomer('${customer.getCID()}')"><span class="glyphicon glyphicon-log-in">修改</span></a>
		       	<a class="form-control" href="${pageContext.request.contextPath}/controller/CustomerDeleteServlet?CID=${customer.getCID()}">删除</a>
		       	</td>
	   		</tr>
		</c:forEach>
			<tr>
				<td>#</td>
		   		<td><input type="text" class="form-control" name="CID"/></td>
		       	<td><input type="text" class="form-control" name="Cname"/></td>
		       	<td><input type="text" class="form-control" name="WorkAddress"/></td>
		       	<td><input type="text" class="form-control" name="Tell"/></td>
		       	<td><input type="date" class="form-control" name="FirstDate"/></td>
		       	<td><input type="submit" class="form-control" value="添加"></td>
	   		</tr>
	</table>
</form>
</div>


<div class="modal fade" id="update_customer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改客户信息</h4>
      </div>
      <div class="modal-body">
      		<form class="form-group" method="post" action="${pageContext.request.contextPath }/controller/CustomerUpdateServlet">
                 <div class="form-group">
                 	<label for="">身份证号</label>
                    <input id="CID" type="text" class="form-control" name="CID" readonly="readonly"/>
                 </div>
                 <div class="form-group">
                     <label for="">姓名</label>
                     <input class="form-control" type="text" placeholder="" name="Cname">
                 </div>
                 <div class="form-group">
                     <label for="">工作地址</label>
                     <input class="form-control" type="text" placeholder="" name="WorkAddress">
                 </div>
                 <div class="form-group">
                     <label for="">电话</label>
                     <input class="form-control" type="text" placeholder="" name="Tell">
                 </div>
                 <div class="form-group">
                     <label for="">初次登记时间</label>
                     <span class="form-control"><input id="SubBack_date" type="date" name="FirstDate" style="border:none;"/></span>
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