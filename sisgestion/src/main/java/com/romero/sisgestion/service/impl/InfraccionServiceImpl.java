package com.romero.sisgestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romero.sisgestion.entity.Infraccion;
import com.romero.sisgestion.repository.InfraccionRepository;
import com.romero.sisgestion.service.InfraccionService;

@Service
public class InfraccionServiceImpl implements InfraccionService{
    @Autowired
    
    private InfraccionRepository repository;
    
	@Override
	
	@Transactional(readOnly=true)
	
	public List<Infraccion> findAll(Pageable page) {
		try {
			return repository.findAll(page).toList();
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Infraccion> findByPlaca(String placa, Pageable page) {
		try {
			return repository.findByPlacaContaining(placa, page);
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Infraccion findById(int id) {
		try {
			Infraccion registro = repository.findById(id).orElseThrow();
			return registro;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public Infraccion save(Infraccion infraccion) {
		try {
			
			Infraccion registro = repository.save(infraccion);
			return registro;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public Infraccion update(Infraccion infraccion) {
         
		try {
			Infraccion registro = repository.findById(infraccion.getId()).orElseThrow();
			registro.setPlaca(infraccion.getPlaca());
			registro.setDescripcion(infraccion.getDescripcion());
			repository.save(registro);
			return registro;
		}catch(Exception e) {
			return null;
		}

	}

	@Override
	public void delete(int id) {
		try {
			Infraccion registro = repository.findById(id).orElseThrow();
			repository.delete(registro);
		}catch(Exception e) {
		
		}
		
	}

}
