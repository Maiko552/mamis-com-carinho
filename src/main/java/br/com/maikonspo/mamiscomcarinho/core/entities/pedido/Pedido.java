package br.com.maikonspo.mamiscomcarinho.core.entities.pedido;


import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;


public class Pedido {
    private Long id;
    private String clienteNome;
    private String descricao;
    private Instant dataPedido = Instant.now();
    private LocalDate dataEntrega;
    private String status;
    private BigDecimal valor;

    public Pedido() {
    }

    public Pedido(Long id, String clienteNome, String descricao, Instant dataPedido, LocalDate dataEntrega, String status, BigDecimal valor) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.descricao = descricao;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.valor = valor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Instant getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Instant dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
