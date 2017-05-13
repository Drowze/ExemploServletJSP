package br.com.javaweb.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaweb.gerenciador.Empresa;
import br.com.javaweb.gerenciador.dao.EmpresaDAO;

/**
 * Servlet implementation class AdicionaEmpresa
 */
@WebServlet("/adicionaEmpresa")
public class AdicionaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Legal, nosso código funciona.. mas será que esta implementado da melhor maneira?
	 * 
	 * Estamos inserindo empresa via método GET do HTTP, isso é problematico nao?
	 * 
	 * Porque?
	 * 
	 * 1) Get pode ser cacheado pelo servidor, então varios problemas de cache poderão surgir
	 * 2) Get tem limite de tamanho na URI, então se passarmos uma URI mto grande, a informacão será perdida
	 * 3) Get deve ser usado para buscar informações, para requisições que não trazem efeitos colaterais indesejáveis, 
	 * 		para requisições que podem ser requisitadas diversas vezes sem causar nenhum dano.
	 * 
	 */
	
	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Empresa : " + nome + " inserida com sucesso!</body></html>");
	}
	*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
				
		request.setAttribute("empresa", empresa.getNome());
		
		RequestDispatcher disp = 
		request.getRequestDispatcher
		("/WEB-INF/paginas/novaEmpresa.jsp");
		disp.forward(request, response);
	}
	
}
