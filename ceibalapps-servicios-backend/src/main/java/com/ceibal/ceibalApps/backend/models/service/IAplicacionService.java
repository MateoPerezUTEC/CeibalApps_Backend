package com.ceibal.ceibalApps.backend.models.service;

import java.util.List;

import com.ceibal.ceibalApps.backend.models.entity.Aplicacion;

public interface IAplicacionService {
	
	public List<Aplicacion> findAll();
	public Aplicacion findById(Long id);
	
	public Aplicacion save(Aplicacion aplicacion);
	public void deleteById(Long id);

}
