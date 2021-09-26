package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JPAUtil;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao() {

	}

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(Long id) {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		Produto produto = em.getReference(Produto.class, id);

		em.getTransaction().begin();
		this.em.remove(produto);
		em.getTransaction().commit();
		em.close();
	}

	public void editar(Produto produto) {
		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close();

	}

	public Produto buscaPorID(Long id) {

		return em.find(Produto.class, id);

	}

	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.descricao = :descricao";
		return em.createQuery(jpql, Produto.class).setParameter("descricao", nome).getResultList();
	}

	public List<Produto> buscarPorFabricante(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.fabricante.descricao = :descricao";
		return em.createQuery(jpql, Produto.class).setParameter("descricao", nome).getResultList();
	}

	public Double buscarPrecoPorNomeDoProduto(String nome) {
		String jpql = "SELECT p.preco FROM Produto p WHERE p.descricao = :preco";
		return em.createQuery(jpql, Double.class).setParameter("preco", nome).getSingleResult();
	}

	public ArrayList<Produto> Listar() {

		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		String jpql = "SELECT p FROM Produto p ORDER BY" + " p.descricao ASC";
		return (ArrayList<Produto>) em.createQuery(jpql, Produto.class).getResultList();

	}
	
	public ArrayList<Produto> ListarFabricanteProduto() {

		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		String jpql = "SELECT p FROM Produto p JOIN p.fabricante f";
		
		 return (ArrayList<Produto>) em.createQuery(jpql, Produto.class).getResultList();

	}

}
