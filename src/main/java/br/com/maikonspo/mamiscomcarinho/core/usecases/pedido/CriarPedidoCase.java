package br.com.maikonspo.mamiscomcarinho.core.usecases.pedido;

import br.com.maikonspo.mamiscomcarinho.core.entities.pedido.Pedido;

public interface CriarPedidoCase {
    public Pedido execute(Pedido pedido);
}
