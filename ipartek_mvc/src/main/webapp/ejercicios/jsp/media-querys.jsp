<% String titulo = "Media querys";%>

<%@include file="/includes/header.jsp" %>
<%@include file="/includes/top-nav.jsp" %>
<main>
	
	<h1> Media Querys </h1>

	<section>
	 	<p> Una media query consiste en un tipo de medio y al menos una consulta que limita las hojas de estilo utilizando características del medio como ancho, alto y color.  </p>
	</section>	
	
	<style>
	
		/* tablet */
		
		@media screen and (max-width: 768px) and (min-width: 425px)
		{
			section
			{
				background-color: purple;
			}
			
			h1
			{
				color: purple;
			}
		}
	
		/*mobil*/
		
		@media screen and (max-width: 426px)
		{
			section
			{
				background-color: pink;
			}
			
			h1
			{
				color: pink;
			}
		}
		
		
	</style>
	
</main>	
<%@include file="/includes/footer.jsp" %>