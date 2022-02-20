package questao9;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import questao9.controller.Controller;

public class ProgramaQ9 {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		Integer opcao;
		try {
			do {
				System.out.println("\n1 - PARA CADASTRAR OFERTAS;");
				System.out.println("2 - PARA ATUALIZAR UMA OFERTA;");
				System.out.println("3 - PARA EXCLUIR UMA OFERTA;");
				System.out.println("4 - PARA LISTAR OFERTAS;");
				System.out.println("0 - SAIR.");
				System.out.print("Escolha uma opção válida: ");

				opcao = scan.nextInt();

				scan.nextLine();
				if (opcao == 1 || opcao == 2 || opcao == 3 || opcao == 4) {
					new Controller().escolhaUsuario(opcao);
					;
				}
			} while (opcao != 0);
		} catch (InputMismatchException e) {
			System.out.println("Erro: InputMismatchException. Opção inválida. " + e.getMessage());
		} finally {
			scan.close();
		}
	}
}
