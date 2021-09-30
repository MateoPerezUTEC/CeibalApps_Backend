package com.ceibal.ceibalApps.backend.models.entities.noticias;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="noticias")
public class Noticia implements Serializable{
	
	/**
	 * 
	 */

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String banner;
	@Column(name = "url_acceso")
	private String urlAcceso;
	@Temporal(TemporalType.DATE)
	private Date vencimiento;
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getUrlAcceso() {
		return urlAcceso;
	}
	public void setUrlAcceso(String urlAcceso) {
		this.urlAcceso = urlAcceso;
	}
	public Date getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	private static final long serialVersionUID = -9195090983907822378L;

}
