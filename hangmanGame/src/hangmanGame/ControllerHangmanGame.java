package hangmanGame;


public class ControllerHangmanGame {
	
	char textoBase[];
	char textoOculto[];
	
	ControllerHangmanGame(String palavra) {
		
		textoBase = palavra.toUpperCase().toCharArray();
		textoOculto = new char[textoBase.length];
		
		for(int c = 0; c < textoOculto.length; c++) 
			if(Character.isLetter(textoBase[c])) textoOculto[c] = '_'; else textoOculto[c] = ' ';
		
		
	}
	
	String verificarLetra(char letra) {
	
		for(int c = 0; c < textoOculto.length; c++) if(textoBase[c] == letra) textoOculto[c] = letra;
		
		return String.valueOf(textoOculto);
	}
	
	String getTexto() {
		
		return String.valueOf(textoOculto);
	}
}
