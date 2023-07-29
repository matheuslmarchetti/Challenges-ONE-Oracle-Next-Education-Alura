package br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class TelaJFrame extends JFrame{
	
	private JFrame frame;
	private JList<?> lista;
	private ArrayList<String> arraylist;
	private String str;
	private DefaultListModel mod;
	
	
	
	
	public void SetAdicionaItens(String string) {
				//str = string;
				mod.addElement(string);
				
		
	}
	
	public TelaJFrame() {
		
		mod = new DefaultListModel();
		lista = new JList<>();
		lista.setModel(mod);		
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
