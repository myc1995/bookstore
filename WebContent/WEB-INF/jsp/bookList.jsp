<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="<%=path%>/css/book_list.css" />
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
<script type="text/javascript">
	$(function() {

		//搜索框获得和失去焦点时切换提示词
		$(".searchtext").focus(function() {
			if (this.value == "书名、作者") {
				this.value = "";
			}
		}).blur(function() {
			if (!this.value) {
				this.value = "书名、作者"
			}
		});

		//点击搜索按钮时，检查用户有没有输入，如果没有输入，取消表单提交
		$("#searchForm").submit(function() {
			var searchText = $(".searchtext").val();
			if (!searchText || searchText == "书名、作者") {
				return false;
			}
			return true;
		});

	});
</script>
</head>
<body>
	<%@include file="/header.jsp"%>

	<div class="main" style="width: 1000px; margin-top: 20px;">
		<!-- 左侧图书分类导航栏 -->
		<div class="book_list_left">
			<ul id="categoryUl">
				<li><a href="<%=path%>/book?action=list">全部</a></li>
				<li><a href="<%=path%>/book?action=list&categoryId=1">小说</a></li>
				<li><a href="<%=path%>/book?action=list&categoryId=2">文学</a></li>
				<li><a href="<%=path%>/book?action=list&categoryId=3">传记</a></li>
				<li><a href="<%=path%>/book?action=list&categoryId=4">艺术</a></li>
				<li><a href="<%=path%>/book?action=list&categoryId=5">科普/百科</a></li>
				<li><a href="<%=path%>/book?action=list&categoryId=6">动漫/幽默</a></li>
			</ul>
		</div>
		<!-- 右侧主体区域 -->
		<div class="book_list_right">
			<!-- 查询区域 -->
			<div>
				<div class="search">
					<form id="searchForm" action="<%=path%>/book" method="post">
						<input type="text" name="searchText" value="书名、作者"
							class="searchtext" /> <input type="submit" class="searchbtn" />
					</form>
				</div>
				<div style="clear: both;"></div>
				<hr style="margin-bottom: 10px" />
			</div>
			<!-- 图书列表区域 -->

			<div class="books">
				<c:forEach items="${page.items}" var='book'>
					<div class="book">
						<a class="bookcover" href="<%=path%>/jsp/bookDetail.jsp"
							target="_blank"> <img src="<%=path%>/img/${book.coverImage}"
							alt="${book.name}" />
						</a>
						<div class="bookinfo">
							<div class="title">${book.name}</div>
							<div class="author">${book.auther}</div>
							<div class="price">
								<span>${book.price}</span>
							</div>
							<div class="description">${book.description}</div>
							<div>
								<a href="<%=path%>/jsp/cartList.jsp" target="_blank"
									class="add-cart"></a>
							</div>
						</div>
					</div>
				</c:forEach>

				<div style="clear: both;"></div>

				<!-- 分页区域 -->
				<div class="page" style="float: right;">
					<a
						<c:if test="${page.targetPage>1 }">
                            href="<%=path%>/book?action=list&targetPage=${page.targetPage-1}&categoryId=${param.categoryId}&searchText=${param.searchText }"
                        </c:if>>上一页</a>

					<span>${page.targetPage }/${page.totalPage }</span> <a
						<c:if test="${page.targetPage<page.totalPage }">
                            href="<%=path%>/book?action=list&targetPage=${page.targetPage+1}&categoryId=${param.categoryId}&searchText=${param.searchText }"
                        </c:if>>下一页</a>
				</div>
			</div>
		</div>
	</div>

	<div style="clear: both; margin-bottom: 55px"></div>

	<%@include file="/footer.jsp"%>
</body>
</html>