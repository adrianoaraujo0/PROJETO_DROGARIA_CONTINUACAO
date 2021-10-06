package br.com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.dao.UsuarioDao;
import br.com.domain.Usuario;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	private UsuarioDao dao;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean InserirUsuario() {
		 dao = new UsuarioDao();
		try {
			dao.cadastrar(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}
	
	
	public String envia() {

		usuario = dao.getUsuario(usuario.getEmail(), usuario.getSenha());
		
		
	    if (usuario == null) {
	      usuario = new Usuario();
	      
	      FacesContext.getCurrentInstance().addMessage( null,
	         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
	           "Erro no Login!"));
	      return null;
	    } else {
	          return "/main";
	    }


	  }

}
