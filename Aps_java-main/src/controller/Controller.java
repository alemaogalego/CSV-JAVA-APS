package controller;

import java.util.List;
import java.util.Scanner;

import dao.csv.DaoCSV;
import entidades.Alunos;
import entidades.Curso;
import entidades.Relacao;
@SuppressWarnings({"unchecked" , "resource"})

public class Controller {

	private DaoCSV model;

	public Controller(DaoCSV model) {
		this.model = model;
	}

	private int getIdInput() {

		while(true) {
			try {
		System.out.println("Entre com o Id");

		Scanner in = new Scanner(System.in);
		String idd = in.nextLine();

		idd = idd.trim();
		int id = Integer.parseInt(idd);

		return id;
			} catch(Exception e){
				System.out.println("Digite um número!");
			}
		}
	}

	private String getNomeInput() {
		System.out.println("Entre com o nome");
		Scanner in = new Scanner(System.in);
		String keyNome = in.nextLine().trim();

		return keyNome;

	}

	public String getCustomInput(String text) {
		System.out.println(text);
		Scanner in = new Scanner(System.in);
		String keyNome = in.nextLine().trim();
		return keyNome;			
	}
	
	private int getCustomInputInt(String text) {
		while(true) {
			try {
		System.out.println(text);
		Scanner in = new Scanner(System.in);
		int keyNome = Integer.parseInt(in.nextLine().trim());

		return keyNome;
			} catch(Exception e){
				System.out.println("Digite um número!");
			}
		}
	}
	
	private double getCustomInputDouble(String text) {
		while(true) {
			try {
		System.out.println(text);
		Scanner in = new Scanner(System.in);
		double keyNome = Double.parseDouble(in.nextLine().trim());

		return keyNome;
			} catch(Exception e){
				System.out.println("Digite um número!");
			}
		}
	}


	public void adicionarAluno() {
		String nome = getNomeInput();

		List<Alunos> alunos2 = model.load(1, "Alunos.csv");

		int id = 0;
		try {
			Alunos e1 = alunos2.get(alunos2.size() - 1);
			id = e1.getId();
		} catch (Exception e1) {
		}

		id++;
		alunos2.add(new Alunos(id, nome));
		boolean is_adicionou = model.save(alunos2, 1, "Alunos.csv");

		if (!is_adicionou) {
			System.out.println("Entidade " + nome + " nao foi adicionada");
		} else {
			System.out.println("Aluno " + nome + " foi criado");
		}

	}

	public void listarTodosAlunos() {

		List<Alunos> alunos = model.load(1, "Alunos.csv");

		System.out.println("" + alunos.size() + " encontrados");
		for (Alunos a : alunos) {
			System.out.println(a);
		}

	}

	public void listarAlunosPorNome() {
		String keyNome = getNomeInput();
		try {
		List<Alunos> alunos = model.getElementoByNome(keyNome, 1, "Alunos.csv");		
		System.out.println("Listando todos os Alunos com " + keyNome + " no nome:");
		System.out.println(alunos.size() + " encontrado(s)");
		
		for (Alunos a : alunos) {
			System.out.println(a);
		}
		}catch(Exception e) {
			System.out.println("Nome de aluno não encontrado");
			}
	}

	public void mostrarAlunoById() {
		
		int id = getIdInput();

		List<Alunos> aluno = model.getElementoById(id, 1, "Alunos.csv");

		System.out.println("Procurando Aluno com id \"" + id + "\"");
		if (aluno == null) {
			System.out.println("Aluno nao encontrado");
		} else {
			System.out.println("Aluno encontrado:");
			System.out.println(aluno);
		}

	}

	public void apagarAluno() {

		int id = getIdInput();

		List<Alunos> alunos = model.load(1, "Alunos.csv");

		for (int i = 0; i < alunos.size(); i++) {
			Alunos aluno = alunos.get(i);
			if (aluno.getId() == id) {
				alunos.remove(i);
			}
		}
		model.save(alunos, 1, "Alunos.csv");

	}

	public void adicionarCurso() {
		int id = 0;

		List<Curso> cursos2 = model.load(2, "Cursos.csv");

		try {
			Curso e1 = cursos2.get(cursos2.size() - 1);
			id = e1.getId();
		} catch (Exception e1) {
		}

		id++;

		String nome = getCustomInput("Entre com o nome");
		String nivel = getCustomInput("Entre com o nivel");
		int ano = getCustomInputInt("Entre com o ano");

		cursos2.add(new Curso(id, nome, ano, nivel));

		boolean is_adicionou = model.save(cursos2, 2, "Cursos.csv");
		if (!is_adicionou) {
			System.out.println("Entidade " + cursos2 + " nao foi adicionada");
		}

	}

	public void listarCursos() {
		List<Curso> cursos = model.load(2, "Cursos.csv");
		System.out.println("" + cursos.size() + " encontrados");
		for (Curso a : cursos) {
			System.out.println(a);
		}
	}

	public void listarCursoByNome() {

		String keyNome = getCustomInput("Entre com um nome de curso");
		try {
		List<Curso> cursos = model.getElementoByNome(keyNome, 2, "Cursos.csv");

		System.out.println("Listando todos os alunos com " + keyNome + " no nome:");
		System.out.println("" + cursos.size() + " encontrados");
		for (Curso a : cursos) {
			System.out.println(a);
		}		
		}catch(Exception e) {
			System.out.println("Título de Curso inexistente");
		}

	}

	public void mostrarCursoById() {

		int id = getIdInput();

		List<Curso> curso = model.getElementoById(id, 2, "Cursos.csv");

		System.out.println("Procurando Curso com id \"" + id + "\"");
		if (curso == null) {
			System.out.println("Curso nao encontrado");
		} else {
			System.out.println("Curso encontrado:");
			System.out.println(curso);
		}

	}

	public void apagarCurso() {

		int id = getIdInput();		
		
		List<Curso> cursos = model.load(2, "Cursos.csv");

		for (int i = 0; i < cursos.size(); i++) {
			Curso curso = cursos.get(i);
			if (curso.getId() == id) {
				cursos.remove(i);
			}
		}
		model.save(cursos, 2, "Cursos.csv");

	}
	
	
	public void adicionarRelacao() {
		int id = 0;

		List<Relacao> Relacoes2 = model.load(3, "Relacao.csv");

		try {
			Relacao e1 = Relacoes2.get(Relacoes2.size() - 1);
			id = e1.getId();
		} catch (Exception e1) {
		}

		id++;
		
		int id_A = getCustomInputInt("Entre o ID do aluno");
		int id_C = getCustomInputInt("Entre o ID do curso");
		double Np1 = getCustomInputDouble("Entre a nota da Np1");
		double Np2 = getCustomInputDouble("Entre a nota da Np2");
		double Reposicao = getCustomInputDouble("Entre com a nota da reposicao");
		double Exame = getCustomInputDouble("Entre com a nota do exame");

		Relacoes2.add(new Relacao(id, id_A, id_C,Np1, Np2, Reposicao, Exame));

		boolean is_adicionou = model.save(Relacoes2, 3, "Relacao.csv");
		if (!is_adicionou) {
			System.out.println("Entidade " + Relacoes2 + " nao foi adicionada");
		}

	}

	public void listarRelacoes() {
		List<Relacao> relacoes = model.load(3, "Relacao.csv");
		System.out.println("" + relacoes.size() + " encontrados");
		for (Relacao a : relacoes) {
			System.out.println(a);
		}
	}

	public void mostrarRelacaoById() {

		int id = getIdInput();

		List<Relacao> relacao = model.getElementoById(id, 3, "Relacao.csv");

		System.out.println("Procurando Curso com id \"" + id + "\"");
		if (relacao== null) {
			System.out.println("Relacao nao encontrada");
		} else {
			System.out.println("Relacao encontrada:");
			System.out.println(relacao);
		}

	}

	public void apagarRelacao() {

		int id = getIdInput();
		List<Relacao> relacoes = model.load(3, "Relacao.csv");

		for (int i = 0; i < relacoes.size(); i++) {
			Relacao relacao = relacoes.get(i);
			if (relacao.getId() == id) {
				relacoes.remove(i);
			}
		}
		model.save(relacoes, 3, "Relacao.csv");

	}

	public void mostrarRelacaoByIdAluno() {
		System.out.println("Informe o id do Aluno:");
		int id = getIdInput();

		List<Relacao> relacao = model.getElementoByIdAluno(id, "Relacao.csv");

		System.out.println("Procurando Aluno com id \"" + id + "\" em algum curso");
		if (relacao == null) {
			System.out.println("Relacao nao encontrada");
		} else {
			System.out.println("Relacao encontrada:");
			System.out.println(relacao);
		}
		
	}
	
	public void mostrarRelacaoByIdCurso() {
		
		System.out.println("Informe o id do Curso:");
		int id = getIdInput();

		List<Relacao> relacao = model.getElementoByIdCurso(id, "Relacao.csv");

		System.out.println("Procurando alunos no curso de id \"" + id + "\"");
		if (relacao == null) {
			System.out.println("Relacao nao encontrada");
		} else {
			System.out.println("Relacao encontrada:");
			System.out.println(relacao);
		}

			}

	public void mostrarCursoByAno() {
		int ano = getCustomInputInt("Informe o Ano do Curso:");
		
		List<Curso> curso = model.getElementoByAno(ano, "Cursos.csv");

		System.out.println("Procurando cursos do ano \"" + ano + "\"");
		if (curso == null) {
			System.out.println("Curso nao encontrado");
		} else {
			System.out.println("Curso encontrado:");
			System.out.println(curso);
		}

		
	}

}
