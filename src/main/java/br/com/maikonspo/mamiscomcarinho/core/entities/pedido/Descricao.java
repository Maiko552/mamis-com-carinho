package br.com.maikonspo.mamiscomcarinho.core.entities.pedido;

import br.com.maikonspo.mamiscomcarinho.core.enums.Cores;

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


}
