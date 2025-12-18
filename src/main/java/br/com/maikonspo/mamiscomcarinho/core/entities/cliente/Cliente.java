package br.com.maikonspo.mamiscomcarinho.core.entities.cliente;

public class Cliente {
    private Long id;
    private String nome;
    private String telefone;
    private String observacao;

    public Cliente(String nome, String telefone, String observacao) {
        validar(nome, telefone);
        this.nome = nome;
        this.telefone = normalizarTelefone(telefone);
        this.observacao = observacao;
    }

    public Cliente(Long id, String nome, String telefone, String observacao) {
        if (id == null) {
            throw new IllegalArgumentException("Id do cliente é obrigatório para reconstrução.");
        }
        validar(nome, telefone);
        this.id = id;
        this.nome = nome;
        this.telefone = normalizarTelefone(telefone);
        this.observacao = observacao;
    }

    private static void validar(String nome, String telefone) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório.");
        }
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone do cliente é obrigatório.");
        }
    }

    private static String normalizarTelefone(String telefone) {
        String somenteDigitos = telefone.replaceAll("\\D", "");
        if (somenteDigitos.isBlank()) {
            throw new IllegalArgumentException("Telefone do cliente inválido.");
        }
        if (somenteDigitos.length() < 10) {
            throw new IllegalArgumentException("Telefone do cliente inválido.");
        }

        return somenteDigitos;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getObservacao() { return observacao; }

    public void setId(Long id) {
        if (id == null) throw new IllegalArgumentException("Id não pode ser nulo.");
        this.id = id;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório.");
        }
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone do cliente é obrigatório.");
        }

        this.telefone = normalizarTelefone(telefone);
    }


    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
