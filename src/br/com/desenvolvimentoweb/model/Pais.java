package br.com.desenvolvimentoweb.model;

import java.io.Serializable;

public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	public Pais() {
		super();
	}

	public Pais(String nome, long populacao, double area) {
		super();
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
	public Pais(int id, String nome, long populacao, double area) {
		super();
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + populacao + ", area=" + area + "]";
	}
}
