package com.examenFSJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examenFSJ.entity.examenEntity;
import com.examenFSJ.service.examenService;

@RestController
@CrossOrigin(origins ="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class examenController {
	
	@Autowired
	examenService service;
	
	@GetMapping("/user")
	public List<examenEntity> findAllUser(){
		return service.findAllUser();		
	}
	
	@GetMapping("/user/{email}")
	public ResponseEntity<examenEntity> findById(@PathVariable("email") String email){
		examenEntity exaentity = service.findById(email);
		
		if(exaentity == null) {
			return new ResponseEntity<examenEntity>(HttpStatus.NOT_FOUND);
			
		}
		return new 		ResponseEntity<examenEntity>(exaentity,HttpStatus.OK);
	}
	
	@DeleteMapping("/userdelete/{email}")
	public String deleteuser(@PathVariable("email") String email) {
		return service.userdelete(email);
	}
	
	@PostMapping("/useradd")
	public examenEntity adduser(@RequestBody examenEntity exaent) {
		return service.saveUser(exaent);
	}

}
