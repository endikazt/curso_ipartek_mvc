<% String titulo = "HelloWeb | Ejemplo Urls"; %>

<%@include file="/includes/header.jsp" %>
<%@include file="/includes/top-nav.jsp" %>

	<h1>Controladores</h1>
	<p>Ejercicio para ver como funciona REQUEST y RESPONSE desde un SERVLET</p>
	
	
	<section>
		<h2>Ejemplo Servlet sin JSP</h2>
		<ul>
			<li><a href="ejemplo1?nombre=pepe&password=123456" target="_blank">Enlace 200</a></li>
			<li><a href="ejemplo1?nombre=tetera" target="_blank">Enlace 418 Tetera</a></li>
			<li><a href="ejemplo1?password=123dssddsd456" target="_blank">Enlace 401 No Autorizado</a></li>
		</ul>
		
		<form action="ejemplo1" method="post">
		
			<input type="text" name="nombre" placeholder="Dime tu nombre" >
			<br>
			<input type="text" name="password" placeholder="123456" >
		
			<input type="submit" value="Enviar">
		</form>
		
	</section>	
	
	
		<section>
		<h2>Ejemplo Servlet + JSP</h2>
		<ul>
			<li><a href="ejemplo2?nombre=pepe&password=123456" target="_blank">Enlace 200</a></li>
			<li><a href="ejemplo1?nombre=tetera" target="_blank">Enlace 418 Tetera</a></li>
			<li><a href="ejemplo1?password=123dssddsd456" target="_blank">Enlace 401 No Autorizado</a></li>
		</ul>
		
		<form action="ejemplo1" method="post">
		
			<input type="text" name="nombre" placeholder="Dime tu nombre" >
			<br>
			<input type="text" name="password" placeholder="123456" >
		
			<input type="submit" value="Enviar">
		</form>
		
	</section>	
	


<%@include file="/includes/footer.jsp" %>	