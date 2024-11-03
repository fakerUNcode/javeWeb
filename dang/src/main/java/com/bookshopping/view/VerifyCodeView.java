package com.bookshopping.view;

import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import com.bookshopping.util.VerifyCodeUtil;

public class VerifyCodeView implements View{

	public String getContentType() {
		return "image/png";
	}

	public void render(Map<String, ?> model, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取输出流
        ServletOutputStream out = response.getOutputStream();
        
        //从model中取出验证码
        String code = (String)model.get("code");
        
        //定义验证码
        VerifyCodeUtil.outputImage(out, code);
	}
}
