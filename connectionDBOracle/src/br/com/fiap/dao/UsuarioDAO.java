package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.connectiom.ConnectionFactory;
import br.com.fiap.model.Usuario;

//Tem as operações, é a ponte entre o pacote de conexão e o pacote de modelo

public class UsuarioDAO {
	
	private Connection connection;
	
	public UsuarioDAO() {
		this.connection = new ConnectionFactory().conectar();
	}
		
//		INSERT.
		public void insert(Usuario usuario) {
			String sql = "insert into usuario (nome, email, dataCadastro) values (?, ?, ?)";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getEmail());
				stmt.setDate(3, usuario.getDataCadastro());
				stmt.execute();
				stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		}
//		DELETE
		public void delete(long id) {
			String sql = "delete * from usuario where id=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setLong(1, id);
				stmt.execute();
				stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
//		UPDATE
		public void update(Usuario usuario) {
			String sql = "update usuario set npome=?, email=?, dataCadastro=? where id=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getEmail());
				stmt.setDate(3, usuario.getDataCadastro());
				stmt.setLong(4,  usuario.getId());
				stmt.execute();
				stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
//		SELECT ALL
		public List<Usuario> selectAll() {
			List<Usuario> listaUsuarios = new ArrayList<Usuario>();
			String sql = "select * from usuario order by nome";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setDataCadastro(rs.getDate("dataCadastro"));
					listaUsuarios.add(usuario);
				}
				stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return listaUsuarios;
		}
	
		
//		SELECT BY ID
		public Usuario selectById(long id) { 
			Usuario usuario = new Usuario();
			String sql = "select * from usuario where id=?";
			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setLong(1, id);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setDataCadastro(rs.getDate("dataCadastro"));
				}
				stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
			return usuario;
		
}
}

