package com.examenFSJ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenFSJ.entity.examenEntity;
import com.examenFSJ.repository.examenRepository;



@Service
public class examenService {
	
	@Autowired
	private examenRepository repository;
	
	public List<examenEntity> findAllUser(){
		return repository.findAll();
	}
	
	public examenEntity findById(String email) {
		return repository.findById(email).orElse(null);		
	}
	
	public String userdelete(String email) {
		repository.deleteById(email);
		return "Usuario eliminado! "+email;
	}
	
	public examenEntity saveUser(examenEntity exaenti) {
		return repository.save(exaenti);
	}

}
