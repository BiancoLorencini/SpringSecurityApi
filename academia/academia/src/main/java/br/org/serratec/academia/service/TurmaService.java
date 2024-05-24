package br.org.serratec.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.org.serratec.academia.entities.Turma;
import br.org.serratec.academia.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository turmaRepository;

	public List<Turma> findAll() {
		return turmaRepository.findAll();
	}

	public Turma findById(Integer id) {
		//return turmaRepository.findById(id).orElse(null);
		return turmaRepository.findById(id).get();
	}

	public Turma save(Turma turma) {
		return turmaRepository.save(turma);
	}

	public Turma update(Turma turma) {
		return turmaRepository.save(turma);
	}

	public void deleteTurmaById(Integer id) {
		if (turmaRepository.existsById(id)) {
			turmaRepository.deleteById(id);
			ResponseEntity.noContent().build();
		} else {
			ResponseEntity.notFound().build();
		}
	}
}
