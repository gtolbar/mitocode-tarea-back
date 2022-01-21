package com.crudback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudback.model.Producto;
import com.crudback.repo.IGenericRepo;
import com.crudback.repo.IProductoRepo;
import com.crudback.service.IProductoService;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService{

	@Autowired
	private IProductoRepo repo;
	
	@Override
	protected IGenericRepo<Producto, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
