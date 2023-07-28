package br.com.challengesoneoraclenexteducationalura.conversordemoedas.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;


public class ApiCotacaoDeMoedas{
	
	private HttpResponse<String> response;

	public ApiCotacaoDeMoedas() {
		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("http://economia.awesomeapi.com.br/json/last/BRL-USD,BRL-EUR,BRL-GBP,"
						+ "USD-BRL,USD-EUR,USD-GBP,EUR-BRL,EUR-USD,EUR-GBP,GBP-BRL,GBP-USD,GBP-EUR"))
				.timeout(Duration.ofSeconds(5)).build();
		HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5))
				.followRedirects(Redirect.NORMAL).build();
		//HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public String getResponse() {
		return response.body();
	}

	public void setResponse(HttpResponse<String> response) {
		this.response = response;
	}
}
