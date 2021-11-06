package com.ceibal.ceibalApps.backend.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceibal.ceibalApps.backend.models.dao.AplicacionDao;
import com.ceibal.ceibalApps.backend.models.entity.Aplicacion;

@Service
public class AplicacionService implements IAplicacionService{
	
	@Autowired
	private AplicacionDao aplicacionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Aplicacion> findAll() {
		return (List<Aplicacion>) aplicacionDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Aplicacion findById(Long id) {
		return aplicacionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Aplicacion save(Aplicacion aplicacion) {
		return aplicacionDao.save(aplicacion);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		aplicacionDao.deleteById(id);
		
	}

}
