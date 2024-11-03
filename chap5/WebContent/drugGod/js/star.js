$(function(){		
	$("li").click(function(){
		$("li").removeClass('select').removeAttr("flag");
		$(this).addClass('select').attr("flag","star")
			.prevAll().addClass('select').attr("flag","star");
		
		$("#score").val($(this).index()+1);
	}).mouseover(function(){
		if(!$(this).hasClass('select')){
			$(this).addClass('select').prevAll().addClass('select');
		}
	}).mouseout(function(){
		$("li").each(function(){
			if($(this).attr('flag')!="star"){
				$(this).removeClass('select');
			}
		})
	})
}) 

