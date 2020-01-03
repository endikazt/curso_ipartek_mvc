<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>

	<h1> Mis Productos </h1>
	
	<div class="row flex-row mt-4 mb-4">
		<div class="col-4">
			<h2> Listado de mis productos </h2>
		</div>
		<div class="col-3">
			<a href="seguridad/productos?accion=formulario" class="btn btn-primary"> Añadir nuevo producto </a>
		</div>
	</div>
	
	<table id="tabla" class="table display" style="width:100%">
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
				    <td><a href="mipanel/productos?accion=formulario&id=${p.id}"> Editar </a></td>
			  	</tr>
			</c:forEach>
        </tbody>
        <tfoot>
            <tr>
               	<th scope="col">#ID</th>
			    <th scope="col">Imagen</th>
			    <th scope="col">Nombre</th>
			    <th scope="col">Descripcion</th>
			    <th scope="col">Precio</th>
			    <th scope="col">Descuento</th>
			    <th scope="col"></th>
            </tr>
        </tfoot>
    </table>

<%@ include file="/includes/footer.jsp"%>