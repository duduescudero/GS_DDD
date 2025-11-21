package br.com.fiap.globalsolution.repository;

import br.com.fiap.globalsolution.model.Matricula;
import br.com.fiap.globalsolution.model.Usuario;
import br.com.fiap.globalsolution.model.Trilha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    List<Matricula> findByUsuario(Usuario usuario);
    List<Matricula> findByTrilha(Trilha trilha);
}
