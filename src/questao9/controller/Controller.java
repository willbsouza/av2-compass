package questao9.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import questao9.connection.ConnectionFactory;
import questao9.dao.ProdutoDAO;
import questao9.model.Produto;
import questao9.util.ProdutoAleatorio;

public class Controller {

	Scanner scan = new Scanner(System.in);
	public void escolhaUsuario(Integer opcao) throws SQLException {
		ProdutoAleatorio aleatorio = new ProdutoAleatorio();
		switch (opcao) {
		case 1:
			System.out.println("\nDigite o nome do produto: ");
			String nome = scan.nextLine();
			System.out.println("Digite a descrição do produto: ");
			String descricao = scan.nextLine();
			System.out.println("Digite o desconto: ");
			Double desconto = scan.nextDouble();
			scan.nextLine();
			Produto produto = new Produto(nome, descricao, desconto);
			try (Connection conn = new ConnectionFactory().recuperarConexao()) {
				new ProdutoDAO(conn).salvar(produto);
				for(int i = 0; i < 3; i++) {
					new ProdutoDAO(conn).salvar(aleatorio.gerarProduto(new Random().nextInt(20)));
				}
			}
			break;
		case 2:
			System.out.print("\nDigite o ID do produto que deseja alterar: ");
			Integer id = scan.nextInt();
			scan.nextLine();
			System.out.println("Digite o nome do produto: ");
			String nomeAtualizar = scan.nextLine();
			System.out.println("Digite a descrição do produto: ");
			String descricaoAtualizar = scan.nextLine();
			System.out.println("Digite o desconto: ");
			Double descontoAtualizar = scan.nextDouble();
			scan.nextLine();
			Produto produtoAtualizar = new Produto(nomeAtualizar, descricaoAtualizar, descontoAtualizar);
			try (Connection conn = new ConnectionFactory().recuperarConexao()) {
				new ProdutoDAO(conn).atualizar(id, produtoAtualizar);
			}
			break;
		case 3:
			try (Connection conn = new ConnectionFactory().recuperarConexao()) {
				new ProdutoDAO(conn).listarTodos();
				System.out.print("Entre com o ID que você quer deletar: ");
				Integer idDelete = scan.nextInt();
				new ProdutoDAO(conn).deletar(idDelete);
			}
			break;
		case 4:
			System.out.print("Entre com o texto para pesquisar: ");
			String pesquisar = scan.nextLine();
			try (Connection conn = new ConnectionFactory().recuperarConexao()) {
				new ProdutoDAO(conn).listarPorDescricao(pesquisar);
			}
			break;
		default:
			break;
		}
	}
}
