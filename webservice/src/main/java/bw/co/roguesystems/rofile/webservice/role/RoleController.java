package bw.co.roguesystems.rofile.webservice.role;

import java.util.Collection;
import java.util.List;

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

import bw.co.roguesystems.rofile.role.service.RoleService;
import bw.co.roguesystems.rofile.role.vo.RoleSearchCriteria;
import bw.co.roguesystems.rofile.role.vo.RoleVO;

@RestController
@RequestMapping("/rofile/roles")
@Component
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@GetMapping
	@ResponseBody
	public List<RoleVO> getAllRoles(){
		return (List<RoleVO>) roleService.getAllRoles();
	}
	
	@GetMapping(value = "/find/{id}")
	@ResponseBody
	public RoleVO findRole(@PathVariable("id") Long id)
	{
		return roleService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@ResponseBody
	public RoleVO saveRole(@RequestBody RoleVO role) {
		return roleService.saveRole(role);
	}
		
	@DeleteMapping(path = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteRole(@PathVariable( "id" ) Long id)
	{
		if(id != null)
		{
			roleService.deleteRole(id);
		}
	}
	
	@PostMapping(value = "/search")
	@ResponseBody
	public Collection<RoleVO> searchRoles(@RequestBody RoleSearchCriteria searchCriteria){
		return roleService.searchRoles(searchCriteria);		
	}
}
