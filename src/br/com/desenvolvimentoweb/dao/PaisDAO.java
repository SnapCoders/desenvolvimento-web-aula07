package br.com.desenvolvimentoweb.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import br.com.desenvolvimentoweb.model.Pais;
import br.com.desenvolvimentoweb.factory.ConnectionFactory;

public class PaisDAO {
	public void incluir(Pais to) {
		String sqlInsert = "INSERT INTO pais (nome, populacao, area) VALUES (?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setString(1, to.getNome());
			stm.setLong(2, to.getPopulacao());
			stm.setDouble(3, to.getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Pais to) {
		String sqlUpdate = "UPDATE pais SET nome = ?, populacao = ?, area = ? WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlUpdate)) {
			stm.setString(1, to.getNome());
			stm.setLong(2, to.getPopulacao());
			stm.setDouble(3, to.getArea());
			stm.setInt(4, to.getId());
			stm.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlDelete)) {
			stm.setInt(1, id);
			stm.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Pais carregar(int id) {
		Pais to = new Pais();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				}
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return to;
	}
	
	public ArrayList<Pais> listarPaises() {
		ArrayList<Pais> lista = new ArrayList<Pais>();
		String sqlSelect = "SELECT * FROM pais;";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Pais pais = new Pais();
					
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getInt("populacao"));
					pais.setArea(rs.getDouble("area"));
					
					lista.add(pais);
				}
				
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		return lista;
	}
	
	public ArrayList<Pais> listarPaises(String chave) {
		ArrayList<Pais> lista = new ArrayList<Pais>();
		String sqlSelect = "SELECT * FROM pais WHERE UPPER(nome) LIKE ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			
			try (ResultSet rs = stm.executeQuery()) {
				while (rs.next()) {
					Pais pais = new Pais();
					
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getInt("populacao"));
					pais.setArea(rs.getDouble("area"));
					
					lista.add(pais);
				}
				
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		return lista;
	}
	
	public Pais maiorPopulacao() {
		Pais to = new Pais();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais ORDER BY populacao DESC LIMIT 1";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {					
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				}
				
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return to;
	}
	
	public Pais menorArea() {
		Pais to = new Pais();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais ORDER BY area ASC LIMIT 1";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {					
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
				}
				
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return to;
	}
	
	public ArrayList<Pais> vetorTresPaises() {
		ArrayList<Pais> paises = new ArrayList<Pais>();
		String sqlSelect = "SELECT id, nome, populacao, area FROM pais LIMIT 3";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlSelect)) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {					
					Pais to = new Pais();
					to.setId(rs.getInt("id"));
					to.setNome(rs.getString("nome"));
					to.setPopulacao(rs.getLong("populacao"));
					to.setArea(rs.getDouble("area"));
					paises.add(to);
				}
				
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return paises;
	}
}
