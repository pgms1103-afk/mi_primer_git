package co.edu.unbosque.miprimerspring.dto;

import java.time.LocalDateTime;
import java.util.Objects;


public class ParejaDTO {
	
	private long id;
	private String nombre;
	private int edad;
	private String carrera;
	private LocalDateTime aniversario;
	
	public ParejaDTO() {

	}

	public ParejaDTO(String nombre, int edad, String carrera, LocalDateTime aniversario) { 
		this.nombre = nombre;
		this.edad = edad;
		this.carrera = carrera;
		this.aniversario = aniversario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public LocalDateTime getAniversario() {
		return aniversario;
	}

	public void setAniversario(LocalDateTime aniversario) {
		this.aniversario = aniversario;
	}

	

	@Override
	public String toString() {
		return "ParejaDTO [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", carrera=" + carrera
				+ ", aniversario=" + aniversario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aniversario, carrera, edad, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParejaDTO other = (ParejaDTO) obj;
		return Objects.equals(aniversario, other.aniversario) && Objects.equals(carrera, other.carrera)
				&& edad == other.edad && id == other.id && Objects.equals(nombre, other.nombre);
	}
	
	

}
