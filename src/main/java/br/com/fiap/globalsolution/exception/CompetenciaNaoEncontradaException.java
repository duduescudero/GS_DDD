package br.com.fiap.globalsolution.exception;

public class CompetenciaNaoEncontradaException extends RuntimeException {
    public CompetenciaNaoEncontradaException(Long id) {
        super("Competência não encontrada com id: " + id);
    }
}
