package br.com.fiap.globalsolution.service;

import br.com.fiap.globalsolution.exception.CompetenciaNaoEncontradaException;
import br.com.fiap.globalsolution.model.Competencia;
import br.com.fiap.globalsolution.repository.CompetenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;

    public CompetenciaService(CompetenciaRepository competenciaRepository) {
        this.competenciaRepository = competenciaRepository;
    }

    public List<Competencia> listarTodas() {
        return competenciaRepository.findAll();
    }

    public Competencia buscarPorId(Long id) {
        return competenciaRepository.findById(id)
                .orElseThrow(() -> new CompetenciaNaoEncontradaException(id));
    }

    @Transactional
    public Competencia criar(Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

    @Transactional
    public Competencia atualizar(Long id, Competencia dadosAtualizados) {
        Competencia existente = buscarPorId(id);
        existente.setNome(dadosAtualizados.getNome());
        existente.setCategoria(dadosAtualizados.getCategoria());
        existente.setDescricao(dadosAtualizados.getDescricao());
        return competenciaRepository.save(existente);
    }

    @Transactional
    public void remover(Long id) {
        Competencia comp = buscarPorId(id);
        competenciaRepository.delete(comp);
    }
}
