package br.com.challengesoneoraclenexteducationalura.conversordetempo.modelos;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

public class FuncaoTempo {
private String resultadoConversao;
private int valorInputTempo;
private String erro;
private Locale localeBR = new Locale("pt","BR");
private NumberFormat numberFormat = NumberFormat.getNumberInstance(localeBR);

	public FuncaoTempo(String tempoAtual, String tempoParaConversao, int valordaTempo) {
		valorInputTempo = valordaTempo;
		switch (tempoAtual) {
		case "Dia":
			if (tempoParaConversao == "Hora") {
				resultadoConversao = numberFormat.format((valorInputTempo * 24));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "h",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (tempoParaConversao == "Minuto") {
				resultadoConversao = numberFormat.format((valorInputTempo * 1440));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "min",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (tempoParaConversao == "Segundo") {
				resultadoConversao = numberFormat.format((valorInputTempo * 86400));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "s",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else  {
				erro = "Informe valores válidos!";
				JOptionPane.showMessageDialog(null,
						erro,
						"Resultado", JOptionPane.ERROR_MESSAGE);
			}
			break;
				
		case "Hora":
			if (tempoParaConversao == "Dia") {
				resultadoConversao = numberFormat.format((valorInputTempo / 24));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "d",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (tempoParaConversao == "Minuto") {
				resultadoConversao = numberFormat.format((valorInputTempo * 60));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "min",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (tempoParaConversao == "Segundo") {
				resultadoConversao = numberFormat.format((valorInputTempo * 3600));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "s",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else  {
				erro = "Informe valores válidos!";
				JOptionPane.showMessageDialog(null,
						erro,
						"Resultado", JOptionPane.ERROR_MESSAGE);
			}
			break;
				
		case "Minuto":
			if (tempoParaConversao == "Dia") {
				resultadoConversao = numberFormat.format((valorInputTempo / 1440));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "d",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (tempoParaConversao == "Hora") {
				resultadoConversao = numberFormat.format((valorInputTempo / 60));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "h",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (tempoParaConversao == "Segundo") {
				resultadoConversao = numberFormat.format((valorInputTempo * 60));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "s",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else  {
				erro = "Informe valores válidos!";
				JOptionPane.showMessageDialog(null,
						erro,
						"Resultado", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		case "Segundo":
			if (tempoParaConversao == "Dia") {
				resultadoConversao = numberFormat.format((valorInputTempo / 86400));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "d",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (tempoParaConversao == "Hora") {
				resultadoConversao = numberFormat.format((valorInputTempo / 3600));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "h",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (tempoParaConversao == "Minuto") {
				resultadoConversao = numberFormat.format((valorInputTempo / 60));
				JOptionPane.showMessageDialog(null,
						"O Tempo convertido equivale a: " + resultadoConversao + "min",
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
		
	public String getGeraHistorico(String simboloTempoAtual, String simboloTempoConvertido, 
			String TempoAtual, String TempoParaConversao ) {
		String valorInputTempoFormat = numberFormat.format(valorInputTempo);
		return valorInputTempoFormat + simboloTempoAtual + " = "
			+ this.resultadoConversao + simboloTempoConvertido + " - "
				+ TempoAtual + " | " + TempoParaConversao;
	}
}