<%@ page language="java" contentType="text/html; gb2312"
    pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; gb2312">
<title>Insert title here</title>
</head>
<body>
	<s:if test="hasFieldErrors()">  
	    <s:iterator value="fieldErrors">  
	        <font color=red><s:property value="value[0]"/></font><br>  
	    </s:iterator>  
	</s:if>
	<form action="/HelloWorldWeb/helloWorldAction.action" method="post">  
    <input type="hidden" name="submitFlag" value="login"/>  
    �˺�:<input type="text" name="account"><br>  
    ����:<input type="password" name="password"><br>  
    <input type="submit" value="�ύ">  
</form>
</body>
</html>