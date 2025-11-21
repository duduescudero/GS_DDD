package br.com.fiap.globalsolution.exception;

public class MatriculaNaoEncontradaException extends RuntimeException {
    public MatriculaNaoEncontradaException(Long id) {
        super("Matrícula não encontrada com id: " + id);
    }
}
