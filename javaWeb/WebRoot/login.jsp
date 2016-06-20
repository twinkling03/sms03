<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>

	<link rel="stylesheet" type="text/css" href="css/css.css">
	<script type="text/javascript">
		function login(){
			loginform =document.getElementById("loginForm");
			loginform.submit();
		}
		
		function clear_v(){

			document.getElementById("loginForm").reset();
		
		}
	</script>	

  </head>
  
  <body class="loginbg">
  
  	<div id="logindiv" class="login">
    <form action="servlet/login" id="loginForm" method="post">
    	<table>
    	<tr>
    		<td>用户名：</td>
    		<td><input type="text" id="username" name="name" class="input"/></td>
    	</tr>
    	<tr>
    		<td>密    码：</td>
    		<td><input type="password" id="passwd" name="passwd" class="input"/></td>
    	</tr>
    	<tr>
    		<td colspan="2" style="text-align: center;">
    		<!-- 
    		<input type="submit" value="登陆" class=".btnlogin"> <input type="button" value="重置" class="btn">
    		 -->
    		<a  onclick="javascript:login();"><img src="images/login.png"/></a> 
    		<a  onclick="clear_v();" ><img src="images/reset.png"/></a> 
    		</td>
    	</tr>
    	</table>
    </form>
    </div>
  </body>
</html>
