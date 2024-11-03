$(function(){
	$(".buy").click(function(){
		var id = $(this).attr("bid");
		$.ajax({
			"url":"../cart/addcart.do",  
			"type":'post',  
			"data":{"bid":id, "date":new Date().getTime()}, 
			"dataType":"json",
			"success":
				function(data){ 
					alert(data.msg);   
				},
			"error":function(){
				//alert("失败");
			}
		});
	});
});