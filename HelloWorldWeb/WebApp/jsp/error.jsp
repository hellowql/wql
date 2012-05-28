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
<font color=red><b>对不起，出错了，错误信息为：</b></font><br>  
<s:property value="exception"/>  
<br>  
<font color=red><b>错误的堆栈信息为：</b></font><br>  
<s:property value="exceptionStack"/>  
</body>
</html>