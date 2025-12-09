package br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DescricaoPersistence {

    @Column(name = "descricao_nome")
    private String nomeDescricao;

    @Column(name = "descricao_desenho")
    private String desenho;
}
