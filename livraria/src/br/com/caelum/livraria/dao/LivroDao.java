package br.com.caelum.livraria.dao;

import java.util.List;

import br.com.caelum.livraria.modelo.Livro;

public class LivroDao {
	private DAO<Livro> dao;

	public void adiciona(Livro t) {
		dao.adiciona(t);
	}

	public void remove(Livro t) {
		dao.remove(t);
	}

	public void atualiza(Livro t) {
		dao.atualiza(t);
	}

	public List<Livro> listaTodos() {
		return dao.listaTodos();
	}

	public Livro buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}

	public int quantidadeDeElementos() {
		return dao.quantidadeDeElementos();
	}
}
