package com.ceibal.ceibalApps.backend.models.services.noticias;

import java.util.List;

import com.ceibal.ceibalApps.backend.models.entities.noticias.Noticia;

public interface INoticiaService {
	
	public List<Noticia> findAll();
	public Noticia findById(Long id);
	
	public Noticia save(Noticia noticia);
	public void deleteById(Long id);

}
