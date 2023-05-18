package com.koreaIT.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class UsrHomeController {
	
	@RequestMapping("/usr/home/main")
	public String showMain() {
		return "usr/home/main";
	}
	
	@RequestMapping("/")
	public String showRoot() {
		return "redirect:/usr/home/main";
	}
	
	@RequestMapping("/usr/home/popUp")
	public String showPopUp() {
		return "/usr/home/popUp";
	}
	
//	@RequestMapping("/usr/home/main2")
//	@ResponseBody
//	public Map<String,Object> showMain2() {
//		
//		Map<String,Object> map = new HashMap<>();
//		map.put("1", "asdasd");
//		map.put("2", 1234123);
//		
//		return map;
//	}
//	
//	@RequestMapping("/usr/home/main3")
//	@ResponseBody
//	public List<String> showMain3() {
//		
//		List<String> list = new ArrayList<>();
//		list.add("ads");
//		list.add("2");
//		
//		return list;
//	}
//	
//	@RequestMapping("/usr/home/main4")
//	@ResponseBody
//	public List<Map<String,Object>> showMain4() {
//		
//		List<Map<String,Object>> list = new ArrayList<>();
//		Map<String,Object> map = new HashMap<>();
//		Map<String,Object> map2 = new HashMap<>();
//		
//		map.put("키", "벨류");
//		map.put("키1", "벨류1");
//		map2.put("키", "벨류");
//		map2.put("키1", "벨류1");
//		
//		list.add(map);
//		list.add(map2);
//		
//		return list;
//	}
	
//	@RequestMapping("/usr/home/main5")
//	@ResponseBody
//	public Article showMain5() {
//		
////		Article article = new Article(1, "asdf");
//		Article article2 = new Article();
//		
//		return article2;
//	}
	
}


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//class Article {
//	private int id;
//	private String title;
//	
//}
