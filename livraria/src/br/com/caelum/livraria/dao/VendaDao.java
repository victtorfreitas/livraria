package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Venda;

public class VendaDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
    private EntityManager em;

    private DAO<Venda> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Venda>(this.em, Venda.class);
    }

    public Venda buscaPorId(Integer livroId) {
        return this.dao.buscaPorId(livroId);
    }

    public void adiciona(Venda venda) {
        this.dao.adiciona(venda);
    }

    public void atualiza(Venda venda) {
        this.dao.atualiza(venda);
    }

    public void remove(Venda venda) {
        this.dao.remove(venda);
    }
    
    public List<Venda> listaTodos() {
        return this.dao.listaTodos();
    }

}