package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Aluno;
import controle.GrupoDeEstudo;
import controle.Sistema;

class testGrupoDeEstudo {
	
	private GrupoDeEstudo g1;
	private GrupoDeEstudo g2;
	private GrupoDeEstudo g3;
	private Sistema sistema;
	private Aluno aluno;
	
	@BeforeEach
	void  main() {
		sistema = new Sistema();
		aluno = new Aluno("111","Lucian","cc");
		g1 = new GrupoDeEstudo("listas");
		g2 = new GrupoDeEstudo("listas");
		g3 = new GrupoDeEstudo("fmmc2");
	}
	@Test
	void testHashCode() {
		assertEquals(g1.hashCode(), g2.hashCode());
	}

	@Test
	void testGrupoDeEstudo() {
		GrupoDeEstudo g4 = new GrupoDeEstudo("calculo1");
	}

	@Test
	void testCadastraAluno() {
		g1.cadastraAluno(aluno);
	}
	
	@Test
	void testEqualsGrupoDeEstudo() {
		assertEquals(true, g1.equals(g2));
	}
	
	@Test
	void testNotEqualsGrupoDeEstudo() {
		assertEquals(false, g1.equals(g3));
	}
	
	@Test
	void testImprimirGrupo() {
		g1.cadastraAluno(aluno);
		assertEquals("Alunos do grupo listas"+System.lineSeparator()+"Aluno: 111 - Lucian - cc"+System.lineSeparator(),g1.imprimirGrupo());
	}
	
	
	
	
	
	
	



}
