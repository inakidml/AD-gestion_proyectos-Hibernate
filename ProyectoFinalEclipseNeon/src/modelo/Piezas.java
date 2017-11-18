package modelo;
// Generated 27-oct-2017 21:41:44 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Piezas generated by hbm2java
 */
public class Piezas implements java.io.Serializable {

	private String codigo;
	private String nombre;
	private float precio;
	private String descripcion;
	private Set gestions = new HashSet(0);

	public Piezas() {
	}

	public Piezas(String codigo, String nombre, float precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Piezas(String codigo, String nombre, float precio, String descripcion, Set gestions) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.gestions = gestions;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getGestions() {
		return this.gestions;
	}

	public void setGestions(Set gestions) {
		this.gestions = gestions;
	}

}
