package br.com.challengesoneoraclenexteducationalura.conversordetempo.modelos;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.json.simple.parser.ParseException;

import br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos.ConversorMenuPrincipal;
import br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos.TelaJFrame;

public class ConversorDeTempo {
	private int valorConvertidoParaInt;
	private String entradaDeValorParaConversao;
	private TelaJFrame frame;
	
	public ConversorDeTempo() throws IOException, InterruptedException, ParseException {
		
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		 entradaDeValorParaConversao = JOptionPane.showInputDialog(frame,
				 "Bem-vindo(a)!" + System.lineSeparator() +
				 "Insira um valor a ser convertido: ", "Conversor de Tempo",
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
				"Conversor de Tempo", JOptionPane.QUESTION_MESSAGE);
		
		if (this.entradaDeValorParaConversao == null) {
			frame.dispose();
		} else {
			LeituraDeDados();
		}
	}
	public void LeituraDeDados() throws IOException, InterruptedException, ParseException {

		try {
			valorConvertidoParaInt = Integer.parseInt(entradaDeValorParaConversao);

			if (valorConvertidoParaInt > 0) {
				ConversorDeTempopcoes();
			} else {
				JOptionPane.showMessageDialog(null, "Informe um valor válido", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				LoopLeituraDeDados();
			}
		} 
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Digite apenas números inteiro!" + System.lineSeparator() + "Não use agrupador de milhar",
					"Erro!",
					JOptionPane.ERROR_MESSAGE);
			LoopLeituraDeDados();
		}

	}

	public void ConversorDeTempopcoes() throws IOException, InterruptedException, ParseException {
		Object[] opcoesDeTempo = { "De Dia a Hora", // 0
				"De Dia a Minuto", // 1
				"De Dia a Segundo", // 2
				"De Hora a Dia", // 3
				"De Hora a Minuto", // 4
				"De Hora a Segundo", // 5
				"De Minuto a Dia", //6
				"De Minuto a Hora", //7
				"De Minuto a Segundo", //8
				"De Segundo a Dia", //9
				"De Segundo a Hora", //10
				"De Segundo a Minuto", //11
		};

		Object selection = JOptionPane.showInputDialog(null, "Selecione a opção de medida de tempo para conversão", "Medidas de Tempo",
				JOptionPane.PLAIN_MESSAGE, null, opcoesDeTempo, opcoesDeTempo[0]);
		
		if (selection == opcoesDeTempo[0]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Dia", "Hora", valorConvertidoParaInt)
					.getGeraHistorico("d", "h", "Dia", "Hora"));
			DesejaContinuar();

		} else if (selection == opcoesDeTempo[1]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Dia", "Minuto", valorConvertidoParaInt)
					.getGeraHistorico("d", "min", "Dia", "Minuto"));
			DesejaContinuar();

		} else if (selection == opcoesDeTempo[2]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Dia", "Segundo", valorConvertidoParaInt)
					.getGeraHistorico("d", "s", "Dia", "Segundo"));
			DesejaContinuar();

		} else if (selection == opcoesDeTempo[3]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Hora", "Dia", valorConvertidoParaInt)
					.getGeraHistorico("h", "d", "Hora", "Dia"));
			DesejaContinuar();

		} else if (selection == opcoesDeTempo[4]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Hora", "Minuto", valorConvertidoParaInt)
					.getGeraHistorico("h", "min", "Hora", "Minuto"));
			DesejaContinuar();

		} else if (selection == opcoesDeTempo[5]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Hora", "Segundo", valorConvertidoParaInt)
					.getGeraHistorico("h", "s", "Hora", "Segundo "));
			DesejaContinuar();

		} else if (selection == opcoesDeTempo[6]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Minuto", "Dia", valorConvertidoParaInt)
					.getGeraHistorico("min", "d", "Minuto", "Dia"));
			DesejaContinuar();

		}  else if (selection == opcoesDeTempo[7]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Minuto", "Hora", valorConvertidoParaInt)
					.getGeraHistorico("min", "h", "Minuto", "Hora"));
			DesejaContinuar();

		}  else if (selection == opcoesDeTempo[8]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Minuto", "Segundo", valorConvertidoParaInt)
					.getGeraHistorico("min", "s", "Minuto", "Segundo"));
			DesejaContinuar();

		}  else if (selection == opcoesDeTempo[9]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Segundo", "Dia", valorConvertidoParaInt)
					.getGeraHistorico("s", "d", "Segundo", "Dia"));
			DesejaContinuar();

		}  else if (selection == opcoesDeTempo[10]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Segundo", "Hora", valorConvertidoParaInt)
					.getGeraHistorico("s", "h", "Segundo", "Hora"));
			DesejaContinuar();

		}  else if (selection == opcoesDeTempo[11]) {
			frame.SetAdicionaItens(new FuncaoTempo
					("Segundo", "Minuto", valorConvertidoParaInt)
					.getGeraHistorico("s", "min", "Segundo", "Minuto"));
			DesejaContinuar();

		}  
		else {
			JOptionPane.showMessageDialog(null, "Opção Inválida", "Atenção", JOptionPane.WARNING_MESSAGE);
			LoopLeituraDeDados();
			
		}		
	}

	public void DesejaContinuar() throws IOException, InterruptedException, ParseException {

		Object[] options = { "Sim", "Não", "Sair" };

		int i = JOptionPane.showOptionDialog(null, "Deseja continuar no Conversor de Tempo?", "Menu",
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
