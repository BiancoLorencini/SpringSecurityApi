package br.org.serratec.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.academia.entities.Instrutor;
import br.org.serratec.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {

	@Autowired
	InstrutorRepository instrutorRepository;

	public List<Instrutor> findAll() {
		return instrutorRepository.findAll();
	}

	public Instrutor findById(Integer id) {
		//return usuarioRepository.findById(id).orElse(null);
		return instrutorRepository.findById(id).get();
	}

	public Instrutor save(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public Instrutor update(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public void deleteInstrutorById(Integer id) {
		if (instrutorRepository.existsById(id)) {
			instrutorRepository.deleteById(id);
			ResponseEntity.noContent().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}
}
