package com.ceibal.ceibalApps.backend.models.dao.noticias;

import org.springframework.data.repository.CrudRepository;

import com.ceibal.ceibalApps.backend.models.entities.noticias.Noticia;

public interface NoticiaDao extends CrudRepository<Noticia, Long>{

}
