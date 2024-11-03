package com.bookshopping.controller;

import javax.annotation.Resource;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookshopping.entity.User;
import com.bookshopping.entity.Result;
import com.bookshopping.exception.ExistedEmailException;
import com.bookshopping.exception.PasswordException;
import com.bookshopping.exception.UserNameException;
import com.bookshopping.service.UserService;
import com.bookshopping.view.VerifyCodeView;
import com.bookshopping.util.VerifyCodeUtil;

import com.bookshopping.util.DegistUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService service;
	
	
	
	//Ajax调用返回
		@RequestMapping("/validEmail.do")
		@ResponseBody  //不返回视图，返回字符串
		public Result validEmail(String email){
			Result result = new Result();
			try {
				User u = service.checkEmail(email);
				result.setStatus(1); //
				result.setMsg("邮箱可用");
			} catch (ExistedEmailException e) {
				result.setStatus(0); //
				result.setMsg("邮箱已被占用");
			}
			return result;
		}
	
    
	//获取验证码
    @RequestMapping("/getVerifyCode.do")
    public ModelAndView CreateVerifyCode(HttpSession session){
        //创建ModelAndView对象
        ModelAndView model = new ModelAndView();
        //调取验证码
        String code = VerifyCodeUtil.getVerifyCode();
        //添加验证码到ModelAndView
        model.addObject("code", code);
        //到实现类去添加视图
        model.setView(new VerifyCodeView());
        
        //添加验证码加入session中
        session.setAttribute("code", code);
        
        //返回模型和视图
        return model;
    }
    
    //检查输入验证码是否正确
	@RequestMapping("/checkVerifyCode.do")
	@ResponseBody  //返回JSON字符串
    public Result checkVerifyCode(HttpSession session, String verifyCode){
    	Result result = new Result();
    	
    	String code =(String)session.getAttribute("code");
    	if(code.equalsIgnoreCase(verifyCode)){ 
    		result.setStatus(1); //
			result.setMsg("正确");
    	}else{
    		result.setStatus(0); //
			result.setMsg("输入有误");
    	}
    	return result;
    }
	

	@RequestMapping("/toRegiste.do")
	public String toRegiste(){
		return "/user/registe";
	}
	
	@RequestMapping("/registe.do")
	public String registe(HttpSession session, String email,
			String password, String nickname){
		
		String pwd = DegistUtil.produceDegistCode(password.toLowerCase());  //转为小写统一处理
		service.addUser(email, pwd, nickname);
		
		session.setAttribute("username", nickname);
		
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "/main/main";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "/user/login";
	}
	
	@RequestMapping("/login.do")
	public String login(String email, String password, 
			HttpSession session, ModelMap model){
		try {
			String pwd = DegistUtil.produceDegistCode(password.toLowerCase());  //转为小写统一处理
			User u = service.checkLogin(email, pwd);
			session.setAttribute("username", u.getNickname());
			return "redirect:toIndex.do";			
		} catch (UserNameException e) {
			model.addAttribute("message", e.getMessage());
			return "user/error";
		} catch (PasswordException e) {
			model.addAttribute("message", e.getMessage());
			return "user/error";
		}
	}
	
	
	//退出登录
    @RequestMapping("/exit.do")
    public String exit(HttpSession session){
    	session.removeAttribute("username");
    	
    	return "redirect:toIndex.do";
    }

}
