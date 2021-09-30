package com.ceibal.ceibalApps.backend.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceibal.ceibalApps.backend.models.dao.NoticiaDao;
import com.ceibal.ceibalApps.backend.models.entity.Noticia;

@Service
public class NoticiaService implements INoticiaService{
	
	@Autowired
	private NoticiaDao noticiaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Noticia> findAll() {
		return (List<Noticia>) noticiaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Noticia findById(Long id) {
		return noticiaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Noticia save(Noticia noticia) {
		return noticiaDao.save(noticia);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		noticiaDao.deleteById(id);
		
	}

}
