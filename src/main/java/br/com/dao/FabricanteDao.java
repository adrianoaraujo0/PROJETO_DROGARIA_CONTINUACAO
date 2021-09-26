package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.domain.Fabricante;
import br.com.util.JPAUtil;

public class FabricanteDao {

	private EntityManager em;

	public FabricanteDao() {

	}

	public FabricanteDao(EntityManager em) {
		this.em = em;
	}

	public void merge(Fabricante fabricante) {
		em.getTransaction().begin();
		em.merge(fabricante);
		em.getTransaction().commit();
		em.close();

	}

	public void cadastrar(Fabricante fabricante) {

		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;
		
		em.getTransaction().begin();
		em.persist(fabricante);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(Fabricante fabricante) {

		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;
		
		em.getTransaction().begin();
		fabricante = em.merge(fabricante);
		this.em.remove(fabricante);
		em.getTransaction().commit();
		em.close();
	}

	public List<Fabricante> editar(Long id) {

		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		String jpql = "SELECT p FROM Fabricante p WHERE p.id = :id";
		return em.createQuery(jpql, Fabricante.class).setParameter("id", id).getResultList();

	}

	public Fabricante buscarPorId(Long id) {
		return em.find(Fabricante.class, id);
	}

	public List<Fabricante> buscarTodos() {
		String jpql = "SELECT p FROM Fabricante";
		return em.createQuery(jpql, Fabricante.class).getResultList();
	}

	public List<Fabricante> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Fabricante p WHERE p.descricao = :nome";
		return em.createQuery(jpql, Fabricante.class).setParameter("nome", nome).getResultList();
	}

	public ArrayList<Fabricante> Listar() {
		
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		String jpql = "SELECT p FROM Fabricante p ORDER BY" + " p.codigo ";
		return (ArrayList<Fabricante>) em.createQuery(jpql, Fabricante.class).getResultList();

	}
}