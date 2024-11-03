package controller.tmpmis;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import bean.Report;

@Controller
@RequestMapping(value="/tmp")
public class AddTmpController {
	
//	@RequestMapping("/add.do")
//	public String getInfo1(HttpServletRequest request) {
//		//1.获取表单提交的数据
//		String name = request.getParameter("name");
//		String telephone = request.getParameter("telephone");
//		String isContacted = request.getParameter("isContacted");
//		String temperature = request.getParameter("temperature");
//		
//		boolean isCon = false;
//		if(isContacted!=null && isContacted.equals("1")){
//			isCon=true;
//		}
//		double temp=0;
//		if(temperature!=null){
//			temp= Double.parseDouble(temperature);
//		}
//		Report r = new Report(name,telephone,isCon,temp);
//		System.out.println(r);	
//		return "show";
//	}
	
	
//	@RequestMapping("/add.do")
//	public String getInfo2(String name, String telephone, 
//			boolean isContacted, 
//			@RequestParam("temperature")double temp) {
//		Report r = new Report(name,telephone,isContacted,temp);
//		System.out.println(r);	
//		return "show";
//	}
	
//	@RequestMapping(value="/add.do")
//	public String getInfo3(Report r) 
//			throws IOException {
//        return "show";
//	}
	
//	@RequestMapping("/add.do")
//	public String getInfo4(HttpServletRequest request, Report r) {
//		request.setAttribute("info", r);
//		return "show";
//	}
	
	
//	@RequestMapping(value="/add.do")
//	public String getInfo5(Report r , ModelMap model) 
//			throws IOException {
//		model.addAttribute("info", r);
//        return "show";
//	}
	
//	@RequestMapping("/add.do")
//	public ModelAndView getInfo6(Report r) {
//		Map<String, Object> data = new HashMap<String, Object>();
//        data.put("info", r);
//        return new ModelAndView("show",data);
//	}
	
}
