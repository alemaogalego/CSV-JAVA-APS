package entidades;

public class Cursos {

	private String nome;
	private String nivel;
	private int ano;
	private Cursos(String aNome, String aNivel, int aAno) {
		this.nome = aNome;
		this.nivel = aNivel;
		this.ano = aAno;
	}
	public String getNome() {
		return nome;
	}
	 String getNivel() {
		return nivel;
	}
	
	public int getAno() {
		return ano;
	}
	
	@Override
	public String toString() {
		return "Cursos [nome=" + nome + ", nivel=" + nivel + ", ano=" + ano + "]";
	}

}
