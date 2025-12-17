package br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities;

import br.com.maikonspo.mamiscomcarinho.core.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PagamentoPersistence {

    @Column(name = "pag_valor_total", precision = 19, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "pag_qtd_parcelas")
    private int quantidadeParcelas;

    @Column(name = "pag_valor_pago", precision = 19, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "pag_data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "pag_data_ultimo_pagamento")
    private LocalDate dataUltimoPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "pag_status")
    private StatusPagamento status;
}
