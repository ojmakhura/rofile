package bw.co.roguesystems.rofile.webservice.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bw.co.roguesystems.rofile.user.service.UserService;
import bw.co.roguesystems.rofile.user.vo.UserDetailsVO;
import bw.co.roguesystems.rofile.user.vo.UserSearchCriteria;

@RestController
@RequestMapping("/rofile/users")
@Component
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	@ResponseBody
	public Collection<UserDetailsVO> getAllRoles()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping(value = "/find/{id}")
	@ResponseBody
	public UserDetailsVO findUser(@PathVariable("id") Long id) 
	{
		return userService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	public UserDetailsVO saveUser(@RequestBody UserDetailsVO userVO)
	{
		return userService.saveUser(userVO);
	}
	
	@DeleteMapping(value = "/delete/id")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteUser(@PathVariable("id") Long id)
	{
		if(id != null)
			this.userService.deleteUser(id);
	}
	
	@PostMapping(value = "/search")
	@ResponseBody
	public Collection<UserDetailsVO> searchUsers(@RequestBody UserSearchCriteria searchCriteria)
	{
		return this.userService.searchUsers(searchCriteria);
	}
}
