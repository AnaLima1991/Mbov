package com.dev.projeto.modelos;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name = "bovino")
public class Bovino implements Serializable {

	public Bovino() {
		super();
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	@Temporal(TemporalType.DATE)
	private Date dataNasci;
	private String corPelo;
	private String numeroBrinco;
	private Double peso_animal;
	private String sexo;
	private String brincoPai;
	private String brincoMae;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataNasci() {
		return dataNasci;
	}
	public void setDataNasci(Date dataNasci) {
		this.dataNasci = dataNasci;
	}
	public String getCorPelo() {
		return corPelo;
	}
	public void setCorPelo(String corPelo) {
		this.corPelo = corPelo;
	}
	public String getNumeroBrinco() {
		return numeroBrinco;
	}
	public void setNumeroBrinco(String numeroBrinco) {
		this.numeroBrinco = numeroBrinco;
	}
	public Double getPeso_animal() {
		return peso_animal;
	}
	public void setPeso_animal(Double peso_animal) {
		this.peso_animal = peso_animal;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getBrincoPai() {
		return brincoPai;
	}
	public void setBrincoPai(String brincoPai) {
		this.brincoPai = brincoPai;
	}
	public String getBrincoMae() {
		return brincoMae;
	}
	public void setBrincoMae(String brincoMae) {
		this.brincoMae = brincoMae;
	}
	
	
	
}