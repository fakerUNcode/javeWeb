$(function(){
	$("#search").click(function(){
		var id = $("#id").val();
		var name = $("#name").val();
		var mobilephone = $("#mobilephone").val();
		var sex = $(":selected").val();
		
		location.href = "findAll.do?id="+id+"&name="+name+"&mobilephone="+mobilephone+"&sex="+sex;
	})
	
	
	var totalPage = $("#totalPage").val();
	$("a").slice(1,totalPage).click(function(){//1-5
		$(this).addClass("current_page").siblings().removeClass("current_page");
	})
})