package co.edu.unbosque.miprimerspring.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ExParejaDTO {
	
	private long id;
	private String nombre;
	int edad;
	private LocalDate fechaNacimiento;
	private LocalDate fechaRuptura;
	private String motivoRuptura;
	
	public ExParejaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ExParejaDTO(String nombre, int edad, LocalDate fechaNacimiento, LocalDate fechaRuptura, String motivoRuptura) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRuptura = fechaRuptura;
		this.motivoRuptura = motivoRuptura;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaRuptura() {
		return fechaRuptura;
	}

	public void setFechaRuptura(LocalDate fechaRuptura) {
		this.fechaRuptura = fechaRuptura;
	}

	public String getMotivoRuptura() {
		return motivoRuptura;
	}

	public void setMotivoRuptura(String motivoRuptura) {
		this.motivoRuptura = motivoRuptura;
	}
	

	@Override
	public String toString() {
		return "ExParejaDTO [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", fechaNacimiento="
				+ fechaNacimiento + ", fechaRuptura=" + fechaRuptura + ", motivoRuptura=" + motivoRuptura + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, fechaNacimiento, fechaRuptura, id, motivoRuptura, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExParejaDTO other = (ExParejaDTO) obj;
		return edad == other.edad && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(fechaRuptura, other.fechaRuptura) && id == other.id
				&& Objects.equals(motivoRuptura, other.motivoRuptura) && Objects.equals(nombre, other.nombre);
	}
	
	

}
