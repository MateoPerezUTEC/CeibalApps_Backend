package com.ceibal.ceibalApps.backend.controllers.noticias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceibal.ceibalApps.backend.models.entities.noticias.Noticia;
import com.ceibal.ceibalApps.backend.models.services.noticias.NoticiaService;

@RestController
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