package hangmanGame;

import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class WindowHandmanGame extends JFrame {
	
	public ControllerHangmanGame controller;
	public JLabel txtRes;
	public JTextField entradaLetra;
	public Random random = new Random();
	public Palavras[] palavras = Palavras.values();
	
	public WindowHandmanGame(String palavra) {
		
		controller = new ControllerHangmanGame(palavra);
		
		setSize(450,225);
		setTitle("Jogo da Forca");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		txtRes = new JLabel(controller.getTexto());
		txtRes.setSize(450,50);
		
		entradaLetra = new JTextField(1);
		entradaLetra.setSize(225, 50);
		
		JButton btnverificarCaracter = new JButton("Verificar Letra");
		btnverificarCaracter.setSize(225,50);
		btnverificarCaracter.addActionListener((ae) -> {
			
			entradaLetra.requestFocusInWindow();
			
			if(entradaLetra.getText().isBlank()) return;
				
			String res =  controller.verificarLetra(entradaLetra.getText().toUpperCase().charAt(0));
			
			entradaLetra.setText(null);
			txtRes.setText(res);
			
		});
		
		JButton btnNovaPalavra = new JButton("Nova Palavra");
		btnNovaPalavra.addActionListener((ae) -> {
			novaPalavra();
		});
		
		
		
		add(txtRes);
		add(entradaLetra);
		add(btnverificarCaracter);
		add(btnNovaPalavra);
		
	}
	
	void novaPalavra() {
		
		int index = random.nextInt(palavras.length);
		String novaPalavra = palavras[index].toString();
		
		controller = new ControllerHangmanGame(novaPalavra);
		txtRes.setText(controller.getTexto());
		entradaLetra.setText(null);
		entradaLetra.requestFocusInWindow();
		
	}
}
