<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />
<link type="text/css" rel="stylesheet" href="<%=path%>/css/book_list.css" />
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
                <li><a href="#">全部</a></li>
                <li><a href="#">小说</a></li>
                <li><a href="#">文学</a></li>
                <li><a href="#">传记</a></li>
                <li><a href="#">艺术</a></li>
                <li><a href="#">科普/百科</a></li>
                <li><a href="#">动漫/幽默</a></li>
            </ul>
        </div>
        <!-- 右侧主体区域 -->
        <div class="book_list_right">
            <!-- 查询区域 -->
            <div>
                <div class="search">
                    <form id="searchForm" action="<%=path%>/book" method="post">
                        <input type="text"  name="searchText" value="书名、作者" class="searchtext" />
                        <input type="submit" class="searchbtn" />
                    </form>
                </div>
                <div style="clear: both;"></div>
                <hr style="margin-bottom: 10px" />
            </div>
            <!-- 图书列表区域 -->
            <div class="books">
               <div class="book">
                   <a class="bookcover" href="<%=path%>/jsp/bookDetail.jsp" target="_blank">
                      <img src="<%=path%>/img/2016-07-15/santi.jpg" alt="三体全集（全3册）" />
                   </a>
                   <div class="bookinfo">
                      <div class="title">三体全集（全3册）</div>
                      <div class="author">刘慈欣</div>
                      <div class="price"><span>¥168.00</span></div>
                      <div class="description">三体人在利用魔法般的科技锁死了地球人的科学之后，庞大的宇宙舰队杀气腾腾地直扑太阳系，意欲清除地球文明。面对前所未有的危局，经历过无数磨难的地球人组建起同样庞大的太空舰队，同时，利用三体人思维透明的致命缺陷，制订了神秘莫测的“面壁计划”，精选出四位“面壁者”。秘密展开对三体人的反击。</div>
                      <div><a href="<%=path%>/jsp/cartList.jsp" target="_blank" class="add-cart"></a></div>
                   </div>
                </div>
    
                <div class="book">
                   <a class="bookcover" href="<%=path%>/jsp/bookDetail.jsp" target="_blank">
                      <img src="<%=path%>/img/2016-07-15/shijianjianshi.jpg" alt="时间简史" />
                   </a>
                   <div class="bookinfo">
                      <div class="title">时间简史</div>
                      <div class="author">（英）霍金</div>
                      <div class="price"><span>¥30.00</span></div>
                      <div class="description">史蒂芬·霍金的《时间简史》，自1988年首版以来的十年岁月里，已成为科学著作的里程碑，在全球销售已近1000万册。首版内容介绍了宇宙本性*前沿的知识。微观和宏观世界观测技术领域方面10年来的进展证明了霍金教授的许多理论预言。他为了把观测的新知识介绍给读者，重写了前言，全面更新的原版的内容，并新增了一章有关虫洞和时间旅行的激动人心的课题。</div>
                      <div><a href="<%=path%>/jsp/cartList.jsp" target="_blank" class="add-cart"></a></div>
                   </div>
                </div>
    
                <div class="book">
                   <a class="bookcover" href="<%=path%>/jsp/bookDetail.jsp" target="_blank">
                      <img src="<%=path%>/img/2016-07-15/biancheng.jpg" alt="边城" />
                   </a>
                   <div class="bookinfo">
                      <div class="title">边城</div>
                      <div class="author">沈从文</div>
                      <div class="price"><span>¥35.00</span></div>
                      <div class="description">小说《边城》无疑是沈从文的代表作，写于一九三三年至一九三四年初。这篇作品如沈从文的其他湘西作品，着眼于普通人、善良人的命运变迁，描摹了湘女翠翠阴差阳错的生活悲剧，诚如作者所言：“一切充满了善，然而到处是不凑巧。既然是不凑巧，因之素朴的善终难免产生悲剧。”《边城》写出了一种如梦似幻之美，像摆渡、教子、救人、助人、送葬这些日常小事，在作者来都显得相当理想化，颇有几分“君子田”的气象。当然，矛盾也并非不存在，明眼人一看便知，作者所用的背景材料中便隐伏着社会矛盾的影子。作者亦不曾讳言他的写作意图是支持“民族复兴大业的人”，“给他们一种勇气和信心”。本书分别从沈从文的《湘行散记》、《湘西》、《从文自传》中搜辑名篇，精益求精，和其小说名作《边城》、《萧萧》、《三三》等并行，可说是基本囊括了沈从文作品的精髓，且较能体现沈氏文风的别样神采。</div>
                      <div><a href="<%=path%>/jsp/cartList.jsp" target="_blank" class="add-cart"></a></div>
                   </div>
                </div>
    
                <div class="book">
                   <a class="bookcover" href="<%=path%>/jsp/bookDetail.jsp" target="_blank">
                      <img src="<%=path%>/img/2016-07-15/liaobuqidegaicibi.jpg" alt="了不起的盖茨比" />
                   </a>
                   <div class="bookinfo">
                      <div class="title">了不起的盖茨比</div>
                      <div class="author">（美）菲茨杰拉德</div>
                      <div class="price"><span>¥19.50</span></div>
                      <div class="description">《了不起的盖茨比》是世界文学经典名著，被誉为20世纪最伟大的英文小说之一。故事的主人公盖茨比出身寒微，一次偶然的机会他认识了富家少女黛西，两人一见钟情，私订终身。后来黛西背叛了他，嫁给了有钱人汤姆。盖茨比为了赢得爱情，不择手段聚积金钱。为了追求黛西，盖茨比耗尽了自己的感情和才智，但理想最终还是破灭了，他带着残破的梦离开了人世。盖茨比是了不起的，他用生命谱写了一曲“爵士年代”的哀伤恋歌；盖茨比的悲剧是“美国梦”破灭的典型代表。</div>
                      <div><a href="<%=path%>/jsp/cartList.jsp" target="_blank" class="add-cart"></a></div>
                   </div>
                </div>
                

                <div style="clear: both;"></div>
                
                <!-- 分页区域 -->
                <div class="page" style="float: right;">
                    <a href="#" >上一页</a>
                    <span>1/1</span>
                    <a href="#" >下一页</a>
                </div>
            </div>
        </div>
    </div>
   
    <div style="clear: both;margin-bottom: 55px"></div>
     
    <%@include file="/footer.jsp"%>
</body>
</html>