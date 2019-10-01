package controle;

import java.util.*;

/**
 * Classe responsavel por gerenciar os alunos, grupos de estudos, e alunos do quadro.
 * @author Lucian Julio
 *
 */
public class Sistema {
	
	/**
	 * Conjunto de alunos cadastrados no sistema.
	 */
	private HashMap<String, Aluno> alunos;
	/**
	 * Grupos de estudos cadastrados no sistema.
	 */
	private HashMap<String, GrupoDeEstudo> gruposDeEstudos;
	/** 
	 * Grupo de alunos que responderam no quadro.
	 */
	private ArrayList<String> alunosDoQuadro;
	
	/**
	 * Constroi um sistema, 
	 */
	public Sistema() {
		this.alunos = new HashMap<>();
		this.gruposDeEstudos = new HashMap<>();
		this.alunosDoQuadro = new ArrayList<>();
	}
	
	/**
	 * Metodo para cadastrar um aluno no sistema
	 * @param matricula matricula do aluno
	 * @param nome nome do aluno
	 * @param curso curso do aluno
	 * @return retorna se verdadeiro ou falso, se o aluno foi cadastrado ou nao.
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		if(alunos.containsKey(matricula)) {
			return false;
		}
		alunos.put(matricula, new Aluno(matricula,nome,curso));
		return true;
	}
	
	/**
	 * Metodo para consultar um aluno no sistema
	 * @param matricula matricula do aluno
	 * @return retorna a representacao de um aluno ou algum possivel erro
	 */
	public String consultarAluno(String matricula) {
		if(alunos.containsKey(matricula)) {
			return alunos.get(matricula).toString();
		}
		return "Aluno nao cadastrado.";
	}
	
	/**
	 * Metodo para cadastrar um grupo
	 * @param grupoNome nome do grupo
	 * @return retorna verdadeiro ou falso, se foi possivel criar o grupo.
	 */
	public boolean cadastrarGrupo(String grupoNome) {
		if(gruposDeEstudos.containsKey(grupoNome)) {
			return false;
		}
		gruposDeEstudos.put(grupoNome, new GrupoDeEstudo(grupoNome));
		return true;
	}
	
	/**
	 * Metodo para alocar um aluno em algum grupo de estudo
	 * @param matricula matricula do aluno
	 * @param grupoNome nome do grupo
	 * @return retorna uma mensagem indicando algum erro, ou se o aluno foi alocado.
	 */
	public String alocarAlunoEmGrupo(String matricula, String grupoNome) {
		if(gruposDeEstudos.containsKey(grupoNome) && alunos.containsKey(matricula)) {
			gruposDeEstudos.get(grupoNome).cadastraAluno(alunos.get(matricula));
		}else {
			if(!gruposDeEstudos.containsKey(grupoNome)) {
				return "Grupo nao cadastrado.";
			}else if(!alunos.containsKey(matricula)){
				return "Aluno nao cadastrado.";
			}
		}
		return "ALUNO ALOCADO!";
	}
	
	/**
	 * Metodo para mostrar a representacao de um grupo
	 * @param grupoNome nome do grupo
	 * @return retorna uma String com as informacoes do grupo.
	 */
	public String imprimrGrupo(String grupoNome) {
		if(!gruposDeEstudos.containsKey(grupoNome)) {
			return "Grupo nao cadastrado.";
		}
		return gruposDeEstudos.get(grupoNome).imprimirGrupo();
	}
	
	/**
	 * Metodo para registrar alunos que responderam no quadro.
	 * @param matricula matricula do aluno
	 * @return retorna uma String indicando algum possivel erro, ou se o aluno foi registrado.
	 */
	public String cadastraAlunoQuadro(String matricula) {
		if(!alunos.containsKey(matricula)) {
			return "Aluno nao cadastrado.";
		}
		alunosDoQuadro.add(matricula);
		return "ALUNO REGISTRADO!";
	}
	
	/**
	 * Metodo para imprimir os alunos que responderam no quadro
	 * @return retorna uma representacao de cada aluno que respondeu no quadro.
	 */
	public String imprimirAlunosQuadro() {
		String saida = "Alunos:"+System.lineSeparator();
		for (int i = 0; i < alunosDoQuadro.size(); i++) {
			Aluno aluno = alunos.get(alunosDoQuadro.get(i));
			saida += i+1+". "+aluno.getMatricula() +" - " + aluno.getNome() + " - " + aluno.getCurso() + System.lineSeparator();
		}
		return saida;
	}
}
