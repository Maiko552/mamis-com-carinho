package br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities;

import br.com.maikonspo.mamiscomcarinho.core.enums.Cores;
import br.com.maikonspo.mamiscomcarinho.core.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoPersistence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "cliente_nome", nullable = false)
    private String clienteNome;

    @Embedded
    private DescricaoPersistence descricao;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "pedido_cores",
            joinColumns = @JoinColumn(name = "pedido_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "cor")
    private List<Cores> cores = new ArrayList<>();

    @Column(name = "data_pedido", nullable = false)
    private Instant dataPedido;

    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido status;

    @Column(name = "valor", nullable = false, precision = 19, scale = 2)
    private BigDecimal valor;

    @Embedded
    private PagamentoPersistence pagamento;
}