package com.telusko.demo;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home Contoller method index is called");
		return "index.jsp";
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
//		// 1st num3 is above one and 2nd num3 is use in jsp file
//		return "result.jsp";
//	}
	
	// @RequestParam
//	@RequestMapping("add")
//	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, HttpSession session) {
//		System.out.println("Home Contoller result is called");
//		int num3 = i + j; // We have to pass this num3 in result.jsp
//		session.setAttribute("num3", num3); 
//		// 1st num3 is above one and 2nd num3 is use in jsp file
//		return "result.jsp";
//	}
	
	//ModelAndView
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2") int j) {
		System.out.println("Home Contoller result is called");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		int num3 = i + j; // We have to pass this num3 in result.jsp
		mv.addObject("num3", num3);
		// 1st num3 is above one and 2nd num3 is use in jsp file
		return mv;
	}

}
