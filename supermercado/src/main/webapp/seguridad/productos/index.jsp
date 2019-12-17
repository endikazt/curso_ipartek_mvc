<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>

	<h1> Productos </h1>
	
	<div class="container d-flex flex-row">
	
		<div class="col-4">
			<h2> Listado de productos </h2>
		</div>
		<div class="col-3">
			<a href="seguridad/productos?accion=formulario" class="btn btn-primary"> Añadir nuevo producto </a>
		</div>
	</div>
	
	<table class="table">
		<thead class="thead-dark">
		  <tr>
		    <th scope="col">#ID</th>
		    <th scope="col">Imagen</th>
		    <th scope="col">Nombre</th>
		    <th scope="col">Descripcion</th>
		    <th scope="col">Precio</th>
		    <th scope="col">Descuento</th>
		    <th scope="col"></th>
		  </tr>
		</thead>
		<tbody>
		
		<c:forEach items="${productos}" var="p">
			<tr>
			    <th scope="row">${p.id}</th>
			    <td><img src="${p.imagen}" alt="imagen de ${p.nombre}" ></td>
			    <td>${p.nombre}</td>
			    <td>${p.descripcion}</td>
			    <td>${p.precio}</td>
			    <td>${p.descuento}</td>
			    <td><a href="seguridad/productos?accion=formulario&id=${p.id}"> Editar </a></td>
		  	</tr>
		</c:forEach>
		 
		</tbody>
	</table>

<%@ include file="/includes/footer.jsp"%>