package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Sistema;

class TestSistema {
	private Sistema sistema;

	@BeforeEach
	void main() {
		sistema = new Sistema();
	}
	
	@Test
	void constroiSistema() {
		Sistema sistema1 = new Sistema();
	}
	
	@Test
	void cadastraAluno() {
		sistema.cadastraAluno("111", "lucian", "cc");
	}
	
	@Test
	void cadastraAlunoNomeNull() {
		try {
			sistema.cadastraAluno("111",null, "cc");
			assertFalse(false);
		}catch(NullPointerException e) {
		}
	}
	
	@Test
	void cadastraAlunoMatriculaNull() {
		try {
			sistema.cadastraAluno(null,"Lucian", "cc");
			assertFalse(false);
		}catch(NullPointerException e) {
		}
	}
	
	@Test
	void cadastraAlunoCursoNull() {
		try {
			sistema.cadastraAluno("111","lucian", null);
			assertFalse(false);
		}catch(NullPointerException e) {
		}
	}
	
	@Test
	void cadastraAlunoNomeVazio() {
		try {
			sistema.cadastraAluno("111","", "cc");
			assertFalse(false);
		}catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	void cadastraAlunoMatriculaVazio() {
		try {
			sistema.cadastraAluno("","lucian", "cc");
			assertFalse(false);
		}catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	void cadastraAlunoCursoVazio() {
		try {
			sistema.cadastraAluno("111","Lucian", "");
			assertFalse(false);
		}catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	void cadastraAlunoJaCadastrado() {
		sistema.cadastraAluno("111","Lucian", "cc");
		assertEquals(false, sistema.cadastraAluno("111","Lucian", "cc"));
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
		sistema.cadastrarGrupo("listas");
	}
	
	@Test
	void cadastrarGrupoNull() {
		try {
			sistema.cadastrarGrupo(null);
			assertFalse(false);
		}catch(NullPointerException e) {
		}
		
	}
	
	@Test
	void cadastrarGrupoVazio() {
		try {
			sistema.cadastrarGrupo("");
			assertFalse(false);
		}catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	void cadastrarGrupoJaCadastrado() {
		sistema.cadastrarGrupo("listas");
		assertEquals(false,sistema.cadastrarGrupo("listas"));
	}
	
	@Test
	void alocarAlunoEmGrupo() {
		sistema.cadastrarGrupo("listas");
		sistema.cadastraAluno("111", "lucian", "CC");
		sistema.alocarAlunoEmGrupo("111", "listas");
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
		sistema.imprimrGrupo("listas");	
	}
	
	@Test
	void imprimirGrupoNaoCadastrado() {
		assertEquals("Grupo nao cadastrado.",sistema.imprimrGrupo("listas"));
	}
	
	@Test
	void cadastrarAlunoEmQuadro() {
		sistema.cadastraAluno("111", "lucian", "CC");
		sistema.cadastraAlunoQuadro("111");
	}
	
	@Test
	void cadastrarAlunoNaoCadastradoEmQuadro() {
		assertEquals("Aluno nao cadastrado.",sistema.cadastraAlunoQuadro("111"));
	}
	
	@Test
	void imprimirAlunosEmQuadro() {
		sistema.cadastraAluno("111", "lucian", "CC");
		sistema.imprimirAlunosQuadro();
	}

}
