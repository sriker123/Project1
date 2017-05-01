package com.niit.slt1.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {
	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView showRegisterPage() {
		System.out.println("showRegisterPage called****");
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("isUserClickedRegister", "true");
		mv.addObject("userObject", user);

		return mv;
	}

	// Step#2 to Register a user
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegistraton(@Valid @ModelAttribute(value = "user") User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "register";
		}
		model.addAttribute("registrationSuccessMessage", "Registered Successfully. Login using username and password");
		model.addAttribute("userObject", user);
		user.setRole("User");
		userDAO.save(user);
		return "login";

	}

	// Login page

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) // this
	 * should // have the // same name // as the // jsp file public ModelAndView
	 * showLoginPage() { System.out.println("Login page method****");
	 * ModelAndView mv = new ModelAndView("home");
	 * mv.addObject("isUserClickedLogin", "true");
	 * 
	 * return mv; }
	 * 
	 * @RequestMapping("/validate") // @PostMapping("/"validate") public
	 * ModelAndView validateCredentials(@RequestParam("userName") String name,
	 * 
	 * @RequestParam("password") String pwd) { // Actually we have to get //
	 * data from DataBase // Temporarily UserID-Spike Password -Qwerty@123
	 * System.out.println("Validate method called"); ModelAndView mv = new
	 * ModelAndView("/home"); mv.addObject("msg", "welcome to shopping cart");
	 * 
	 * if (userDAO.validate(name, pwd) == true) { mv.addObject("isUserLoggedIn",
	 * "true");
	 * 
	 * user = userDAO.getUserbyName(name); if (user.getRole().equals("Admin")) {
	 * mv.addObject("isAdmin", "true"); } else { mv.addObject("isAdmin",
	 * "false"); } // mv.addObject("successmsg","Valid Credentials");
	 * session.setAttribute("loginmessage", "Welcome:  " + name); } else {
	 * mv.addObject("errormsg", "Invalid Credentials....please try again"); }
	 * return mv; }
	 */

	/*@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("/home");

		session.removeAttribute("loginmessage");// what ever the values attached
												// to the session are removed

		return mv;
	}*/
	
	

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,

			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null)
			model.addAttribute("errormsg", "Invalid username and password... Please enter the correctly");
		if (logout != null)
			model.addAttribute("logout", "logout successfully");

		return "login";
	}

}
