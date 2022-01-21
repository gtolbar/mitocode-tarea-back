package com.crudback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudback.model.Persona;
import com.crudback.repo.IGenericRepo;
import com.crudback.repo.IPersonaRepo;
import com.crudback.service.IPersonaService;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService{

	@Autowired
	private IPersonaRepo repo;
	
	@Override
	protected IGenericRepo<Persona, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
