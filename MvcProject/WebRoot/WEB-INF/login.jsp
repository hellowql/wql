<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		function showMsg()
		{
			var msg=document.getElementById("msg");
			if(msg.value!='')
			{
				alert(msg.value);
			}
		}
	</script>
  </head>
  
  <body onload="showMsg()">
    <input type="hidden" id="msg" name="msg" value="${requestScope.msg }"/>
    
    <form name="f1" id="f1" action="<c:url value="/next"/>" method="post">
      <input type="hidden" name="cmd" value="verifyLogin"/>
      <input type="hidden" id="url" name="url" value="${requestScope.url }"/>
      <table border="0">
        <tr>
          <td>Login:</td>
          <td><input type="text" name="login" id="login"></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><input type="password" name="password" id="password"></td>
        </tr> 
        <tr>
          <td colspan="2" align="center"><input type="submit"></td>
        </tr>
      </table>
    </form>
  </body>
</html>
