package controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import bean.User;

@Controller
public class LoginController {
	
//	@RequestMapping(value="/login.do")
//	public ModelAndView login(String name, String pwd,
//			RedirectAttributes redirectAttributes) 
//			throws IOException {
//		if(null!=name && name.equals("song") && 
//				null!=pwd && pwd.equals("1234") ){ //用户名密码匹配
//			redirectAttributes.addFlashAttribute("d",name);
//			return new ModelAndView(new RedirectView("index.jsp"));
//		}else{			
//			return new ModelAndView(new RedirectView("login.html"));
//		}
//	}
	
	@RequestMapping(value="/login.do")
	public String login(User u,RedirectAttributes attr) 
			throws IOException {
		if(u.getName().equals("song") && 
				u.getPwd().equals("1") ){ //用户名密码匹配
			attr.addFlashAttribute("user",u);
			return "redirect:index.jsp";
		}else{			
			return "redirect:login.html";
		}
	}

//	@RequestMapping(value="/add.do")
//	public String getInfo8(Report r) 
//			throws IOException {
//        return "show";
//	}

}
