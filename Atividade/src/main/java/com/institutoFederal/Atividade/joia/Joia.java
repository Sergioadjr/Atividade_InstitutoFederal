package com.institutoFederal.Atividade.joia;

import java.util.List;
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

    public Joia(double valor, double peso, int quantidadeEmEstoque, String materialPrincipal, Tipo tipo) {
        this.valor = valor;
        this.peso = peso;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.materialPrincipal = materialPrincipal;
        this.tipo = tipo;
    }

    public static Joia cadastrarProduto(Scanner scanner) {
        System.out.println("Cadastrar Produto");
        System.out.print("Digite o tipo de jóia que deseja cadastrar (ANEL, COLAR ou BRINCO): ");
        Tipo tipo = Tipo.valueOf(scanner.next().toUpperCase());
        System.out.print("Digite o valor da jóia: R$ ");
        double valor = scanner.nextDouble();
        System.out.print("Digite o peso da jóia que será cadastrada (em gramas): ");
        double peso = scanner.nextDouble();
        System.out.print("Digite o material principal da jóia: ");
        String materialPrincipal = scanner.next();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidadeEmEstoque = scanner.nextInt();
        return new Joia(valor, peso, quantidadeEmEstoque, materialPrincipal, tipo);
    }

    public static void buscarPorTipo(List<Joia> joias, Tipo tipo) {
        System.out.println("Buscando por joias do tipo: " + tipo);

        boolean buscaRealizada = false;
        for (Joia joia : joias) {
            if (joia.getTipo() == tipo) {
                System.out.println("Tipo: " + joia.getTipo());
                System.out.println("Valor: R$ " + joia.getValor());
                System.out.println("Peso: " + joia.getPeso() + " gramas");
                System.out.println("Material Principal: " + joia.getMaterialPrincipal());
                System.out.println("Quantidade em Estoque: " + joia.getQuantidadeEmEstoque());
                buscaRealizada = true;
            }
        }

        if (!buscaRealizada) {
            System.out.println("Nenhuma joia do tipo " + tipo + " foi encontrada.");
        }
    }

    public static Tipo tipoComMaiorValor(List<Joia> joias) {
        Tipo tipoMaiorValor = null;
        double maiorValor = Double.MIN_VALUE;

        for (Joia joia : joias) {
            if (joia.getValor() > maiorValor) {
                maiorValor = joia.getValor();
                tipoMaiorValor = joia.getTipo();
            }
        }

        return tipoMaiorValor;
    }
}
