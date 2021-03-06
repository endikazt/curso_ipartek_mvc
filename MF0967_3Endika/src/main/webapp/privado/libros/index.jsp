<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>

	<h1> Seccion de libros </h1>
	
	<h2 class="mt-4 mb-3"> Listado de libros </h2>
	
	<table class="table">
		<thead class="thead-dark">
		  <tr>
		    <th scope="col">#ID</th>
		    <th scope="col">Portada</th>
		    <th scope="col">Nombre</th>
		    <th scope="col">Autor</th>
		    <th scope="col">Precio (&#8364)</th>
		    <th scope="col">Descuento (%)</th>
		    <th></th>
		  </tr>
		</thead>
		<tbody>
		
		<c:if test="${not empty libros}">	
			<c:forEach items="${libros}" var="l">
				<tr>
				    <th scope="row">${l.id}</th>
				    <td><img src="${l.imagen}"></td>
				    <td>${l.nombre}</td>
				    <td>${l.autor}</td>
				    <td>${l.precioFormateado()}&#8364</td>
				    <td>${l.descuento}%</td>
				    <td>
				    	<a href="privado/libros?accion=formulario&id=${l.id}"> <img src="images/editar-libro.png" alt="imagen editar libro"> </a>
				    </td>
			  	</tr>
			</c:forEach>
		</c:if>
		 
		</tbody>
		
		<c:if test="${empty libros}">
			<p> En esto momentos no hay ningun libro en la base de datos. Si lo desea puede agregar uno desde <a href="libros?accion=formulario">este enlace</a>. </p>
		</c:if>
		
	</table>

<%@ include file="/includes/footer.jsp"%>