package br.com.challengesoneoraclenexteducationalura.sistedeconversores.telainicial;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import org.json.simple.parser.ParseException;

import br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos.ConversorMenuPrincipal;

public class TelaConversor {
	private static JFrame frame;
	
	public static void main(String[] args) throws IOException, InterruptedException, ParseException {
		
		frame = new JFrame("Sistema de Conversores");    //creat new frame
		frame.getContentPane().setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);       //make it visible
    	frame.setResizable(false);
    	frame.setSize(600,600);      //set the size
    	frame.setLocationRelativeTo(null);// center frame
		
    	JLabel labelBemVindo = new JLabel("Bem-vindo(a) ao Sistema de Conversores");
		//labelBemVindo.setBounds(100, 100, 500, 70);
    	labelBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
    	labelBemVindo.setVerticalAlignment(SwingConstants.CENTER);
		labelBemVindo.setFont(new Font("Arial", Font.BOLD, 16));
		frame.add(labelBemVindo);
		
		final JButton buttonIniciar = new JButton("Iniciar");
		buttonIniciar.setBounds(240, 300, 120, 30);
		buttonIniciar.setFont(new Font("Arial", Font.BOLD, 20));
		buttonIniciar.setFocusPainted(false);
		buttonIniciar.setForeground(Color.WHITE);
		buttonIniciar.setBackground(Color.BLACK);
		buttonIniciar.setBorderPainted(false);

		buttonIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	buttonIniciar.setForeground(Color.BLACK);
		    	buttonIniciar.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	buttonIniciar.setForeground(Color.WHITE);
		    	buttonIniciar.setBackground(Color.BLACK);
		    }
		});
		
		buttonIniciar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();                //close old frame
					new ConversorMenuPrincipal();
				} catch (IOException | InterruptedException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}            
			}
		});
		
		final JButton buttonSair = new JButton("Sair");
		buttonSair.setBounds(240, 350, 120, 30);
		buttonSair.setFont(new Font("Arial", Font.BOLD, 20));
		buttonSair.setFocusPainted(false);
		buttonSair.setForeground(Color.WHITE);
		buttonSair.setBackground(Color.BLACK);
		buttonSair.setBorderPainted(false);

		buttonSair.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	buttonSair.setForeground(Color.BLACK);
		    	buttonSair.setBackground(Color.GRAY);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	buttonSair.setForeground(Color.WHITE);
		    	buttonSair.setBackground(Color.BLACK);
		    }
		});
		
		buttonSair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Saindo do programa...", "Mensagem", 
				JOptionPane.WARNING_MESSAGE);
				System.exit(0);
				
			}
		});
		
		frame.add(buttonIniciar);
		frame.add(buttonSair);
		
	}
}