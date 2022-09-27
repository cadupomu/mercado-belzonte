package com.rj.mercado.gestaoprodutos.repository;

import com.rj.mercado.gestaoprodutos.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("produtoRepository")
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
