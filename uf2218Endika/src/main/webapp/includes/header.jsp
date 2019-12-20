
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
    <title>UF2218 - Endika Zuazo</title>
    
    <base href="${pageContext.request.contextPath}/">

   <!-- Bootstrap core CSS -->
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

   <!-- nuestro css -->
   <link rel="stylesheet" href="css/custom.css">

  </head>
  <body id="top">
    <nav class="site-header sticky-top py-1">
        <div class="container d-flex flex-column flex-md-row justify-content-start">
        		<a class="py-3 d-none d-md-inline-block mr-4" href="">Inicio</a>
            	<a class="py-3 d-none d-md-inline-block mr-4" href="libros">Libros</a>
	            <a class="py-3 d-none d-md-inline-block mr-4" href="libros?accion=formulario"> Nuevo libro </a>      
        </div>
    </nav>

    <main class="container">
    
    <c:if test="${not empty mensajeAlerta}">
    
    	<div class="alert alert-${mensajeAlerta.tipo} alert-dismissible fade show mt-4" role="alert">
		 	${mensajeAlerta.texto}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
    
    </c:if>
    
    