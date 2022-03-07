package com.reinaldo.os.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.os.domain.Cidade;
import com.reinaldo.os.dto.CidadeDTO;
import com.reinaldo.os.repositories.CidadeRepository;
import com.reinaldo.os.services.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> listarUm(@PathVariable Integer id){
		Cidade obj = service.listar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CidadeDTO>> listarTodos(){
		List<Cidade> obj = service.listarTodos();
	    List<CidadeDTO> listDto = obj.stream().map(cidDTO -> new CidadeDTO(cidDTO)).collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDto);
	}
	
}
