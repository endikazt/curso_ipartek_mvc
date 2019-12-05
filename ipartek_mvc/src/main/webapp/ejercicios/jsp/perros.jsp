<% String titulo = "CRUD Perros";%>

<%@page import="com.ipartek.formacion.modelo.pojos.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="/includes/header.jsp" %>
<%@include file="/includes/top-nav.jsp" %>
<main>

	<%
	
		ArrayList<Perro> perros = (ArrayList<Perro>) request.getAttribute("perros");
	
	%>

	<h1> CRUD Perros </h1>

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
					
					<% for ( Perro p :  perros ){ %>
					
						<tr>
							<td><%=p.getId()%></td>				
							<td><%=p.getNombre()%> </td>				
							<td><img alt="" style="height: 150px; width: 200px" src="<%=p.getFoto()%>"></td>	
							<td><a href="/helloweb/perros?id=<%=p.getId()%>&eliminar=true"> Eliminar </a></td>			
						</tr>
					
					<% } %>	
			
				</tbody>
				<tfoot>
				
				</tfoot>		
			</table>
	</section>
	
	<section>
	
		<h2> Formulario de perros </h2>
		
		<form action="/helloweb/perros" method="POST">
		
			
			<label for="nombre"> Nombre del perro: </label>
			<input type="text" name="nombre" placeholder="Nombre del perrete" required>	
			<label for="foto"> Foto del perro: </label>
			<input type="url" name="foto" placeholder="url (jpg, jpeg, png, etc)" required>
	
			<input type="submit" value="Añadir perro">
		
		 </form>
	
	</section>

</main>
<%@include file="/includes/footer.jsp" %>