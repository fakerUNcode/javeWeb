<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="bookshopping.com/tag" prefix="udc"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>网上书店</title>
	<link href="<%=request.getContextPath() %>/css/book.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/css/second.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/css/list.css" rel="stylesheet" type="text/css" />
	<script src="<%=request.getContextPath() %>/js/jquery-1.12.4.js"></script>
	<script charset="utf-8" src="<%=request.getContextPath() %>/js/addToCarts.js"></script>
</head>
<body>
	&nbsp;
	<!-- 头部开始 -->
	<%@include file="../common/head.jsp"%>

	<div class='your_position'>
		您现在的位置:&nbsp; <a href='../user/toIndex.do'>图书</a> &gt;&gt; <font style='color: #cc3300'><strong>${catName}</strong>&nbsp;(${totalNum })
		</font>
	</div>

	<div class="book">
		<!--左栏开始-->
		<div id="left" class="book_left_list">
			<div id="__fenleiliulan">
				<div class=second_l_border2>
					<h2>分类浏览</h2>
					<ul>
						<li>
						</li>
						<c:forEach items="${childList}" var="c">
							<div class="clear"></div>
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei></div>
										<div class="second_fenlei">
											&nbsp;&nbsp;<a href="cateAndBookList.do?pid=${pid }&cid=${c.id }">${c.name }&nbsp;(${c.books.size()})</a>
										</div>
								</div>
							</li>
							<div class="clear"></div>
							<!--2级分类结束-->
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<!--左栏结束-->

		<!--中栏开始-->
		<div class="book_center">
			<!--图书列表开始-->
			<div id="divRight" class="list_right">
				<div id="book_list" class="list_r_title">
					<div class="list_r_title_text">排序方式</div>
					<div id="divTopPageNavi" class="list_r_title_text3">
						<!--分页导航开始-->
						<c:if test="${page>1}" var="res">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="cateAndBookList.do?pid=${pid }&cid=${cid }&page=${page-1}">
									<img src='../images/page_up.gif' />
								</a>
							</div>
						</c:if>
						<c:if test="${!res}">
							<div class='list_r_title_text3a'>
								<img src='../images/page_up_gray.gif' />
							</div>
						</c:if>
						<div class='list_r_title_text3b'>第${page}页/共${totalPage}页</div>
						<c:if test="${page<totalPage}" var="res">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href="cateAndBookList.do?pid=${pid }&cid=${cid }&page=${page+1 }">
									<img src='../images/page_down.gif' />
								</a>
							</div>
						</c:if>
						<c:if test="${!res}">
							<div class='list_r_title_text3a'>
								<img src='../images/page_down_gray.gif' />
							</div>
						</c:if>
						<!--分页导航结束-->
					</div>
				</div>

				<div id="fenlei">
					<c:forEach items="${books}" var="book">
						<!--商品条目开始-->
						<div class="clear"></div>
						<div class="list_r_list">
							<span class="list_r_list_book">
								<a name="link_prd_img"	href='?id=${book.id}'> 
									<img src="../images/product/${book.picture}" />
								</a> 
							</span>
							<h2>
								<a name="link_prd_name" href="#"></a>
							</h2>
							<br/>
							<h4 class="list_r_list_h4">
								作 者: <a href='#' name='作者'>${book.author}</a>
							</h4>
							<h4>
								出版社： <a href='#' name='出版社'>${book.publishing}</a>
							</h4>
							<h4>
								出版时间：
								<udc:sysdate format="yyyy-MM-dd" time="${book.publishTime}"/>
							</h4>
							<h5>
								${book.authorSummary }
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">
									￥<fmt:formatNumber value="${book.fixedPrice }" pattern=".00" type="number"/>
								</span> 
								&nbsp;&nbsp;<span class="red">
									 ￥<fmt:formatNumber value="${book.realPrice }" pattern=".00" type="number"/>
								</span> 
								&nbsp;&nbsp;节省:￥<fmt:formatNumber value="${book.fixedPrice-book.realPrice }" pattern=".00" type="number"/>
							</h6>
							<span class="list_r_list_button" /> 
							<a href="javascript: ;" bid="${book.id}" class="buy">  <!-- class="buy"为Ajax访问寻找元素使用 -->
								<img src='../images/buy.gif' />
							</a>
						</div>
						<div class="clear"></div>
						<!--商品条目结束-->
					</c:forEach>
				</div>
				<div class="clear"></div>
				<div id="divBottomPageNavi" class="fanye_bottom"></div>
			</div>
			<!--图书列表结束-->
		</div>
		<!--中栏结束-->

		<div class="clear"></div>
	</div>
</body>
</html>