package com.crudback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudback.model.DetalleVenta;
import com.crudback.repo.IDetalleVentaRepo;
import com.crudback.repo.IGenericRepo;
import com.crudback.service.IDetalleVentaService;

@Service
public class DetalleVentaServiceImpl extends CRUDImpl<DetalleVenta, Integer> implements IDetalleVentaService{

	@Autowired
	private IDetalleVentaRepo repo;
	
	@Override
	protected IGenericRepo<DetalleVenta, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
