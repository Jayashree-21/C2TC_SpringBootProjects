package com.tns.user;


import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {
		@Autowired
		private UserService service;
		
		@GetMapping("/user")
		public List<User> list()
		{
			
			return service.listAll();
		}
		@GetMapping("/user/{id}")
		public ResponseEntity<User> get(@PathVariable int id)
		{
			try
			{
				User user = service.get(id);
				return new ResponseEntity<User>(HttpStatus.OK);
			}
			catch (NoSuchElementException e)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		}
		public void add(@RequestBody User user)
		{
			service.save(user);
		}
		@PutMapping("/user/{id}")
		public ResponseEntity<?> update(@RequestBody User user, @PathVariable int id)
		{
			try
			{
				String existUser = user.toString();
				service.save(user);
				return new ResponseEntity<>(HttpStatus.OK);
			}
			catch (NoSuchElementException e)
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
			public void delete(@PathVariable int id)
			{
				service.delete(id);
			}
			
		}





