package br.com.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.FabricanteDao;
import br.com.dao.ProdutoDao;
import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

	private Produto produto;
	private ArrayList<Fabricante> comboFabricantes;

	private ArrayList<Produto> produtos;
	private ArrayList<Produto> produtosFiltrados;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Fabricante> getComboFabricantes() {
		return comboFabricantes;
	}

	public void setComboFabricantes(ArrayList<Fabricante> comboFabricantes) {
		this.comboFabricantes = comboFabricantes;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(ArrayList<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	//// METODOS
	public void cadastrar(Produto produto) {

		ProdutoDao dao = new ProdutoDao();
		dao.cadastrar(produto);
	}

	public void excluir(Long id) {

		ProdutoDao dao = new ProdutoDao();
		dao.remover(id);
	}

	public void alterar(Produto produto) {

		ProdutoDao dao = new ProdutoDao();
		dao.editar(produto);
	}

	public void prepararNovo() {
		try {

			this.produto = new Produto();

			FabricanteDao dao = new FabricanteDao();

			comboFabricantes = dao.Listar();

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void carregarListagem() {
		try {

			ProdutoDao dao = new ProdutoDao();
			produtos = dao.ListarFabricanteProduto();

			// JSFUtil.adicionarMensagemSucesso("");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void novo() {
		try {
			ProdutoDao dao = new ProdutoDao();
			dao.cadastrar(produto);
			produtos = dao.ListarFabricanteProduto();

			JSFUtil.adicionarMensagemSucesso("CADASTRADO COM SUCESSO");

		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			ProdutoDao dao = new ProdutoDao();

			dao.remover(produto.getCodigo());

			produtos = dao.Listar();
			// = new ArrayList<Fabricante>(dao.Listar());

			JSFUtil.adicionarMensagemSucesso("Removido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			// JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararEditar() {

		this.produto = new Produto();

		FabricanteDao dao = new FabricanteDao();

		comboFabricantes = dao.Listar();

	}

	public void editar() {
		try {

			ProdutoDao dao = new ProdutoDao();
			dao.editar(produto);

			produtos = dao.ListarFabricanteProduto();

			JSFUtil.adicionarMensagemSucesso("EDITADO!!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}
}
