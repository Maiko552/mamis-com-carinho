package br.com.maikonspo.mamiscomcarinho.core.usecases.pedido;

import br.com.maikonspo.mamiscomcarinho.core.entities.pedido.Pedido;
import br.com.maikonspo.mamiscomcarinho.core.gateway.PedidoRepository;

public class CancelarPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public CancelarPedidoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void executar(Long pedidoId) {
        Pedido pedido = pedidoRepository.buscarPorId(pedidoId)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        pedido.cancelar();
        pedidoRepository.salvar(pedido);
    }
}
