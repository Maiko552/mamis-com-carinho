package br.com.maikonspo.mamiscomcarinho.core.gateway;

import br.com.maikonspo.mamiscomcarinho.core.entities.pedido.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {
    Pedido salvar(Pedido pedido);
    Optional<Pedido> buscarPorId(Long id);
    List<Pedido> listarTodos();
    void deletarPorId(Long id);
}
