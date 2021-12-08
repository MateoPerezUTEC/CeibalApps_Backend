package com.ceibal.ceibalApps.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceibal.ceibalApps.backend.models.entity.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long>{
	
}
