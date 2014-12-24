<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>内容列表页面</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet">
<script src="<%=basePath%>resources/js/common/jquery-1.10.1.js"></script>
<script src="<%=basePath%>resources/js/front/talk.js"></script>
</head>
<body>
	<input type="hidden" value="<%=basePath%>" id="basePath">
	<!-- 
		<h3>客官，来啦，坐吧！回复[查看]收取更多精彩内容。</h3>
	 -->
	<div id="jp-container"></div>
	<div>
		<input id="content" type="text"> <input type="button"
			onclick="send();" value="发送">
	</div>
</body>
</html>