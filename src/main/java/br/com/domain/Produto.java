package br.com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;
	private Long quantidade;
	private Double preco;

	@ManyToOne
	@JoinColumn(name = "fabricante_produto")
	private Fabricante fabricante = new Fabricante();

	public Produto() {

	}

	public Produto(String descricao) {
		this.descricao = descricao;
	}

	public Produto(String descricao, Long quantidade, Double preco, Fabricante fabricante) {
		this.fabricante = fabricante;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "\nProduto :codigo = " + codigo +
				", descricao = " + descricao + ", quantidade = " + quantidade + 
				", preco = " + preco + ", fabricante = " + fabricante;
	}
	
	

}
