package br.com.fiap.globalsolution.controller;

import br.com.fiap.globalsolution.model.Trilha;
import br.com.fiap.globalsolution.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {

    private final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }

    @GetMapping
    public List<Trilha> listarTodas() {
        return trilhaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> buscarPorId(@PathVariable Long id) {
        Trilha trilha = trilhaService.buscarPorId(id);
        return ResponseEntity.ok(trilha);
    }

    @PostMapping
    public ResponseEntity<Trilha> criar(@Valid @RequestBody Trilha trilha,
                                        UriComponentsBuilder uriBuilder) {
        Trilha criada = trilhaService.criar(trilha);
        URI uri = uriBuilder.path("/api/trilhas/{id}")
                .buildAndExpand(criada.getId()).toUri();
        return ResponseEntity.created(uri).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trilha> atualizar(@PathVariable Long id,
                                            @Valid @RequestBody Trilha trilha) {
        Trilha atualizada = trilhaService.atualizar(id, trilha);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        trilhaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idTrilha}/competencias/{idCompetencia}")
    public ResponseEntity<Trilha> adicionarCompetencia(@PathVariable Long idTrilha,
                                                       @PathVariable Long idCompetencia) {
        Trilha trilha = trilhaService.adicionarCompetencia(idTrilha, idCompetencia);
        return ResponseEntity.ok(trilha);
    }
}
