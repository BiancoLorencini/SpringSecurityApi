package br.org.serratec.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.academia.entities.Telefone;
import br.org.serratec.academia.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	TelefoneRepository telefoneRepository;

	public List<Telefone> findAll() {
		return telefoneRepository.findAll();
	}

	public Telefone findById(Integer id) {
		//return usuarioRepository.findById(id).orElse(null);
		return telefoneRepository.findById(id).get();
	}

	public Telefone save(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}

	public Telefone update(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}

	public void deleteUsuarioById(Integer id) {
		if (telefoneRepository.existsById(id)) {
			telefoneRepository.deleteById(id);
			ResponseEntity.noContent().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}
}
