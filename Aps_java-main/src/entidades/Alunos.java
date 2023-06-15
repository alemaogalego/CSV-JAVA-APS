package entidades;

public class Alunos {

	private int id;
	private String nome;

	public Alunos(int aId, String aNome) {
		this.id = aId;
		this.nome = aNome.replaceAll(",", " ");
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Alunos [Id=" + id + ", Nome=" + nome + "]";
	}
}
