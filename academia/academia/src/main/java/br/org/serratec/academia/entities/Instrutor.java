package br.org.serratec.academia.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instrutor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "instrutorId", scope = Instrutor.class)
public class Instrutor {

	// ---chave primaria---
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instrutor_id")
	private Integer instrutorId;

	// ---atributos---
	@Column(name = "rg")
	private String rg;
	@Column(name = "nome_instrutor")
	private String nomeInstrutor;

	// ---Relação---
	@OneToOne(mappedBy = "instrutor", cascade = CascadeType.ALL)
	private Telefone telefone;

	@OneToMany(mappedBy = "instrutor")
	private List<Turma> turmas;

	// ---get&set---
	public Integer getInstrutorId() {
		return instrutorId;
	}

	public void setInstrutorId(Integer instrutorId) {
		this.instrutorId = instrutorId;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

}
