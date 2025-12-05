package br.com.maikonspo.mamiscomcarinho.core.usecases.pedido;

import br.com.maikonspo.mamiscomcarinho.core.entities.pedido.Pedido;
import br.com.maikonspo.mamiscomcarinho.core.gateway.PedidoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistrarPagamentoUseCase {
    private final PedidoRepository pedidoRepository;

    public RegistrarPagamentoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido executar(Long pedidoId, BigDecimal valorPago, LocalDate dataPagamento) {
        if (pedidoId == null) {
            throw new IllegalArgumentException("Id do pedido é obrigatório.");
        }
        if (valorPago == null || valorPago.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor do pagamento deve ser maior que zero.");
        }
        if (dataPagamento == null) {
            throw new IllegalArgumentException("Data de pagamento é obrigatória.");
        }

        Pedido pedido = pedidoRepository.buscarPorId(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado."));
        pedido.registrarPagamento(valorPago, dataPagamento);
        return pedidoRepository.salvar(pedido);
    }
}
