package pe.edu.upc.stumatch.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.stumatch.business.crud.UserService;
import pe.edu.upc.stumatch.model.entity.User;

@Controller
@RequestMapping("/users")
@SessionAttributes("{user}")
public class UserController {

	
	@Autowired
	private UserService uService;

	@GetMapping("/new")
	public String newUser(Model model, SessionStatus status)
		{
		User user = new User();
		model.addAttribute("user", user);
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		model.addAttribute("bcpe", bcpe);
		try {
			List<User> users = uService.getAll();
			model.addAttribute("users", users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usersecurity/user";
	}


	@PostMapping("savenew")
	public String saveUser(Model model, @ModelAttribute("user") User user) {
		try {
			User userSaved = uService.create(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/authoritys/new";
	}
}
