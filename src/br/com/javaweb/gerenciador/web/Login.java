package br.com.javaweb.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.javaweb.gerenciador.Usuario;
import br.com.javaweb.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        PrintWriter writer = response.getWriter();
        
        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

        if (usuario == null) {
            response.sendRedirect("erro.html");
        } else {
			HttpSession session = request.getSession();	
			session.setAttribute("usuarioLogado", usuario);			
			RequestDispatcher disp = 
			request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
        }
		
	}

}
