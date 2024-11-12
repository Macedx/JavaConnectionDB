package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;

public class Teste {

	public static void main(String[] args) {
	
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario ana = new Usuario("Ana", "ana@gmail.com");
		Usuario bruno= new Usuario("Bruno", "bruno@gmail.com");
		Usuario gabriel = new Usuario("Gabriel", "gabriel@gmail.com");
		
//		INSERIR USUARIOS NO BANCO
		
		dao.insert(ana);
		dao.insert(bruno);
		dao.insert(gabriel);

		List<Usuario> lista = new ArrayList<Usuario>();
		lista = dao.selectAll();
		
		for(Usuario usuario : lista) {
			System.out.println("ID: "+ usuario.getId());
			System.out.println("Nome: " + usuario.getNome());
			System.out.println("Email: "+ usuario.getEmail());
			System.out.println("Data de cadastro: " + usuario.getDataCadastro());
		}
		
	}

}
