package br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import org.json.simple.parser.ParseException;

public class TelaJFrame extends JFrame{
	
	private JFrame frame;
	private JTextField textField;
	private JList<?> lista;
	private ArrayList<String> arraylist;
	private String str;
	
	
	
	
	public void SetAdicionaItens(String string) {
				
		textField.setText(string);
		arraylist = new ArrayList<String>();
		arraylist.add(string);	
		for (int i = 0; i < arraylist.size(); i++) {
			str = arraylist.get(i).intern();
			System.out.println(str);
		}		
		
	}
	
	public TelaJFrame() {
		
		String[] historico = {"Conversor de Moedas", "Conversor de Temperatura", "Conversor de Tempo"};
		lista = new JList<>(historico);
		
		
		textField = new JTextField();
		
		CriaTelaJFrame();
		
		System.out.println(str);
		
	}
	
	final private void  CriaTelaJFrame() {
		
		frame = new JFrame("Histórico de Conversões");    //creat new frame
		frame.add(BorderLayout.WEST, lista);
		frame.add(textField);
		frame.getContentPane().setBackground(Color.GRAY);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);       //make it visible
    	frame.setResizable(false);
    	frame.setSize(600,600);      //set the size
    	frame.setLocationRelativeTo(null);// center frame
    	
	}
}
