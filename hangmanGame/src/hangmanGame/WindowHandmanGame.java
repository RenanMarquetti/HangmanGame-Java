package hangmanGame;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class WindowHandmanGame extends JFrame {
	
	public ControllerHangmanGame controller;
	public JLabel txtRes;
	public JLabel txtLetrasFaltantes;
	public JTextField entradaLetra;
	public Random random = new Random();
	public Palavras[] palavras = Palavras.values();

	
	public WindowHandmanGame() {
		
		int largura = 853;
		int altura = 480;
		
		
		setSize(largura,altura);
		setTitle("Jogo da Forca");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		Font fontMain = new Font("Serif", Font.PLAIN, 36);
		
		txtRes = new JLabel();
		txtRes.setFont(fontMain);
		txtRes.setSize(753,50);
		txtRes.setLocation(50, 50);
		
		entradaLetra = new JTextField(1);
		entradaLetra.setFont(fontMain);
		entradaLetra.setSize(225, 50);
		entradaLetra.setLocation(50, 150);
		
		JButton btnverificarCaracter = new JButton("Verificar Letra");
		btnverificarCaracter.setSize(326,50);
		btnverificarCaracter.setLocation(50,250);
		btnverificarCaracter.addActionListener((ae) -> {
			
			entradaLetra.requestFocusInWindow();
			
			if(entradaLetra.getText().isBlank()) return;
				
			String res =  controller.verificarLetra(entradaLetra.getText().toUpperCase().charAt(0));
			
			entradaLetra.setText(null);
			txtRes.setText(res);
			
			String resLetrasFaltanes = controller.isOver() ? "Você vanceu!!!!" : controller.getLetrasFaltanes();
			
			txtLetrasFaltantes.setText(resLetrasFaltanes);
			
		});
		
		JButton btnNovaPalavra = new JButton("Nova Palavra");
		btnNovaPalavra.setSize(326,50);
		btnNovaPalavra.setLocation(426,250);
		btnNovaPalavra.addActionListener((ae) -> {
			novaPalavra();
		});
		
		txtLetrasFaltantes = new JLabel();
		txtLetrasFaltantes.setSize(753,50);
		txtLetrasFaltantes.setLocation(50, 350);
		txtLetrasFaltantes.setFont(fontMain.deriveFont(26f));
		
		
		add(txtRes);
		add(entradaLetra);
		add(btnverificarCaracter);
		add(btnNovaPalavra);
		add(txtLetrasFaltantes);
		
		
		novaPalavra();
		
	}
	
	void novaPalavra() {
		
		int index = random.nextInt(palavras.length);
		String novaPalavra = palavras[index].toString();
		
		controller = new ControllerHangmanGame(novaPalavra);
		txtRes.setText(controller.getTexto());
		entradaLetra.setText(null);
		entradaLetra.requestFocusInWindow();
		txtLetrasFaltantes.setText(controller.getLetrasFaltanes());
		
	}
	
}
