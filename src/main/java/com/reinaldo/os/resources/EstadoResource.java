package com.reinaldo.os.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.os.domain.Estado;
import com.reinaldo.os.dto.EstadoDTO;
import com.reinaldo.os.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> listarUm(@PathVariable Integer id){
		Estado obj = service.listarUm(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> listarTodos(){
		List<Estado> obj = service.listarTodos();
		List<EstadoDTO> listDto = obj.stream().map(objDto -> new EstadoDTO(objDto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
