package br.edu.senaisp.model;

import java.util.List;

public class Estado {
	public int id;
	public String uf;
	public String nome;
	public List<Cidade> cidades;
	
	public Estado(String uf, String nome) {
		this.uf = uf;
		this.nome = nome;
	}	
	
	public Estado(int id, String uf, String nome) {
		this.id = id;
		this.uf = uf;
		this.nome = nome;
	}

}
