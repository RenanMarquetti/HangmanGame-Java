package hangmanGame;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ControllerHangmanGame {
	
	char[] textoBase, textoOculto;
	
	char letrasFaltanes[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','W','Y','Z'};
	
	ControllerHangmanGame(String palavra) {
		
		textoBase = palavra.toUpperCase().toCharArray();
		textoOculto = new char[textoBase.length];
		
		for(int c = 0; c < textoOculto.length; textoOculto[c++] = '_');
		
		
	}
	
	String verificarLetra(char letra) {
	
		for(int c = 0; c < textoOculto.length; c++) if(textoBase[c] == letra) textoOculto[c] = letra;
		
		for(int i = 0; i < letrasFaltanes.length; i++) if(letrasFaltanes[i] == letra) {letrasFaltanes[i] = '_'; break;}
		
		return getTexto();
	}
	
	boolean isOver() {
		
		return Arrays.equals(textoOculto,textoBase);
	}
	
	String getTexto() {return formatTexto(textoOculto);}
	
	String getLetrasFaltanes() {return formatTexto(letrasFaltanes);}

	
	String formatTexto(char arrayChar[]) {
		return String.valueOf(arrayChar).replaceAll ("(.)", "$1 ");
	}
}
