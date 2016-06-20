<%@ page language="java" import="java.util.*,com.javaweb.javabean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">



   <jsp:include page="menu.html"></jsp:include>
   <script type="text/javascript">
   	$(function(){
   		var bg;
			$("tr").mouseover(function(){
				bg=$(this).css('background-color');
				$(this).css('background-color','#AED');
				
			});
			$("tr").mouseout(function(){
				$(this).css('background-color',bg);
				
			});
   	});
   </script>
    	<div align="center" id="stus_div">
    		<h1>All Students Infomation</h1>
    			
    			<table  border="1px" width="780px" class="stu_list">
    				<thead>
    					<tr>
	    					<th>ID</th>
	    					<th>Xuehao</th>
	    					<th>Name</th>
	    					<th>Age</th>
	    					<th>Operation</th>
    					</tr>
    				</thead>
    			
    			

    			<x:forEach var="stu" items="${stuList}">
    					<tr>
    						<td>${stu.id }</td>
    
    						<td>${stu.xuehao }</td>
    	
    						<td>${stu.name}</td>
    	
    						<td>${stu.age}</td>
    						<td><a href="<%= basePath %>servlet/xx/UpdateStudent?m=update&id=${stu.id }">Update</a> &nbsp; <a href="<%= basePath %>servlet/xx/DeleteStudent?m=delete&id=${stu.id }" onclick="return window.confirm('Are you really want to remove this student?');" >Delete</a></td>
    					</tr>
    			</x:forEach>
    				<tfoot>
						<tr >
    						<td colspan="5" align="center"><a href="addNewStudent.jsp">Add new student</a></td>
    					</tr>
    				</tfoot>
    			</table>
    			
    	</div>
    	
  </body>
</html>
