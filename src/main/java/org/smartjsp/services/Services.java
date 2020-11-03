package org.smartjsp.services;

import org.smartjsp.services.tools.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Services {
		
	@GetMapping("/newbpartner/{name}/{taxID}")
	public Response welcomeWithParameter(@PathVariable String name,@PathVariable String taxID ) {
		return new TodoService().createBpartner(name, taxID);
	}
	
	@GetMapping("/hello")
	public Response retrieveTodos() {
		return new TodoService().saludar();
	}
	
	@GetMapping("/hellos")
	public Response retrieveTodoss() {
		return TodoService.saludars();
	}
}
