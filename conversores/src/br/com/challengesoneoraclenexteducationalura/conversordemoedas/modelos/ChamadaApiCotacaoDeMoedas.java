package br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos;

import java.text.NumberFormat;
//import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ChamadaApiCotacaoDeMoedas extends ApiCotacaoDeMoedas {
	
	private String dinheiroFormat;
	private String nomeParDeMoedas;
	private String dinheiroFormatInput;
//	private ArrayList<String> lista;
	private double cotacao;




	public ChamadaApiCotacaoDeMoedas(String moedas, String tagLanguageInput, String tagCountryInput, 
			String tagLanguage, String tagCountry, double valor) {
		Object jsonParser;
		try {
			jsonParser = new JSONParser().parse(getResponse());
			JSONObject objJsonObject = (JSONObject) jsonParser;
			JSONObject objMoedas = (JSONObject) objJsonObject.get(moedas);
			String bid = (String) objMoedas.get("bid");
			nomeParDeMoedas = (String) objMoedas.get("name");
			//System.out.println(getResponse());
			
			cotacao = Double.parseDouble(bid);
			Locale localeInput = new Locale(tagLanguageInput, tagCountryInput);
			NumberFormat dinheiroInput = NumberFormat.getCurrencyInstance(localeInput);
			dinheiroFormatInput = dinheiroInput.format(valor);
			double result = valor * cotacao;
			Locale locale = new Locale(tagLanguage, tagCountry);
			NumberFormat dinheiro = NumberFormat.getCurrencyInstance(locale);
			dinheiroFormat = dinheiro.format(result);
			//test console
			
//			lista = new ArrayList<String>();
//			lista.add(dinheiroFormatInput + " = " + dinheiroFormat + " " + nomeParDeMoedas);
//			for (int i = 0; i < lista.size(); i++) {
//				System.out.println(lista.get(i));
//			}
			
			//test console	
			if (moedas == "BRLUSD" || moedas == "BRLGBP" || moedas == "EURUSD" || moedas == "EURGBP") {
				JOptionPane.showMessageDialog(null,
						"O valor convertido equivale a: " + dinheiroFormat + System.lineSeparator()
								+ "O ponto é separador decimal" + System.lineSeparator()
								+ "A vírgula agrupador de milhar",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else if (moedas == "USDBRL" || moedas == "GBPBRL" || moedas == "USDEUR" || moedas == "GBPEUR") {
				JOptionPane.showMessageDialog(null,
						"O valor convertido equivale a: " + dinheiroFormat + System.lineSeparator()
								+ "A vírgula é separador decimal" + System.lineSeparator()
								+ "O ponto agrupador de milhar",
						"Resultado", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "O valor convertido equivale a: " + dinheiroFormat, "Resultado",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getGeraHistorico() {
		return this.dinheiroFormatInput + " = " + this.dinheiroFormat + " " + this.nomeParDeMoedas;
	}
}
