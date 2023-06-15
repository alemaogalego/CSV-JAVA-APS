package entidades;

public class Curso {
	private int Id_Curso;
	private String Titulo;
	private int Ano;
	private String Nivel;

	public Curso(int aId_Curso, String aTitulo, int aAno, String aNivel) {
		this.Id_Curso = aId_Curso;
		this.Titulo = aTitulo.replaceAll(",", " ");
		this.Ano = aAno;
		this.Nivel = aNivel;
	}

	public String getTitulo() {
		return Titulo;
	}

	public int getId() {
		return Id_Curso;
	}

	public int getAno() {
		return Ano;
	}

	public String getNivel() {
		return Nivel;
	}

	@Override
	public String toString() {
		return "Curso{" + "id = " + Id_Curso + ", Titulo = " + Titulo + ", Ano = " + Ano + ", Nivel = " + Nivel + '}';
	}

	public static void main(String[] args) {
	}

}
