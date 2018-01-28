<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.*,bean.*,java.sql.ResultSet,util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆租赁系统</title>

<link rel="stylesheet" href="./css/main.css" type="text/css" />
<link rel="stylesheet" href="./css/index.css" type="text/css" />
<link rel="stylesheet" href="./css/bootstrap.css" type="text/css">
<script src="./js/tether.js"></script>
<script src="./js/jquery-3.2.1.js"></script>
<script src="./js/bootstrap.js"></script>

<script> 
	function editsubscribe(Cplatenum,Ctype) {  
	    //向模态框中传值
	    $('#Cplatenum').val(Cplatenum);
	    $('#Ctype').val(Ctype);
	}  
</script>  

</head>

<body>

<div class="head-div">
<jsp:include page="./head.jsp"></jsp:include>
</div>
	<div class="projectList container">
		<table class="project-talbe">
		    <tr>
		        <th>车牌号</th>
		        <th>车辆类型</th>
		        <th>购买时间</th>
		        <th>日租金</th>
		        <th>月租金</th>
		        <th>状态</th>
		        <th>操作</th>
		    </tr>
		    <%
		    ResultSet resultset = null;
			try {
				Connection connection = new DBConnection().LinkDB();
				String sql = "select * from car_and_ctype_view;";
				Statement statement = connection.createStatement();
				
				resultset = statement.executeQuery(sql);
			}catch(Exception e) {
				e.printStackTrace();
			}
			int num = 0;
		    while(resultset.next()){
		    %>
		    <tr>
		    	<td><%=resultset.getString("Cplatenum") %></td>
		    	<td><%=resultset.getString("Ctype") %></td>
		    	<td><%=resultset.getString("Cpurdate") %></td>
		    	<td><%=resultset.getDouble("Drent") %></td>
		    	<td><%=resultset.getDouble("Mrent") %></td>
		    	<td><%=resultset.getString("Ccondition") %></td>
	       		<td>
	       		<a class="form-control" href=""data-toggle="modal" data-target="#update_subcribe" onclick="editsubscribe('<%=resultset.getString("Cplatenum")%>','<%=resultset.getString("Ctype") %>')"><span class="glyphicon glyphicon-log-in">预约</span></a>
	       		</td>
		   	</tr>
		    <%
		    }
		    %>	
		</table>
	</div>

<!-- 修改Car -->
<div class="modal fade" id="update_subcribe" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加预约信息</h4>
      </div>
      <div class="modal-body">
      		<form class="form-group" method="post" action="${pageContext.request.contextPath }/controller/SubscribeInsertServlet">
                 <div class="form-group">
                 	<label for="">车辆类型</label>
                    <input id="Ctype" type="text" class="form-control" name="Ctype" readonly="readonly"/>
                 </div>
                 <div class="form-group">
                 	<label for="">车牌号</label>
                    <input id="Cplatenum" type="text" class="form-control" name="Cplatenum" readonly="readonly"/>
                 </div>
                 <div class="form-group">
                     <label for="">身份证号</label>
                     <span class="form-control"><input type="date" name="CID" style="border:none;"/></span>
                 </div>
                 <div class="form-group">
                     <label for="">预计提车时间</label>
                     <span class="form-control"><input type="date" name="Rent_date" style="border:none;"/></span>
                 </div>
                  <div class="form-group">
                     <label for="">预计还车时间</label>
                     <span class="form-control"><input type="date" name="Back_date" style="border:none;"/></span>
                 </div>
                 <div class="text-right">
                     <button class="btn btn-primary" type="submit">预约</button>
                     <button class="btn btn-danger" data-dismiss="modal">取消</button>
                 </div>
            </form>
      </div>
    </div>
  </div>
</div>

<div class="foot-div">
<jsp:include page="./foot.jsp"></jsp:include>
</div>

</body>
</html>