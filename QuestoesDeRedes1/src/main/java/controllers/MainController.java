package controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/main"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, String> controle;
	
	@Override
    public void init(ServletConfig config) throws ServletException {
		controle = new HashMap<String, String>();
		controle.put("index","controllers.Index");
		controle.put("verifica","controllers.VerificaResposta");
	}
       
    public MainController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String servlet = request.getParameter("s");
		
		Comando cmd;
		try {
			servlet = (servlet == null)?"index":servlet;
			cmd = (Comando) Class.forName((String) controle.get(servlet)).newInstance();
			cmd.executar(request, response);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
