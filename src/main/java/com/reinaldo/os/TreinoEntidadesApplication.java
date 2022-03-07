package com.reinaldo.os;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.os.domain.Cidade;
import com.reinaldo.os.domain.Estado;
import com.reinaldo.os.repositories.CidadeRepository;
import com.reinaldo.os.repositories.EstadoRepository;

@SpringBootApplication
public class TreinoEntidadesApplication implements CommandLineRunner{

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TreinoEntidadesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado e1 = new Estado(null, "Goiás");
		
		Cidade c1 = new Cidade(null, "Goiania", e1);
		Cidade c2 = new Cidade(null, "Anápolis", e1);
		Cidade c3 = new Cidade(null, "Inhumas", e1);
		
		e1.getCidades().addAll(Arrays.asList(c1,c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(e1));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		
	}

}
