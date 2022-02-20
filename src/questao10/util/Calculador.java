package questao10.util;

public class Calculador {

	private Integer divertido = 0, chateado = 0;
	
	public String avaliarSentimento(String msg) {
	for (int i = 0; i < msg.length() - 2; i++) {
		if (msg.charAt(i) == ':') {
			if (msg.substring(i, i + 3).equals(":-)")) {
				divertido++;
			}else if (msg.substring(i, i + 3).equals(":-(")) {
				chateado++;
			}
		}
	}
	String resultado = divertido - chateado > 0 ? "divertido" : 
		divertido - chateado < 0 ? "chateado" : "neutro";
	return resultado;
	}

}
