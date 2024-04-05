package br.edu.senaisp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.edu.senaisp.model.Cidade;
import br.edu.senaisp.model.Estado;

public class EstadoDAO {

	private final String SQLINSERT = "INSERT INTO estado (uf, nome) VALUES(?, ?)";

	public int novo(Estado estado) {
		int id = 0;
		try {
			Connection con = dao.conexao();

			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, estado.uf);
				ps.setString(2, estado.nome);

				ps.execute();

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}

	public int novoCompleto(Estado estado) {
		int id = 0;
		try {
			Connection con = dao.conexao();

			if (!con.isClosed()) {
				PreparedStatement ps = con.prepareStatement(SQLINSERT, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, estado.uf);
				ps.setString(2, estado.nome);

				ps.execute();

				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1); // variavel onde vai guardar o retorno do generated key
				
				estado.id = id; // gravando no id do estado com a variavel do generated key
				
				CidadeDAO cDAO = new CidadeDAO();
				
				for (Cidade cidade : estado.cidades) {
					
					cidade.estado = estado;
					
					cDAO.novo(cidade);
					
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	
}
