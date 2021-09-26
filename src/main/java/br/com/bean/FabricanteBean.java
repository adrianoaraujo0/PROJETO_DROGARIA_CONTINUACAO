package br.com.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.FabricanteDao;
import br.com.domain.Fabricante;
import br.com.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante;
	private ArrayList<Fabricante> fabricantes;
	private ArrayList<Fabricante> fabricantesFiltrados;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ArrayList<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public ArrayList<Fabricante> getFabricantesFiltrados() {
		return fabricantesFiltrados;
	}

	public void setFabricantesFiltrados(ArrayList<Fabricante> fabricantesFiltrados) {
		this.fabricantesFiltrados = fabricantesFiltrados;
	}

	@PostConstruct // é carregado ao iniciar da pag
	public void prepararLista() {
		try {
			FabricanteDao dao = new FabricanteDao();
			fabricantes = dao.Listar();

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararNovo() {
		fabricante = new Fabricante();
	}

	public void novo() {
		try {
			FabricanteDao dao = new FabricanteDao();

			dao.cadastrar(fabricante);

			fabricantes = dao.Listar();

			JSFUtil.adicionarMensagemSucesso("Fabricante salvo com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void excluir() {
		try {
			FabricanteDao dao = new FabricanteDao();

			dao.remover(fabricante);

			fabricantes = dao.Listar();
			//= new ArrayList<Fabricante>(dao.Listar());

			JSFUtil.adicionarMensagemSucesso("Removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			// JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}


	public void editar() {
		try {

			FabricanteDao dao = new FabricanteDao();
			fabricantes = dao.Listar();

			dao.merge(fabricante);

			JSFUtil.adicionarMensagemSucesso("ALTERADO COM SUCESSO");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

}
