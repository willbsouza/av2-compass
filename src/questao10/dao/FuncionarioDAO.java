package questao10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import questao10.model.Funcionario;

public class FuncionarioDAO {

	private Connection conn;

	public FuncionarioDAO(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Funcionario funcionario) {
		try {
			String sql = "INSERT INTO tb_funcionario (nome, sentimento) VALUES (?, ?)";
			try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				st.setString(1, funcionario.getNome());
				st.setString(2, funcionario.getSentimento());
				st.execute();
				try (ResultSet rs = st.getGeneratedKeys()) {
					while (rs.next()) {
						funcionario.setId(rs.getInt(1));
						listarPorId(rs.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException." + e.getMessage());
		}
	}

	public void totalSentimentos() {
		try {
			String sql = "SELECT * FROM tb_funcionario";
			Integer divertido = 0, chateado = 0, neutro = 0;
			try (PreparedStatement st = conn.prepareStatement(sql)) {
				st.execute();
				try (ResultSet rs = st.getResultSet()) {
					while (rs.next()) {
						if (rs.getString(3).equals("divertido")) {
							divertido++;
						} else if (rs.getString(3).equals("chateado")) {
							chateado++;
						} else {
							neutro++;
						}
					}
				}
			}
			System.out.println("Total resposta divertido: " + divertido);
			System.out.println("Total resposta chateado: " + chateado);
			System.out.println("Total resposta neutro: " + neutro);
		} catch (SQLException e) {
			System.out.println("SQLException." + e.getMessage());
		}
	}

	private void listarPorId(Integer id) {
		try {
			String sql = "SELECT * FROM tb_funcionario WHERE id = ?";
			try (PreparedStatement st = conn.prepareStatement(sql)) {
				st.setInt(1, id);
				st.execute();
				try (ResultSet rs = st.getResultSet()) {
					while (rs.next()) {
						System.out.println("Id: " + rs.getInt(1) + " | Nome: " + rs.getString(2) + " | Sentimento: "
								+ rs.getString(3));
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException." + e.getMessage());
		}
	}
}
