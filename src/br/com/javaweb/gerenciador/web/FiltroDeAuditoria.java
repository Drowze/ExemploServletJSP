package br.com.javaweb.gerenciador.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.javaweb.gerenciador.Usuario;

/**
 * Servlet Filter implementation class FiltroDeAuditoria
 * 
 * OBS:realizar o teste de falha de seguranca
 * document.cookie = "usuario.logado=outrousuario.gmail.com";
 */
@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

   

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		String usuario = getUsuario(req);
					
        
        System.out.println("Usuario " + usuario + " acessando a URI "
                + uri);
        
        chain.doFilter(request, response);
		
        
	}

	private String getUsuario(HttpServletRequest req){
		
		/**
		 * O servlet conteiner usa um cookie chamado JSESSIONID para indicar o código do 
		 * usuário atual. No servidor ele armazena em um tipo de HashMap qual o código e 
		 * quais os dados atrelados ao usuário.
		 */
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if (usuario==null) return "<deslogado>";
		return usuario.getEmail();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	


}
