<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2
			style="background: #487a6f; border-top-left-radius: 5px; 
			border-top-right-radius: 5px; color:"微软雅黑";width:100%;">
			图书分类
		</h2>
		<c:forEach items="${cats}" var="c1">
			<!--1级分类开始-->
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='#'> ${c1.name}</a>]
				</h3>
				<ul class="ul_left_list">
					<!--2级分类开始-->
					<c:forEach items="${c1.childrenListCates}" var="c2">
						<li><a
							href='<%=request.getContextPath() %>/list/cateAndBookList.do?pid=${c1.id}&cid=${c2.id}'>
							${c2.name}
							</a>
						</li>
						<!--2级分类结束-->
					</c:forEach>
				</ul>
				<div class="empty_left"></div>
			</div>

			<div class="more2"></div>
			<!--1级分类结束-->
		</c:forEach>

		<div class="bg_old">
			<h3>&nbsp;</h3>
		</div>
	</div>
</div>
