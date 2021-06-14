package br.com.annotation.copy;

import br.com.annotation.anots.Loggable;

public class Produto implements Loggable {

	private String nome;
	private Double preco;
	private Integer desconto;
	private Integer quantidade;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto(String nome, Double preco, Integer desconto, Integer quantidade) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.quantidade = quantidade;
	}

	public Produto() {
	}

	public Produto(String status) {
		super();
		this.status = status;
	}

}
