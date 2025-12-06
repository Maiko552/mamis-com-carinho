package br.com.maikonspo.mamiscomcarinho.core.entities.pedido;

import br.com.maikonspo.mamiscomcarinho.core.entities.transacao.Pagamento;
import br.com.maikonspo.mamiscomcarinho.core.enums.StatusPedido;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class Pedido {

    private Long id;
    private String clienteNome;
    private Descricao descricao;
    private Instant dataPedido;
    private LocalDate dataEntrega;
    private StatusPedido status;
    private BigDecimal valor;
    private Pagamento pagamento;

    public Pedido(String clienteNome,
                  Descricao descricao,
                  LocalDate dataEntrega,
                  BigDecimal valor) {

        if (clienteNome == null || clienteNome.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório.");
        }
        if (descricao == null) {
            throw new IllegalArgumentException("Descrição do pedido é obrigatória.");
        }
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor do pedido deve ser maior que zero.");
        }

        this.clienteNome = clienteNome;
        this.descricao = descricao;
        this.dataPedido = Instant.now();
        this.dataEntrega = dataEntrega;
        this.status = StatusPedido.NOVO;
        this.valor = valor;
        this.pagamento = new Pagamento(valor, 1, dataEntrega != null ? dataEntrega : LocalDate.now());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public Instant getDataPedido() {
        return dataPedido;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor do pedido não pode ser negativo.");
        }
        this.valor = valor;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

}
