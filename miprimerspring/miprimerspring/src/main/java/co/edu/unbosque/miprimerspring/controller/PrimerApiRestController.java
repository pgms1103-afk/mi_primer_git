package co.edu.unbosque.miprimerspring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/primerapi")
@CrossOrigin(origins = { "http://localhost:8080", "*" })
/*
 * IMPORTANTICIMO: SI LO MONTO PARA EL USUARIO LO MODIFICO, SI NO CUALQUIER IP
 * VA A TENER ACCESO D:
 */

public class PrimerApiRestController {
	
	@GetMapping("/saludar")
	public String getSaludar() {
		return "Buenos dias :)";
	}
	
	@GetMapping("/saludarpornombre")
	public String getSaludarPorNombre(@RequestParam String nombre) {
		return "Buenos dias " + nombre;
	}
	
	@GetMapping("/sumar")
	public String getSumar(@RequestParam int numero1, @RequestParam int numero2) {
		int resultado = numero1 + numero2;
		return "Su suma es " + resultado;
	}
	
	@GetMapping("/restar")
	public String getRestar(@RequestParam int numero1, @RequestParam int numero2) {
		int resultado = numero1 - numero2;
		return "Su resta es " +resultado;
	}
	
	@GetMapping("/multiplicar")
	public String getMultiplicar(@RequestParam int numero1, @RequestParam int numero2) {
		int resultado = numero1 * numero2;
		return "Su multiplicacion es " +resultado;
	}
	
	@GetMapping("/division")
	public String getDivision(@RequestParam int numero1, @RequestParam int numero2) {
		int resultado = numero1 / numero2;
		return "Su division es " +resultado;
	}
	
	
	
		
	
	
	

}
