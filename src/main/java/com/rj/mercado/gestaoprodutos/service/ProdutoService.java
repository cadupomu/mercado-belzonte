package com.rj.mercado.gestaoprodutos.service;

import com.rj.mercado.gestaoprodutos.domain.model.Produto;
import com.rj.mercado.gestaoprodutos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(UUID id) {
        return produtoRepository.findById(id).orElse(new Produto());
    }

    public void deleteById(UUID id) {
        produtoRepository.deleteById(id);
    }

    public void update(UUID id, String tipo) {
        produtoRepository.updateTipo(id, tipo);
    }

    public Produto findByTipo(String tipo) {
        return produtoRepository.findByTipo(tipo);
    }
}
