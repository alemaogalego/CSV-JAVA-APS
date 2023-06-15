package entidades;

public class Rendimento {

	private String Id;
	private String Nome;
	private String Nivel;
	private int Ano;
	private double NP1;
	private double NP2;
	private double Repocicao;
	private double Exame;
	private Rendimento(String id, String nome, String nivel, int ano, double nP1, double nP2, double repocicao,
			double exame) {
		super();
		Id = id;
		Nome = nome;
		Nivel = nivel;
		Ano = ano;
		NP1 = nP1;
		NP2 = nP2;
		Repocicao = repocicao;
		Exame = exame;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getNivel() {
		return Nivel;
	}
	public void setNivel(String nivel) {
		Nivel = nivel;
	}
	public int getAno() {
		return Ano;
	}
	public void setAno(int ano) {
		Ano = ano;
	}
	public double getNP1() {
		return NP1;
	}
	public void setNP1(double nP1) {
		NP1 = nP1;
	}
	public double getNP2() {
		return NP2;
	}
	public void setNP2(double nP2) {
		NP2 = nP2;
	}
	public double getRepocicao() {
		return Repocicao;
	}
	public void setRepocicao(double repocicao) {
		Repocicao = repocicao;
	}
	public double getExame() {
		return Exame;
	}
	public void setExame(double exame) {
		Exame = exame;
	}
	@Override
	public String toString() {
		return "Rendimento [Id=" + Id + ", Nome=" + Nome + ", Nivel=" + Nivel + ", Ano=" + Ano + ", NP1=" + NP1
				+ ", NP2=" + NP2 + ", Repocicao=" + Repocicao + ", Exame=" + Exame + "]";
	}


}
