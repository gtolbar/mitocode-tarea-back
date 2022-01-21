package com.crudback.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crudback.exception.ModeloNotFoundException;
import com.crudback.model.Producto;
import com.crudback.service.IProductoService;


@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listar() throws Exception{
		List<Producto> lista = service.listar();
		return new ResponseEntity<List<Producto>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Producto obj=service.listarPorId(id);
		
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		return new ResponseEntity<Producto>(obj,HttpStatus.OK);
	}
	
	@GetMapping("/hateoas/{id}")
	public EntityModel<Producto> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Producto obj=service.listarPorId(id);
		
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		EntityModel<Producto> recurso= EntityModel.of(obj);
		
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorIdHateoas(id));
		
		recurso.add(link1.withRel("producto-recurso1"));
		
		return recurso;
	}
	
	@PostMapping
	public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto p) throws Exception{
		Producto obj = service.registrar(p);
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping()
	public ResponseEntity<Producto> modificar(@RequestBody Producto p) throws Exception{
		Producto obj = service.modificar(p);
		return new ResponseEntity<Producto>(obj,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Producto> eliminar(@PathVariable("id") Integer id) throws Exception{
		Producto obj=service.listarPorId(id);	
		if(obj==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		
		return new ResponseEntity<Producto>(obj,HttpStatus.NO_CONTENT);
	}
	
	
}
