package com.ipartek.formacion.listeners;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.PerroController2;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
	private final static Logger LOG = Logger.getLogger(AppListener.class);

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	LOG.info("La APP se ha inicializado.");
    	
    	// sc == applicationScope
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("numeroUsuariosConectados", 0);
    	sc.setAttribute("contadorIntentos", 0);
    	
    	Set<String> listaIps = new HashSet<String>();
    	
    	sc.setAttribute("listaIps", listaIps);
    	
    }
	
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
       LOG.info("La APP se ha parado.");
    }

}
