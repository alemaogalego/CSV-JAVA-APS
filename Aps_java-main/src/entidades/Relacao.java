package entidades;

public class Relacao {
	private int id_Relacao;
	private int id_Aluno_fk;
	private int id_Curso_fk;
	private double Np1;
	private double Np2;
	private double Reposicao;
	private double Exame;

	public Relacao(int AId2, int aId_aluno, int aId_curso, double aNp1, double aNp2, double aReposicao, double aExame) {
		this.id_Relacao = AId2;
		this.id_Aluno_fk = aId_aluno;
		this.id_Curso_fk = aId_curso;
		this.Np1 = aNp1;
		this.Np2 = aNp2;
		this.Reposicao = aReposicao;
		this.Exame = aExame;
	}

	public int getAlunofk() {
		return id_Aluno_fk;
	}

	public int getCursofk() {
		return id_Curso_fk;
	}

	public int getId() {
		return id_Relacao;
	}

	public double getNota1() {
		return Np1;
	}

	public double getNota2() {
		return Np2;
	}

	public double getReposicao() {
		return Reposicao;
	}
	
	public double getExame() {
		return Exame;
	}

	@Override
	public String toString() {
		return "Aluno{" + "id = " + id_Relacao + ", Alunofk = " + id_Aluno_fk + ", Cursofk = " + id_Curso_fk
				+ ", NotaNP1 = " + Np1 + ", NotaNP2 = " + Np2 + ", Reposicao = " + Reposicao + ", Exame: " + Exame + '}';
	}
}
