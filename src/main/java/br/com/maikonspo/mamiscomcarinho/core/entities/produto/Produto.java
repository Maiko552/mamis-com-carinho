package br.com.maikonspo.mamiscomcarinho.core.entities.produto;

import br.com.maikonspo.mamiscomcarinho.core.enums.CategoriaProduto;

import java.math.BigDecimal;
import java.time.Duration;

public class Produto {

    private Long id;
    private String nome;
    private CategoriaProduto categoria;
    private boolean ativo;
    private BigDecimal precoBase;
    private Duration prazoProducaoEstimado;

    public Produto(String nome,
                   CategoriaProduto categoria,
                   BigDecimal precoBase,
                   Duration prazoProducaoEstimado) {

        validar(nome, categoria, precoBase, prazoProducaoEstimado);

        this.nome = nome;
        this.categoria = categoria;
        this.precoBase = precoBase;
        this.prazoProducaoEstimado = prazoProducaoEstimado;
        this.ativo = true;
    }

    public Produto(Long id,
                   String nome,
                   CategoriaProduto categoria,
                   BigDecimal precoBase,
                   Duration prazoProducaoEstimado,
                   boolean ativo) {

        if (id == null) {
            throw new IllegalArgumentException("Id do produto é obrigatório para reconstrução.");
        }
        validar(nome, categoria, precoBase, prazoProducaoEstimado);

        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.precoBase = precoBase;
        this.prazoProducaoEstimado = prazoProducaoEstimado;
        this.ativo = ativo;
    }

    private static void validar(String nome,
                                CategoriaProduto categoria,
                                BigDecimal precoBase,
                                Duration prazoProducaoEstimado) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório.");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria do produto é obrigatória.");
        }
        if (precoBase == null || precoBase.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço base deve ser maior que zero.");
        }
        if (prazoProducaoEstimado == null || prazoProducaoEstimado.isNegative() || prazoProducaoEstimado.isZero()) {
            throw new IllegalArgumentException("Prazo de produção estimado deve ser maior que zero.");
        }
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public CategoriaProduto getCategoria() { return categoria; }
    public boolean isAtivo() { return ativo; }
    public BigDecimal getPrecoBase() { return precoBase; }
    public Duration getPrazoProducaoEstimado() { return prazoProducaoEstimado; }

}
