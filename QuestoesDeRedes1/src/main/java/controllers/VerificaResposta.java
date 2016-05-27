package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

public class VerificaResposta extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		String resposta_s =  request.getParameter("resposta");
		int resposta = Integer.parseInt(resposta_s);
		
		String indicePergunta_s = request.getParameter("indicePergunta");
		int indicePergunta = Integer.parseInt(indicePergunta_s);
		
		boolean acertou = Dao.verSeAcertou(indicePergunta, resposta);
		
		String jsp = "/WEB-INF/resposta_errada.jsp";
		if(acertou)
			jsp = "/WEB-INF/resposta_correta.jsp";		
		
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
