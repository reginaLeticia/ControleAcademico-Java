package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Sistema;

class TestSistema {
	
	private Sistema sistema;

	@BeforeEach
	void constroiSistema() {
		sistema = new Sistema();
	}
	
	@Test
	void cadastraAluno() {
		assertTrue(sistema.cadastraAluno("111", "lucian", "cc"));
	}
	
	@Test
	void cadastraAlunoNomeNull() {
		try {
			sistema.cadastraAluno("111",null, "cc");
		}catch(NullPointerException e) {}
	}
	
	@Test
	void cadastraAlunoMatriculaNull() {
		try {
			sistema.cadastraAluno(null,"Lucian", "cc");
		}catch(NullPointerException e) {}
	}
	
	@Test
	void cadastraAlunoCursoNull() {
		try {
			sistema.cadastraAluno("111","lucian", null);
		}catch(NullPointerException e) {}
	}
	
	@Test
	void cadastraAlunoNomeVazio() {
		try {
			sistema.cadastraAluno("111","", "cc");
		}catch(IllegalArgumentException e) {}
	}
	
	@Test
	void cadastraAlunoMatriculaVazio() {
		try {
			sistema.cadastraAluno("","lucian", "cc");
		}catch(IllegalArgumentException e) {}
	}
	
	@Test
	void cadastraAlunoCursoVazio() {
		try {
			sistema.cadastraAluno("111","Lucian", "");
		}catch(IllegalArgumentException e) {}
	}
	
	@Test
	void cadastraAlunoJaCadastrado() {
		sistema.cadastraAluno("111","Lucian", "cc");
		assertFalse(sistema.cadastraAluno("111","Lucian", "cc"));
	}
	
	@Test
	void consultarAluno() {
		sistema.cadastraAluno("111","Lucian", "cc");
		assertEquals("Aluno: 111 - Lucian - cc", sistema.consultarAluno("111"));
		
	}
	
	@Test
	void consultarAlunoNaoCadastrado() {
		assertEquals("Aluno nao cadastrado.", sistema.consultarAluno("111"));
	}
	
	@Test
	void cadastrarGrupo() {
		assertTrue(sistema.cadastrarGrupo("listas"));
	}
	
	@Test
	void cadastrarGrupoNull() {
		try {
			sistema.cadastrarGrupo(null);
		}catch(NullPointerException e) {}
		
	}
	
	@Test
	void cadastrarGrupoVazio() {
		try {
			sistema.cadastrarGrupo("");	
		}catch(IllegalArgumentException e) {}
	}
	
	@Test
	void cadastrarGrupoJaCadastrado() {
		sistema.cadastrarGrupo("listas");
		assertFalse(sistema.cadastrarGrupo("listas"));
	}
	
	@Test
	void alocarAlunoEmGrupo() {
		sistema.cadastrarGrupo("listas");
		sistema.cadastraAluno("111", "lucian", "CC");
		assertEquals("ALUNO ALOCADO!",sistema.alocarAlunoEmGrupo("111", "listas"));
	}
	
	@Test
	void alocarAlunoEmGrupoNaoCadastrado() {
		sistema.cadastraAluno("111", "lucian", "CC");
		assertEquals("Grupo nao cadastrado.",sistema.alocarAlunoEmGrupo("111", "listas"));
	}
	
	@Test
	void alocarAlunoNaoCadastradoEmGrupo() {
		sistema.cadastrarGrupo("listas");
		assertEquals("Aluno nao cadastrado.",sistema.alocarAlunoEmGrupo("111", "listas"));
	}
	
	@Test
	void imprimirGrupo() {
		sistema.cadastrarGrupo("listas");
		sistema.cadastraAluno("111", "lucian", "CC");
		sistema.alocarAlunoEmGrupo("111", "listas");
		assertEquals("Alunos do grupo listas\nAluno: 111 - lucian - CC\n",sistema.imprimrGrupo("listas"));	
	}
	
	@Test
	void imprimirGrupoVazio() {
		sistema.cadastrarGrupo("listas");
		assertEquals("Alunos do grupo listas\n",sistema.imprimrGrupo("listas"));	
	}
	
	@Test
	void imprimirGrupoNaoCadastrado() {
		assertEquals("Grupo nao cadastrado.",sistema.imprimrGrupo("listas"));
	}
	
	@Test
	void cadastrarAlunoEmQuadro() {
		sistema.cadastraAluno("111", "lucian", "CC");
		assertEquals("ALUNO REGISTRADO!",sistema.cadastraAlunoQuadro("111"));
		
	}
	
	@Test
	void cadastrarAlunoNaoCadastradoEmQuadro() {
		assertEquals("Aluno nao cadastrado.",sistema.cadastraAlunoQuadro("111"));
	}
	
	@Test
	void imprimirAlunosEmQuadro() {
		sistema.cadastraAluno("111", "lucian", "CC");
		assertEquals("Alunos:\n", sistema.imprimirAlunosQuadro());
	}

}
