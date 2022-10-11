package com.rj.mercado.gestaoprodutos.repository;

import com.rj.mercado.gestaoprodutos.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository("produtoRepository")
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    @Modifying
    @Transactional
    @Query(value = "update Produto t set t.tipo = :tipo where t.produtoId = :id")
    void updateTipo(UUID id, String tipo);

    Produto findByTipo(String tipo);
}
