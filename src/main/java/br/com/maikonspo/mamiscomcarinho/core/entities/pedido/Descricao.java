package br.com.maikonspo.mamiscomcarinho.core.entities.pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Descricao {

    private String nomeDescricao;
    private final List<Cores> cores = new ArrayList<>();
    private String desenho;

    public String getNomeDescricao() {
        return nomeDescricao;
    }
    public void setNomeDescricao(String nomeDescricao) {
        this.nomeDescricao = nomeDescricao;
    }
    public String getDesenho() {
        return desenho;
    }
    public void setDesenho(String desenho) {
        this.desenho = desenho;
    }
    public List<Cores> getCores() {
        return Collections.unmodifiableList(cores);
    }
    public void setCores(List<Cores> cores) {
        this.cores.clear();
        if (cores != null) {
            this.cores.addAll(cores);
        }
    }


    public void alterarCor(Cores novaCor) {
        this.cores.clear();
        if (novaCor != null) {
            this.cores.add(novaCor);
        }
    }

    public void alterarTudo(String novoNome, List<Cores> novasCores, String novoDesenho) {
        this.nomeDescricao = novoNome;
        setCores(novasCores);
        this.desenho = novoDesenho;
    }

    public void adicionarCor(Cores cor) {
        if (cor == null) return;
        if (!this.cores.contains(cor)) {
            this.cores.add(cor);
        }
    }

    public void removerCor(Cores cor) {
        if (cor == null) return;
        this.cores.remove(cor);
    }
}
