package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class Comando {
	
	public abstract void executar(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, IOException, ServletException;
}
