package com.javabykiran.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javabykiran.model.State;
import com.javabykiran.model.User;
import com.javabykiran.model.Users;
import com.javabykiran.service.RegisterService;
import com.javabykiran.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/showUserList")
	public ModelAndView showUserList() {
		ModelAndView mv = new ModelAndView();
		if (userService.showUsers() != null) {
			mv.setViewName("users");
			mv.addObject("data", userService.showUsers());
		} else {
			mv.addObject("msg", "User not available..please add.");
			mv.setViewName("login");
		}
		return mv;
	}
	
	/*@RequestMapping("/adduser")
	public String addUser() {
		return "adduser";
	}*/
	
	
	@RequestMapping("/add")
	public ModelAndView add(@ModelAttribute User user) {
		System.out.println("User controller");
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
		userService.add(user);
		mv.addObject("msg", "User added.");
		mv.setViewName("dashboard");
		return mv;
	}

	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User users) 
	{
		
		if(users.getUserid()==0)
		{	
			System.out.println(users.getUserid());
			userService.addUser(users);
		}
		else
		{
			System.out.println(users.getUserid());
			userService.update(users);
		}
		List<User> l= userService.showUsers();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("users");
		mv.addObject("data", l);
		return mv;
	}
	
	@RequestMapping(value="/editUser/{id}")    
    public ModelAndView editUser(@PathVariable int id){    
        User user=userService.getEmpById(id);   
        ModelAndView mv = new ModelAndView();
        if(user != null)
        {
        	mv.addObject("userData",user);  
        	mv.setViewName("edituser");
        	System.out.println(user.getUsername());
        	return mv;
        }
        else
        {
        	mv.setViewName("edituser");
        	mv.addObject("msg","Record not found.");  
        	return mv;
        }
    } 
	
	 	@RequestMapping(value="/updateUser")
	    public String updateUser(@ModelAttribute User user) {
		 ModelAndView mv = new ModelAndView();
	      	System.out.println(user.getUsername());
	      	System.out.println(user.getUserid());
	        userService.updateUser(user);
	        
	       // mv.setViewName("users");
        	//mv.addObject("userData",userService.showUsers());  
        	return "redirect:/showUserList";
	    }
	 	
	 	@RequestMapping(value="/delete/{id}")    
	    public ModelAndView deleteUser(@PathVariable int id){   
	 		
	        userService.deleteUser(id);
	        return new ModelAndView("redirect:/showUserList");
	 	}
	 
	 /*	@RequestMapping(value = "/update/{id}")
	    public ModelAndView edit(@PathVariable int id) {
	 	 	
		 System.out.println("in method");
		 ModelAndView mv = new ModelAndView();
		 User u = userService.getByID(id);
		 mv.setViewName("adduser");
		 mv.addObject("userData", u);
		 return mv;
	 }
	
	 	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
		public String saveOrUpdateUser(@ModelAttribute() @Validated User user,
				BindingResult result, Model model, 
				final RedirectAttributes redirectAttributes) {

				userService.saveOrUpdate(user);
				
				// POST/REDIRECT/GET
				return "redirect:/users/";

				// POST/FORWARD/GET
				// return "user/list";

			}*/
	 	
	 	
	 	
	 	//new code
	 	 @RequestMapping(value = "/editNew", method = RequestMethod.GET)
	     public ModelAndView editNew(HttpServletRequest request) {
	         int userId = Integer.parseInt(request.getParameter("id"));
	         User user = userService.getByID(userId);
	         State stateDetails = userService.getStateById(user.getState().getState_id());     
	         int selectedStateId = stateDetails.getState_id();
	  
	         ModelAndView model = new ModelAndView("UserForm1");
	         List<State> al =  userService.getAllStates();
		 	 model.addObject("StatesList",al);
	         model.addObject("User", user);
	         model.addObject("selectedStateId", selectedStateId);
	  
	         return model;
	     }
	 	 
	 	 
	 	/* @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	     public ModelAndView saveEmployee(@ModelAttribute User user) {
	 		 System.out.println(user);
	 		String message = null;
	         if (user.getUserid() == 0) { // if employee id is 0 then creating the
	             // employee other updating the employee
	        	 
	        	 
	        	 userService.addNewUser(user);
	        	 //message = "User added.";
	         } else {
	        	 userService.updateUser(user);
	        	 //message = "User updated.";
	         }
	         
	         return new ModelAndView("redirect:/showUserList");
	     }*/
	 	 
	 	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	     public ModelAndView saveEmployee(@ModelAttribute User user,BindingResult result) {	 
	 		System.out.println(user.getEmail());
	 		System.out.println(result.getFieldValue("state"));
	 		//add
	 		if (user.getUserid() == 0) { 
		 		State s = new State();
		 		String tempString = (String) result.getFieldValue("state");
		 	    int state_id = Integer.parseInt(tempString);
		 	    State stateDetails = userService.getStateById(state_id);
		 		s.setState_id(Integer.parseInt(tempString));
		 		s.setState(stateDetails.getState());
		 		user.setState(s);
		 		//result.findEditor("state", State.class);
		        userService.addNewUser(user);	  
	 		}
	 		else 
	 		{
	 			//update
	 			State s = new State();
		 		String tempString = (String) result.getFieldValue("state");
		 	    int state_id = Integer.parseInt(tempString);
		 	    State stateDetails = userService.getStateById(state_id);
		 		s.setState_id(Integer.parseInt(tempString));
		 		s.setState(stateDetails.getState());
		 		user.setState(s);
	        	userService.updateUser(user);
	         }
	         return new ModelAndView("redirect:/showUserList");
	     }
	 	 
	 	 
	 	
	 	 
	 	
	 	@RequestMapping(value = "/newUser")
	    public ModelAndView newContact() {
	 		ModelAndView model = new ModelAndView();
	 		User user = new User();
	 		List<State> al =  userService.getAllStates();
	 		model.addObject("StatesList",al);
	        model.addObject("User", user);
	        model.setViewName("UserForm1");
	        return model;
	    }

	 	
	 	@RequestMapping(value = "/deleteMultiple" , method = RequestMethod.POST)
	 	public ModelAndView deleteMultiple(@RequestParam(value = "id[]", required = false) int[] ids) 
	 	{
	 	  if(ids != null)
	 	  {
	 	    System.out.println("checkbox is checked"+ids.length);
	 	    for (int i = 0; i < ids.length; i++) {
				System.out.println(ids[i]+" "); 
			}
	 	    userService.deleteAll(ids);
	 	    System.out.println("All deleted");
	 	  }
	 	  else
	 	  {
	 	    System.out.println("checkbox is not checked");
	 	  }
	 	  return new ModelAndView("redirect:/showUserList");
	 	}

}
