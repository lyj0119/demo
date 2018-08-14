<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>添加商品</title>
</head>
<body>
	<form action="/demo/product/save.mvc" method="post">
	商品名：<input type="text" name="name" /><br />
	价格：<input type="text" name="price" /><br />
	备注：<textarea rows="5" cols="20" name="remark"></textarea> 
	<select name="category.id">
		<option value="0">--请选择--</option>
		<c:forEach items="${applicationScope.catList}" var="category">
			<option value="${category.id}">${category.name}</option>
		</c:forEach>
	</select>
	<button type="submit">添加商品</button>
	</form>
</body>
</html>