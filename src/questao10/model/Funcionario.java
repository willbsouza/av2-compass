package questao10.model;

public class Funcionario {

	private Integer id;
	private String nome;
	private String sentimento;
	
	public Funcionario(String nome, String sentimento) {
		this.nome = nome;
		this.sentimento = sentimento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSentimento() {
		return sentimento;
	}

	public void setSentimento(String sentimento) {
		this.sentimento = sentimento;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", sentimento=" + sentimento + "]";
	}
}
