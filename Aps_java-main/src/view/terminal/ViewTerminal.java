package view.terminal;

import java.util.Scanner;
import controller.Controller;
import dao.csv.DaoCSV;

@SuppressWarnings("resource")
public class ViewTerminal {

	public Controller controller;

	public void init() {
		int opcao = 0;
		DaoCSV dao = new DaoCSV();

		controller = new Controller(dao);
		while (true) {
			opcao = getOpcao();
			switch (opcao) {
				case 1:
					controller.adicionarAluno();
					break;
				case 2:
					controller.listarTodosAlunos();
					break;
				case 3:
					controller.listarAlunosPorNome();
					break;
				case 4:
					controller.mostrarAlunoById();
					break;
				case 5:
					controller.apagarAluno();
					break;
				case 6:
					controller.adicionarCurso();
					break;
				case 7:
					controller.listarCursos();
					break;
				case 8:
					controller.listarCursoByNome();
					break;
				case 9:
					controller.mostrarCursoById();
					break;
				case 10:
					controller.mostrarCursoByAno();
					break;
				case 11:
					controller.apagarCurso();
					break;
				case 12:
					controller.adicionarRelacao();
					break;
				case 13:
					controller.listarRelacoes();
					break;
				case 14:
					controller.mostrarRelacaoById();
					break;
				case 15:
					controller.mostrarRelacaoByIdAluno();
					break;
				case 16:
					controller.mostrarRelacaoByIdCurso();
					break;
				case 17:
					controller.apagarRelacao();
					break;

				case 0:
					System.out.println("Saindo do programa");
					System.exit(0);
					break;
			}
			controller.getCustomInput("\nAperte enter para continuar");
		}

	}

	public int getOpcao() {

		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Escolha a opcao:");
		System.out.println("--------------------------------");
		System.out.println("0 - Para sair do programa");
		System.out.println("1 - Para adicionar aluno");
		System.out.println("2 - Listar todos alunos");
		System.out.println("3 - Encontrar aluno por nome");
		System.out.println("4 - Encontrar aluno pelo id");
		System.out.println("5 - Remover aluno pelo id");
		System.out.println("--------------------------------");
		System.out.println("6 - Para adicionar curso");
		System.out.println("7 - Listar todos os cursos");
		System.out.println("8 - Encontrar curso por nome");
		System.out.println("9 - Encontrar curso pelo id");
		System.out.println("10 - Encontrar curso pelo ano");
		System.out.println("11  Remover curso pelo id");
		System.out.println("--------------------------------");
		System.out.println("12 - Para adicionar relacao");
		System.out.println("13 - Listar todos as relacoes");
		System.out.println("14 - Encontrar relacao por id");
		System.out.println("15 - Encontrar relacao por id do aluno");
		System.out.println("16 - Encontrar relacao por id do curso");
		System.out.println("17 - Remover relacao pelo id");
		System.out.println("--------------------------------");
		System.out.println();

		Scanner in = new Scanner(System.in);
		String linha = in.nextLine();

		try {
			return Integer.parseInt(linha);
		} catch (NumberFormatException e) {
			System.out.println("O valor entrado: " + linha + " não é valido");
			System.out.println("A opcao deve ser um numero inteiro\n");
			return -1;
		}

	}

	public int entraNp1() {
		System.out.println("Entre com a np1 do aluno");
		Scanner in = new Scanner(System.in);
		String np1Line = in.nextLine();
		try {
			int np1 = Integer.parseInt(np1Line);
			if (np1 < 0) {
				throw new NumberFormatException("Np1 negativa");
			}
			return np1;
		} catch (NumberFormatException e) {
			System.out.println("Entrada invalida: " + np1Line);
			System.out.println("    Deve ser um inteiro positivo");
			return entraNp1();
		}
	}

	public double entraNp2() {
		System.out.println("Entre com o np2 do aluno");
		Scanner in = new Scanner(System.in);
		String Np2Line = in.nextLine();
		try {
			double np2 = Double.parseDouble(Np2Line);
			if (np2 < 0) {
				throw new NumberFormatException("Np2 negativo");
			}
			return np2;
		} catch (NumberFormatException e) {
			System.out.println("Entrada invalida: " + Np2Line);
			System.out.println("    Deve ser um real positivo");
			return entraNp2();
		}
	}

}
