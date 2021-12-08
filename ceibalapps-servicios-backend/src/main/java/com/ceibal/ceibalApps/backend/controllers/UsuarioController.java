package com.ceibal.ceibalApps.backend.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ceibal.ceibalApps.backend.models.entity.Usuario;
import com.ceibal.ceibalApps.backend.models.service.IUsuarioService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}, maxAge = 3600)
public class UsuarioController {
	
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/api/usuarios/listar")
	public List<Usuario> listar(){
		return usuarioService.findAll();
		
	}
	
	@GetMapping("/api/usuarios/obtener/{id}")
	public Usuario obtener(@PathVariable Long id){
		return usuarioService.findById(id);

	}
	
	@PostMapping("/api/usuarios/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario usuario) {
		Date now = new Date();
		   usuario.setFechaCreacion(now);
		return usuarioService.save(usuario);
		
	}
	
	@PutMapping("/api/usuarios/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario editar(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioDb = usuarioService.findById(id);
	
		usuarioDb.setEmail(usuario.getEmail());
		usuarioDb.setFechaCreacion(usuarioDb.getFechaCreacion());
		usuarioDb.setRol(usuario.getRol());
		
		
		return usuarioService.save(usuarioDb);
	}
	
	@DeleteMapping("/api/usuarios/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}

}
