var email_flag=false;
var password_flag = false;
var repassword_flag = false;
var verifyCode_flag = false;

//(1)检测邮箱
$(function(){
    $('#email').blur(function(){
    	//1:判断邮箱是否为空
    	$("#warning_email").html('');
	    var email = $('#email').val();
	    if(email==""){
	    	$("#warning_email").html('邮箱不能为空');
	        return;
        }
	    
	    //2:判断邮箱格式是否正确
	    var Email_reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
	    if(!Email_reg.test(email)){
	    	$("#warning_email").html('邮箱格式不正确');
	        return;
	    }
	    
	    //3:判断邮箱唯一性--Ajax
	    $.ajax({
	        type:"post",
	    	url: 'validEmail.do',
	        data:{'email':email},
	        dataType:"json",
	        success: function(data){ //data:返回JSON数据
	        	$("#warning_email").html(data.msg);
	        	email_flag = data.status==1? true:false;
	        }
	    });       
    }).focus(function(){
    	$('#email').val("");
    	$("#warning_email").html("");
    })
});

//(2)检测密码
$(function(){   
     $('#password').blur(function(){
    	 
	     $('#warning_password').html('');
	     var password = $('#password').val();
	    
	     //1:检测密码是否为空
	     if(password==""){
	        $('#warning_password').html('密码不能为空');
	        password_flag=false;
	        return;
	     }
	     
	     //2：检测密码格式是否正确
	     var password_reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$/;
	     if(password_reg.test(password)){
	    	 password_flag=true;
	     }else{
	    	 $('#warning_password').html('密码不符合规则');
	        password_flag=false;
	        return;
	     }   
     }).focus(function(){
    	$("#warning_password").html("");
    	$("#warning_final_password").html("");
    })
     
     //检测再次输入密码
     $('#final_password').blur(function(){
	     $('#warning_final_password').html('');
	     
	     if(password_flag){ //密码不空
		     var password = $('#password').val();
		     var repeatPass = $('#final_password').val();
		     
		     //:检测第二次输入的密码是否于第一次的相等
		     if(repeatPass!=password){
		         $('#warning_final_password').html('两次密码不同');
		         return;
		     }else{
		    	 $('#warning_final_password').html('密码有效');
		         repassword_flag = true; 
		     }
	     }else{
	    	 $('#warning_password').html('请先输入合法密码');
	     }
     }).focus(function(){
    	$('#final_password').val("");
    	$("#warning_final_password").html("");
    });
});

//(4)更换验证码
$(function(){
    $('#imgVcode').click(function(){
        $('#imgVcode').attr('src','getVerifyCode.do?dt='+new Date().getTime());
	});
});	
	
//(5)检查输入的code是否正确 
$(function(){
	$("#verifycode").blur(function(){
		
		//verifyCode_flag = false;  //防止曾经成功过而不再经过检测
		var verifyCode = $('#verifycode').val();
		//1:判断是否为空
		if(verifyCode==""){
		  $('#warning_verifycode').html('请输入验证码');
		  return;
		}
		
		//2:Ajax请求检测验证码是否正确
		$.ajax({
			  type: "post",
			  url: 'checkVerifyCode.do',
			  data: {'verifyCode':verifyCode},
			  dataType: "json",
			  success: function(data){
				  	$("#warning_verifycode").html(data.msg);
				  	verifyCode_flag = data.status==1? true:false;
			  }
		});
		
	}).focus(function(){
		$('warning_verifycode').html('');
	})
 });   
 
//(6)表单验证
$(function(){
   $('#form').submit(function(){
      var flag = email_flag&&password_flag&&repassword_flag&&verifyCode_flag;
      if(!flag){
    	 check();  //继续验证    	 
    	 return false;
      }
     
      return true;   //返回true表示提交，返回false不提交
   });
});

function check(){
	var email = $('#email').val();
    var password = $('#password').val();
    var final_password = $('#final_password').val();
    var verifyCode = $('#txtVerifyCode').val();
    
	if(email==""){
		$('#warning_email').html('邮箱不能为空');
    }
	if(password==""){
		$('#warning_password').html('密码不能为空');
    }
	if(final_password==""){
		$('#warning_final_password').html('密码不能为空');
    }
	if(verifyCode==""){
		$('#warning_verifycode').html('验证码不能为空');
    }
	
}
