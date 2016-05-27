package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import models.Pergunta;

public class Index extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		Pergunta perguntaAleatoria = Dao.getPerguntaAleatoria();
		request.setAttribute("perguntaAleatoria", perguntaAleatoria);
		
		int indicePergunta = Dao.getIndicePergunta(perguntaAleatoria);
		request.setAttribute("indicePergunta", indicePergunta);
		
		String jsp = "/WEB-INF/index.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
