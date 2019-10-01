package controle;

import java.util.Scanner;

public class Main {
	
	public static String menu() {
		return "(C)adastrar Aluno\n" + 
		"(E)xibir Aluno\n" + 
		"(N)ovo Grupo\n" + 
		"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
		"(R)egistrar Aluno que Respondeu\n" + 
		"(I)mprimir Alunos que Responderam\n" + 
		"(O)ra, vamos fechar o programa!\n\n"+
		"Opcao>";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Sistema controle = new Sistema();
		boolean verdade = true;
		while(verdade) {
			System.out.print(menu());
			String opc = sc.nextLine();
			switch (opc) {
			case "C":
				System.out.print("Matricula:");
				String matricula1 = sc.nextLine();
				Util.validarStringNull("Nao e permitido matricula nula!", matricula1);
				Util.validarStringVazia("Nao e permitido matricula vazia!", matricula1);
				System.out.print("Nome:");
				String nome = sc.nextLine();
				Util.validarStringNull("Nao e permitido nome nulo!", nome);
				Util.validarStringVazia("Nao e permitido nome vazio!", nome);
				System.out.print("Curso:");
				String curso = sc.nextLine();
				Util.validarStringNull("Nao e permitido curso nulo!", matricula1);
				Util.validarStringVazia("Nao e permitido curso vazio!", matricula1);
				if(controle.cadastraAluno(matricula1, nome, curso)) {
					System.out.println("CADASTRO REALIZADO!"+System.lineSeparator());
				}else {
					System.out.println("MATRICULA JA CADASTRADA!"+System.lineSeparator());
				}
				break;
				
				
			case "E":
				
				System.out.print("Matricula:");
				String matricula2 = sc.nextLine();
				Util.validarStringNull("Nao e permitido matricula nula!", matricula2);
				Util.validarStringVazia("Nao e permitido matricula vazia!", matricula2);
				System.out.println(controle.consultarAluno(matricula2)+System.lineSeparator());
				break;
			case "N":
				System.out.print("Grupo:");
				String nomeGrupo = sc.nextLine();
				Util.validarStringNull("Nao e permitido nome de grupo nulo!", nomeGrupo);
				Util.validarStringVazia("Nao e permitido nome de grupo vazio!", nomeGrupo);
				if(controle.cadastrarGrupo(nomeGrupo)) {
					System.out.println("CADASTRO REALIZADO!"+System.lineSeparator());
				}else {
					System.out.println("GRUPO JA CADASTRADO!"+System.lineSeparator());
				}
				break;
			case "A":
				System.out.print(System.lineSeparator()+"(A)locar Aluno ou (I)mprimir Grupo?");
				String opc2 = sc.nextLine();
				if(opc2.equals("A")) {
					System.out.print("Matricula:");
					String matricula3 = sc.nextLine();
					Util.validarStringNull("Nao e permitido matricula nula!", matricula3);
					Util.validarStringVazia("Nao e permitido matricula vazia!", matricula3);
					System.out.print("Grupo:");
					String grupo = sc.nextLine();
					Util.validarStringNull("Nao e permitido nome de grupo nulo!", grupo);
					Util.validarStringVazia("Nao e permitido nome de grupo vazio!", grupo);
					System.out.println(controle.alocarAlunoEmGrupo(matricula3, grupo));
				}else {
					System.out.print("Grupo:");
					String grupo = sc.nextLine();
					Util.validarStringNull("Nao e permitido nome de grupo nulo!", grupo);
					Util.validarStringVazia("Nao e permitido nome de grupo vazio!", grupo);
					System.out.println(controle.imprimrGrupo(grupo));
				}
				break;
			case "R":
				System.out.print("Matricula:");
				String matricula3 = sc.nextLine();
				Util.validarStringNull("Nao e permitido matricula nula!", matricula3);
				Util.validarStringVazia("Nao e permitido matricula vazia!", matricula3);
				System.out.println(controle.cadastraAlunoQuadro(matricula3));
				break;
			case "I":
				System.out.println(controle.imprimirAlunosQuadro());
				break;
			case "O":
				verdade = false;
				break;
			default:
				System.out.println("Entrada invalida!");
				break;
			}
		}
		
	}
}
