package br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities.cliente;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "clientes",
        indexes = {
                @Index(name = "idx_clientes_telefone", columnList = "telefone")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientePersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 120)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 20, unique = true)
    private String telefone;

    @Column(name = "observacao", length = 500)
    private String observacao;
}
