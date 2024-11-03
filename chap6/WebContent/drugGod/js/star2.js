$(function(){		
	$("li").on({
		'mouseover':function(){
			if($(this).attr("flag")!="star"){
				$("li").removeClass('select');
				$(this).addClass('select').prevAll().addClass('select');
			}
		},
		'click': function(){
			if($(this).attr("flag")!="star"){  //当前未选中：选中当前及其前面的所有星星
				$("li").removeClass("select").removeAttr("flag");
				$(this).addClass("select").attr("flag","star")
					.prevAll().addClass("select").attr("flag","star");
			}else{//当前选中：去掉后面的所有星				
				$(this).nextAll().removeClass("select").removeAttr("flag");
			}
			$("#score").val($(this).index()+1)
		},		
		'mouseout':function(){			
			if($(this).attr("flag")!="star"){	//如果未选中，移出改变；所以要为每个设置标志
				$(this).removeClass("select");
			}
		}
	})	
}) 