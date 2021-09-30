package com.ceibal.ceibalApps.backend.noticias.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceibal.ceibalApps.backend.noticias.models.entity.Noticia;

public interface NoticiaDao extends CrudRepository<Noticia, Long>{

}
