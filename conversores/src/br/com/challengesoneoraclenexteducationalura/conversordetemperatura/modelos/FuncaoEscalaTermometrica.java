package br.com.challengesoneoraclenexteducationalura.conversordetemperatura.modelos;

import javax.swing.JOptionPane;

public class FuncaoEscalaTermometrica {
private double resultadoConversao;
private double valorInputTemperatura;
private String erro;

	public FuncaoEscalaTermometrica(String escalaAtual, String escalaParaConversao, double valordaTemperatura) {
		valorInputTemperatura = valordaTemperatura;
		switch (escalaAtual) {
		case "Celsius":
			if (escalaParaConversao == "Fahrenheit") {
				resultadoConversao = (valorInputTemperatura * 1.8) + 32;
				JOptionPane.showMessageDialog(null,
						"A temperatura convertida equivale a: " + resultadoConversao + "\u00b0F",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (escalaParaConversao == "Kelvin") {
				resultadoConversao = valorInputTemperatura + 273.15;
				JOptionPane.showMessageDialog(null,
						"A temperatura convertida equivale a: " + resultadoConversao + "K",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else  {
				erro = "Informe valores válidos!";
				JOptionPane.showMessageDialog(null,
						erro,
						"Resultado", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		case "Fahrenheit":
			if (escalaParaConversao == "Celsius") {
				resultadoConversao = (valorInputTemperatura - 32) / 1.8;
				JOptionPane.showMessageDialog(null,
						"A temperatura convertida equivale a: " + resultadoConversao + "\u00b0C",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (escalaParaConversao == "Kelvin") {
				resultadoConversao = (valorInputTemperatura - 32) * 5/9 + 273.15;
				JOptionPane.showMessageDialog(null,
						"A temperatura convertida equivale a: " + resultadoConversao + "K",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else  {
				erro = "Informe valores válidos!";
				JOptionPane.showMessageDialog(null,
						erro,
						"Resultado", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		case "Kelvin":
			if (escalaParaConversao == "Celsius") {
				resultadoConversao = valorInputTemperatura - 273.15;
				JOptionPane.showMessageDialog(null,
						"A temperatura convertida equivale a: " + resultadoConversao + "\u00b0C",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (escalaParaConversao == "Fahrenheit") {
				resultadoConversao = ((valorInputTemperatura - 273.15) * 1.8) + 32;
				JOptionPane.showMessageDialog(null,
						"A temperatura convertida equivale a: " + resultadoConversao + "\u00b0F",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else  {
				erro = "Informe valores válidos!";
				JOptionPane.showMessageDialog(null,
						erro,
						"Resultado", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			erro = "Informe valores válidos!";
			JOptionPane.showMessageDialog(null,
					erro,
					"Resultado", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
	
	public String getGeraHistorico(String simboloTemperaturaAtual, String simboloTemperaturaConvertido, 
			String escalaAtual, String escalaParaConversao ) {
		return this.valorInputTemperatura + simboloTemperaturaAtual + " = "
			+ this.resultadoConversao + simboloTemperaturaConvertido + " - "
				+ escalaAtual + " | " + escalaParaConversao;
	}
}
