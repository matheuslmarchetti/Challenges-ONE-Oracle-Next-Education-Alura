package br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class TelaJFrame extends JFrame{
	
	private JFrame frame;
	private JTextField textField;
	private JList<?> lista;
	private ArrayList<String> arraylist;
	
	
	public void SetAdicionaItens(String string) {
		String[] historico = {};
		lista = new JList<>(historico);
		textField = new JTextField();
		textField.setText(string);
//		arraylist = new ArrayList<String>();
//		arraylist.add(string);
//		for (int i = 0; i < arraylist.size(); i++) {
//			textField.setText(arraylist.get(i));
//		}
		CriaTelaJFrame();
		frame.add(BorderLayout.WEST, lista);
	}
	
	private void  CriaTelaJFrame() {
		
		
		frame = new JFrame("Histórico de Conversões");    //creat new frame
//		frame.add(BorderLayout.WEST, lista);
		frame.add(textField);
		//frame.getContentPane().setBackground(Color.BLACK);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);       //make it visible
    	frame.setResizable(false);
    	frame.setSize(600,600);      //set the size
    	frame.setLocationRelativeTo(null);// center frame
		
	}
	
	
	
}
