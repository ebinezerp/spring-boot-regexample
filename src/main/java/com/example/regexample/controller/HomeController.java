package com.example.regexample.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.regexample.model.UserAccount;
import com.example.regexample.service.UserAccountService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private UserAccountService userAccountService;
	
	
   @GetMapping
   public String welcomePage()
   {
	   return "master";
   }
   
   @GetMapping("/login")
   public String loginPage(Model model)
   {
	   model.addAttribute("page", "login");
	   return "master";
   }
   
   
   @GetMapping("/signup")
   public String signupPage(Model model)
   {
	   model.addAttribute("page", "signup");
	   model.addAttribute("userAccount", new UserAccount());
	   return "master";
   }
   
   
   @PostMapping("/signup")
   public String signup(@Valid @ModelAttribute("userAccount")UserAccount userAccount,BindingResult result,Model model)
   {
	   if(result.hasFieldErrors())
	   {
		   model.addAttribute("userAccount", userAccount);
		   model.addAttribute("page", "signup");
		   return "master";
	   }
	   
	   if(userAccountService.saveAccount(userAccount))
	   {
		   model.addAttribute("page", "login");
	   }else
	   {
		   model.addAttribute("signup_error", "Internal Server Error occured. Sorry for Inconvinence. Try Again later!!!");
		   model.addAttribute("page", "signup");
	   }
	   
	   return "master";
   }

   
   
   @PostMapping("/login")
   public String login(@RequestParam("email")String email,@RequestParam("password")String password,Model model,HttpSession session)
   {
	   UserAccount userAccount=userAccountService.login(email, password);
	   System.out.println("User Account: "+userAccount);
	   if(userAccount!=null)
	   {
		   model.addAttribute("page", "home");
		   session.setAttribute("userAccount", userAccount);
	   }else
	   {
		   model.addAttribute("page", "login");
	   }
	   
	   return "master";
   }
   
   
   @GetMapping("/logout")
   public String logout(HttpSession session,Model model)
   {
	   if(session.getAttribute("userAccount")!=null)
	   {
		   session.removeAttribute("userAccount");
	   }
	   
	   session.invalidate();
	   
	   
	   return "master";
   }
}
