package br.com.fiap.globalsolution.service;

import br.com.fiap.globalsolution.exception.CompetenciaNaoEncontradaException;
import br.com.fiap.globalsolution.exception.TrilhaNaoEncontradaException;
import br.com.fiap.globalsolution.model.Competencia;
import br.com.fiap.globalsolution.model.Trilha;
import br.com.fiap.globalsolution.repository.CompetenciaRepository;
import br.com.fiap.globalsolution.repository.TrilhaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository trilhaRepository;
    private final CompetenciaRepository competenciaRepository;

    public TrilhaService(TrilhaRepository trilhaRepository,
                         CompetenciaRepository competenciaRepository) {
        this.trilhaRepository = trilhaRepository;
        this.competenciaRepository = competenciaRepository;
    }

    public List<Trilha> listarTodas() {
        return trilhaRepository.findAll();
    }

    public Trilha buscarPorId(Long id) {
        return trilhaRepository.findById(id)
                .orElseThrow(() -> new TrilhaNaoEncontradaException(id));
    }

    @Transactional
    public Trilha criar(Trilha trilha) {
        return trilhaRepository.save(trilha);
    }

    @Transactional
    public Trilha atualizar(Long id, Trilha dadosAtualizados) {
        Trilha existente = buscarPorId(id);

        existente.setNome(dadosAtualizados.getNome());
        existente.setDescricao(dadosAtualizados.getDescricao());
        existente.setNivel(dadosAtualizados.getNivel());
        existente.setCargaHoraria(dadosAtualizados.getCargaHoraria());
        existente.setFocoPrincipal(dadosAtualizados.getFocoPrincipal());
        existente.setCompetencias(dadosAtualizados.getCompetencias());

        return trilhaRepository.save(existente);
    }

    @Transactional
    public void remover(Long id) {
        Trilha trilha = buscarPorId(id);
        trilhaRepository.delete(trilha);
    }

    @Transactional
    public Trilha adicionarCompetencia(Long idTrilha, Long idCompetencia) {
        Trilha trilha = buscarPorId(idTrilha);
        Competencia comp = competenciaRepository.findById(idCompetencia)
                .orElseThrow(() -> new CompetenciaNaoEncontradaException(idCompetencia));
        trilha.getCompetencias().add(comp);
        return trilhaRepository.save(trilha);
    }
}
