package br.com.challengesoneoraclenexteducationalura.conversordetemperatura.modelos;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

public class FuncaoEscalaTermometrica {
private String resultadoConversao;
private double valorInputTemperatura;
private String erro;
private Locale localeBR = new Locale("pt","BR");
private NumberFormat numberFormat = NumberFormat.getNumberInstance(localeBR);

	public FuncaoEscalaTermometrica(String escalaAtual, String escalaParaConversao, double valordaTemperatura) {
		valorInputTemperatura = valordaTemperatura;
		switch (escalaAtual) {
		case "Celsius":
			if (escalaParaConversao == "Fahrenheit") {
				resultadoConversao = numberFormat.format((valorInputTemperatura * 1.8) + 32);
				JOptionPane.showMessageDialog(null,
						"A temperatura convertida equivale a: " + resultadoConversao + "\u00b0F",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (escalaParaConversao == "Kelvin") {
				resultadoConversao = numberFormat.format(valorInputTemperatura + 273.15);
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
				resultadoConversao = numberFormat.format((valorInputTemperatura - 32) / 1.8);
				JOptionPane.showMessageDialog(null,
						"A temperatura convertida equivale a: " + resultadoConversao + "\u00b0C",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (escalaParaConversao == "Kelvin") {
				resultadoConversao = numberFormat.format((valorInputTemperatura - 32) * 5/9 + 273.15);
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
				resultadoConversao = numberFormat.format(valorInputTemperatura - 273.15);
				JOptionPane.showMessageDialog(null,
						"A temperatura convertida equivale a: " + resultadoConversao + "\u00b0C",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (escalaParaConversao == "Fahrenheit") {
				resultadoConversao = numberFormat.format(((valorInputTemperatura - 273.15) * 1.8) + 32);
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
		String valorInputTemperaturaFormat = numberFormat.format(valorInputTemperatura);
		return valorInputTemperaturaFormat + simboloTemperaturaAtual + " = "
			+ this.resultadoConversao + simboloTemperaturaConvertido + " - "
				+ escalaAtual + " | " + escalaParaConversao;
	}
}
