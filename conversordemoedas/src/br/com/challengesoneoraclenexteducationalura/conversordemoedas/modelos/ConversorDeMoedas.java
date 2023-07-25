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
	
	public void LoopLeituraDeDados() {
		entradaDeValorParaConversao = JOptionPane.showInputDialog(null, "Insira um valor a ser convertido: ", 
						"Conversor de Moedas", JOptionPane.QUESTION_MESSAGE);	
		
		LeituraDeDados();
	}
	
	public void LeituraDeDados() {
		
		try {
			valorConvertidoParaDouble = Double.parseDouble(entradaDeValorParaConversao);
			if (valorConvertidoParaDouble >= 0) {
				ConversorDeMoedasOpcoes();
			} else {
				JOptionPane.showMessageDialog(null, "Informe um valor maior que zero!" , "Atenção!", 
						JOptionPane.WARNING_MESSAGE);
				LoopLeituraDeDados();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Voltando ao Menu Inicial...", "Informação", 
					JOptionPane.INFORMATION_MESSAGE);
					new ConversorMenuPrincipal();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite apenas números!" , "Erro!", 
					JOptionPane.ERROR_MESSAGE);
			LoopLeituraDeDados();
		}
		
	}
	
	public void ConversorDeMoedasOpcoes() {
		Object[] opcoesDeMoedas = 
			{
					"De Reais a Dólares", //0
					"De Reais a Euros", //1
					"De Reais a Libras", //2
					"Dólares a Reais", //3
					"Dólares a Euros", //4
					"Dólares a Libras", //5
					"Euros a Reais", //6
					"Euros a Dólares", //7
					"Euros a Libras", //8
					"Libras a Reais", //9
					"Libras a Dólares", //10
					"Libras a Euros", //11
			};
		
		Object selection = JOptionPane.showInputDialog(null, "Selecione a moeda de conversão","Moedas", 
				JOptionPane.PLAIN_MESSAGE, 
				null, opcoesDeMoedas, opcoesDeMoedas[0]);
		
		if (selection == opcoesDeMoedas[0]) {
			double cotacao = 4.75;
			double result = valorConvertidoParaDouble / cotacao ;
			JOptionPane.showMessageDialog(null, "US$ " + result, "Resultado", 
					JOptionPane.INFORMATION_MESSAGE);
			LoopLeituraDeDados();
		} else if(selection == opcoesDeMoedas[1]) {
			double cotacao = 5.25;
			double result = valorConvertidoParaDouble / cotacao ;
			JOptionPane.showMessageDialog(null, "€ " + result, "Resultado", 
					JOptionPane.INFORMATION_MESSAGE);
			LoopLeituraDeDados();
		} else if(selection == opcoesDeMoedas[2]) {
			double cotacao = 6.13;
			double result = valorConvertidoParaDouble / cotacao ;
			JOptionPane.showMessageDialog(null, "£ " + result, "Resultado", 
					JOptionPane.INFORMATION_MESSAGE);
			LoopLeituraDeDados();
		} else if(selection == opcoesDeMoedas[3]) {
			double cotacao = 4.75;
			double result = valorConvertidoParaDouble * cotacao ;
			JOptionPane.showMessageDialog(null, "R$ " + result, "Resultado", 
					JOptionPane.INFORMATION_MESSAGE);
			LoopLeituraDeDados();
		} else {
			JOptionPane.showMessageDialog(null, "Opção Inválida", "Atenção", 
					JOptionPane.WARNING_MESSAGE);
			LoopLeituraDeDados();
		}
		
	}
	
}
