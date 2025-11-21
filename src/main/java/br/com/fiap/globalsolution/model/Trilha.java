package br.com.fiap.globalsolution.model;

import br.com.fiap.globalsolution.model.enums.NivelTrilha;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trilhas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da trilha é obrigatório")
    @Column(nullable = false, length = 150)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private NivelTrilha nivel;

    @Min(value = 1, message = "Carga horária deve ser positiva")
    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "foco_principal", length = 100)
    private String focoPrincipal;

    @ManyToMany
    @JoinTable(
            name = "trilha_competencia",
            joinColumns = @JoinColumn(name = "trilha_id"),
            inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    private Set<Competencia> competencias = new HashSet<>();
}
