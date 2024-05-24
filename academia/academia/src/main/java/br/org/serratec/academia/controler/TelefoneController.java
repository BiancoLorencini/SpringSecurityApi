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
import br.org.serratec.academia.entities.Telefone;
import br.org.serratec.academia.service.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

	@Autowired
	TelefoneService telefoneService;

	@GetMapping
	public ResponseEntity<List<Telefone>> findAll() {
		return new ResponseEntity<>(telefoneService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Telefone> findById(@PathVariable Integer id) {
		Telefone telefone = telefoneService.findById(id);

		if (telefone == null) {
			return new ResponseEntity<>(telefone, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(telefone, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Telefone> save(@RequestBody Telefone telefone) {
		return new ResponseEntity<>(telefoneService.save(telefone), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Telefone> update(@RequestBody Telefone telefone) {
		return new ResponseEntity<>(telefoneService.update(telefone), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public void deleteProfile(@PathVariable Integer id) {
		telefoneService.deleteUsuarioById(id);
	}
}
