package br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities;

import br.com.maikonspo.mamiscomcarinho.core.enums.Cores;
import br.com.maikonspo.mamiscomcarinho.core.enums.StatusPedido;
import br.com.maikonspo.mamiscomcarinho.core.entities.transacao.Pagamento;
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

    private String clienteNome;

    @Embedded
    private DescricaoPersistence descricao;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "pedido_cores",
            joinColumns = @JoinColumn(name = "pedido_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "cor")
    private List<Cores> cores = new ArrayList<>();

    private Instant dataPedido;
    private LocalDate dataEntrega;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private BigDecimal valor;

    private Pagamento pagamento;
}
