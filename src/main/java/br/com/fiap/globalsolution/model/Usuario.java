package br.com.fiap.globalsolution.model;

import br.com.fiap.globalsolution.model.enums.NivelCarreira;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "area_atuacao", length = 100)
    private String areaAtuacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_carreira", length = 50)
    private NivelCarreira nivelCarreira;

    @PastOrPresent
    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist() {
        if (dataCadastro == null) {
            dataCadastro = LocalDate.now();
        }
    }
}
