package br.com.fiap.globalsolution.model;

import br.com.fiap.globalsolution.model.enums.StatusMatricula;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Usuário é obrigatório")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotNull(message = "Trilha é obrigatória")
    @ManyToOne
    @JoinColumn(name = "trilha_id", nullable = false)
    private Trilha trilha;

    @PastOrPresent
    @Column(name = "data_inscricao", nullable = false)
    private LocalDate dataInscricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private StatusMatricula status;

    @PrePersist
    public void prePersist() {
        if (dataInscricao == null) {
            dataInscricao = LocalDate.now();
        }
        if (status == null) {
            status = StatusMatricula.EM_ANDAMENTO;
        }
    }
}
