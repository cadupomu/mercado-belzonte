package com.rj.mercado.gestaoprodutos.domain.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

@Entity
@Table(name = "produto")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID produtoId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private Double preco;

    @ElementCollection
    @CollectionTable(
            name = "fornecedores",
            joinColumns =
            @JoinColumn(
                    name = "produto_id",
                    foreignKey =
                    @ForeignKey(
                            name = "fkey_produto_id"
                    )
            )
    )
    @Column(name = "fornecedores")
    private List<String> fornecedores;

    @Column(nullable = false)
    @jdk.jfr.Timestamp
    private Timestamp created_at;
}
