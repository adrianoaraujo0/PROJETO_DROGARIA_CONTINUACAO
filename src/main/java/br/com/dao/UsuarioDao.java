package br.com.dao;

import javax.persistence.EntityManager;

import br.com.domain.Usuario;
import br.com.util.JPAUtil;

public class UsuarioDao {

	private EntityManager em;
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao() {

	}

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Usuario usuario) {

		EntityManager em = JPAUtil.getEntityManager();
		this.em = em;

		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	 public Usuario getUsuario(String nomeUsuario, String senha) {

	      try {
	        Usuario usuario = (Usuario) em
	         .createQuery("SELECT u from Usuario u where u.email =:name and u.senha = :senha")
	         .setParameter("name", nomeUsuario)
	         .setParameter("senha", senha).getSingleResult();

	        return usuario;
	      } catch (Exception e) {
	            return null;
	      }
	    }

}
