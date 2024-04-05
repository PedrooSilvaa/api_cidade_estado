package br.edu.senaisp.controller;

import java.io.IOException;
import java.util.ArrayList;

import br.edu.senaisp.dao.EstadoDAO;
import br.edu.senaisp.model.Cidade;
import br.edu.senaisp.model.Estado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/estado")
public class EstadoController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uf = req.getParameter("uf");
		String nome = req.getParameter("nome");
		
		Estado estado = new Estado(-1, uf, nome);
		estado.cidades = new ArrayList<Cidade>();
		
		Cidade c1 = new Cidade();
		c1.nome  = "Porto Seguro";
		
		Cidade c2 = new Cidade();
		c2.nome  = "Salvador";
		
		estado.cidades.add(c1);
		estado.cidades.add(c2);
		
		EstadoDAO dao = new EstadoDAO();
		int id = dao.novoCompleto(estado);
		
		
		
		resp.getWriter().append(String.valueOf(id));
		
		
	}

}
