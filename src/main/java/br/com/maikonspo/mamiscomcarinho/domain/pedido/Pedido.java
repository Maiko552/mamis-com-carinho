package br.com.maikonspo.mamiscomcarinho.domain.pedido;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq_gen")
    @SequenceGenerator(name = "pedido_seq_gen", sequenceName = "pedido_seq", allocationSize = 1)
    private Long id;

    @Column(name = "cliente_nome", nullable = false)
    private String clienteNome;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "data_pedido", nullable = false)
    private Instant dataPedido = Instant.now();

    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private BigDecimal valor;

}
