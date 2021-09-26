package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.bean.FabricanteBean;
import br.com.bean.ProdutoBean;
import br.com.domain.Fabricante;
import br.com.domain.Produto;
import br.com.util.JPAUtil;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = JPAUtil.getEntityManager();
		
		Fabricante f = new Fabricante("10 DE MAIO");
		Fabricante faca = new Fabricante("CAREFUL");
		FabricanteDao dao = new FabricanteDao();
		
		List<Fabricante> l = dao.Listar();
		
		for(Fabricante x : l) {
		
		System.out.println(x);
		}
		
//
//		Produto p = new Produto("Velho", 11l, 20.0, f);
//		Produto edita = new Produto();
//		edita.setCodigo(14l);
//		edita.setDescricao("Novo");
//		ProdutoBean bean = new ProdutoBean();
////		EntityManager em = JPAUtil.getEntityManager();
//		ProdutoDao dao = new ProdutoDao();
//
////		bean.cadastrar(p);
//		
////		bean.alterar(edita);
//		
//		List<Produto> lista = dao.ListarFabricanteProduto();
//		System.out.println(lista);
//		
//		for(Produto x : lista) {
//			System.out.println(x);
//		}

	}

}
