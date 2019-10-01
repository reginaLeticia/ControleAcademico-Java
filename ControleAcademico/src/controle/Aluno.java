package controle;


public class Aluno {
	
	private String nome;
	private String matricula;
	private String curso;
	
	public Aluno(String matricula, String nome, String curso) {
		Util.validarStringNull("Nao e permitido nome nulo!", nome);
		Util.validarStringVazia("Nao e permitido nome vazio!", nome);
		Util.validarStringNull("Nao e permitido matricula nula!",matricula);
		Util.validarStringVazia("Nao e permitido matricula vazia!", matricula);
		Util.validarStringNull("Nao e permitido curso nulo!", curso);
		Util.validarStringVazia("Nao e permitido curso nulo!", curso);
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return "Aluno: "+this.matricula+" - "+this.nome + " - "+this.curso;
	}
	
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public String getCurso() {
		return curso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
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