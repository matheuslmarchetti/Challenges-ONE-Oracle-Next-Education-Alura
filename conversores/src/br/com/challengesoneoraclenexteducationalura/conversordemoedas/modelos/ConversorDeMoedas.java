package br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.json.simple.parser.ParseException;

import br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos.ConversorMenuPrincipal;

public class ConversorDeMoedas {

	private double valorConvertidoParaDouble;
	private String entradaDeValorParaConversao;
	private String[] referencias;
	private int posicaoLivre;
	private String dinheiroFormat;

	public ConversorDeMoedas() throws IOException, InterruptedException, ParseException {
		
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		
		 entradaDeValorParaConversao = JOptionPane.showInputDialog(null,
				 "Bem-vindo(a)!" + System.lineSeparator() +
				 "Insira um valor a ser convertido: ", "Conversor de Moedas",
				 JOptionPane.QUESTION_MESSAGE);
		 
		 LeituraDeDados();

	}

	public void LoopLeituraDeDados() throws IOException, InterruptedException, ParseException {
		
		entradaDeValorParaConversao = JOptionPane.showInputDialog(null, "Insira um valor a ser convertido: ",
				"Conversor de Moedas", JOptionPane.QUESTION_MESSAGE);
		
		LeituraDeDados();
	}

	public void LeituraDeDados() throws IOException, InterruptedException, ParseException {

		try {
			valorConvertidoParaDouble = Double.parseDouble(entradaDeValorParaConversao.replace(",", "."));
			if (valorConvertidoParaDouble >= 0) {
				ConversorDeMoedasOpcoes();
			} else {
				JOptionPane.showMessageDialog(null, "Informe um valor maior que zero!", "Atenção!",
						JOptionPane.WARNING_MESSAGE);
				LoopLeituraDeDados();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Voltando ao Menu Inicial...", "Informação",
					JOptionPane.INFORMATION_MESSAGE);
			new ConversorMenuPrincipal();
		} catch (NumberFormatException e) {
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

			new ChamadaApiCotacaoDeMoedas("BRLUSD", "en", "US", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[1]) {

			new ChamadaApiCotacaoDeMoedas("BRLEUR", "fr", "FR", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[2]) {

			new ChamadaApiCotacaoDeMoedas("BRLGBP", "en", "GB", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[3]) {

			new ChamadaApiCotacaoDeMoedas("USDBRL", "pt", "BR", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[4]) {

			new ChamadaApiCotacaoDeMoedas("USDEUR", "fr", "FR", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[5]) {

			new ChamadaApiCotacaoDeMoedas("USDGBP", "en", "GB", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[6]) {

			new ChamadaApiCotacaoDeMoedas("EURBRL", "pt", "BR", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[7]) {

			new ChamadaApiCotacaoDeMoedas("EURUSD", "en", "US", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[8]) {

			new ChamadaApiCotacaoDeMoedas("EURGBP", "en", "GB", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[9]) {

			new ChamadaApiCotacaoDeMoedas("GBPBRL", "pt", "BR", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[10]) {

			new ChamadaApiCotacaoDeMoedas("GBPUSD", "en", "US", valorConvertidoParaDouble);
			DesejaContinuar();

		} else if (selection == opcoesDeMoedas[11]) {

			new ChamadaApiCotacaoDeMoedas("GBPEUR", "fr", "FR", valorConvertidoParaDouble);
			DesejaContinuar();

		} else {
			JOptionPane.showMessageDialog(null, "Opção Inválida", "Atenção", JOptionPane.WARNING_MESSAGE);
			LoopLeituraDeDados();
			
		}		
	}

	public void DesejaContinuar() throws IOException, InterruptedException, ParseException {

		Object[] options = { "Sim", "Não", "Sair" };

		int i = JOptionPane.showOptionDialog(null, "Deseja continuar no Conversor de Moedas?", "Menu",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		if (i == JOptionPane.YES_OPTION) {
			LoopLeituraDeDados();
		} else if (i == JOptionPane.NO_OPTION) {
			new ConversorMenuPrincipal();
		} else {
			JOptionPane.showMessageDialog(null, "Saindo do programa...", "Atenção", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}

	}
	
	public void GeraHistorico() {
		referencias = new String[10];
		posicaoLivre = 0;
		referencias[0] = dinheiroFormat;
		String str = referencias[0];
		System.out.println(str);
	}	
}
