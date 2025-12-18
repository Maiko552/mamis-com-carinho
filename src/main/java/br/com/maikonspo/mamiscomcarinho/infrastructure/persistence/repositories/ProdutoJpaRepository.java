package br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.repositories;


import br.com.maikonspo.mamiscomcarinho.infrastructure.persistence.entities.produto.ProdutoPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoJpaRepository extends JpaRepository<ProdutoPersistence, Long> {

}
