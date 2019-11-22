<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	    <title>Document</title>
	
	    <base href="/helloweb/">
	    
	    <link rel="stylesheet" href="ejercicios/css/stylesCssBasico.css">
		<link rel="stylesheet" href="css/styles.css">
	
	    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />

	</head>
	<body>
<%@include file="/includes/top-nav.jsp" %>
		<main>
		    <script src="/ejercicios/js/mainCssBasico.js">  </script>
		    
		    <hr>
		    
		    <a style="padding-right: 1em;" target="_blank" href="https://formacion.ipartek.com"> Link a Ipartek Formacion </a> 
		    <a style="padding-right: 1em;" href="index.jsp"> Volver a la pagina de inicio </a> 
		    <a style="padding-right: 1em;" href="#imagenes"> Imagenes </a> 
		    <a style="padding-right: 1em;" href="tel:669666868"> Realizar llamada </a>
		    <a style="padding-right: 1em;" href="mailto:endikaztxt@gmail.com"> Mandar un correo </a>
		    <noscript> Tienes que activar javascript para utilizar esta funcion </noscript>
		    <button style="padding-right: 1em;" onclick="tacharTexto()"> Haz click aqui </button>
		
		    <h1> Ejercicio CSS Basico </h1>
		
		    <p id="parrafo1" style="margin: auto;"> Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi et tempore velit asperiores illo suscipit laborum, enim quis nisi dolorum facilis tenetur provident corrupti obcaecati earum recusandae vitae amet error. </p> 
		    <p id="parrafo2" style="margin: auto;"> Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi et tempore velit asperiores illo suscipit laborum, enim quis nisi dolorum facilis tenetur provident corrupti obcaecati earum recusandae vitae amet error. </p>
		    <p id="parrafo3" style="margin: auto;"> Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi et tempore velit asperiores illo suscipit laborum, enim quis nisi dolorum facilis tenetur provident corrupti obcaecati earum recusandae vitae amet error. </p>
		    <p id="parrafo4" style="margin: auto;"> Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi et tempore velit asperiores illo suscipit laborum, enim quis nisi dolorum facilis tenetur provident corrupti obcaecati earum recusandae vitae amet error. </p> <br>
		    <p id="parrafo5" style="margin: auto;">
		        <pre>
		        Lorem ipsum dolor sit amet consectetur adipisicing elit. 
		        Eligendi et tempore velit asperiores illo suscipit laborum, 
		        enim quis nisi dolorum facilis tenetur provident corrupti 
		        obcaecati earum recusandae vitae amet error.
		        </pre>
		    </p>
		
		    <hr>
		
		    <ol style="margin: auto;">
		        <li> Opcion 1</li>
		        <li> Opcion 2</li>
		    </ol>
		
		    <ul style="margin: auto;">
		        <li> Opcion 1</li>
		        <li> Opcion 2</li>
		    </ul>
		    <dl style="margin: auto;">
		        <dt> Opcion 1</dt>
		        <dd> Muestra la opcion 1 </dd>
		        <dt> Opcion 2</dt>
		        <dd> Muestra la opcion 2 </dd>
		    </dl>
		
		    <hr>
		
		    <iframe style="marin: auto;" width="560" height="315" src="https://www.youtube.com/embed/DJki_1XHbX0" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		
		    <hr id="#imagenes">
		
		    <img  height="275" width="300" src="images/awake.jpg" alt="Awake but a what cost meme">
		
		    <img  height="425" width="300" src="images/html5-cheat-sheet.png" alt="Tabla de etiquetas HTML">
		    <hr>
		
		    <progress value="60" max="100">
		            <span id="descargando">60</span>%
		   </progress>
		
		   <meter min="0" max="120" value="40">
		        <span>1/3</span>
		    </meter>
		
		    <hr>
<%@include file="/includes/footer.jsp" %>