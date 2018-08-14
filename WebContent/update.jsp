<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>更新商品</title>
</head>
<body>
	<form action="/demo/product/update.mvc" method="post">
	商品名：<input type="text" name="name" value="${product.name}"/><br />
	价格：<input type="text" name="price" value="${product.price}"/><br />
	备注：<textarea rows="5" cols="20" name="remark">${product.remark}</textarea> 
	<select name="category.id">
		<option value="0">--请选择--</option>
		<c:forEach items="${applicationScope.catList}" var="category">
			<c:choose>
				<c:when test="${category.id==product.category.id}">
					<option value="${category.id}" selected="selected">${category.name}</option>
				</c:when>
				<c:otherwise>
					<option value="${category.id}">${category.name}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
	<button type="submit">更新商品</button>
	<input type="hidden" name="id" value="${product.id}" />
	</form>
</body>
</html>