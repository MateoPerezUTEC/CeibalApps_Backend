package com.ceibal.ceibalApps.backend.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceibal.ceibalApps.backend.models.dao.UsuarioDao;
import com.ceibal.ceibalApps.backend.models.entity.Aplicacion;
import com.ceibal.ceibalApps.backend.models.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		usuarioDao.deleteById(id);
		
	}

	
	

}
