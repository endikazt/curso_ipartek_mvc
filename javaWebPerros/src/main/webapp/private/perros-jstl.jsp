<% String titulo = "CRUD Perros";%>

<%@include file="/includes/header.jsp" %>
<%@include file="/includes/top-nav.jsp" %>
<main>

	<h1> CRUD Perros con JSTL </h1>
	
	<p> Mismo ejemplo que el de CRUD Perros pero esta vez usando taglib y expresion lenguage</p>
	
	<c:if test="${not empty mensaje}">
		<p style="color:teal;font-size: 2em">${mensaje}</p>
	</c:if>
	
	<c:if test="${empty mensaje}">
		<p style="color:teal;font-size: 2em">No tenemos ningun mensaje</p>
	</c:if>
	
	<section>
	
		<h2> Lista de perros </h2>
			<table>
				<thead>
					<tr>
						<th> ID </th>
						<th> Nombre </th>
						<th> Foto </th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach items="${perros}" var="p">
						<tr>
							<td>${p.id}</td>				
							<td>${p.nombre} </td>				
							<td><img alt="" style="height: 150px; width: 200px" src="${p.foto}"></td>	
							<td>
								<a href="/perretes/private/perros2?id=${p.id}&adoptar=si"> Adoptar </a>
								<a href="/perretes/private/perros2?id=${p.id}&editar=si"> Modificar </a>
							</td>			
						</tr>	
					</c:forEach>
					
				</tbody>
				<tfoot>
				
				</tfoot>		
			</table>
	</section>
	
	<section>
		
		${perroEditar}
	
		<h2> Formulario de perros </h2>
		
		<form action="/perretes/private/perros2" method="POST">
			<input type="hidden" name="id" value="${perroEditar.id}"> <br>
			<label for="nombre"> Nombre del perro: </label>
			<input type="text" name="nombre" placeholder="Nombre del perrete" value="${perroEditar.nombre}" required> <br>	
			<label for="foto"> Foto del perro: </label>
			<input type="url" name="foto" placeholder="url (jpg, jpeg, png, etc)" value="${perroEditar.foto}" required> <br>
	
			<input type="submit" value="Añadir perro">
		
		 </form>
	
	</section>

</main>
<%@include file="/includes/footer.jsp" %>