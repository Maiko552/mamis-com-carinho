package br.com.maikonspo.mamiscomcarinho.core.usecases.pedido;

import br.com.maikonspo.mamiscomcarinho.core.entities.pedido.Descricao;
import br.com.maikonspo.mamiscomcarinho.core.entities.pedido.Pedido;
import br.com.maikonspo.mamiscomcarinho.core.gateway.PedidoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CriarPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public CriarPedidoUseCase(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido executar(Comando comando) {
        if (comando == null) {
            throw new IllegalArgumentException("Comando não pode ser nulo.");
        }

        String clienteNome = comando.clienteNome();
        Descricao descricao = comando.descricao();
        LocalDate dataEntrega = comando.dataEntrega();
        BigDecimal valor = comando.valor();

        Pedido pedido = new Pedido(
                clienteNome,
                descricao,
                dataEntrega,
                valor
        );

        return pedidoRepository.salvar(pedido);
    }

    public record Comando(
            String clienteNome,
            Descricao descricao,
            LocalDate dataEntrega,
            BigDecimal valor
    ) {
    }
}
