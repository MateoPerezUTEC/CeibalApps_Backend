package com.ceibal.ceibalApps.backend.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.ceibal.ceibalApps.backend.models.entity.Noticia;
import com.ceibal.ceibalApps.backend.models.service.NoticiaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}, maxAge = 3600)
public class NoticiaController {
	
	@Autowired
	private NoticiaService noticiaService;
	
	@GetMapping("/api/noticias/listar")
	public List<Noticia> listar(){
		return noticiaService.findAll();
		
	}
	
	@GetMapping("/api/noticias/obtener/{id}")
	public Noticia obtener(@PathVariable Long id){
		return noticiaService.findById(id);

	}
	
	@PostMapping("/api/noticias/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Noticia crear(@RequestBody Noticia noticia) {
		Date now = new Date();
		   noticia.setFechaCreacion(now);
		   noticia.setBanner("http://localhost:6001/api/images/"+noticia.getBanner());
		return noticiaService.save(noticia);
		
	}
	
	@PutMapping("/api/noticias/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Noticia editar(@RequestBody Noticia noticia, @PathVariable Long id) {
		Noticia noticiaDb = noticiaService.findById(id);
		noticiaDb.setBanner(noticia.getBanner());
		noticiaDb.setFechaCreacion(noticia.getFechaCreacion());
		noticiaDb.setNombre(noticia.getNombre());
		noticiaDb.setUrlAcceso(noticia.getUrlAcceso());
		noticiaDb.setVencimiento(noticia.getVencimiento());
		
		return noticiaService.save(noticiaDb);
	}
	
	@DeleteMapping("/api/noticias/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		noticiaService.deleteById(id);
	}
}