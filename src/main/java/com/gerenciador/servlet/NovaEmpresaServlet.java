package com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gerenciador.banco.Banco;
import com.gerenciador.dominio.Empresa;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nomeEmpresa = request.getParameter("nome");
		String qtdFuncionarios = request.getParameter("qtdFuncionarios");
		String localizacao = request.getParameter("localizacao");
		String faturamento = request.getParameter("faturamento");
		
		
		System.out.println(nomeEmpresa);
		System.out.println(qtdFuncionarios);
		System.out.println(localizacao);
		System.out.println(faturamento);
		
		Empresa empresa = new Empresa(nomeEmpresa, Integer.parseInt(qtdFuncionarios), localizacao, Double.parseDouble(faturamento));
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		out.println("<html><body>Empresa cadastrada com sucesso!</body></html>");
		
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("nomeEmpresa", empresa.getNome());
		rd.forward(request, response);	
	}

}
