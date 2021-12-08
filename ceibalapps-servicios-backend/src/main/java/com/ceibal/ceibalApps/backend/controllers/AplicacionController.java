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
		   if(aplicacion.getBanner().contains("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/images")) {
				aplicacion.setBanner(aplicacion.getBanner());
			}else {
				aplicacion.setBanner("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/images/"+aplicacion.getBanner());	
			}
		   if(aplicacion.getIcono().contains("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/images")) {
				aplicacion.setIcono(aplicacion.getIcono());
			}else {
				aplicacion.setIcono("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/images/"+aplicacion.getIcono());	
			}
		   if(aplicacion.getApk().contains("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/files")) {
				aplicacion.setApk(aplicacion.getApk());
			}else {
				aplicacion.setApk("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/files/"+aplicacion.getApk());	
			}
		return aplicacionService.save(aplicacion);
		
	}
	
	@PutMapping("/api/aplicaciones/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Aplicacion editar(@RequestBody Aplicacion aplicacion, @PathVariable Long id) {
		Aplicacion aplicacionDb = aplicacionService.findById(id);
		if(aplicacion.getBanner().contains("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/images")) {
			aplicacionDb.setBanner(aplicacion.getBanner());
		}else {
			aplicacionDb.setBanner("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/images/"+aplicacion.getBanner());	
		}
	   if(aplicacion.getIcono().contains("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/images")) {
			aplicacionDb.setIcono(aplicacion.getIcono());
		}else {
			aplicacionDb.setIcono("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/images/"+aplicacion.getIcono());	
		}
	   if(aplicacion.getApk().contains("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/files")) {
			aplicacionDb.setApk(aplicacion.getApk());
		}else {
			aplicacionDb.setApk("http://ceibalappsserviciosbackend-env.eba-kppep2ke.us-east-2.elasticbeanstalk.com/api/files/"+aplicacion.getApk());	
		}
	
		aplicacionDb.setCalificacion(aplicacion.getCalificacion());
		aplicacionDb.setCategoria(aplicacion.getCategoria());
		aplicacionDb.setDescripcion(aplicacion.getDescripcion());
		aplicacionDb.setFechaCreacion(aplicacionDb.getFechaCreacion());

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