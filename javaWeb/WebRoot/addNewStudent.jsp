<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Add New Student</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	
    
 
  <jsp:include page="menu.html"></jsp:include>
  <script type="text/javascript">
		$(function(){
			$("#xuehao").blur(function(){
				var xuehao=$(this).val();
				$.post("servlet/xx/CheckExistForStuNo?m=checkExistForStuNo",{"xh":xuehao},
				function(data,status){
					if(status=='success'){
						var json=eval('(' + data + ')');
						if(json.value=='true'){
							$(this).val("");
							alert("您输入的学好已经存在！");
						};
					}
				});
			});
		});
		
	
	</script>
    <div id="content">


    <H1>Add Student Information</H1>
    <form action="servlet/xx/SaveStudent?m=save" method="post">
    	<table>
    		<tr>
    			<td>学号</td>
    			<td><input type="text" id="xuehao" name="xuehao" value="${stu.xuehao}" /></td>
    		</tr>
    		<tr>
    			<td>姓名</td>
    			<td><input type="text" name="name" value="${stu.name}"/></td>
    		</tr>
    		<tr>
    			<td>年龄</td>
    			<td><input type="text" name="age" value="${stu.age}"/></td>
    		</tr>
    		<tr>
    			<td  colspan="2" align="center"><input type="submit" title="保存" value="保存"/> &nbsp;  &nbsp; <input type="button" title="取消" value="取消"/></td>
    			
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
</html>
