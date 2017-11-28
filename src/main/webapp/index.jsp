<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
		alert(11)
			if(${msg}!=null&&${msg}!=''){
				alert(${msg});
			}
		});
	
	
	</script>
</head>
<body>
<h2>系统主页</h2>
<!--freemark需要安全输出，页面中有Null会报错  -->
<%-- ${(hello)!'' } --%>

<a href="${pageContext.request.contextPath}/stu/getStu">学生列表</a>
<a href="${pageContext.request.contextPath}/stu/addStu">添加学生</a>
<a href="${pageContext.request.contextPath}/stu/delStu">删除学生</a>
<a href="${pageContext.request.contextPath}/stu/updStu">修改学生</a>
</body>
</html>
