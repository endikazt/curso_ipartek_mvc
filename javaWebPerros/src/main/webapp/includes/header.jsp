<!DOCTYPE html>
<html lang="en">

    <head>
    
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0 user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        
        <link href="https://fonts.googleapis.com/css?family=Fira+Mono&display=swap" rel="stylesheet">
        
        <title><%=titulo%></title>

        <!-- La base para contruir todas las rutas de la pagina -->

        <base href="/perretes/">

        <!-- CSS Custom -->
        <link rel="stylesheet" href="css/styles.css?time=<%=System.currentTimeMillis()%>">
        
        <link rel="apple-touch-icon" sizes="57x57" href="images/icons/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="images/icons/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="images/icons/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="images/icons/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="images/icons/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="images/icons/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="images/icons/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="images/icons/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="images/icons/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="images/icons/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="images/icons/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="images/icons/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="images/icons/favicon-16x16.png">
		<link rel="manifest" href="images/icons/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="images/icons/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
		
    </head>
    
    <body id="top">
    
    <section id="usuario">
    	<%
    		String user = (String) session.getAttribute("usuarioLogeado");
    		String idioma = (String) session.getAttribute("idioma");
    	
    		if(user == null) {
    			
    	%>
    	
    		<p style="color:#F00;"> La sesion ha caducado. Va a la pagina de <a href="index.jsp">login</a> para iniciar sesion de nuevo.</p>
    	
    	<% 		
    		} else {
    	%>
    	
    		<p> Usuario = <%=user%>, Idioma = <%=idioma%> <a href="/perretes/logout"> Cerrar sesion</a></p>
    	
    	<%
    		}
    	%>
    	
    	<p> Usuario conectados: ${applicationScope.numeroUsuariosConectados}</p>
    </section>