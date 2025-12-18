package br.com.maikonspo.mamiscomcarinho.core.entities.item;

import br.com.maikonspo.mamiscomcarinho.core.entities.pedido.Descricao;
import br.com.maikonspo.mamiscomcarinho.core.entities.produto.Produto;

import java.math.BigDecimal;

public class ItemPedido {

    private Long id;
    private Produto produto;
    private int quantidade;
    private BigDecimal precoUnitario;
    private Descricao descricao;

    public ItemPedido(Produto produto, int quantidade, BigDecimal precoUnitario, Descricao descricao) {
        validar(produto, quantidade, precoUnitario, descricao);
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.descricao = descricao;
    }

    public ItemPedido(Long id, Produto produto, int quantidade, BigDecimal precoUnitario, Descricao descricao) {
        if (id == null) throw new IllegalArgumentException("Id do item é obrigatório para reconstrução.");
        validar(produto, quantidade, precoUnitario, descricao);
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.descricao = descricao;
    }

    private static void validar(Produto produto, int quantidade, BigDecimal precoUnitario, Descricao descricao) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto é obrigatório.");
        }
        if (quantidade < 1) {
            throw new IllegalArgumentException("Quantidade deve ser maior ou igual a 1.");
        }
        if (precoUnitario == null || precoUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço unitário deve ser maior que zero.");
        }
        if (descricao == null) {
            throw new IllegalArgumentException("Descrição do item é obrigatória.");
        }
    }

    public Long getId() { return id; }
    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public BigDecimal getPrecoUnitario() { return precoUnitario; }
    public Descricao getDescricao() { return descricao; }

    public void setId(Long id) {
        if (id == null) throw new IllegalArgumentException("Id não pode ser nulo.");
        this.id = id;
    }

    public void setProduto(Produto produto) {
        if (produto == null) throw new IllegalArgumentException("Produto é obrigatório.");
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 1) throw new IllegalArgumentException("Quantidade deve ser maior ou igual a 1.");
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        if (precoUnitario == null || precoUnitario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço unitário deve ser maior que zero.");
        }
        this.precoUnitario = precoUnitario;
    }

    public void setDescricao(Descricao descricao) {
        if (descricao == null) throw new IllegalArgumentException("Descrição do item é obrigatória.");
        this.descricao = descricao;
    }
}
