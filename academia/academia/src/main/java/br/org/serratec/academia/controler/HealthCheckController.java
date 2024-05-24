package br.org.serratec.academia.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
	@GetMapping("/health-check")
	public ResponseEntity<Object> healthCheck() {
		return ResponseEntity.status(200).body("Health Checked!");
	}

	@GetMapping("/health-check-authentication")
	public ResponseEntity<Object> healthCheckAuthentication() {
		return ResponseEntity.status(200).body("Health Authentication Checked!");
	}

}
