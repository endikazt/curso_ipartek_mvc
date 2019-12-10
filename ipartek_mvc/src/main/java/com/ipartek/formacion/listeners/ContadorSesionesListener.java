package com.ipartek.formacion.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class ContadorSesionesListener
 *
 */
@WebListener
public class ContadorSesionesListener implements HttpSessionAttributeListener {
	private final static Logger LOG = Logger.getLogger(ContadorSesionesListener.class);

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
	    LOG.debug("attributeAdded: " + event.getName() + " " + event.getValue());
	     
	    ServletContext sc = event.getSession().getServletContext();
	     
	    if("usuarioLogeado".equals(event.getName())) 
	    {
		 	int numeroUsuarios = (int) sc.getAttribute("numeroUsuariosConectados");
			numeroUsuarios++;
			sc.setAttribute("numeroUsuariosConectados", numeroUsuarios);			
	    }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	LOG.debug("attributeRemoved: " + event.getName() + " " + event.getValue());
    	
    	ServletContext sc = event.getSession().getServletContext();
        
    	 if("usuarioLogeado".equals(event.getName())) 
	 	 {
	    	int numeroUsuarios = (int) sc.getAttribute("numeroUsuariosConectados");
	     	int numeroUsuariosConectados = (numeroUsuarios == 0) ? 0: numeroUsuarios--;
			sc.setAttribute("numeroUsuariosConectados", numeroUsuarios);
	 	 }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	LOG.debug("attributeReplaced: " + event.getName() + " " + event.getValue());
    }
	
}
