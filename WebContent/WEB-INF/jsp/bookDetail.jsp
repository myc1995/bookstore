<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/book_detail.css" />
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
</head>
<body>
   <%@include file="/header.jsp"%>

   <div class="main"  style="width: 900px;">
      <!-- 图书大图片 -->
      <div class="show_pic">
         <img class="pic" src="<%=path%>/img/2016-07-15/santi.jpg" />
      </div>

      <div class="show_info">
         <h2>三体全集（全3册）</h2>
         <ul class="intro">
            <li>图书编号：1900471292</li>
            <li>价格：<div class="price">¥168.00</div></li>
            <li>作 者： 刘慈欣</li>
            <li>出 版 社：重庆出版社</li>
            <li>
                <span>出版日期：2011-11-01</span> 
                <span>ISBN：9787536692930</span>
            </li>
            <li>
                <span>页 数：1326</span>
                <span>字 数：891924</span> 
            </li>
         </ul>

         <div class="buy-area">
            <form action="<%=path%>/jsp/cartList.jsp" method="post">
                <label>我要买：</label>
                <input type="text" name="count" value="1"  size="4"/> 本
                <input type="submit"  class="add-cart"  value=""/>
            </form>
         </div>
         
      </div>
      
      <div style="clear: both;"></div>
      
      <div class="pro_content" >
            <div class="section">
               <div class="tit">内容推荐</div>
               <div class="descrip"> 三体人在利用魔法般的科技锁死了地球人的科学之后，庞大的宇宙舰队杀气腾腾地直扑太阳系，意欲清除地球文明。面对前所未有的危局，经历过无数磨难的地球人组建起同样庞大的太空舰队，同时，利用三体人思维透明的致命缺陷，制订了神秘莫测的“面壁计划”，精选出四位“面壁者”。秘密展开对三体人的反击。 </div>
            </div>
      </div>
      
   </div>

   <%@include file="/footer.jsp"%>
</body>
</html>