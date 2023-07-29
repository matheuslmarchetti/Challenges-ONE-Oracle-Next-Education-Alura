package br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TelaJFrame extends JFrame{
	
	private JFrame frame;
	private JTextField textField;
	private String string;
	
	public void SetAdicionaItens(String string) {
		textField.setText("teste" + string);
	}
	
	public TelaJFrame() {
		textField = new JTextField();
		SetAdicionaItens(string);
		
		frame = new JFrame("Historico");    //creat new frame
		frame.add(textField);
		//frame.getContentPane().setBackground(Color.BLACK);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);       //make it visible
    	frame.setResizable(false);
    	frame.setSize(600,600);      //set the size
    	frame.setLocationRelativeTo(null);// center frame
		
	}
	
	
	
}
