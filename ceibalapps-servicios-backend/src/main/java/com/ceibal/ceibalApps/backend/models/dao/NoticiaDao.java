package com.ceibal.ceibalApps.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceibal.ceibalApps.backend.models.entity.Noticia;

public interface NoticiaDao extends CrudRepository<Noticia, Long>{

}
