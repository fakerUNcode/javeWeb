$(function(){
	var flag_email=true,flag_password=true;
	
	$("#form").submit(function(){
		var email = $('#email').val();
	    var password = $('#password').val();
	    
	    if(email==""){
			$('#warning_email').html('邮箱不能为空');	
			flag_email=false;
	    }
		if(password==""){
			$('#warning_password').html('密码不能为空');
			flag_password=false;
	    }
		return flag_email && flag_password;
	})
	
})