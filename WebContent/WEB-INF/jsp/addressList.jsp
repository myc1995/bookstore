<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收货地址管理</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
</head>
<body>
	<%@include file="/header.jsp"%>
	<div class="main" style="width: 777px;">

		<div class="message">
			<p>收货地址</p>
			<span>${message }</span>
		</div>

		<div style="margin-bottom: 40px;">
			<a href="<%=path%>/jsp/addressAdd.jsp" target="_self">添加新收货地址</a>
		</div>
		<table>
			<thead>
				<tr>
					<td>收货人</td>
					<td>联系电话</td>
					<td>详细位置</td>
					<td>添加时间</td>
					<td>操作</td>
				</tr>
			</thead>

			<tbody>
				<tr class="address-default">
					<td>蛋蛋</td>
					<td>18000000001</td>
					<td>北京市 西城区 xxxx</td>
					<td>2016-01-01 10:10:10</td>
					<td><a href="<%=path%>/jsp/addressUpdate.jsp">修改</a> &nbsp; <a
						href="#">删除</a> &nbsp; 默认地址</td>
				</tr>
				<tr>
					<td>蛋蛋</td>
					<td>18000000002</td>
					<td>北京市 海淀区 xxxx</td>
					<td>2016-05-01 11:11:11</td>
					<td><a href="<%=path%>/jsp/addressUpdate.jsp">修改</a> &nbsp; <a
						href="#">删除</a> &nbsp; <a href="#">设为默认地址</a></td>
				</tr>
				<tr>
					<td>蛋蛋</td>
					<td>18000000001</td>
					<td>北京市 昌平区 xxxx</td>
					<td>2016-06-02 08:00:10</td>
					<td><a href="<%=path%>/jsp/addressUpdate.jsp">修改</a> &nbsp; <a
						href="#">删除</a> &nbsp; <a href="#">设为默认地址</a></td>
				</tr>
			</tbody>
		</table>
	</div>

	<%@include file="/footer.jsp"%>
</body>
</html>