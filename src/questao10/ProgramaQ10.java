package questao10;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import questao10.dao.FuncionarioDAO;
import questao10.model.Funcionario;
import questao10.util.Calculador;
import questao9.connection.ConnectionFactory;

public class ProgramaQ10 {

	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nome = scan.nextLine();
		System.out.println("Entre com uma mensagem expressando seu sentimento: ");
		String sentimento = new Calculador().avaliarSentimento(scan.nextLine());
		Funcionario funcionario = new Funcionario(nome, sentimento);
		try(Connection conn = new ConnectionFactory().recuperarConexao()){
			new FuncionarioDAO(conn).salvar(funcionario);
			new FuncionarioDAO(conn).totalSentimentos();
		}
		scan.close();
	}
}
