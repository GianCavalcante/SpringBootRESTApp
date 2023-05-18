package org.springboot.starter.venda;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Venda {
	
	@Id
	private String id;
	private double valor;
	private String data;
	private String idVendedor;
	private String nomeVendedor;
	
	public Venda() {}

	public Venda(String id, double valor, String data, String idVendedor, String nomeVendedor) {
		super();
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.idVendedor = idVendedor;
		this.nomeVendedor = nomeVendedor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
}
