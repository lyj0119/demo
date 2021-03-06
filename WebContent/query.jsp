<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>查询</title>
</head>
<body>
	<form action="/demo/product/query.mvc" method="get">
		查询关键字：<input type="text" name="keyword" value="${keyword}"/><br />
		<button type="submit">搜索</button>
	</form>
	<table width="800" border="1">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>价格</th>
			<th>备注</th>
			<th>日期</th>
			<th>类别</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${proList}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td>${p.remark}</td>
				<td>${p.date}</td>
				<td>${p.category.name}</td>
				<td><a href="/demo/product/delete.mvc?id=${p.id}">删除</a>
				|<a href="/demo/product/getById.mvc?id=${p.id}">更新</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>