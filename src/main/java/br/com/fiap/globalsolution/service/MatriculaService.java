package br.com.fiap.globalsolution.service;

import br.com.fiap.globalsolution.exception.MatriculaNaoEncontradaException;
import br.com.fiap.globalsolution.exception.TrilhaNaoEncontradaException;
import br.com.fiap.globalsolution.exception.UsuarioNaoEncontradoException;
import br.com.fiap.globalsolution.model.Matricula;
import br.com.fiap.globalsolution.model.Trilha;
import br.com.fiap.globalsolution.model.Usuario;
import br.com.fiap.globalsolution.model.enums.StatusMatricula;
import br.com.fiap.globalsolution.repository.MatriculaRepository;
import br.com.fiap.globalsolution.repository.TrilhaRepository;
import br.com.fiap.globalsolution.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TrilhaRepository trilhaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository,
                            UsuarioRepository usuarioRepository,
                            TrilhaRepository trilhaRepository) {
        this.matriculaRepository = matriculaRepository;
        this.usuarioRepository = usuarioRepository;
        this.trilhaRepository = trilhaRepository;
    }

    public List<Matricula> listarTodas() {
        return matriculaRepository.findAll();
    }

    public Matricula buscarPorId(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new MatriculaNaoEncontradaException(id));
    }

    @Transactional
    public Matricula matricularUsuarioEmTrilha(Long usuarioId, Long trilhaId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
        Trilha trilha = trilhaRepository.findById(trilhaId)
                .orElseThrow(() -> new TrilhaNaoEncontradaException(trilhaId));

        Matricula matricula = new Matricula();
        matricula.setUsuario(usuario);
        matricula.setTrilha(trilha);
        matricula.setDataInscricao(LocalDate.now());
        matricula.setStatus(StatusMatricula.EM_ANDAMENTO);

        return matriculaRepository.save(matricula);
    }

    @Transactional
    public Matricula atualizarStatus(Long id, StatusMatricula status) {
        Matricula matricula = buscarPorId(id);
        matricula.setStatus(status);
        return matriculaRepository.save(matricula);
    }

    @Transactional
    public void remover(Long id) {
        Matricula matricula = buscarPorId(id);
        matriculaRepository.delete(matricula);
    }

    public List<Matricula> listarPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
        return matriculaRepository.findByUsuario(usuario);
    }

    public List<Matricula> listarPorTrilha(Long trilhaId) {
        Trilha trilha = trilhaRepository.findById(trilhaId)
                .orElseThrow(() -> new TrilhaNaoEncontradaException(trilhaId));
        return matriculaRepository.findByTrilha(trilha);
    }
}
