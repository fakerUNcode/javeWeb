package ex1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ex1.bean.City;

@Controller
@RequestMapping("/city")
public class ListController {

	@RequestMapping("/list.do")
	public String listCity(ModelMap model) {
		List<City> listCity = new ArrayList<City>();
		
		listCity.add(new City("001", "北京"));
		listCity.add(new City("002", "上海"));
		listCity.add(new City("003", "广州"));
		listCity.add(new City("004", "深圳"));

		model.addAttribute("listCity", listCity);
		return "listCity";
	}
}
