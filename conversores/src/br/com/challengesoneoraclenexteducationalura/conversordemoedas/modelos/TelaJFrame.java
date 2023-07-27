package br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos;

import java.awt.Color;

import javax.swing.JFrame;

public class TelaJFrame extends JFrame {

	public TelaJFrame() {
		
		JFrame frame = new JFrame("Conversor de Comprimentos");    //creat new frame
		frame.getContentPane().setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);       //make it visible
    	frame.setResizable(false);
    	frame.setSize(600,600);      //set the size
    	frame.setLocationRelativeTo(null);// center frame
		
	}
	
}
