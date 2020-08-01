package com.telusko.demo;

import java.util.Arrays;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.model.Alien;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home Contoller method index is called");
		return "index";
	}
	
	// Accepting User Input
//	@RequestMapping("add")
//	public String add(HttpServletRequest request) {
//		System.out.println("Home Contoller result is called");
//		int num1 = Integer.parseInt(request.getParameter("num1"));
//		int num2 = Integer.parseInt(request.getParameter("num2"));
//		int num3 = num1 + num2; // We have to pass this num3 in result.jsp
//		// Method 1 is Dispatcher servlet
//		//return "result.jsp?num3=" + num3;
//		HttpSession session = request.getSession();
//		session.setAttribute("num3", num3); 
//      // 2nd num3 is above one and 1st num3 is use in jsp file
//		return "result.jsp";
//	}
	
	// @RequestParam
//	@RequestMapping("add")
//	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session) {
//		System.out.println("Home Contoller result is called");
//		int num3 = i + j; // We have to pass this num3 in result.jsp
//		session.setAttribute("num3", num3); 
//		// 2nd num3 is above one and 1st num3 is use in jsp file
//		return "result.jsp";
//	}
	
//	//ModelAndView
//	@RequestMapping("add")
//	public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j) {
//		System.out.println("Home Contoller result is called");
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		int num3 = i + j; // We have to pass this num3 in result.jsp
//		mv.addObject("num3", num3);
//		// 2nd num3 is above one and 1st num3 is use in jsp file
//		return mv;
//	}
	
	//Model or ModelMap
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m) { // we can use Model also
		System.out.println("Home Contoller result is called");
		int num3 = i + j; // We have to pass this num3 in result.jsp
		m.addAttribute("num3", num3); // 2nd num3 is above one and 1st num3 is use in jsp file
		return "result";
	}
	
//	//ModelAttribute need
//	@RequestMapping("addAlien")
//	public String addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, Model m) { 
//			System.out.println("Home Contoller result is called 2nd time");
//			Alien a = new Alien();
//			a.setAid(aid);
//			a.setAname(aname);
//			m.addAttribute("alien", a); // 2nd a is above one and 1st alien is use in jsp file
//			return "result";
//	}
	
//	//ModelAttribute 
//	@RequestMapping("addAlien")
//	public String addAlien(@ModelAttribute("a1") Alien a, Model m) { 
//		System.out.println("Home Contoller result is called 2nd time");
//		return "result";
//	}
	
	//Method POST
	@PostMapping(value = "addAlien") // IMPORT BOOK
//	@RequestMapping(value = "addAlien", method=RequestMethod.GET) // IMPORT BOOK
	public String addAlien(@ModelAttribute("a1") Alien a, Model m) { 
		System.out.println("Home Contoller result is called 2nd time");
		return "result";
	}
	
	// Method GET
	@GetMapping("getAliens")
	public String getAlien(Model m) {
		List<Alien> aliens = Arrays.asList( new Alien(101,"Akash"), new Alien(102,"Khandelia") );
		m.addAttribute("result", aliens);
		return "showAliens";
	}
	
	// This will call first in the Controller
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name", "Alien");
	}
	
}
