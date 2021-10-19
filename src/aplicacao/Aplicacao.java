/*
* <União Metropolitana de Educação e Cultura>
* <Bacharelado em Sistemas de Informação>
* <Programação Orientada a Objetos II>
* <Prof. Pablo Ricardo Roxo Silva>
* <Iago da Conceição Barbosa>
*/

package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

		boolean encerrar = false;
		while (!encerrar) {
			System.out.println("====== MENU ======\r\n" + "1 - Cadastrar funcionário\r\n"
					+ "2 - Listar funcionários\r\n"
					+ "3 - Pesquisar funcionário\r\n"
					+ "4 - Encerrar\n");

			System.out.println("Informe a opção desejada:");
			
			String nome;
			int idade;
			String departamento;
			int opcao = sc.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("Favor,informe o nome do Funcionário:");
				nome = sc.next() + "\r\n";
				System.out.println("Favor,informe a idade do Funcionário:");
				idade = sc.nextInt();
				System.out.println();
				System.out.println("Favor,informe o departamento do Funcionário:");
				departamento = sc.next();
				
				Funcionario funcionario = new Funcionario(nome, idade, departamento);
				listaFuncionarios.add(funcionario);
				break;

			case 2:
				System.out.println("Essa é a lista de funcionarios:");

				for (Funcionario fun : listaFuncionarios) {
					System.out.println(fun);
				}
				break;

			case 3:
				System.out.println("Informe o nome do funcionário que deseja perquisar:");
				nome = sc.next() + "\r\n";
				funcionario = new Funcionario();
				funcionario.setNome(nome);
				
				if (listaFuncionarios.contains(funcionario)) {
					System.out.println(nome + " está na lista!");
					System.out.println("====== MENU ======\r\n" + "1 - Deseja editar\r\n"
							+ "2 - Deseja excluir\r\n");
					
					System.out.println("Informe a opção desejada:");
					
					opcao = sc.nextInt();
					if (opcao == 1) {
						listaFuncionarios.remove(funcionario);

						System.out.println("Favor,informe o novo nome do Funcionário:");
						nome = sc.next() + "\r\n";
						System.out.println("Favor,informe a nova idade do Funcionário:");
						idade = sc.nextInt();
						System.out.println();
						System.out.println("Favor,informe o novo departamento do Funcionário:");
						departamento = sc.next();
						
						funcionario = new Funcionario(nome, idade, departamento);
						listaFuncionarios.add(funcionario);
						
					}
					else if (opcao == 2){
						listaFuncionarios.remove(funcionario);
					}
					else {
						System.out.println("Opção incorreta!\r\n");
					}
				} else {
					System.out.println(nome + " não está na lista!");
				}		
				break;

			case 4:
				System.out.println("Programa encerrado!");
				encerrar = true;

			default:
				System.out.println("Opção incorreta!\r\n");
			}
		}
		sc.close();
	}

}
