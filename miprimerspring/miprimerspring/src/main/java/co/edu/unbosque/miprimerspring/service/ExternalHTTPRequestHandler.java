package co.edu.unbosque.miprimerspring.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;

import co.edu.unbosque.miprimerspring.dto.JokeDTO;
import co.edu.unbosque.miprimerspring.dto.MultipleJokeDTO;

public class ExternalHTTPRequestHandler {

	private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder() //
			.version(HttpClient.Version.HTTP_2)// version mas actualizada (2)
			.connectTimeout(Duration.ofSeconds(10)).build();// Tiene la duración de la solicitud
	// CON ESTE CLIENTE SE PUEDE EMPEZAR A REALIZAR SOLICITUDDES
//+--------------------------------------------------------------------------------------------------------------------------------------

	public static String doGet(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url)) // PARA TODA COLICITUD EXISTE UNA
																					// REQUEST (es la solicitud que
																					// queremos hacer,
				// se indica a tipo y a quien),
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();
		// se le pueden agregar "cabesales" (info extra que
		// se mandan en la soli, dependiendo de esos encabezados se puede ser mas
		// especifico sobre que solicitudes SI y cuales NO quiero contestar (se le
		// indica cuales clientes si lo puedeb usar y cuales no con el User-Agent)
		// aqui se cambia por si es admin on no

		HttpResponse<String> respuesta = null;
		try {
			respuesta = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
			// PARA CADA REQUST EXISTE UNA REPONSE (recibe la respuesta)
			// recibe el codigo y el cuerpo en JSON, es null inicialmente pq no se ha hecho
			// la solicitud
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("status code --> " + respuesta.statusCode()); // se imprime el codigo de estado y el JSON,
																			// (la variable respuesta)
		return respuesta.body();
	}

	public static void main(String[] args) {
		MultipleJokeDTO chiste = doGetMultipleJokeDTO("https://v2.jokeapi.dev/joke/Programming?amount=4");
		System.out.println(chiste.toString());
	}

//----------------------------------------------------------------------------------------------------------------------------------------
	public static JokeDTO doGetJokeDTO(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> respuesta = null;
		try {
			respuesta = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("status code --> " + respuesta.statusCode()); 
		Gson gson = new Gson ();
		return gson.fromJson(respuesta.body(), JokeDTO.class); //SE CONVIERTE EL JSON AL DTO (SOLO LOS ATRIBUTOS QUE SEAN NECESARIOS EN EÑ DTO SE GUARDARAN
	}
	
//----------------------------------------------------------------------------------------------------------------------------------------
	
	public static MultipleJokeDTO doGetMultipleJokeDTO(String url) {
		HttpRequest solicitud = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> respuesta = null;
		try {
			respuesta = HTTP_CLIENT.send(solicitud, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("status code --> " + respuesta.statusCode()); 
		Gson gson = new Gson ();
		return gson.fromJson(respuesta.body(), MultipleJokeDTO.class); //SE CONVIERTE EL JSON AL DTO (SOLO LOS ATRIBUTOS QUE SEAN NECESARIOS EN EÑ DTO SE GUARDARAN
	}


}
