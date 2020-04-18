package br.com.desenvolvimentoweb.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desenvolvimentoweb.model.Pais;
import br.com.desenvolvimentoweb.service.PaisService;

@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pAcao = request.getParameter("acao");
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		
		int id = -1;
		int populacao = 0;
		double area = 0.0; 
		
		try {
			if (pId != null) id = Integer.parseInt(pId);
			if (pPopulacao != null) populacao = Integer.parseInt(pPopulacao);
			if (pArea != null) area = Double.parseDouble(pArea);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		Pais pais = new Pais();
		pais.setId(id);
		pais.setNome(pNome);
		pais.setPopulacao(populacao);
		pais.setArea(area);
		
		PaisService ps = new PaisService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		if (pAcao.equals("Criar")) {
			
			ps.criar(pais);
			@SuppressWarnings("unchecked")
			ArrayList<Pais> lista = (ArrayList<Pais>)session.getAttribute("lista");
			if (lista != null) lista.add(pais);
			else lista = ps.listarPaises();
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("listarPaises.jsp");
			
		} else if (pAcao.equals("Excluir")) {
			
			ps.excluir(pais.getId());
			@SuppressWarnings("unchecked")
			ArrayList<Pais> lista = (ArrayList<Pais>)session.getAttribute("lista");
			lista.remove(busca(pais, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("listarPaises.jsp");
			
		} else if (pAcao.equals("Alterar")) {
			
			ps.atualizar(pais);
			@SuppressWarnings("unchecked")
			ArrayList<Pais> lista = (ArrayList<Pais>)session.getAttribute("lista");
			int pos = busca(pais, lista);
			lista.remove(pos);
			lista.add(pos, pais);
			session.setAttribute("lista", lista);
			request.setAttribute("pais", pais);
			view = request.getRequestDispatcher("visualizarPais.jsp");
			
		} else if (pAcao.equals("Visualizar")) {
			
			pais = ps.carregar(pais.getId());
			request.setAttribute("pais", pais);
			view = request.getRequestDispatcher("visualizarPais.jsp");
			
		} else if (pAcao.equals("Editar")) {
			
			pais = ps.carregar(pais.getId());
			request.setAttribute("pais", pais);
			view = request.getRequestDispatcher("alterarPais.jsp");
			
		}
		
		view.forward(request, response);
	}
	
	public int busca(Pais pais, ArrayList<Pais> lista) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == pais.getId()) return i;
		}
		return -1;
	}
}
