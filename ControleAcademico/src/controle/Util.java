package controle;

/**
 * Classe criada para modularizar o lancamento de erros no sistema.
 * 
 * @author Lucian Julio
 *
 */
public class Util {
	/**
	 * Metodo para validar Paramentros String null.
	 * @param mensagem mensagem de erro a ser apresentada na excessao caso seja lancada.
	 * @param valor valor a ser comparado com String null
	 */
	public static void validarStringNull(String mensagem, String valor) {
		if(valor == null) {
			throw new NullPointerException(mensagem);
		}
	}
	/**
	 * Metodo para validar Paramentros String Vazia.
	 * @param mensagem mensagem de erro a ser apresentada na excessao caso seja lancada.
	 * @param valor valor a ser comparado com String vazia.
	 */
	public static void validarStringVazia(String mensagem, String valor) {
		if(valor.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
