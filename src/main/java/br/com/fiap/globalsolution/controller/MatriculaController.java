package br.com.fiap.globalsolution.controller;

import br.com.fiap.globalsolution.model.Matricula;
import br.com.fiap.globalsolution.model.enums.StatusMatricula;
import br.com.fiap.globalsolution.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public List<Matricula> listarTodas() {
        return matriculaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscarPorId(@PathVariable Long id) {
        Matricula matricula = matriculaService.buscarPorId(id);
        return ResponseEntity.ok(matricula);
    }

    @PostMapping
    public ResponseEntity<Matricula> matricular(@RequestParam Long usuarioId,
                                                @RequestParam Long trilhaId) {
        Matricula matricula = matriculaService.matricularUsuarioEmTrilha(usuarioId, trilhaId);
        return ResponseEntity.status(201).body(matricula);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Matricula> atualizarStatus(@PathVariable Long id,
                                                     @RequestParam StatusMatricula status) {
        Matricula matricula = matriculaService.atualizarStatus(id, status);
        return ResponseEntity.ok(matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        matriculaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Matricula> listarPorUsuario(@PathVariable Long usuarioId) {
        return matriculaService.listarPorUsuario(usuarioId);
    }

    @GetMapping("/trilha/{trilhaId}")
    public List<Matricula> listarPorTrilha(@PathVariable Long trilhaId) {
        return matriculaService.listarPorTrilha(trilhaId);
    }
}
