package br.edu.ifms.aluno.exception;

public class ListException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ListException(String message) {
        super(message);
    }

    public ListException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
