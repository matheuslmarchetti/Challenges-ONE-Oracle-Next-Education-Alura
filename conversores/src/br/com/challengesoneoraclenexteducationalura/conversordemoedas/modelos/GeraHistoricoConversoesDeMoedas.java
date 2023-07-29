package br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.challengesoneoraclenexteducationalura.framesdosconversores.modelos.TelaJFrame;

public class GeraHistoricoConversoesDeMoedas extends ApiCotacaoDeMoedas{
	private String dinheiroFormat;
	private String nomeParDeMoedas;
	private String dinheiroFormatInput;
	private ArrayList<String> lista;
	private String historico;
	
	public GeraHistoricoConversoesDeMoedas(String moedas, String tagLanguageInput, String tagCountryInput, 
			String tagLanguage, String tagCountry, double valor) {
		
		Object jsonParser;
		try {
			jsonParser = new JSONParser().parse(getResponse());
			JSONObject objJsonObject = (JSONObject) jsonParser;
			JSONObject objMoedas = (JSONObject) objJsonObject.get(moedas);
			String bid = (String) objMoedas.get("bid");
			nomeParDeMoedas = (String) objMoedas.get("name");
			//System.out.println(getResponse());

			double cotacao = Double.parseDouble(bid);
			Locale localeInput = new Locale(tagLanguageInput, tagCountryInput);
			NumberFormat dinheiroInput = NumberFormat.getCurrencyInstance(localeInput);
			dinheiroFormatInput = dinheiroInput.format(valor);
			double result = valor * cotacao;
			Locale locale = new Locale(tagLanguage, tagCountry);
			NumberFormat dinheiro = NumberFormat.getCurrencyInstance(locale);
			dinheiroFormat = dinheiro.format(result);
			lista = new ArrayList<String>();
			lista.add(dinheiroFormatInput + " = " + dinheiroFormat + " " + nomeParDeMoedas);
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
				historico = lista.get(i);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getGeraHistorico() {
		return this.historico;
	}

}
