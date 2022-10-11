package com.rj.mercado.gestaoprodutos.app.controller;

import com.rj.mercado.gestaoprodutos.domain.model.Produto;
import com.rj.mercado.gestaoprodutos.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = "almoxarife")
@Tag(name = "Almoxarifado Produto Controller", description = "Controladora dos produtos do Mercado Belzonte")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping(value = "/produto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cadastra um produto", responses = {@ApiResponse(description = "Sucesso ao cadastrar", responseCode = "201", content = @Content)})
    ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.save(produto), CREATED);
    }

    @GetMapping(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lista de produtos", responses = {@ApiResponse(description = "Sucesso ao listar todos os produtos", responseCode = "200", content = @Content)})
    ResponseEntity<List<Produto>> findAll() {
        return new ResponseEntity<>(produtoService.findAll(), OK);
    }

    @GetMapping(value = "/produto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Localiza algum produto pelo ID", responses = {@ApiResponse(description = "Sucesso ao consultar o produto", responseCode = "200", content = @Content)})
    ResponseEntity<Produto> findById(@PathVariable UUID id) {
        return new ResponseEntity<>(produtoService.findById(id), OK);
    }

    @PutMapping(value = "/produto", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualiza um produto", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "201", content = @Content)})
    ResponseEntity<?> update(@RequestBody Produto produto) {
        produtoService.save(produto);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PatchMapping(value = "/produto")
    @Operation(summary = "atualiza um produto", responses = {@ApiResponse(description = "Sucesso ao atualizar", responseCode = "204")})
    ResponseEntity<?> updateTipo(@RequestParam UUID id, @RequestParam String tipo) {
        produtoService.update(id, tipo);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @DeleteMapping(value = "/produto/{id}")
    @Operation(summary = "Exclui um produto pelo ID", responses = {@ApiResponse(description = "Sucesso ao apagar o produto", responseCode = "204")})
    ResponseEntity<?> deleteById(@PathVariable UUID id) {
        produtoService.deleteById(id);
        return new ResponseEntity<>(NO_CONTENT);
    }
}
