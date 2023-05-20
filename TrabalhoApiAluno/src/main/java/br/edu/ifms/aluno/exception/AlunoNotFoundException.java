package br.edu.ifms.aluno.exception;

public class AlunoNotFoundException extends AppException {

	private static final long serialVersionUID = 1L;

	public AlunoNotFoundException(String message) {
		super(message);
		
	}
	
	public AlunoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
