package com.reinaldo.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.os.domain.Estado;
import com.reinaldo.os.repositories.EstadoRepository;


@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public Estado listarUm(Integer id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Estado> listarTodos(){
		return repository.findAll();
	}
	
}
