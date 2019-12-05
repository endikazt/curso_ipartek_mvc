<% String titulo = "FlexBox";%>

<%@include file="/includes/header.jsp" %>
<%@include file="/includes/top-nav.jsp" %>
<main>
	<h1> FlexBox </h1>
	<section>
	<ul>
	 	<li><a target="_blank" href="https://css-tricks.com/snippets/css/a-guide-to-flexbox/"> Guia de FlexBox</a></li>
	 	<li><a target="_blank" href="https://flexboxfroggy.com/#es"> Juego de FlexBox</a></li>
	 	<li><a target="_blank" href="http://www.falconmasters.com/web-design/sitio-web-layout-flexbox/"> Maquetar paginas web con FlexBox</a></li>
	 	<p> Flex es una nueva forma de <code>display</code> de CSS3 totalmente nueva, para que las cajas no sean inline o block, se comportaran de una forma mucho mas flexible ;)</p>
	 	<p> Sirve para distribuir los elementos conetenidos (hijos) en una etiqueta con <code>display</code></p>
	</ul>
	</section>
	<style>
		/* Estilos para practicar flexbox*/
		
		.container
		{
			border: 5px solid #000;
			width: 80%;
			margin: auto;
			display: flex;
			
			flex-direction: row; /* Por defecto */
			flex-wrap: wrap; /*Por defecto acomoda todo y no desborda*/
			justify-content: space-between;
			
		}	
		
		.container div
		{
			border: 5px solid teal;
			min-height: 80px;
			margin: 5px;
			width: 15%;
			box-sizing: border-box;
			background-color: blue;
			color: white;
			
		}
		
	</style>
	
	<section>
	<div class="container"> 
		<div> Hijo 1 </div>
		<div> Hijo 2 </div>
		<div> Hijo 3 </div>
		<div> Hijo 4 </div>
		<div> Hijo 5 </div>
		<div> Hijo 6 </div>
	</div>
	</section>

	<section>
	<img src="http://www.campus.formacion.ipartek.com/moodle/pluginfile.php/4558/mod_resource/content/1/flex-axes.png">
	</section>	

</main>	
<%@include file="/includes/footer.jsp" %>