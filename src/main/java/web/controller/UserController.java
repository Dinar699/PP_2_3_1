package web.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public String showAllUser(ModelMap model) {
		List<User> messages = userService.getAllUser();
		model.addAttribute("messages", messages);
		return "users";
	}

	@GetMapping("/addNewUser")
	public String addNewUser(ModelMap model) {

		model.addAttribute("messages", new User());
		return "userInfo";
	}

	@PostMapping()
	public String addUser(@ModelAttribute("messages") User user) {

		if (user.getId() == null) {
			userService.add(user);
		} else {
			userService.updateUser(user);
		}

		return "redirect:/user";
	}

	@DeleteMapping("user-delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/user";

	}

	@PatchMapping("/user-update/{id}")
	public String updateUser(@PathVariable("id") Long id, ModelMap model) {
		User messages = userService.getUser(id);
		model.addAttribute("messages", messages);
		return "userInfo";
	}


}