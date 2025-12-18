package br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities.item;

import br.com.maikonspo.mamiscomcarinho.core.enums.Cores;
import br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities.pedido.DescricaoPersistence;
import br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities.pedido.PedidoPersistence;
import br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities.produto.ProdutoPersistence;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido_itens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemPedidoPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pedido_id", nullable = false)
    private PedidoPersistence pedido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutoPersistence produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unitario", nullable = false, precision = 19, scale = 2)
    private BigDecimal precoUnitario;

    @Embedded
    private DescricaoPersistence descricao;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "pedido_item_cores",
            joinColumns = @JoinColumn(name = "item_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "cor", nullable = false, length = 30)
    private List<Cores> cores = new ArrayList<>();
}
