<% String titulo = "Index - Curso Ipartek 2019/2020";%>
<%@include file="/includes/header.jsp" %>

<%@include file="/includes/top-nav.jsp" %>

<main>
	    <h1> Alta de usuarios </h1>
	
		<hr>
		
		<c:if test="${not empty mensaje}">
			
			<div style="border: 1px solid #FF0000; min-height: 2em; width: auto">
				
				<p style="color: #FF0000">${mensaje}</p>
			
			</div>
								
		</c:if>
	
	    <form action="private/altausuario" method="POST">
	    	<fieldset>
                <legend> Formulario alta </legend>
                <label for="nombre"> Nombre: </label>
                	<input type="text" name="nombre" autofocus value="${nombreFormulario}" placeholder="Dime tu nombre"> <br>
                <label for="email"> Email: </label>
                	<input type="email" name="email" value="${emailFormulario}" required placeholder="ejemplo@hotmail.com"> <br>
                <label for="deportes">Deportes</label><br>
                <!-- Metodo de sacar datos a machete y enviar de vuelta datos en caso de error -->
	                <input type="checkbox" name="deportes" value="Quidditch" ${deportesFormulario.stream().anyMatch(v->v == 'Quidditch').get() ? 'checked' : ''}> Quidditch <br>
	                <input type="checkbox" name="deportes" value="Jugger" ${deportesFormulario.stream().anyMatch(v->v == 'Jugger').get() ? 'checked' : ''}> Jugger <br>
	                <input type="checkbox" name="deportes" value="Bodyboard" ${deportesFormulario.stream().anyMatch(v->v == 'Bodyboard').get() ? 'checked' : ''}> Bodyboard <br>
	                <input type="checkbox" name="deportes" value="Skateboard" ${deportesFormulario.stream().anyMatch(v->v == 'Skateboard').get() ? 'checked' : ''}> Skateboard <br>
	                <input type="checkbox" name="deportes" value="Escalada" ${deportesFormulario.stream().anyMatch(v->v == 'Escalada').get() ? 'checked' : ''}> Escalada <br>
	             	<label for="sexo">Sexo</label><br>
	             	<select name="sexo">
	             	<!-- 
	             	
		             	Metodo con Hashmap y enviar de vuelta datos en caso de error 
		             	<c:forEach items="${applicationScope.hmSexo}" var="sexos">	
							<option value="${sexos.key}" ${sexoFormulario eq sexos.key ? 'checked' : ''}> ${sexos.value} </option><br>
						</c:forEach>
					
					-->
					
						<option value="H" ${(sexoFormulario eq "H") ? "checked" : ""}> Hombre </option>
						<option value="M" ${(sexoFormulario eq "M") ? "checked" : ""}> Mujer </option>
						<option value="I" ${(sexoFormulario eq "I") ? "checked" : ""}> Indefinido </option>
						
						
					</select>				
	                <input type="submit" value="Enviar">
	       </fieldset>  
	    </form>
	    
</main>
        
<%@include file="/includes/footer.jsp" %>