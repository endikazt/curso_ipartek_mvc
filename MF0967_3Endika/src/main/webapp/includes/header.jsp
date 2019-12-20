
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
<fmt:setLocale value="es_ES"/>

<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
  	
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Endika Zuazo Txintxurreta">
    <title>MF0967_3 - Endika Zuazo</title>
    
    <base href="${pageContext.request.contextPath}/">

   <!-- Bootstrap core CSS -->
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
   
   <!-- Font Awesome CSS -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" rel="stylesheet">

   <!-- Custom CSS -->
   <link rel="stylesheet" href="css/custom.css">

  </head>
  <body id="top">
  
  <nav></nav>
  
  <h5></h5>
  
  <section></section>
  
  <br>
    <nav class="site-header sticky-top">
       
         <div class="topnav" id="myTopnav">
         
	        <c:if test="${empty usuarioLogeado}">
	        
		        <a class="py-2 d-none d-md-inline-block" href="inicio"> <img src="images/icono-nav.png" alt="imagen libreria"> </a>    	
            	<a class="py-3 d-none d-md-inline-block" href="login.jsp">Login</a>
            	<a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>  
            
            </c:if>
            
            <c:if test="${not empty usuarioLogeado}">
            	
            	<a href=""> <img src="images/icono-nav.png"> </a>
            	<a class="py-3 d-none d-md-inline-block mr-4" href="inicio">Inicio</a>
            	<a class="py-3 d-none d-md-inline-block mr-4" href="privado/libros?accion=listar">Libros</a>
	            <a class="py-3 d-none d-md-inline-block mr-4" href="privado/libros?accion=formulario"> Nuevo libro </a>
	            <a class="py-3 d-none d-md-inline-block mr-4" href="logout">Logout</a>
	            <a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
	            
            </c:if>
            
        </div> 
	           
    </nav>

    <main class="container">
    
     <c:if test="${not empty mensajeAlertaLogout}">
    
    	<div class="alert alert-${mensajeAlertaLogout.tipo} alert-dismissible fade show mt-4" role="alert">
		 	${mensajeAlertaLogout.texto}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
    
    </c:if>
    
    <c:if test="${not empty mensajeAlerta}">
    
    	<div class="alert alert-${mensajeAlerta.tipo} alert-dismissible fade show mt-4" role="alert">
		 	${mensajeAlerta.texto}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
    
    </c:if>
    
    