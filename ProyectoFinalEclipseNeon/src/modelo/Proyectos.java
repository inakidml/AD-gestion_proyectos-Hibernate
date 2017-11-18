package modelo;
// Generated 27-oct-2017 21:41:44 by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Proyectos generated by hbm2java
 */
public class Proyectos implements java.io.Serializable {

	private String codigo;
	private String nombre;
	private String ciudad;
	private Set gestions = new HashSet(0);

	public Proyectos() {
	}

	public Proyectos(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Proyectos(String codigo, String nombre, String ciudad, Set gestions) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
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

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Set getGestions() {
		return this.gestions;
	}

	public void setGestions(Set gestions) {
		this.gestions = gestions;
	}

}