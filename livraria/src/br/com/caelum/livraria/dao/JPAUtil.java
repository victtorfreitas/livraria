package br.com.caelum.livraria.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("livraria");

	@Produces //Para o CDI que o metodo abaixo produz um EntityManager
	@RequestScoped //O CDI precisa saber quantas vezes o EntityManager será criado, que no caso é uma vez na requisição inicial
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	//Disposes é para o CDI identificar que será realizado quando a Requisição acima não existir, ou seja, quando o usuario fizer logoff
	public void close(@Disposes EntityManager em) {
		em.close();
	}
}
