package questao9.model;

import java.time.LocalDate;

public class Produto {
	
	private Integer id;
	private String nome;
	private String descricao;
	private Double desconto;
	private LocalDate dataInicio;
	
	public Produto(String nome, String descricao, Double desconto) {
		this.nome = nome;
		this.descricao = descricao;
		this.desconto = desconto;
		this.dataInicio = LocalDate.now();
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", desconto=" + desconto
				+ ", dataInicio=" + dataInicio + "]";
	}
}
