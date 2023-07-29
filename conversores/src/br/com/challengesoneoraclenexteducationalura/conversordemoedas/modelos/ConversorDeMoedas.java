package br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.json.simple.parser.ParseException;

import br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos.ConversorMenuPrincipal;
import br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos.TelaJFrame;

public class ConversorDeMoedas {

	private double valorConvertidoParaDouble;
	private String entradaDeValorParaConversao;
	private TelaJFrame frame;
	
	public ConversorDeMoedas() throws IOException, InterruptedException, ParseException {
		
		
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		 entradaDeValorParaConversao = JOptionPane.showInputDialog(frame,
				 "Bem-vindo(a)!" + System.lineSeparator() +
				 "Insira um valor a ser convertido: ", "Conversor de Moedas",
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
				"Conversor de Moedas", JOptionPane.QUESTION_MESSAGE);
		
		if (this.entradaDeValorParaConversao == null) {
			frame.dispose();
		} else {
			LeituraDeDados();
		}
	}
	public void LeituraDeDados() throws IOException, InterruptedException, ParseException {

		try {
			valorConvertidoParaDouble = Double.parseDouble(entradaDeValorParaConversao.replace(",", "."));

			if (valorConvertidoParaDouble > 0) {
				ConversorDeMoedasOpcoes();
			} else {
				JOptionPane.showMessageDialog(null, "Informe um valor maior que zero!", "Atenção!",
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

	public void ConversorDeMoedasOpcoes() throws IOException, InterruptedException, ParseException {
		Object[] opcoesDeMoedas = { "De Real a Dólar", // 0
				"De Real a Euro", // 1
				"De Real a Libra Esterlina", // 2
				"Dólar a Real", // 3
				"Dólar a Euro", // 4
				"Dólar a Libra Esterlina", // 5
				"Euro a Real", // 6
				"Euro a Dólar", // 7
				"Euro a Libra Esterlina", // 8
				"Libra Esterlina a Real", // 9
				"Libra Esterlina a Dólar", // 10
				"Libra Esterlina a Euro", // 11
		};

		Object selection = JOptionPane.showInputDialog(null, "Selecione a moeda de conversão", "Moedas",
				JOptionPane.PLAIN_MESSAGE, null, opcoesDeMoedas, opcoesDeMoedas[0]);
		
		if (selection == opcoesDeMoedas[0]) {
			frame.SetAdicionaItens((new ChamadaApiCotacaoDeMoedas("BRLUSD", "pt", "BR", "en", "US", valorConvertidoParaDouble).getGeraHistorico()));
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[1]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("BRLEUR", "pt", "BR", "fr", "FR", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[2]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("BRLGBP", "pt", "BR", "en", "GB", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[3]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("USDBRL", "en", "US", "pt", "BR", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[4]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("USDEUR", "en", "US", "fr", "FR", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[5]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("USDGBP", "en", "US", "en", "GB", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[6]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("EURBRL", "fr", "FR", "pt", "BR", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[7]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("EURUSD", "fr", "FR", "en", "US", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[8]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("EURGBP", "fr", "FR", "en", "GB", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[9]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("GBPBRL", "en", "GB", "pt", "BR", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[10]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("GBPUSD", "en", "GB", "en", "US", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[11]) {
			frame.SetAdicionaItens(new ChamadaApiCotacaoDeMoedas("GBPEUR", "en", "GB", "fr", "FR", valorConvertidoParaDouble).getGeraHistorico());
			DesejaContinuar();

		} else {
			JOptionPane.showMessageDialog(null, "Opção Inválida", "Atenção", JOptionPane.WARNING_MESSAGE);
			LoopLeituraDeDados();
			
		}		
	}

	public void DesejaContinuar() throws IOException, InterruptedException, ParseException {

		Object[] options = { "Sim", "Não", "Sair" };

		int i = JOptionPane.showOptionDialog(null, "Deseja continuar no Conversor de Moedas?", "Menu",
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
