package br.edu.ifms.aluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.aluno.model.Aluno;
import br.edu.ifms.aluno.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.cadastrar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alunoAtualizado = alunoService.atualizarAluno(aluno);
        if (alunoAtualizado != null) {
            return ResponseEntity.ok(alunoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable Integer id, @RequestBody Aluno obj) {
        alunoService.excluirAluno(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        List<Aluno> alunos = alunoService.listarAlunos();
        return ResponseEntity.ok(alunos);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoId(@PathVariable Integer id) {
        Aluno aluno = alunoService.buscarAlunoId(id);
        		return ResponseEntity.ok(aluno); 
    }
	
	@GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorNome(@PathVariable("nome") String nome) {
        List<Aluno> alunos = alunoService.buscarAlunosPorNome(nome);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/idade/{idade}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorIdade(@PathVariable("idade") int idade) {
        List<Aluno> alunos = alunoService.buscarAlunosPorIdade(idade);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/campus/{campus}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorCampus(@PathVariable("campus") String campus) {
        List<Aluno> alunos = alunoService.buscarAlunosPorCampus(campus);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/curso/{curso}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorCurso(@PathVariable("curso") String curso) {
        List<Aluno> alunos = alunoService.buscarAlunosPorCurso(curso);
        if (!alunos.isEmpty()) {
            return ResponseEntity.ok(alunos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
  
}
