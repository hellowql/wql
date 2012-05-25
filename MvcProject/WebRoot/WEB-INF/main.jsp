<%@ page language="java" import="java.util.*,com.sodi.pojo.*" pageEncoding="utf-8"%>
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
  </head>
  
  <body>
    <c:if test="${empty sessionScope.login}">
    	<a href='<c:url value="/next?cmd=NullDispatcher&page=login.jsp"/>'>登陆</a><br>
    </c:if>
    <c:if test="${not empty sessionScope.login}">
    	欢迎：${sessionScope.login.loginName }<br>
    </c:if>
    <c:forEach items="${requestScope.paperList}" var="paper" varStatus="index">
    	<a href=" <c:url value="/showOnePaper?paperId=${paper.paperId }"/>">${index.count }. ${paper.paperTitle }</a><br>
    	${paper.description }<br>
    </c:forEach>
     <c:if test="${not empty requestScope.url}">
    	5秒后转向刚才的页面或<a href="${requestScope.url }">单击超链接直接进入</a>
    </c:if>
   </body>
</html>
