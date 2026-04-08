package co.edu.unbosque.miprimerspring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspring.entity.ExPareja;
import co.edu.unbosque.miprimerspring.service.ExParejaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/expareja")
@CrossOrigin(origins = { "http://localhost:8080", "*" })
public class ExParejaController {

	@Autowired
	private ExParejaService exParSer;

	public ExParejaController() {

	}

	@PostMapping("/crear")
	public ResponseEntity<String> crearPareja(@RequestParam String nombre, @RequestParam int edad,
			@RequestParam LocalDate fechaNacimiento, @RequestParam LocalDate fechaRuptura, @RequestParam String motivoRuptura) {
		ExPareja nuevo = new ExPareja(nombre, edad, fechaNacimiento, fechaRuptura, motivoRuptura);
		int status = exParSer.create(nuevo);
		if (status == 0) {
			return new ResponseEntity<>("Dato creado con éxito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al crear ex pareja", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/mostrartodo")
	public ResponseEntity<List<ExPareja>> mostrarTodo() {
		List<ExPareja> exParejas = exParSer.getAll();
		if (exParejas.isEmpty()) {
			return new ResponseEntity<List<ExPareja>>(exParejas, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ExPareja>>(exParejas, HttpStatus.ACCEPTED);
		}

	}

	@PutMapping("/actualizar")
	public ResponseEntity<String> actualizarExPareja(@RequestBody ExPareja data) {
		 int actualizado = exParSer.updateById(data.getId(), data);
		 if (actualizado == 0) {
			 return new ResponseEntity<>("Ex pareja actualizada correctamente", HttpStatus.ACCEPTED);
		 }else {
		    return new ResponseEntity<>("Ex pareja no existe", HttpStatus.NO_CONTENT);	
		 }
		
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminarExPareja (@RequestParam Long id){
		int eliminado = exParSer.deleteById(id);
		if (eliminado == 0) {
			return new ResponseEntity<>("Ex pareja eliminada correctamente", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Ex pareja no existe", HttpStatus.NO_CONTENT);

		}
	}

}
