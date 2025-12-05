package br.com.maikonspo.mamiscomcarinho.core.entities.pedido;

import br.com.maikonspo.mamiscomcarinho.core.entities.transacao.Pagamento;

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


    public void cancelar() {
        if (this.status == StatusPedido.ENTREGUE) {
            throw new IllegalStateException("Não é possível cancelar um pedido já entregue.");
        }
        this.status = StatusPedido.CANCELADO;
    }

    public void marcarComoEntregue() {
        if (this.status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("Não é possível entregar um pedido cancelado.");
        }
        this.status = StatusPedido.ENTREGUE;
    }

    public void iniciarProducao() {
        if (this.status != StatusPedido.NOVO) {
            throw new IllegalStateException("Só é possível iniciar produção de pedidos novos.");
        }
        this.status = StatusPedido.EM_ANDAMENTO;
    }

    public void reagendarEntrega(LocalDate novaDataEntrega) {
        if (novaDataEntrega.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Nova data de entrega não pode ser no passado.");
        }
        if (this.status == StatusPedido.ENTREGUE || this.status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("Não é possível reagendar um pedido já finalizado.");
        }
        this.dataEntrega = novaDataEntrega;
    }

    public void atualizarValor(BigDecimal novoValor) {
        if (novoValor == null || novoValor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor do pedido não pode ser negativo.");
        }
        this.valor = novoValor;
    }

    public void aplicarDescontoPercentual(BigDecimal percentual) {
        if (percentual == null ||
                percentual.compareTo(BigDecimal.ZERO) < 0 ||
                percentual.compareTo(new BigDecimal("100")) > 0) {
            throw new IllegalArgumentException("Percentual de desconto deve estar entre 0 e 100.");
        }

        BigDecimal fator = BigDecimal.ONE.subtract(
                percentual.divide(new BigDecimal("100"))
        );
        this.valor = this.valor.multiply(fator);
    }

    public boolean isAtrasado() {
        return this.status != StatusPedido.ENTREGUE
                && this.dataEntrega != null
                && this.dataEntrega.isBefore(LocalDate.now());
    }

    public void configurarParcelamento(int quantidadeParcelas, LocalDate dataVencimento) {
        if (this.status != StatusPedido.NOVO) {
            throw new IllegalStateException("Só é possível configurar parcelamento para pedidos novos.");
        }
        this.pagamento = new Pagamento(this.valor, quantidadeParcelas, dataVencimento);
    }

    public void registrarPagamento(BigDecimal valorPago, LocalDate dataPagamento) {
        this.pagamento.registrarPagamento(valorPago, dataPagamento);
    }

    public boolean isInadimplente() {
        return this.pagamento != null && this.pagamento.isInadimplente();
    }
}
