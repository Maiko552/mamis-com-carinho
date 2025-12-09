package br.com.maikonspo.mamiscomcarinho.core.entities.transacao;

import br.com.maikonspo.mamiscomcarinho.core.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagamento {

    private BigDecimal valorTotal;
    private int quantidadeParcelas;
    private BigDecimal valorPago;
    private LocalDate dataVencimento;
    private LocalDate dataUltimoPagamento;
    private StatusPagamento status;

    public Pagamento(BigDecimal valorTotal,
                     int quantidadeParcelas,
                     LocalDate dataVencimento) {

        if (valorTotal == null || valorTotal.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor total do pagamento deve ser maior que zero.");
        }
        if (quantidadeParcelas < 1 || quantidadeParcelas > 10) {
            throw new IllegalArgumentException("Quantidade de parcelas deve ser entre 1 e 10.");
        }
        if (dataVencimento == null) {
            throw new IllegalArgumentException("Data de vencimento é obrigatória.");
        }

        this.valorTotal = valorTotal;
        this.quantidadeParcelas = quantidadeParcelas;
        this.dataVencimento = dataVencimento;
        this.valorPago = BigDecimal.ZERO;
        this.status = StatusPagamento.PENDENTE;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public LocalDate getDataUltimoPagamento() {
        return dataUltimoPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }


}
