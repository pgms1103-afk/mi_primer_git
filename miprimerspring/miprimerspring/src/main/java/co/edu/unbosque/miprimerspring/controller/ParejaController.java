package co.edu.unbosque.miprimerspring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspring.dto.ParejaDTO;
import co.edu.unbosque.miprimerspring.entity.Pareja;
import co.edu.unbosque.miprimerspring.service.ParejaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/pareja")
@CrossOrigin(origins = { "http://localhost:8080", "*" })
public class ParejaController {

	@Autowired
	private ParejaService parejaSer;

	public ParejaController() {

	}

	@PostMapping("/crear")
	public ResponseEntity<String> crearPareja(@RequestParam String nombre, @RequestParam int edad,
			@RequestParam String carrera, @RequestParam LocalDateTime aniversario) {
		ParejaDTO nuevo = new ParejaDTO(nombre, edad, carrera, aniversario);
		int status = parejaSer.create(nuevo);
		if (status == 0) {
			return new ResponseEntity<>("Dato creado con éxito", HttpStatus.CREATED); // Dentro de () se pone: codigo de
																						// estado y cuerpo de respuesta
		} else {
			return new ResponseEntity<>("Error al crear pareja", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/mostrartodo")
	public ResponseEntity<List<ParejaDTO>> mostrarTodo() {
		List<ParejaDTO> parejas = parejaSer.getAll();
		if (parejas.isEmpty()) {
			return new ResponseEntity<List<ParejaDTO>>(parejas, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ParejaDTO>>(parejas, HttpStatus.ACCEPTED);
		}
	}

	@PutMapping("/actualizar")
	public ResponseEntity<String> actualizarPareja(@RequestBody ParejaDTO data) {

		int actualizado = parejaSer.updateById(data.getId(), data);
		if (actualizado == 0) {
			return new ResponseEntity<>("Pareja actualizada correctamente", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Pareja no existe", HttpStatus.NO_CONTENT);

		}
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<String> eliminarPareja(@RequestParam Long id) {
		int eliminado = parejaSer.deleteById(id);
		if (eliminado == 0) {
			return new ResponseEntity<>("Pareja eliminada correctamente", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Pareja no existe", HttpStatus.NO_CONTENT);

		}
	}
	
	@GetMapping("/buscarpornombre")
	public ResponseEntity<List<ParejaDTO>> buscarPorNombre(@RequestParam String nombre) {
		List<ParejaDTO> parejas = parejaSer.findByNombre(nombre);
		if (parejas.isEmpty()) {
			return new ResponseEntity<List<ParejaDTO>>(parejas, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<ParejaDTO>>(parejas, HttpStatus.ACCEPTED);
		}
	}

}
