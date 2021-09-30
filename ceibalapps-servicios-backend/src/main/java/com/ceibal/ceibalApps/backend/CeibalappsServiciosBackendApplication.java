package com.ceibal.ceibalApps.backend;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceibal.ceibalApps.backend.models.services.FileStorageService;

@SpringBootApplication
public class CeibalappsServiciosBackendApplication implements CommandLineRunner{
	 @Resource
	  FileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(CeibalappsServiciosBackendApplication.class, args);
	}

	 @Override
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }

}
