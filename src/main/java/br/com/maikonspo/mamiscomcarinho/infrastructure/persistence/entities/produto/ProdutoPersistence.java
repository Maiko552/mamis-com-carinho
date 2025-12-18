package br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities.produto;

import br.com.maikonspo.mamiscomcarinho.core.enums.CategoriaProduto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 120)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", nullable = false, length = 60)
    private CategoriaProduto categoria;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    @Column(name = "preco_base", nullable = false, precision = 19, scale = 2)
    private BigDecimal precoBase;

    @Column(name = "prazo_producao_dias", nullable = false)
    private Integer prazoProducaoDias;
}
