package com.reinaldo.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.os.domain.Cidade;
import com.reinaldo.os.dto.CidadeDTO;
import com.reinaldo.os.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public Cidade listar(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public List<Cidade> listarTodos(){
		return repository.findAll();
	}
	
}
