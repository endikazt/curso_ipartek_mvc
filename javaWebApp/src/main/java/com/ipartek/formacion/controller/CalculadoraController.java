package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraController
 */
@WebServlet("/sumar")
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculadoraController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recibir parametros del formulario
		String op = request.getParameter("op");
		String num1 = request.getParameter("op1");
		String nume2 = request.getParameter("op2");
		
		
		//realizar calculos
		
		try 
		{
			
			switch (op) {
			case "1":
				int suma = (Integer.parseInt(num1) + Integer.parseInt(nume2));
				//enviar datos a la vista
				request.setAttribute("resultado", suma);
				break;
			case "2":
				int resta = (Integer.parseInt(num1) - Integer.parseInt(nume2));
				//enviar datos a la vista
				request.setAttribute("resultado", resta);
				break;
			case "3":
				int multi = (Integer.parseInt(num1) * Integer.parseInt(nume2));
				//enviar datos a la vista
				request.setAttribute("resultado", multi);
				break;
			case "4":
				int divi = (Integer.parseInt(num1) / Integer.parseInt(nume2));
				//enviar datos a la vista
				request.setAttribute("resultado", divi);
				break;

			default:
				break;
			}
						
					
		} catch (Exception e) 
		{	
			//enviar datos a la vista
			request.setAttribute("resultado", 0);
			request.setAttribute("mensaje", "illo ponme numeros");
			
		} finally {
			
			request.setAttribute("op1", num1);
			request.setAttribute("op2", nume2);	
			request.setAttribute("op", op);	
			request.getRequestDispatcher("resultado.jsp").forward(request, response);
		}
		
		
	}

}
