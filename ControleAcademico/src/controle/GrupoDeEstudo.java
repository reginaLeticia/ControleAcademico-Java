package controle;

import java.util.HashSet;
/**
 * Representa um grupo de estudo, onde possui um nome para o grupo e os alunos que fazem parte do grupo.
 * @author Lucian Julio
 *
 */
public class GrupoDeEstudo {
	
	/**
	 * nome do grupo
	 */
	private String nome;
	/**
	 * alunos que estao no grupo
	 */
	private HashSet<Aluno> alunosNoGrupo;
	
	/**
	 * Constroi um grupo de estudo
	 * @param nome nome que o grupo vai receber
	 */
	public GrupoDeEstudo(String nome) {
		Util.validarStringNull("Não e permitido nome nulo!", nome);
		Util.validarStringVazia("Nao e permitido nome vazio", nome);
		this.nome = nome;
		this.alunosNoGrupo = new HashSet<>();
	}
	
	/**
	 * Metodo para cadastrar um aluno no grupo
	 * @param aluno recebe o objeto aluno para o cadastro
	 */
	public void cadastraAluno(Aluno aluno) {
		alunosNoGrupo.add(aluno);
	}
	
	/**
	 * Gera a representacao em String do grupo
	 * @return a representacao do grupo
	 */
	public String imprimirGrupo() {
		String saida = "Alunos do grupo "+this.nome + System.lineSeparator();
		for (Aluno aluno : alunosNoGrupo) {
			saida += aluno.toString() + System.lineSeparator();
		}
		return saida;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	 * Compara se um grupo e igual a outro objeto
	 * @param obj obj que vai ser comparado
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoDeEstudo other = (GrupoDeEstudo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equalsIgnoreCase(other.nome))
			return false;
		return true;
	}
	
	

}
