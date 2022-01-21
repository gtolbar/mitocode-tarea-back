package com.crudback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Data;


@Entity
@Table(name="persona")
@Data
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 3, message = "{nombres.size}")
	@Column(name="nombres", nullable=false, length = 70)
	private String nombres;
	
	@NotNull
	@Size(min = 3, message = "{apellidos.size}")
	@Column(name="apellidos", nullable=false, length = 70)
	private String apellidos;
	
	
}
