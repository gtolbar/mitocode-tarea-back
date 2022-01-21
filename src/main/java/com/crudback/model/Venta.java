package com.crudback.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="venta")
@Data
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="fecha", nullable=false)
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name="id_persona", nullable=false)
	private Persona idPersona;
	
	
	@Column(name="importe", nullable=false)
	private double importe;
	
}
