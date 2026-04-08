package co.edu.unbosque.miprimerspring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.dto.ParejaDTO;
import co.edu.unbosque.miprimerspring.entity.Pareja;
import co.edu.unbosque.miprimerspring.repository.ParejaRepository;

@Service
public class ParejaService implements CRUDoperation<ParejaDTO> {

	@Autowired // Para que Spring autoinicialize el objeto
	private ParejaRepository parejaRep;
	@Autowired
	private ModelMapper mapper;

	public ParejaService() {

	}

	@Override
	public int create(ParejaDTO data) {
		// Si la entidad y el DTO tiene lo mismo de todo, el model Mapper solo dice
		// "Esto es igual a esto" y lo convierte, easy peasy. (ESTA CONVERSION ES UNO A
		// UNO).
		Pareja entity = mapper.map(data, Pareja.class);// se hace usando la clase PURA como segundo parametro.
		parejaRep.save(entity);
		return 0;
		// Si se necesita validar otra cosa, se hace AQUI; Ejemplo, saltado de
		// excepciones, si algo ya existe, algo específico.
	}

	@Override
	public List<ParejaDTO> getAll() {
		List<Pareja> entityList = (List<Pareja>) parejaRep.findAll();
		List<ParejaDTO> dtoList = new ArrayList<>();
		// Se coge cada una de las entidades, y se convierte a DTO.
		// FUNCIONES LAMDA:
		// Son anonimas y autogeneran lineas de código
		entityList.forEach((entity) -> {
			ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
			dtoList.add(dto);
		});// Estructura lambda, primero parametros, y despues lógica
			// La funcion se llama forEach, la logica q se ponga dentro del lambda se va a
			// aplicar para cada uno de los datos dentro de la lista, el parametro almacena
			// cada uno de esos datos.
		return dtoList;
	}
	
	@Override
	public int deleteById(Long id) {
	   
	    Optional<Pareja> encontrado = parejaRep.findById(id);

	    if (encontrado.isPresent()) {
	        ParejaDTO dto = mapper.map(encontrado.get(), ParejaDTO.class);
	        Pareja entity = mapper.map(dto, Pareja.class);
	        parejaRep.delete(entity);
	        return 0; 
	    }
	    return 1; 
	}

//	@Override
//	public int deleteById(Long id) {
//		
//		Optional<Pareja> encontrado = parejaRep.findById(id);
//				
//		if (encontrado.isPresent()) {
//			parejaRep.delete(encontrado.get());
//			return 0;
//		}
//		return 1;
//	}

	@Override
	public int updateById(Long id, ParejaDTO data) {
		Optional<Pareja> encontrado = (Optional<Pareja>) parejaRep.findById(id);
		// Si necesito actualizar algo y los nuevos datos ya existen, tengo q
		// controlarlo
		if (encontrado.isPresent()) {
			Pareja temp = encontrado.get();
			// Si hay un dato ya insterdao, ya tiene un ID, si el mismo dato con el mismo
			// ID, se sobrescribe
			temp.setNombre(data.getNombre());
			temp.setCarrera(data.getCarrera());
			temp.setAniversario(data.getAniversario());
			temp.setEdad(data.getEdad());
			parejaRep.save(temp);
			return 0;
		}
		return 1;
	}

	@Override
	public long count() {
		return parejaRep.count();
	}

	@Override
	public boolean exist(Long id) {
		return parejaRep.existsById(id) ? true : false;
	}
	
	public List<ParejaDTO> findByNombre (String nombre) {
		Optional<List<Pareja>> encontrados = parejaRep.findByNombre(nombre);//Debe ser de entidades, porqeu desde el repositorio llega como entidades, pero al mandarlo al controller, se manda como DTO. 
		List<Pareja> entityList = encontrados.get();
		List<ParejaDTO> dtoList = new ArrayList<>();
		if(encontrados.isPresent() && !encontrados.get().isEmpty()) {
			entityList.forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
	    } else {
	    	return new ArrayList<ParejaDTO>();
	    }
	
	
	}
	
	public List<ParejaDTO> findByEdad (int edad){
		Optional <List<Pareja>> encontrados = parejaRep.findByEdad(edad);
		List<Pareja> entityList = encontrados.get();
		List<ParejaDTO> dtoList = new ArrayList<>();
		if(encontrados.isPresent() && !encontrados.get().isEmpty()) {
			entityList.forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
		}else {
			return new ArrayList <ParejaDTO>();
		}
	}
	
	public List<ParejaDTO> findByCarrera(String carrera){
		Optional <List<Pareja>> encontrados = parejaRep.findByCarrera(carrera);
		List<Pareja> entityList = encontrados.get();
		List<ParejaDTO> dtoList = new ArrayList<>();
		if(encontrados.isPresent() && !encontrados.get().isEmpty()) {
			entityList.forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
		}else {
			return new ArrayList <ParejaDTO>();
		}
	}
	
	public List<ParejaDTO> findByAniversario(LocalDateTime aniversario){
		Optional <List<Pareja>> encontrados = parejaRep.findByAniversario(aniversario);
		List<Pareja> entityList = encontrados.get();
		List<ParejaDTO> dtoList = new ArrayList<>();
		if(encontrados.isPresent() && !encontrados.get().isEmpty()) {
			entityList.forEach((entity) -> {
				ParejaDTO dto = mapper.map(entity, ParejaDTO.class);
				dtoList.add(dto);
			});
			return dtoList;
		}else {
			return new ArrayList <ParejaDTO>();
		}
	}
	
	

	
}
