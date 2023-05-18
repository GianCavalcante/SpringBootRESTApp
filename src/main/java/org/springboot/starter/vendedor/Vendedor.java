package org.springboot.starter.vendedor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vendedor {
	
	@Id
	private String id;
	private String nome;
	private double totalVendas;
	private double mediaDiariaVendas;
	
	public Vendedor() {}

	public Vendedor(String id, String nome, double totalVendas, double mediaDiariaVendas) {
		super();
		this.id = id;
		this.nome = nome;
		this.totalVendas = totalVendas;
		this.mediaDiariaVendas = mediaDiariaVendas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}

	public double getMediaDiariaVendas() {
		return mediaDiariaVendas;
	}

	public void setMediaDiariaVendas(double mediaDiariaVendas) {
		this.mediaDiariaVendas = mediaDiariaVendas;
	}
}
