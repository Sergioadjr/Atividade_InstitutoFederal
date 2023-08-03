package com.institutoFederal.Atividade;

import com.institutoFederal.Atividade.joia.Joia;
import com.institutoFederal.Atividade.tipo.Tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtividadeApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Joia> joias = new ArrayList<>();

		int opcao;
		do {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Realizar busca de joia");
			System.out.println("3 - Sair");

			opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					Joia joia = Joia.cadastrarProduto(scanner);
					joias.add(joia);
					System.out.println("Produto cadastrado com sucesso!");
					break;
				case 2:
					if (joias.isEmpty()) {
						System.out.println("Nenhuma joia cadastrada. A busca não é possível.");
					} else {
						System.out.print("Digite o tipo de jóia que deseja buscar (ANEL, COLAR ou BRINCO): ");
						Tipo tipoBusca = Tipo.valueOf(scanner.next().toUpperCase());
						Joia.buscarPorTipo(joias, tipoBusca);
					}
					break;
				case 3:
					System.out.println("Encerrando o programa...");
					break;
				default:
					System.out.println("Opção inválida. Digite novamente.");
			}
		} while (opcao != 3);

		scanner.close();
	}
}
