package co.edu.unbosque.miprimerspring.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expareja")
public class ExPareja {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
	private String nombre;
	int edad;
	private LocalDate fechaNacimiento;
	private LocalDate fechaRuptura;
	private String motivoRuptura;
	
	public ExPareja() {
		// TODO Auto-generated constructor stub
	}

	public ExPareja(String nombre, int edad, LocalDate fechaNacimiento, LocalDate fechaRuptura, String motivoRuptura) {
		super();
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
		ExPareja other = (ExPareja) obj;
		return edad == other.edad && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(fechaRuptura, other.fechaRuptura) && id == other.id
				&& Objects.equals(motivoRuptura, other.motivoRuptura) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	
	

}
