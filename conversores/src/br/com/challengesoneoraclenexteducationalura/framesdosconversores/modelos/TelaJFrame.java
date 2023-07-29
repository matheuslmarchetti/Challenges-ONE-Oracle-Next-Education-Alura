package br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

public class TelaJFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JList<String> lista;
	private DefaultListModel<String> mod;
	
	
	
	
	public void SetAdicionaItens(String string) {
				mod.addElement(string);		
	}
	
	public TelaJFrame() {
		
		mod = new DefaultListModel<String>();
		lista = new JList<String>();
		lista.setModel((ListModel<String>) mod);		
		CriaTelaJFrame();

		
	}
	
	private void  CriaTelaJFrame() {
		
		frame = new JFrame("Histórico de Conversões");    //creat new frame
		frame.add(BorderLayout.CENTER, lista);
		frame.getContentPane().setBackground(Color.GRAY);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);       //make it visible
    	frame.setResizable(false);
    	frame.setSize(600,600);      //set the size
    	frame.setLocationRelativeTo(null);// center frame
    	
	}
}
