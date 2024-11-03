<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.12.4.js"></script>
	</head>
	<body>
		<br/>
		<br/>
		<div class="my_shopping">
			<img class="pic_shop" src="../images/mycart.jpg" />
		</div>
			  <c:if test="${cartlist!=null}" var="res">
			    <div id="div_choice" class="choice_merch">
				<div class="choice_bord">
					<!-- 购物列表开始 -->
					<table class="tabl_buy" id="tbCartItemsNormal">
					  <tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">定价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">本网价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>变更数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>				
					</tr>
					  <c:forEach items="${cartlist}" var="cartitem">
					      <tr class='td_no_bord'>
							
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="#">${cartitem.book.bookName}</a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray">￥
								<fmt:formatNumber value="${cartitem.book.fixedPrice }" pattern=".00" type="number"/>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span>
									￥<fmt:formatNumber value="${cartitem.book.realPrice }" pattern=".00" type="number"/>
								</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;${cartitem.quantity}
							</td>
							<td >
								<input class="modify_num" id="${cartitem.book.id}" type="text" size="3" maxlength="4"/>
								<a href="javascript:;" class="${cartitem.book.id}">变更</a>	
								<script>
									$(function(){
										$('.${cartitem.book.id}').click(function(){		
											var quantity = $('#${cartitem.book.id}').val();
											var reg=/^\d+$/;
											if(!reg.test(quantity)){
												alert("请输入数字");
												return;
											}
											var bid = ${cartitem.book.id};
											window.location='modifycart.do?bid='+bid+"&quantity="+quantity;
										});
									});
								</script>					
							</td>
							<td>
								<a href="deletecart.do?bid=${cartitem.book.id}">删除</a>								
							</td>
						</tr>
					</c:forEach>
					<!-- 购物列表结束 -->
					</table>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../user/toIndex.do'> 继续挑选商品&gt;&gt;</a>
					</div>
					<div class="total_balance">
						<div class="save_total">							
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>
							<fmt:formatNumber value="${total}" pattern=".00" type="number"/>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='#' > 
								<img src="../images/checkout.jpg" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
			  </c:if>
			  <c:if test="${!res}">
			    <p> 您还没有选购商品，请
						<a href='../user/toIndex.do'> 挑选商品>></a>
			    </p>
			  </c:if>
	</body>
</html>



