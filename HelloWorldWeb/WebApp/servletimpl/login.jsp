<%@ page language="java" contentType="text/html; gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; gb2312">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="helloModel" class="com.wql.vo.HelloWorldModel" scope="request" />
	<jsp:setProperty property="*" name="helloModel"/>
	<%
		if("login".equals(helloModel.getSubmitFlag())){
	%>
		<jsp:forward page="/hello"/>
	<%
		}
	%>
	<form action="hello" method="post">
		<input type="hidden" name="submitFlag" value="login">
		Account:<input type="text" name="account"><br />
		Password:<input type="password" name="password"><br />
		<input type="submit" value="submit">
	</form>
</body>
</html>