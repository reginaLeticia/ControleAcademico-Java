package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Aluno;

class TestAluno {
	
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	
	@BeforeEach
	public void main() {
		aluno1 = new Aluno("110","Lucian","cc");
		aluno2 = new Aluno("110","Lucian","cc");
		aluno3 = new Aluno("150","Lucian","cc");
	}
	
	@Test
	void testHashCode() {
		assertEquals(aluno1.hashCode(), aluno2.hashCode());
	}
	
	
	@Test
	void testConstroiAluno() {
		Aluno aluno4 = new Aluno("152","lucian","cc");
	}
	
	@Test
	void testConstroiAlunoNomeNull() {
		try {
			Aluno aluno4 = new Aluno("222",null,"cc");
		}catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testConstroiAlunoMatriculaNull() {
		try {
			Aluno aluno4 = new Aluno(null,"lucian","cc");
		}catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	@Test
	void testConstroiAlunoCursoNull() {
		try {
			Aluno aluno4 = new Aluno("222","Lucian",null);
		}catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testConstroiAlunoMatriculavazio() {
		try {
			Aluno aluno4 = new Aluno("","Lucian","cc");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testConstroiAlunoCursovazio() {
		try {
			Aluno aluno4 = new Aluno("222","Lucian","");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testConstroiAlunoNomevazio() {
		try {
			Aluno aluno4 = new Aluno("222","","cc");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testToString() {
		assertEquals(aluno1.toString(), "Aluno: 110 - Lucian - cc" );
	}
	
	@Test
	void testAlunoEquals() {
		assertEquals(true, aluno1.equals(aluno2));
	}
	
	@Test
	void testAlunoNotEquals() {
		assertEquals(false, aluno1.equals(aluno3));
	}
	
	
}
