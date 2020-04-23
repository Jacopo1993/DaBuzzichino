package it.micra.dabuzzichino.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet(name = "LoginServlet", urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet {
	
	//implementare chiamata al Db!!!!
	private final String user = "demo";
	private final String password = "demo";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String paramUsername=request.getParameter("username");
		String paramPassword=request.getParameter("password");
		
		if (user.equals(paramUsername) && password.equals(paramPassword)) {
			//se l'autenticazione è corretta
			
			//recupero la sessione
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			
			HttpSession currentSession = request.getSession();//crea una nuova sessione
			currentSession.setAttribute("user", paramUsername);
			currentSession.setMaxInactiveInterval(5*60); //5 minuti di inattività
			
			response.sendRedirect("home.xhtml");
		}
		else {
			//se il login fallisce
			response.sendRedirect("login.jsp");
			//implementare messaggio di errore!!!!!!
			
		}
	}

}
