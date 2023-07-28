package br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.json.simple.parser.ParseException;

import br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos.ConversorDeMoedas;
import br.com.challengesoneoraclenexteducationalura.conversordetemperatura.modelos.ConversorDeTemperatura;
import br.com.challengesoneoraclenexteducationalura.conversordetempo.modelos.ConversorDeTempo;

public class ConversorMenuPrincipal {
	
	private Object[] opcoesDeConversor = {"Escolha uma Opção", "Conversor de Moedas", "Conversor de Temperatura", 
			"Conversor de Tempo"};
	
	public ConversorMenuPrincipal() throws IOException, InterruptedException, ParseException {
		
		TelaJFrame frame = new TelaJFrame();
		
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		
		Object selection = JOptionPane.showInputDialog(frame, "Selecione um Conversor","Menu", 
				JOptionPane.PLAIN_MESSAGE, 
				null, opcoesDeConversor, opcoesDeConversor[0]);		
		
//		Object selection = JOptionPane.showInputDialog(null, "Selecione um Conversor","Menu", 
//				JOptionPane.PLAIN_MESSAGE, 
//				null, opcoesDeConversor, opcoesDeConversor[0]);	
		
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
