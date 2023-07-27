package br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConversorDeMoedas {
	
	private double valorConvertidoParaDouble;
	private String entradaDeValorParaConversao;

	public ConversorDeMoedas() throws IOException, InterruptedException, ParseException {
		
		entradaDeValorParaConversao = JOptionPane.showInputDialog(null, "Bem-vindo(a)!" + 
				System.lineSeparator() + "Insira um valor a ser convertido: ", 
						"Conversor de Moedas", JOptionPane.QUESTION_MESSAGE);
		
		LeituraDeDados();

	}
	
	public void LoopLeituraDeDados() throws IOException, InterruptedException, ParseException {
		entradaDeValorParaConversao = JOptionPane.showInputDialog(null, "Insira um valor a ser convertido: ", 
						"Conversor de Moedas", JOptionPane.QUESTION_MESSAGE);

		LeituraDeDados();
	}
	
	public void LeituraDeDados() throws IOException, InterruptedException, ParseException {
		
		try {
			valorConvertidoParaDouble = Double.parseDouble(entradaDeValorParaConversao.replace("," , "."));
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
			JOptionPane.showMessageDialog(null, "Digite apenas números!" + 
					System.lineSeparator() + "Não use agrupador de milhar", "Erro!", 
					JOptionPane.ERROR_MESSAGE);
			LoopLeituraDeDados();
		}
		
	}
	
	public void ConversorDeMoedasOpcoes() throws IOException, InterruptedException, ParseException {
		Object[] opcoesDeMoedas = 
			{
					"De Real a Dólar", //0
					"De Real a Euro", //1
					"De Real a Libra Esterlina", //2
					"Dólar a Real", //3
					"Dólar a Euro", //4
					"Dólar a Libra Esterlina", //5
					"Euro a Real", //6
					"Euro a Dólar", //7
					"Euro a Libra Esterlina", //8
					"Libra Esterlina a Real", //9
					"Libra Esterlina a Dólar", //10
					"Libra Esterlina a Euro", //11
			};
		
		Object selection = JOptionPane.showInputDialog(null, "Selecione a moeda de conversão","Moedas", 
				JOptionPane.PLAIN_MESSAGE, 
				null, opcoesDeMoedas, opcoesDeMoedas[0]);
		
		if (selection == opcoesDeMoedas[0]) {
			
			ChamadaApiCotacaoDeMoedas("BRLUSD", "en", "US");
			LoopLeituraDeDados();
			
		} else if(selection == opcoesDeMoedas[1]) {
			
			ChamadaApiCotacaoDeMoedas("BRLEUR", "fr", "FR");
			LoopLeituraDeDados();
			
		} else if(selection == opcoesDeMoedas[2]) {
			
			ChamadaApiCotacaoDeMoedas("BRLGBP", "en", "GB");
			LoopLeituraDeDados();
			
		} else if(selection == opcoesDeMoedas[3]) {
			
			ChamadaApiCotacaoDeMoedas("USDBRL", "pt", "BR");
			LoopLeituraDeDados();
			
		} else if(selection == opcoesDeMoedas[4]) {
			
			ChamadaApiCotacaoDeMoedas("USDEUR", "fr", "FR");
			LoopLeituraDeDados();
			
		}  else if(selection == opcoesDeMoedas[5]) {
			
			ChamadaApiCotacaoDeMoedas("USDGBP", "en", "GB");
			LoopLeituraDeDados();
			
		}  else if(selection == opcoesDeMoedas[6]) {
			
			ChamadaApiCotacaoDeMoedas("EURBRL", "pt", "BR");
			LoopLeituraDeDados();
			
		}  else if(selection == opcoesDeMoedas[7]) {
			
			ChamadaApiCotacaoDeMoedas("EURUSD", "en", "US");
			LoopLeituraDeDados();
			
		}  else if(selection == opcoesDeMoedas[8]) {
			
			ChamadaApiCotacaoDeMoedas("EURGBP", "en", "GB");
			LoopLeituraDeDados();
			
		}  else if(selection == opcoesDeMoedas[9]) {
			
			ChamadaApiCotacaoDeMoedas("GBPBRL", "pt", "BR");
			LoopLeituraDeDados();
			
		}  else if(selection == opcoesDeMoedas[10]) {
			
			ChamadaApiCotacaoDeMoedas("GBPUSD", "en", "US");
			LoopLeituraDeDados();
			
		}  else if(selection == opcoesDeMoedas[11]) {
			
			ChamadaApiCotacaoDeMoedas("GBPEUR", "fr", "FR");
			LoopLeituraDeDados();
			
		}  else {
			JOptionPane.showMessageDialog(null, "Opção Inválida", "Atenção", 
					JOptionPane.WARNING_MESSAGE);
			LoopLeituraDeDados();
		}
		
	}
	
	public void ChamadaApiCotacaoDeMoedas(String moedas, String tagLanguage, String tagCountry) {
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("http://economia.awesomeapi.com.br/json/last/BRL-USD,BRL-EUR,BRL-GBP,"
						+ "USD-BRL,USD-EUR,USD-GBP,EUR-BRL,EUR-USD,EUR-GBP,GBP-BRL,GBP-USD,GBP-EUR"))
				.timeout(Duration.ofSeconds(5))
				.build();
		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(5))
				.followRedirects(Redirect.NORMAL)
				.build();
		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, BodyHandlers.ofString());
			//System.out.println(response.body());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Object jsonParser;
		try {
			jsonParser = new JSONParser().parse(response.body());
			JSONObject objJsonObject = (JSONObject) jsonParser;
			JSONObject objMoedas = (JSONObject) objJsonObject.get(moedas);
			String bid = (String) objMoedas.get("bid");
			//System.out.println(bid);
			
			double cotacao = Double.parseDouble(bid);
			double result = valorConvertidoParaDouble * cotacao;
			Locale locale = new Locale(tagLanguage,tagCountry);
			NumberFormat dinheiro = NumberFormat.getCurrencyInstance(locale);
			String dinheiroFormat = dinheiro.format(result);
			if (moedas == "BRLUSD" || moedas == "BRLGBP" || moedas == "EURUSD" || moedas == "EURGBP") {
				JOptionPane.showMessageDialog(null, "O valor convertido equivale a: " + dinheiroFormat  + 
						System.lineSeparator() + "O ponto é separador decimal"  + 
						System.lineSeparator() + "A vírgula agrupador de milhar", "Resultado", 
						JOptionPane.INFORMATION_MESSAGE);
			} else if (moedas == "USDBRL" || moedas == "GBPBRL" || moedas == "USDEUR" || moedas == "GBPEUR") {
				JOptionPane.showMessageDialog(null, "O valor convertido equivale a: " + dinheiroFormat  + 
						System.lineSeparator() + "A vírgula é separador decimal"  + 
						System.lineSeparator() + "O ponto agrupador de milhar", "Resultado", 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "O valor convertido equivale a: " + dinheiroFormat, 
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void ContinuarOuFechar() {
		
		JOptionPane.showInputDialog(null, "Deseja Continuar?", 
				"Conversor de Moedas", JOptionPane.QUESTION_MESSAGE);
		
	}
	
}
