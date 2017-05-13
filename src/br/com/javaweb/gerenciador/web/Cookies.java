package br.com.javaweb.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {
	
	private final Cookie[] cookies;
	
	public Cookies(Cookie[] cookies){
		this.cookies = cookies;
	}

	public Cookie buscaUsuarioLogado(){
		
		if (cookies == null) return null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("usuario.logado")) {
            	System.out.println("Achou o Cookie!");
                return cookie;
            }
        }
		return null;
	}
}
