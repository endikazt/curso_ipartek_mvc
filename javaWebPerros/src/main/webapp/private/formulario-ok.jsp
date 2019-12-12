<% String titulo = "Index - Curso Ipartek 2019/2020";%>
<%@include file="/includes/header.jsp" %>

<%@include file="/includes/top-nav.jsp" %>

<main>
		<h1> Resumen alta </h1>
	
		<hr>
		<c:if test="${not empty mensaje}">
			
			<div style="border: 1px solid #00FF00; min-height: 2em; width: auto">
				
				<p style="color: #00FF00">${mensaje}</p>
			
			</div>
								
		</c:if>
		
		<section>
			
			<p> Nombre: ${nombreFormulario} </p>
			<p> Email: ${emailFormulario} </p>
			<p> Deportes: </p>
				<ul>
					<c:forEach items="${deportesFormulario}" var="deporte">
						<li> ${deporte} </li>
					</c:forEach>
				</ul>
		
		</section>

</main>

<%@include file="/includes/footer.jsp" %>