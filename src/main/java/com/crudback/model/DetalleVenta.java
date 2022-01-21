package com.crudback.model;

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
@Table(name="detalle-venta")
@Data
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_venta", nullable=false)
	private Venta idVenta;
	
	@ManyToOne
	@JoinColumn(name="id_producto", nullable=false)
	private Producto idProducto;
	
	@Column(name="cantidad", nullable=false)
	private Integer cantidad;
	
}
