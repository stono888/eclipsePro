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
<script src="<%=basePath%>resources/js/back/list.js"></script>
</head>
<body>
	<form action="<%=basePath%>List.action" id="mainForm" method="post">
		<table>
			<tbody>
				<tr>
					<td><input type="button" value="批量删除" onclick="delBatch('<%=basePath%>')"></td>
					<td><input type="button" value="批量添加" ></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" id="delOK" value="${delOK}">
		<input type="hidden" id="delId" name="id">
		<table>
			<tbody>
				<tr>
					<td width="90" align="right">指令名称</td>
					<td><input name="command" type="text" value="${command}" /></td>
					<td width="90" align="right">指令描述</td>
					<td><input name="description" type="text"
						value="${description}" /></td>
					<td width="85" align="right"><input type="submit" value="查询"></td>
				</tr>
			</tbody>
		</table>
		<table align="center">
			<tbody>
				<tr>
					<th><input type="checkbox" id="all" /></th>
					<th>序号</th>
					<th>指令名称</th>
					<th>指令描述</th>
					<th>操作</th>
				</tr>
			</tbody>
			<c:forEach items="${messageList}" var="message" varStatus="status">
				<tr
					<c:if test="${status.index%2 ==1}">style='background-color:#ecf6ee;'</c:if>>
					<td><input type="checkbox" name="ids" value="${message.id}" /></td>
					<td>${status.index + 1}</td>
					<td>${message.command}</td>
					<td>${message.description}</td>
					<td><a href="#">修改</a>&nbsp;&nbsp;&nbsp; <a
						onclick='delOne(${message.id},"<%=basePath%>")'>删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>