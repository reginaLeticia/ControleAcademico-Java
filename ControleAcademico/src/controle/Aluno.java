package controle;

/**
 * Representacao de um aluno, contendo nome,matricula e curso. O aluno e
 * identificado unicamente por sua matricula.
 * 
 * @author Lucian Julio
 *
 */
public class Aluno {
	/**
	 * nome do aluno
	 */
	private String nome;
	/**
	 * matricula do aluno
	 */
	private String matricula;
	/**
	 * curso do launo
	 */
	private String curso;

	/**
	 * Constroi um aluno
	 * 
	 * @param matricula matricula do aluno
	 * @param nome      nome do aluno
	 * @param curso     curso do aluno
	 */
	public Aluno(String matricula, String nome, String curso) {
		Util.validarStringNull("Não é permitido nome nulo!", nome);
		Util.validarStringVazia("Não é permitido nome vazio!", nome);
		Util.validarStringNull("Não é permitido matricula nula!", matricula);
		Util.validarStringVazia("Não é permitido matricula vazia!", matricula);
		Util.validarStringNull("Não é permitido curso nulo!", curso);
		Util.validarStringVazia("Não é permitido curso nulo!", curso);
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	/**
	 * Representacao em String de um objeto aluno.
	 */
	@Override
	public String toString() {
		return "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso;
	}

	/**
	 * Pega o nome do aluno
	 * 
	 * @return o nome do aluno
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Pega a matricula do aluno
	 * 
	 * @return a matricula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Pega o curso do aluno
	 * 
	 * @return o curso do aluno.
	 */
	public String getCurso() {
		return this.curso;
	}

	/**
	 * Retorna um valor inteiro que representa o hashcode do objeto, que � obtido
	 * atravez da matricula.
	 * 
	 * @return inteiro que representa o hashcode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Compara se o objeto aluno e igual a outro objeto, usando a matricula
	 * 
	 * @param obj Objeto a ser comparado.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}