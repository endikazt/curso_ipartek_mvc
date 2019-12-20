package com.ipartek.formacion.endika.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.endika.model.Alerta;


/**
 * Servlet implementation class LogoutConctroller
 */
@WebServlet("/logout")
public class LogoutConctroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioLogeado");
		
		session.invalidate();
		session = null;
		
		request.setAttribute("mensajeAlertaLogout", new Alerta("Gracias por la visita, te echaremos de menos.", Alerta.TIPO_PRIMARY));
		request.getRequestDispatcher("/inicio").forward(request, response);
	}

}
