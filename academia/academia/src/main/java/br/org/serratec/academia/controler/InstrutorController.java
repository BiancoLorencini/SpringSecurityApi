package br.org.serratec.academia.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.academia.entities.Instrutor;
import br.org.serratec.academia.service.InstrutorService;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

	@Autowired
	InstrutorService instrutorService;

	@GetMapping
	public ResponseEntity<List<Instrutor>> findAll() {
		return new ResponseEntity<>(instrutorService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Instrutor> findById(@PathVariable Integer id) {
		Instrutor turma = instrutorService.findById(id);

		if (turma == null) {
			return new ResponseEntity<>(turma, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(turma, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Instrutor> save(@RequestBody Instrutor instrutor) {
		return new ResponseEntity<>(instrutorService.save(instrutor), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Instrutor> update(@RequestBody Instrutor instrutor) {
		return new ResponseEntity<>(instrutorService.update(instrutor), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteProfile(@PathVariable Integer id) {
		instrutorService.deleteInstrutorById(id);
	}
}
