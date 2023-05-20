package br.edu.ifms.aluno.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifms.aluno.exception.AlunoNotFoundException;
import br.edu.ifms.aluno.exception.AppException;
import br.edu.ifms.aluno.exception.ListException;
import br.edu.ifms.aluno.model.Aluno;
import br.edu.ifms.aluno.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	//Método POST
	public Aluno cadastrar(Aluno aluno) {
		try {
			aluno.setIdAluno(null);
			return alunoRepository.saveAndFlush(aluno);
		}catch(Exception e) {
			throw new ServiceException("Erro ao cadastrar Aluno. Tente Novamente" + e.getMessage());
		}
	}
	
	//Método PUT
	public Aluno atualizarAluno(Aluno aluno) {
		try {
			Aluno alunoNovo = buscarAlunoId(aluno.getIdAluno());
			
			alunoNovo.setNome(aluno.getNome());
			alunoNovo.setIdade(aluno.getIdade());
			alunoNovo.setSexo(aluno.getSexo());
			alunoNovo.setCurso(aluno.getCurso());
			alunoNovo.setCampus(aluno.getCampus());
	
			return alunoRepository.save(alunoNovo);
		}catch(Exception e) {
			throw new ServiceException("Erro ao Atualizar Aluno! " + e.getMessage());
		}
		
	}
	
	//Método Delete
	public void excluirAluno(Integer id) {
		try {
			buscarAlunoId(id);
			alunoRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			//ID não existente
			throw new AlunoNotFoundException("Aluno não encontrado com o ID: " +id);
		}catch(Exception e) {
			throw new AppException("Erro ao excluir o Aluno!" + e.getMessage());
		}
	}
	
	//Métodos GET
	public List<Aluno> listarAlunos(){
		try {
			return alunoRepository.findAll();
		}catch(Exception e) {
			throw new ListException("Não existe nenhum aluno cadastrado." + e.getMessage());
		}
	}

	public Aluno buscarAlunoId(Integer id){
		Optional<Aluno> aluno = alunoRepository.findById(id);
		if (aluno.isPresent()) {
			return aluno.get();
			
		}else {
			throw new AlunoNotFoundException("Aluno não encontrado com ID: " +id);
		}

	}
	
	public List<Aluno> buscarAlunosPorNome(String nome) {
		try {
			return alunoRepository.findByNome(nome);
		}catch(Exception e) {
			throw new ListException("Não foi possivel encontrar Alunos com o nome especificado.");
		}
    }
	
	public List<Aluno> buscarAlunosPorIdade(int idade) {
		try {
			return alunoRepository.findByIdade(idade);
		}catch(Exception e) {
			throw new AlunoNotFoundException("Não foi possível localizar o Aluno especificado!");
		}
    }
	
	public List<Aluno> buscarAlunosPorCampus(String campus) {
		try {
			return alunoRepository.findByCampus(campus);
		}catch(Exception e) {
			throw new ListException("Não foi possivel encontrar o campus com o nome especificado.");
		}
    }
	
	public List<Aluno> buscarAlunosPorCurso(String curso) {
		try {
			return alunoRepository.findByCurso(curso);
		}catch(Exception e) {
			throw new ListException("Não foi possivel encontrar o curso com o nome especificado.");
		}
    }
	
	
	
}