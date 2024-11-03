$(function(){	
	$(".vote").click(function(){	
		var self = $(this);
		$.ajax({
			"url": "count.jsp",
        	"type": "post",
        	"data":{'id': $(this).next().html()},
        	"success":function(data){
        		self.prev().html(data.trim())	        		
        	}
		})		
	})
})