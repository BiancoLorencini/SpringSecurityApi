package br.org.serratec.academia.records;

import java.util.Set;

public record UserRecord(
		String email,
		String password,
		Set<String> role
		) {

}
