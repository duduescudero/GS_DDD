package br.com.fiap.globalsolution.controller;

import br.com.fiap.globalsolution.model.Competencia;
import br.com.fiap.globalsolution.service.CompetenciaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/competencias")
public class CompetenciaController {

    private final CompetenciaService competenciaService;

    public CompetenciaController(CompetenciaService competenciaService) {
        this.competenciaService = competenciaService;
    }

    @GetMapping
    public List<Competencia> listarTodas() {
        return competenciaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> buscarPorId(@PathVariable Long id) {
        Competencia competencia = competenciaService.buscarPorId(id);
        return ResponseEntity.ok(competencia);
    }

    @PostMapping
    public ResponseEntity<Competencia> criar(@Valid @RequestBody Competencia competencia,
                                             UriComponentsBuilder uriBuilder) {
        Competencia criada = competenciaService.criar(competencia);
        URI uri = uriBuilder.path("/api/competencias/{id}")
                .buildAndExpand(criada.getId()).toUri();
        return ResponseEntity.created(uri).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competencia> atualizar(@PathVariable Long id,
                                                 @Valid @RequestBody Competencia competencia) {
        Competencia atualizada = competenciaService.atualizar(id, competencia);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        competenciaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
