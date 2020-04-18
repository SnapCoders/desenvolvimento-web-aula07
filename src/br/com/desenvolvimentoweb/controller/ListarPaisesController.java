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

@WebServlet("/ListarPaises.do")
public class ListarPaisesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String pChave = request.getParameter("data[search]");
		String pAcao = request.getParameter("acao");
		
		PaisService ps = new PaisService();
		ArrayList<Pais> lista = null;
		HttpSession session = request.getSession();
		
		if (pAcao.equals("Buscar")) {
			
			if (pChave != null && pChave.length() > 0) {
				
				lista = ps.listarPaises(pChave);
				
			} else {
				
				lista = ps.listarPaises();
				
			}
			
			session.setAttribute("lista", lista);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("listarPaises.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
