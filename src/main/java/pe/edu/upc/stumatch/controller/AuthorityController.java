package pe.edu.upc.stumatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.stumatch.business.crud.AuthorityService;
import pe.edu.upc.stumatch.model.entity.Authority;

@Controller
@RequestMapping("/authoritys")
@SessionAttributes("{authority}")
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;
	
	@GetMapping("new")
	public String newAuthority(Model model) {
		Authority authority = new Authority();
		model.addAttribute("authority", authority);
		try {
			List<Authority> authoritys = authorityService.getAll();
			model.addAttribute("authoritys", authoritys);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "role/role";
	}
	
	@PostMapping("savenew")
	public String saveAuthority(Model model, @ModelAttribute("authority") Authority authority) {
		try {
			Authority authoritySaved = authorityService.create(authority);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/students";
	}
	
}
