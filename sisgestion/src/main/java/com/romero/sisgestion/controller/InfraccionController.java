package com.romero.sisgestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romero.sisgestion.entity.Infraccion;
import com.romero.sisgestion.service.InfraccionService;

@RestController
@RequestMapping("/v1/infracciones")
public class InfraccionController {

	@Autowired
	private InfraccionService service;
	
	@GetMapping()
	public ResponseEntity<List<Infraccion>> findAll(
		@RequestParam(value = "placa", required = false, defaultValue = " ")String placa,
		@RequestParam(value = "offset", required = false, defaultValue = "0")int pageNumber,
		@RequestParam(value = "limit", required = false, defaultValue = "5")int pageSize
		){
			Pageable page= PageRequest.of(pageNumber, pageSize);
			List<Infraccion> infracciones;
			if(placa == null ) {
				infracciones = service.findAll(page);
				
			}else {
				infracciones = service.findByPlaca(placa, page);
			}
			
			if(infracciones.isEmpty()) {
				return ResponseEntity.noContent().build();
				
			}
			return ResponseEntity.ok(infracciones);
	}
}
