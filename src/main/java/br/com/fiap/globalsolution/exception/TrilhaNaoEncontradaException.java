package br.com.fiap.globalsolution.exception;

public class TrilhaNaoEncontradaException extends RuntimeException {
    public TrilhaNaoEncontradaException(Long id) {
        super("Trilha não encontrada com id: " + id);
    }
}
