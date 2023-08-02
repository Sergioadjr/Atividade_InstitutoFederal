package com.institutoFederal.Atividade.joia;

import java.util.Scanner;

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

    // Construtor:
    public Joia(double valor, double peso, int quantidadeEmEstoque, String materialPrincipal, Tipo tipo) {
        this.valor = valor;
        this.peso = peso;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.materialPrincipal = materialPrincipal;
        this.tipo = tipo;
    }

    private static void cadastrarProduto(Scanner scanner) {
        System.out.println("Cadastrar Produto");
        System.out.print("Digite o tipo de jóia que deseja cadastrar: ");
        Tipo tipo = Tipo.valueOf(scanner.next().toUpperCase());
        System.out.print("Digite o valor da jóia: R$ ");
        double valor = scanner.nextDouble();
        System.out.print("Digite o peso da jóia que será cadastrada (em gramas): ");
        double peso = scanner.nextDouble();
        System.out.print("Digite o material principal da jóia: ");
        String materialPrincipal = scanner.next();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidadeEmEstoque = scanner.nextInt();
        Joia joia = new Joia(valor, peso, quantidadeEmEstoque, materialPrincipal, tipo);
        System.out.println("Produto cadastrado com sucesso!");
    }

}
