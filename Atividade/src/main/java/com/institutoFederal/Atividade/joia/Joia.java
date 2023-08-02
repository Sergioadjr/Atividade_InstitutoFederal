package com.institutoFederal.Atividade.joia;

import com.institutoFederal.Atividade.tipo.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Joia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double valor;
    private double peso;
    private int quantidadeEmEstoque;
    private String materialPrincipal;
    private Tipo tipo;

    public Joia(double valor, double peso, int quantidadeEmEstoque, String materialPrincipal, Tipo tipo){
        this.valor=valor;
        this.peso=peso;
        this.quantidadeEmEstoque= quantidadeEmEstoque;
        this.materialPrincipal= materialPrincipal;
        this.tipo= tipo;
    }
}

