<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header">
	<div class="operate">
		<ul>
			<li>您好！xxx&nbsp;&nbsp;</li>
			<li><a href="${pageContext.request.contextPath }/"> 首页 </a></li>
			<li><a target="_blank"
				href="${pageContext.request.contextPath }/jsp/cartList.jsp"> <i
					class="icon_card"></i>购物车 <span>3</span>
			</a></li>
			<li><a target="_blank"
				href="${pageContext.request.contextPath }/jsp/userLogin.jsp"> 登录
			</a></li>
			<li><a target="_blank"
				href="${pageContext.request.contextPath }/jsp/userRegister.jsp">
					注册 </a></li>
			<li><a target="_blank"
				href="${pageContext.request.contextPath }/jsp/ordersList.jsp">
					我的订单 <span>2</span>
			</a></li>
			<li><a target="_blank"
				href="${pageContext.request.contextPath }/jsp/addressList.jsp">
					收货地址 </a></li>
			<li><a
				href="${pageContext.request.contextPath }/jsp/userPasswordUpdate.jsp">
					修改密码 </a></li>
			<li><a href="#"> 退出 </a></li>
		</ul>
	</div>
</div>
