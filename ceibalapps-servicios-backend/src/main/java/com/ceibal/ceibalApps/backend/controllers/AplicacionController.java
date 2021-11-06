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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ceibal.ceibalApps.backend.models.entity.Aplicacion;
import com.ceibal.ceibalApps.backend.models.entity.Noticia;
import com.ceibal.ceibalApps.backend.models.service.AplicacionService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT}, maxAge = 3600)
public class AplicacionController {
	
	@Autowired
	private AplicacionService aplicacionService;
	
	@GetMapping("/api/aplicaciones/listar")
	public List<Aplicacion> listar(){
		return aplicacionService.findAll();
		
	}
	
	@GetMapping("/api/aplicaciones/obtener/{id}")
	public Aplicacion obtener(@PathVariable Long id){
		return aplicacionService.findById(id);

	}
	
	@PostMapping("/api/aplicaciones/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Aplicacion crear(@RequestBody Aplicacion aplicacion) {
		Date now = new Date();
		   aplicacion.setFechaCreacion(now);
		   aplicacion.setIcono("http://localhost:6001/api/images/"+aplicacion.getIcono());
		   aplicacion.setApk("http://localhost:6001/api/files/"+aplicacion.getApk());
		   aplicacion.setBanner("http://localhost:6001/api/images/"+aplicacion.getBanner());
		return aplicacionService.save(aplicacion);
		
	}
	
	@PutMapping("/api/aplicaciones/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Aplicacion editar(@RequestBody Aplicacion aplicacion, @PathVariable Long id) {
		Aplicacion aplicacionDb = aplicacionService.findById(id);
		aplicacionDb.setApk(aplicacion.getApk());
		aplicacionDb.setCalificacion(aplicacion.getCalificacion());
		aplicacionDb.setCategoria(aplicacion.getCategoria());
		aplicacionDb.setDescripcion(aplicacion.getDescripcion());
		aplicacionDb.setFechaCreacion(aplicacion.getFechaCreacion());
		aplicacionDb.setIcono(aplicacion.getIcono());
		aplicacionDb.setNombre(aplicacion.getNombre());
		aplicacionDb.setPaquete(aplicacion.getPaquete());
		aplicacionDb.setRecomendada(aplicacion.isRecomendada());
		aplicacionDb.setVersion(aplicacion.getVersion());
		
		return aplicacionService.save(aplicacionDb);
	}
	
	@DeleteMapping("/api/aplicaciones/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		aplicacionService.deleteById(id);
	}
}