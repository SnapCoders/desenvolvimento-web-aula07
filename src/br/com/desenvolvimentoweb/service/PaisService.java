package br.com.desenvolvimentoweb.service;

import java.util.ArrayList;

import br.com.desenvolvimentoweb.model.Pais;
import br.com.desenvolvimentoweb.dao.PaisDAO;

public class PaisService {
	PaisDAO dao;
	
	public PaisService() {
		dao = new PaisDAO();
	}
	
	public void criar(Pais to) {
		dao.incluir(to);
	}
	
	public void atualizar(Pais to) {
		dao.atualizar(to);
	}
	
	public void excluir(int id) {
		dao.excluir(id);
	}
	
	public Pais carregar(int id) {
		return dao.carregar(id);
	}
	
	public ArrayList<Pais> listarPaises() {
		return dao.listarPaises();
	}
	
	public ArrayList<Pais> listarPaises(String chave) {
		return dao.listarPaises(chave);
	}
	
	public Pais maiorPopulacao() {
		return dao.maiorPopulacao();
	}
	
	public Pais menorArea() {
		return dao.menorArea();
	}
	
	public ArrayList<Pais> vetorTresPaises() {
		return dao.vetorTresPaises();
	}
}
