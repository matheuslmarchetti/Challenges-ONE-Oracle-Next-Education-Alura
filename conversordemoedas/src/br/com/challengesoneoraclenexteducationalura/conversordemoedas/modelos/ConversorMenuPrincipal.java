package br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos;

import javax.swing.JOptionPane;

public class ConversorMenuPrincipal {
	
	private Object[] opcoesDeConversor = {"Escolha uma Opção", "Conversor de Moedas", "Conversor de Temperatura", 
			"Conversor de Tempo"};
	
	public ConversorMenuPrincipal() {
		
		Object selection = JOptionPane.showInputDialog(null, "Selecione um Conversor","Menu", 
				JOptionPane.PLAIN_MESSAGE, 
				null, opcoesDeConversor, opcoesDeConversor[0]);	
		
		if (selection == opcoesDeConversor[0]) {
			JOptionPane.showMessageDialog(null, "Selecione uma opção válida!", "Informação", 
					JOptionPane.INFORMATION_MESSAGE);
			new ConversorMenuPrincipal();
		} else if(selection == opcoesDeConversor[1]) {
			new ConversorDeMoedas();
		} else if(selection == opcoesDeConversor[2]) {
			new ConversorDeTemperatura();
		} else if(selection == opcoesDeConversor[3]) {
			new ConversorDeTempo();
		} else {
			JOptionPane.showMessageDialog(null, "Saindo do programa...", "Atenção", 
					JOptionPane.WARNING_MESSAGE);
					System.exit(0);
		}
		
	}

}
