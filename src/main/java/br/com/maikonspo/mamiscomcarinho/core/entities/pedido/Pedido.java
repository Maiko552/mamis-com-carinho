package br.com.maikonspo.mamiscomcarinho.core.entities.pedido;



import br.com.maikonspo.mamiscomcarinho.core.entities.cliente.Cliente;
import br.com.maikonspo.mamiscomcarinho.core.entities.item.ItemPedido;
import br.com.maikonspo.mamiscomcarinho.core.entities.transacao.Pagamento;
import br.com.maikonspo.mamiscomcarinho.core.enums.StatusPedido;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {

    private Long id;
    private Cliente cliente;
    private final List<ItemPedido> itens = new ArrayList<>();
    private Instant dataPedido;
    private LocalDate dataEntrega;
    private StatusPedido status;
    private Pagamento pagamento;

    public Pedido(Cliente cliente,
                  List<ItemPedido> itens,
                  LocalDate dataEntrega) {

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente é obrigatório.");
        }
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Pedido deve ter pelo menos 1 item.");
        }

        this.cliente = cliente;
        this.itens.addAll(itens);
        this.dataPedido = Instant.now();
        this.dataEntrega = dataEntrega;
        this.status = StatusPedido.NOVO;

        BigDecimal total = calcularTotal();
        this.pagamento = new Pagamento(total, 1, dataEntrega != null ? dataEntrega : LocalDate.now());
    }

    public Pedido(Long id,
                  Cliente cliente,
                  List<ItemPedido> itens,
                  Instant dataPedido,
                  LocalDate dataEntrega,
                  StatusPedido status,
                  Pagamento pagamento) {

        if (id == null) throw new IllegalArgumentException("Id do pedido é obrigatório para reconstrução.");
        if (cliente == null) throw new IllegalArgumentException("Cliente é obrigatório.");
        if (itens == null || itens.isEmpty()) throw new IllegalArgumentException("Pedido deve ter pelo menos 1 item.");
        if (dataPedido == null) throw new IllegalArgumentException("Data do pedido é obrigatória.");
        if (status == null) throw new IllegalArgumentException("Status do pedido é obrigatório.");
        if (pagamento == null) throw new IllegalArgumentException("Pagamento é obrigatório.");

        this.id = id;
        this.cliente = cliente;
        this.itens.addAll(itens);
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.pagamento = pagamento;
    }

    private BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            total = total.add(item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }
        return total;
    }

    public BigDecimal getValorTotal() {
        return calcularTotal();
    }

    public Long getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return Collections.unmodifiableList(itens); }
    public Instant getDataPedido() { return dataPedido; }
    public LocalDate getDataEntrega() { return dataEntrega; }
    public StatusPedido getStatus() { return status; }
    public Pagamento getPagamento() { return pagamento; }

    public void setId(Long id) {
        if (id == null) throw new IllegalArgumentException("Id não pode ser nulo.");
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) throw new IllegalArgumentException("Cliente é obrigatório.");
        this.cliente = cliente;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setStatus(StatusPedido status) {
        if (status == null) throw new IllegalArgumentException("Status do pedido é obrigatório.");
        this.status = status;
    }

    public void setPagamento(Pagamento pagamento) {
        if (pagamento == null) throw new IllegalArgumentException("Pagamento é obrigatório.");
        this.pagamento = pagamento;
    }
}
