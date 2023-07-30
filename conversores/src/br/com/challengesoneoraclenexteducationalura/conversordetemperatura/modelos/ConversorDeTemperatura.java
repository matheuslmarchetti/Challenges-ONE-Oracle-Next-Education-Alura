package br.com.challengesoneoraclenexteducationalura.conversordetemperatura.modelos;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.json.simple.parser.ParseException;


import br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos.ConversorMenuPrincipal;
import br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos.TelaJFrame;

public class ConversorDeTemperatura {
	private double valorConvertidoParaDouble;
	private String entradaDeValorParaConversao;
	private TelaJFrame frame;
	
	public ConversorDeTemperatura() throws IOException, InterruptedException, ParseException {
		
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		 entradaDeValorParaConversao = JOptionPane.showInputDialog(frame,
				 "Bem-vindo(a)!" + System.lineSeparator() +
				 "Insira um valor a ser convertido: ", "Conversor de Temperatura",
				 JOptionPane.QUESTION_MESSAGE);
		 
		 if (entradaDeValorParaConversao == null) {
			
			JOptionPane.showMessageDialog(null, "Voltando ao Menu Inicial...", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			new ConversorMenuPrincipal();
		}
		 frame = new TelaJFrame();
		 LeituraDeDados();
	}
	
	
	public void LoopLeituraDeDados() throws IOException, InterruptedException, ParseException {
		
		entradaDeValorParaConversao = JOptionPane.showInputDialog(frame, "Insira um valor a ser convertido: ",
				"Conversor de Temperatura", JOptionPane.QUESTION_MESSAGE);
		
		if (this.entradaDeValorParaConversao == null) {
			frame.dispose();
		} else {
			LeituraDeDados();
		}
	}
	public void LeituraDeDados() throws IOException, InterruptedException, ParseException {

		try {
			valorConvertidoParaDouble = Double.parseDouble(entradaDeValorParaConversao.replace(",", "."));

			if (valorConvertidoParaDouble < 0 |valorConvertidoParaDouble > 0) {
				ConversorDeTemperaturaOpcoes();
			} else {
				JOptionPane.showMessageDialog(null, "Informe um valor válido", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				LoopLeituraDeDados();
			}
		} 
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Digite apenas números!" + System.lineSeparator() + "Não use agrupador de milhar", "Erro!",
					JOptionPane.ERROR_MESSAGE);
			LoopLeituraDeDados();
		}

	}

	public void ConversorDeTemperaturaOpcoes() throws IOException, InterruptedException, ParseException {
		Object[] opcoesDeTemperatura = { "De Grau Celsius a Grau Fahrenheit", // 0
				"De Grau Celsius a Kelvin", // 1
				"De Grau Fahrenheit a Grau Celsius", // 2
				"De Grau Fahrenheit a Kelvin", // 3
				"De Kelvin a Grau Celsius", // 4
				"De Kelvin a Grau Fahrenheit", // 5
		};

		Object selection = JOptionPane.showInputDialog(null, "Selecione a escala termométrica de conversão", "Escalas Termométricas",
				JOptionPane.PLAIN_MESSAGE, null, opcoesDeTemperatura, opcoesDeTemperatura[0]);
		
		if (selection == opcoesDeTemperatura[0]) {
			frame.SetAdicionaItens(new FuncaoEscalaTermometrica
					("Celsius", "Fahrenheit", valorConvertidoParaDouble)
					.getGeraHistorico("\u00b0C", "\u00b0F", "Celsius", "Fahrenheit"));
			DesejaContinuar();

		} else if (selection == opcoesDeTemperatura[1]) {
			frame.SetAdicionaItens(new FuncaoEscalaTermometrica
					("Celsius", "Kelvin", valorConvertidoParaDouble)
					.getGeraHistorico("\u00b0C", "K", "Celsius", "Kelvin"));
			DesejaContinuar();

		} else if (selection == opcoesDeTemperatura[2]) {
			frame.SetAdicionaItens(new FuncaoEscalaTermometrica
					("Fahrenheit", "Celsius", valorConvertidoParaDouble)
					.getGeraHistorico("\u00b0F", "\u00b0C", "Fahrenheit", "Celsius"));
			DesejaContinuar();

		} else if (selection == opcoesDeTemperatura[3]) {
			frame.SetAdicionaItens(new FuncaoEscalaTermometrica
					("Fahrenheit", "Kelvin", valorConvertidoParaDouble)
					.getGeraHistorico("\u00b0F", "K", "Fahrenheit", "Kelvin"));
			DesejaContinuar();

		} else if (selection == opcoesDeTemperatura[4]) {
			frame.SetAdicionaItens(new FuncaoEscalaTermometrica
					("Kelvin", "Celsius", valorConvertidoParaDouble)
					.getGeraHistorico("K", "\u00b0C", "Kelvin", "Celsius"));
			DesejaContinuar();

		} else if (selection == opcoesDeTemperatura[5]) {
			frame.SetAdicionaItens(new FuncaoEscalaTermometrica
					("Kelvin", "Fahrenheit", valorConvertidoParaDouble)
					.getGeraHistorico("K", "\u00b0F", "Kelvin", "Fahrenheit"));
			DesejaContinuar();

		} else {
			JOptionPane.showMessageDialog(null, "Opção Inválida", "Atenção", JOptionPane.WARNING_MESSAGE);
			LoopLeituraDeDados();
			
		}		
	}

	public void DesejaContinuar() throws IOException, InterruptedException, ParseException {

		Object[] options = { "Sim", "Não", "Sair" };

		int i = JOptionPane.showOptionDialog(null, "Deseja continuar no Conversor de Temperatura?", "Menu",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

		if (i == JOptionPane.YES_OPTION) {
			LoopLeituraDeDados();
		} else if (i == JOptionPane.NO_OPTION) {
			JOptionPane.getRootFrame().dispose();
		} else {
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Saindo do programa...", "Atenção", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}

	}

}
