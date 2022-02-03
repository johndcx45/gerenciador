package com.gerenciador.dominio;

public class Empresa {
	
	String nome;
	int qtdFuncionarios;
	String localizacao;
	double faturamentoPorAno;
	
	public Empresa(String nome, int qtdFuncionarios, String localizacao, double faturamentoPorAno) {
		super();
		this.nome = nome;
		this.qtdFuncionarios = qtdFuncionarios;
		this.localizacao = localizacao;
		this.faturamentoPorAno = faturamentoPorAno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}
	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public double getFaturamentoPorAno() {
		return faturamentoPorAno;
	}
	public void setFaturamentoPorAno(double faturamentoPorAno) {
		this.faturamentoPorAno = faturamentoPorAno;
	}
	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", qtdFuncionarios=" + qtdFuncionarios + ", localizacao=" + localizacao
				+ ", faturamentoPorAno=" + faturamentoPorAno + "]";
	}
	
	
}
