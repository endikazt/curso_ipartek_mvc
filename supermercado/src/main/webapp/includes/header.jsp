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
    <meta name="author" content="Endika Zuazo">
    <title>Supermercado</title>
    
    <base href="${pageContext.request.contextPath}/">

   <!-- Bootstrap core CSS -->
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
   
   <!-- Datatable CSS -->
   <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css"/>
   <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.dataTables.min.css"/>
   
   <!-- Fontaesome -->
   <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css"/>

   <!-- nuestro css -->
   <link rel="stylesheet" href="css/custom.css">

  </head>
  <body id="top">
  
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><i class="fas fa-store-alt"></i></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		  <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
		  <ul class="navbar-nav">
		    <li class="nav-item active">
		      <a class="nav-link" href="#">Home </a>
		    </li>
		    
		    <c:if test="${not empty usuarioLogeado}">
		    
		    	<c:if test="${usuarioLogeado.rol.id eq 2}">
		    	
		    		<li class="nav-item dropdown active">
					      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					        Productos
					      </a>
					      <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					        <a class="dropdown-item" href="seguridad/productos?accion=listar">Listado productos</a>
					        <a class="dropdown-item" href="seguridad/productos?accion=formulario">Nuevo producto</a>
					      </div>
					    </li>
					    <li class="nav-item dropdown active">
					      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					        Usuarios
					      </a>
					      <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					        <a class="dropdown-item" href="seguridad/usuarios?accion=listar">Listado usuarios</a>
					        <a class="dropdown-item" href="seguridad/usuarios?accion=formulario">Nuevo usuario</a>
					      </div>
		    		</li>
		        
		   		</c:if> 
		    	
	    		<c:if test="${usuarioLogeado.rol.id eq 1}">
	    	
		    		<li class="nav-item dropdown active">
				      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				        Mis Productos
				      </a>
				      <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				        <a class="dropdown-item" href="mipanel/productos?accion=listar">Mis productos</a>
				        <a class="dropdown-item" href="mipanel/productos?accion=formulario">Nuevo producto</a>
				      </div>
					</li>
	        
	   			</c:if> 
		        
		    </c:if> 
		  
		  <c:if test="${empty usuarioLogeado}">

		  	 <li class="nav-item">
			    <a class="btn btn-outline-primary my-2 my-sm-0" href="login.jsp">Login</a>
		    </li>
		  
		  </c:if>
		  
		  <c:if test="${not empty usuarioLogeado}">
		  
		  	<c:if test="${usuarioLogeado.rol.id eq 2}">
		  	
			  	<li class="nav-item dropdown">
			      <a class="btn btn-outline-primary my-2 my-sm-0 dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			        ${usuarioLogeado.nombre}
			      </a>
			      <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
			        <a class="dropdown-item" href="seguridad/usuarios?accion=formulario&id=${usuarioLogeado.id}">Perfil</a>
			        <div class="dropdown-divider"></div>
	          		<a class="dropdown-item" href="logout">Cerrar sesion</a>
			      </div>
			    </li>
		  	
		  	</c:if>
		  	
		  	<c:if test="${usuarioLogeado.rol.id eq 1}">
		  	
			  	<li class="nav-item dropdown">
			      <a class="btn btn-outline-primary my-2 my-sm-0 dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			        ${usuarioLogeado.nombre}
			      </a>
			      <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
			        <a class="dropdown-item" href="mipanel/usuarios?accion=formulario&id=${usuarioLogeado.id}">Perfil</a>
			        <div class="dropdown-divider"></div>
	          		<a class="dropdown-item" href="logout">Cerrar sesion</a>
			      </div>
			    </li>
		  	
		  	</c:if>
		  
		  </c:if>
		  
		  </ul>
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
    
    