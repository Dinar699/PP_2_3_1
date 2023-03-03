package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.servise.UserServise;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserServise userServise;

	public UserController(UserServise userServise) {
		this.userServise = userServise;
	}

	@GetMapping()
	public String showAllUser(ModelMap model) {
		List<User> messages = userServise.getAllUser();
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
			userServise.add(user);
		} else {
			userServise.updateUser(user);
		}

		return "redirect:/user";
	}

	@DeleteMapping("user-delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userServise.deleteUser(id);
		return "redirect:/user";

	}

	@GetMapping("/user-update/{id}")
	public String updateUser(@PathVariable("id") Long id, ModelMap model) {
		User messages = userServise.getUser(id);
		model.addAttribute("messages", messages);
		return "userInfo";
	}


}