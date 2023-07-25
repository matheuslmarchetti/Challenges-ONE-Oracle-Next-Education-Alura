package br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos;

import javax.swing.JOptionPane;

public class ConversorDeMoedas {
	
	private double valorConvertidoParaDouble;
	private String entradaDeValorParaConversao;

	public ConversorDeMoedas() {
		
		entradaDeValorParaConversao = JOptionPane.showInputDialog(null, "Bem-vindo(a)!" + 
				System.lineSeparator() + "Insira um valor a ser convertido: ", 
						"Conversor de Moedas", JOptionPane.QUESTION_MESSAGE);	
		
		LeituraDeDados();

	}
	
	public void LoopLeituraDeDadosErrados() {
		entradaDeValorParaConversao = JOptionPane.showInputDialog(null, "Insira um valor a ser convertido: ", 
						"Conversor de Moedas", JOptionPane.QUESTION_MESSAGE);	
		
		LeituraDeDados();
	}
	
	public void LeituraDeDados() {
		
		try {
			valorConvertidoParaDouble = Double.parseDouble(entradaDeValorParaConversao);
			if (valorConvertidoParaDouble >= 0) {
				JOptionPane.showMessageDialog(null, "Valor informado: " + valorConvertidoParaDouble, "Conversor de Moedas", 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Informe um valor maior que zero!" , "Atenção!", 
						JOptionPane.WARNING_MESSAGE);
				//new ConversorDeMoedas();
				LoopLeituraDeDadosErrados();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Voltando ao Menu Inicial...", "Informação", 
					JOptionPane.INFORMATION_MESSAGE);
					new ConversorMenuPrincipal();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite apenas números!" , "Erro!", 
					JOptionPane.ERROR_MESSAGE);
			LoopLeituraDeDadosErrados();
		}
		
	}
	
}
