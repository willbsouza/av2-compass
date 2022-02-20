package questao9.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import questao9.model.Produto;

public class ProdutoDAO {

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private Connection conn;

	public ProdutoDAO(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Produto produto) {
		try {
			String sql = "INSERT INTO tb_produto(nome, descricao, desconto, data_inicio) VALUES" + "(?, ?, ?, ?)";
			try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				st.setString(1, produto.getNome());
				st.setString(2, produto.getDescricao());
				st.setDouble(3, produto.getDesconto());
				st.setString(4, produto.getDataInicio().format(dtf));
				st.execute();

				try (ResultSet rs = st.getGeneratedKeys()) {
					while (rs.next()) {
						produto.setId(rs.getInt(1));
						System.out.println("Id criado: " + rs.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException." + e.getMessage());
		}
	}

	public void listarPorDescricao(String descricao) {
		try {
			String sql = "SELECT * FROM tb_produto WHERE descricao LIKE '%" + descricao + "%'";
			try (PreparedStatement st = conn.prepareStatement(sql)) {
				st.execute();
				try (ResultSet rs = st.getResultSet()) {
					while (rs.next()) {
						System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | "
								+ rs.getDouble(4) + " | " + rs.getString(5));
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException." + e.getMessage());
		}
	}

	private Integer listarPorId(Integer id) {
		try {
			String sql = "SELECT * FROM tb_produto WHERE id = ?";
			try (PreparedStatement st = conn.prepareStatement(sql)) {
				st.setInt(1, id);
				st.execute();
				try (ResultSet rs = st.getResultSet()) {
					while (rs.next()) {
						if (rs.getInt(1) == id) {
							return 1;
						}
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException." + e.getMessage());
		}
		return 0;
	}

	public void listarTodos() {
		try {
			String sql = "SELECT * FROM tb_produto";
			try (PreparedStatement st = conn.prepareStatement(sql)) {
				st.execute();
				try (ResultSet rs = st.getResultSet()) {
					while (rs.next()) {
						System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | "
								+ rs.getDouble(4) + " | " + rs.getString(5));
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException." + e.getMessage());
		}
	}

	public void deletar(Integer id) {
		try {
			String sql = "DELETE FROM tb_produto WHERE id = ?";
			try (PreparedStatement st = conn.prepareStatement(sql)) {
				st.setInt(1, id);
				st.execute();
				Integer linhasAlteradas = st.getUpdateCount();
				if (linhasAlteradas >= 1) {
					System.out.println("Produto deletado com sucesso.");
				} else {
					System.out.println("ID inexistente. Nenhuma alteração realizada.");
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException." + e.getMessage());
		}
	}

	public void atualizar(Integer id, Produto produto) {
		try {
			if (listarPorId(id) == 1) {
				String sql = "UPDATE tb_produto SET nome = ?, descricao = ?, desconto = ?, data_inicio = ? WHERE id = ?";
				try (PreparedStatement st = conn.prepareStatement(sql)) {
					st.setString(1, produto.getNome());
					st.setString(2, produto.getDescricao());
					st.setDouble(3, produto.getDesconto());
					st.setString(4, produto.getDataInicio().format(dtf));
					st.setInt(5, id);
					st.execute();
				}
			} else {
				System.out.println("ID não encontrado. Será realizado a inserção de novo produto!");
				salvar(produto);
			}
		} catch (SQLException e) {
			System.out.println("SQLException." + e.getMessage());
		}
	}
}
