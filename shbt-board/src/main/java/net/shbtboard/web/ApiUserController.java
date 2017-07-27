package net.shbtboard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.shbtboard.domain.User;
import net.shbtboard.domain.UserRepository;

@RestController
@RequestMapping("/api/users")
public class ApiUserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User show(@PathVariable Long id) {
		User user = userRepository.findOne(id);
		System.out.println("ApiUserController======"+user.toString());
		return user;
	}
}
