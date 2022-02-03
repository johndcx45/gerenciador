package com.gerenciador.banco;

import java.util.ArrayList;
import java.util.List;

import com.gerenciador.dominio.Empresa;

public class Banco {
	
	private static List<Empresa> bancoDeEmpresas = new ArrayList<>();
	
	public void adiciona(Empresa empresa) {
		Banco.bancoDeEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.bancoDeEmpresas;
	}
}
