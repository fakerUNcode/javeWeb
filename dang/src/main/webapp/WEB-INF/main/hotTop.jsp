<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<div class="book_c_4">
	<!--新书热卖开始-->
	<c:forEach items="${hotNewList}" var="book" varStatus="s">
		<div class="second_c_02_b1">
			<h3>
				<span class="num">
					${s.count} 
				</span> 
					<a href='#' title="">
						${book.bookName}
					</a>
			</h3>
		</div>
	</c:forEach>
	<!--新书热卖结束-->
</div>
<div class="clear"></div>