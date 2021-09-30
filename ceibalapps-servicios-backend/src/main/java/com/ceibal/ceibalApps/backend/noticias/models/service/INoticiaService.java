package com.ceibal.ceibalApps.backend.noticias.models.service;

import java.util.List;

import com.ceibal.ceibalApps.backend.noticias.models.entity.Noticia;

public interface INoticiaService {
	
	public List<Noticia> findAll();
	public Noticia findById(Long id);
	
	public Noticia save(Noticia noticia);
	public void deleteById(Long id);

}
