package co.edu.unbosque.miprimerspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspring.entity.ExPareja;
import co.edu.unbosque.miprimerspring.repository.ExParejaRepository;

@Service
public class ExParejaService implements CRUDoperation<ExPareja>{
	
	@Autowired
	private ExParejaRepository exParejaRep;
	
	public ExParejaService() {
		
	}

	@Override
	public int create(ExPareja data) {
		exParejaRep.save(data);
		return 0;
	}

	@Override
	public List<ExPareja> getAll() {
		return (List<ExPareja>) exParejaRep.findAll();
	}

	@Override
	public int deleteById(Long id) {
		Optional<ExPareja> encontrado = exParejaRep.findById(id);
		if (encontrado.isPresent()) {
			exParejaRep.delete(encontrado.get());
			return 0;
		}
		return 1;
	}

	@Override
	public int updateById(Long id, ExPareja data) {
		Optional<ExPareja> encontrado = exParejaRep.findById(id);
		if(encontrado.isPresent()) {
			ExPareja temp = encontrado.get();
			temp.setEdad(data.getEdad());
			temp.setFechaNacimiento(data.getFechaNacimiento());
			temp.setFechaRuptura(data.getFechaRuptura());
			temp.setMotivoRuptura(data.getMotivoRuptura());
			temp.setNombre(data.getNombre());
			exParejaRep.save(temp);
			return 0;
		}
		return 1;
	}

	@Override
	public long count() {
		return exParejaRep.count();
	}

	@Override
	public boolean exist(Long id) {
		return exParejaRep.existsById(id)?true:false;
	}

}
