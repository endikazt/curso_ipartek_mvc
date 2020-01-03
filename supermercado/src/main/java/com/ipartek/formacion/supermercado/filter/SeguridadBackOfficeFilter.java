package com.ipartek.formacion.supermercado.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.modelo.pojo.Rol;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/seguridad/*" })
public class SeguridadBackOfficeFilter implements Filter {

	private final static Logger LOG = Logger.getLogger(SeguridadBackOfficeFilter.class);

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.trace("destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;


		/*
		 * 
		 * LOG.debug("RequestURL " + req.getRequestURL()); LOG.debug("RequestURI " +
		 * req.getRequestURI()); LOG.debug("HTTP Protocol " + req.getProtocol());
		 * LOG.debug("Remote Address" + req.getRemoteAddr()); LOG.debug("Remote Host" +
		 * req.getRemoteHost()); LOG.debug("Navegador" + req.getHeader("User-Agent"));
		 * 
		 */

//		Map<String, String[]> map = req.getParameterMap();
//
//		for (String key: map.keySet())
//	    {
//            String keyStr = key;
//            String[] value = (String[])map.get(keyStr);
//            
//            for(int i = 0; i < value.length; i++) {
//            	LOG.debug("Key" + key + "   :   " + value[i]);
//            }
//	           
//	    }

		HttpSession session = req.getSession();
		
		Usuario uLogeado = (Usuario) session.getAttribute("usuarioLogeado");

		if (uLogeado != null && uLogeado.getRol().getId() == Rol.ROL_ADMIN) {
			
			// dejamos continuar
			// pass the request along the filter chain
			chain.doFilter(request, response);

		} else {
			
			LOG.warn("acceso denegado por seguridad " + uLogeado);
			session.invalidate();
			resp.sendRedirect( req.getContextPath() +  "/login.jsp");
			
		}

	}
}
