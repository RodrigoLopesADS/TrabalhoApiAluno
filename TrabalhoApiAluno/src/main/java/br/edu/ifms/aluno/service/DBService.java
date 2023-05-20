package br.edu.ifms.aluno.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.aluno.model.Aluno;
import br.edu.ifms.aluno.repository.AlunoRepository;

@Service
public class DBService {

	@Autowired
	AlunoRepository alunoRepository;
	
	public void instantiateTestDataBase() throws ParseException {
		
		Aluno al1 = new Aluno(null, "Rodrigo", 38, "Masculino", "TADS", "IFMS-Corumba");
		Aluno al2 = new Aluno(null, "Bruno", 25, "Masculino", "TADS", "IFMS-Corumba");
		Aluno al3 = new Aluno(null, "Mariana", 26, "Feminino", "TADS", "IFMS-Corumba");
		
		
		alunoRepository.saveAll(Arrays.asList(al1, al2, al3));
			
	}	
}
