<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="bookshopping.com/tag" prefix="udc"%>

<h2 style="">
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>
	编辑推荐
</h2>
<div>
	<div class=second_c_02>
		<div class=second_c_02_b1>
			<c:forEach items="${hotList}" var="book">
				<div class=second_c_02_b1_1>
					<a href='#?id=${book.id}' target='_blank'>
					<img src="<%=request.getContextPath() %>/images/product/${book.picture}" width=70 border=0 /> </a>
				</div>

				<div class=second_c_02_b1_2>
					<h3>
						<a book='#?id=${book.id}' target='_blank' title=${book.bookName}>${book.bookName}</a>
					</h3>
					<h4>
						作者：${book.author} 著 <br /> 出版社：${book.publishing}&nbsp;&nbsp;&nbsp;&nbsp;
						出版时间：
						<udc:sysdate format="yyyy-MM-dd" time="${book.publishTime}"/>
					</h4>
					<h5>${book.description}</h5>
					<h6>定价：￥<fmt:formatNumber value="${book.fixedPrice }" pattern=".00" type="number"/>&nbsp;&nbsp;
					本网价：￥<fmt:formatNumber value="${book.realPrice }" pattern=".00" type="number"/></h6>
					<div class=line_xx></div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
