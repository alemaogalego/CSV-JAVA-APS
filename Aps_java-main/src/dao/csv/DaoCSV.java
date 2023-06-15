package dao.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import entidades.Alunos;
import entidades.Curso;
import entidades.Relacao;
@SuppressWarnings({"unchecked", "rawtypes"})
public class DaoCSV {

	public boolean save( List elementos, int n, String filepath) {
		try (

				OutputStream os = new FileOutputStream(filepath);
				OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
				PrintWriter pw = new PrintWriter(osw, true);) {
			if (n == 1) {
				List<Alunos> alunos = elementos;
				for (Alunos aluno : alunos) {					
					pw.println(aluno.getId() + "," + aluno.getNome());
				}
				return true;
			}

			else if (n == 2) {
				List<Curso> cursos = elementos;
				for (Curso curso : cursos) {
					pw.println(curso.getId() + "," + curso.getTitulo() + "," + curso.getAno() + "," + curso.getNivel());
				}
				return true;
			}

			else {
				List<Relacao> relacoes = elementos;
				for (Relacao relacao : relacoes) {
					pw.println(relacao.getId() + "," + relacao.getAlunofk() + "," + relacao.getCursofk() + ","
							+ relacao.getNota1() + "," + relacao.getNota2() + "," + relacao.getReposicao() + "," + relacao.getExame());
				}
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List load(int n, String filepath) {

		List<Alunos> alunos = new ArrayList<>();
		List<Relacao> relacoes = new ArrayList<>();
		List<Curso> cursos = new ArrayList<>();

		try (InputStream is = new FileInputStream(filepath);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);) {
			String linha;

			if (n == 1) {
				while ((linha = br.readLine()) != null) {
					String[] palavras = linha.split(",");

					String id = palavras[0].replaceAll("\\uFEFF", "");
					String nome = palavras[1];

					Alunos aluno = new Alunos(Integer.parseInt(id.trim()), nome);
					alunos.add(aluno);
				}
				return (List<Alunos>) alunos;
			} else if (n == 2) {
				while ((linha = br.readLine()) != null) {
					String[] palavras = linha.split(",");

					String id = palavras[0].replaceAll("\\uFEFF", "");
					String nome = palavras[1];
					int ano = Integer.parseInt(palavras[2]);
					String nivel = palavras[3];

					Curso curso = new Curso(Integer.parseInt(id.trim()), nome, ano, nivel);
					cursos.add(curso);
				}
				return (List<Curso>) cursos;

			} else {
				while ((linha = br.readLine()) != null) {
					String[] palavras = linha.split(",");
					String idr = palavras[0].replaceAll("\\uFEFF", "");
					String ida = palavras[1].replaceAll("\\uFEFF", "");;
					String idc = palavras[2].replaceAll("\\uFEFF", "");;
					String nota1 = palavras[3];
					String nota2 = palavras[4];
					double Reposicao = Double.parseDouble(palavras[5]);
					double Exame = Double.parseDouble(palavras[6]);

					Relacao relacao = new Relacao(Integer.parseInt(idr), Integer.parseInt(ida), Integer.parseInt(idc),
							Double.parseDouble(nota1), Double.parseDouble(nota2), Reposicao, Exame);
					relacoes.add(relacao);
				}
				return (List<Relacao>) relacoes;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return alunos;
	}
	public List getElementoByNome(String keyName, int n, String filepath) {

		try (InputStream is = new FileInputStream(filepath);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);) {
			String linha;

			while ((linha = br.readLine()) != null) {

				String[] palavras = linha.split(",");

				String id = palavras[0].replaceAll("\\uFEFF", "");
				int id2 = Integer.parseInt(id);

				if (n == 1) {
					List<Alunos> alunos = new ArrayList<>();

					String nome = palavras[1];
					if (!nome.toLowerCase().contains(keyName.toLowerCase())) {
						continue;
					}

					Alunos aluno = new Alunos(id2, nome);
					alunos.add(aluno);
					return alunos;

				} else if (n == 2) {

					String nome = palavras[1];
					int ano = Integer.parseInt(palavras[2]);
					String nivel = palavras[3];
					Curso curso = new Curso(id2, nome, ano, nivel);
					List<Curso> cursos = new ArrayList<>();

					if (!nome.toLowerCase().contains(keyName.toLowerCase())) {
						continue;
					}

					cursos.add(curso);

					return cursos;

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List getElementoById(int theId, int n, String filepath) {

		try (InputStream is = new FileInputStream(filepath);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);) {
			String linha;

			while ((linha = br.readLine()) != null) {

				String[] palavras = linha.split(",");

				String id = palavras[0].replaceAll("\\uFEFF", "");
				int id2 = Integer.parseInt(id);

				if (theId == id2) {
					if (n == 1) {
						String nome = palavras[1];
						Alunos aluno = new Alunos(id2, nome);
						List<Alunos> alunos = new ArrayList<>();
						alunos.add(aluno);
						return alunos;
					} else if (n == 2) {
						String nome = palavras[1];
						int ano = Integer.parseInt(palavras[2]);
						String nivel = palavras[3];
						Curso curso = new Curso(id2, nome, ano, nivel);
						List<Curso> cursos = new ArrayList<>();
						cursos.add(curso);
						return cursos;
					} else {
						int id_aluno = Integer.parseInt(palavras[1]);
						int id_curso = Integer.parseInt(palavras[2]);
						double Np1 = Double.parseDouble(palavras[3]);
						double Np2 = Double.parseDouble(palavras[4]);
						double Reposicao = Double.parseDouble(palavras[5]);
						double Exame = Double.parseDouble(palavras[6]);

						Relacao relacao = new Relacao(id2, id_aluno, id_curso, Np1, Np2, Reposicao, Exame);
						List<Relacao> relacoes = new ArrayList<>();
						relacoes.add(relacao);
						return relacoes;
					}

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List getElementoByIdCurso(int theId, String filepath) {
		try (InputStream is = new FileInputStream(filepath);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);) {
			String linha;

			while ((linha = br.readLine()) != null) {
				String[] palavras = linha.split(",");
				String id = palavras[2].replaceAll("\\uFEFF", "");
				
				int id2 = Integer.parseInt(id);
				if (theId == id2) {
					int id_aluno = Integer.parseInt(palavras[1]);
					int id_curso = Integer.parseInt(palavras[2]);
					double Np1 = Double.parseDouble(palavras[3]);
					double Np2 = Double.parseDouble(palavras[4]);
					double Reposicao = Double.parseDouble(palavras[5]);
					double Exame = Double.parseDouble(palavras[6]);
	
					Relacao relacao = new Relacao(id2, id_aluno, id_curso, Np1, Np2, Reposicao, Exame);
					List<Relacao> relacoes = new ArrayList<>();
					relacoes.add(relacao);
					return relacoes;				
	}
	}
			
	} catch (IOException e) {
		e.printStackTrace();		
	}
		return null;
	}
	
	public List getElementoByIdAluno(int theId, String filepath) {
		try (InputStream is = new FileInputStream(filepath);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);) {
			String linha;

			while ((linha = br.readLine()) != null) {
				String[] palavras = linha.split(",");
				String id = palavras[1].replaceAll("\\uFEFF", "");
				
				int id2 = Integer.parseInt(id);
				if (theId == id2) {
					int id_aluno = Integer.parseInt(palavras[1]);
					int id_curso = Integer.parseInt(palavras[2]);
					double Np1 = Double.parseDouble(palavras[3]);
					double Np2 = Double.parseDouble(palavras[4]);
					double Reposicao = Double.parseDouble(palavras[5]);
					double Exame = Double.parseDouble(palavras[6]);
	
					Relacao relacao = new Relacao(id2, id_aluno, id_curso, Np1, Np2, Reposicao, Exame);
					List<Relacao> relacoes = new ArrayList<>();
					relacoes.add(relacao);
					return relacoes;				
	}
	}
			
	} catch (IOException e) {
		e.printStackTrace();		
	}
		return null;
	}
	
	public List getElementoByAno(int aAno, String filepath) {
		try (InputStream is = new FileInputStream(filepath);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);) {
			String linha;

			while ((linha = br.readLine()) != null) {
				String[] palavras = linha.split(",");
				String anoString = palavras[2].replaceAll("\\uFEFF", "");
				
				int anoInt = Integer.parseInt(anoString);
				if (aAno == anoInt) {
					int id2 = Integer.parseInt(palavras[0]);
					String nome = palavras[1];
					String nivel = palavras[3];
					Curso curso = new Curso(id2, nome, anoInt, nivel);
					List<Curso> cursos = new ArrayList<>();
					cursos.add(curso);
					return cursos;
	}
	}
			
	} catch (IOException e) {
		e.printStackTrace();		
	}
		return null;
	}
}
