package com.romero.sisgestion.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.romero.sisgestion.entity.Infraccion;

public interface InfraccionService {
	
	public List<Infraccion> findAll(Pageable page);
	public List<Infraccion> findByPlaca(String placa, Pageable page);
	public Infraccion findById(int id);
	public Infraccion save(Infraccion infraccion);
	public Infraccion update(Infraccion infraccion);
	public void delete(int id);


}
