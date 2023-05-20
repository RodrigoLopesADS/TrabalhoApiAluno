package br.edu.ifms.aluno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.aluno.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	//@Query("SELECT a FROM Aluno a WHERE lower(a.nome) LIKE %:nome%")
   // List<Aluno> findByNome(@Param("nome") String nome);
    
    List<Aluno> findByNome(String nome);
	
	List<Aluno> findByIdade(int idade);

	
	List<Aluno> findByCampus(String campus);
	
	List<Aluno> findByCurso(String curso);
	
	
	
}
