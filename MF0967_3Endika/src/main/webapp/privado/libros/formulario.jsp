<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>

	<h1> Seccion de libros </h1>	
		
		<div class="row justify-content-center mt-5 mb-2">
			<div class="col-6 d-flex justify-content-center text-white border border-dark rounded bg-dark"> <h2> Añadir un nuevo libro </h2> </div>
		</div>
		
		<div class="row justify-content-center mb-5 ">
			<div class="col-6 border border-dark rounded p-4">

			<form action="privado/libros" method="post">
			 
			<input type="hidden" name="accion" value="guardar">
			<input type="hidden" name="id" value="${libro.id}">
			
			    <div class="form-group">
			        <label for="nombre">Libro</label>
			        <input type="text" 
			               class="form-control"
			               name="nombre"
			               id="nombre" 
			               value="${libro.nombre}"
			               placeholder="Ejemplo: El problema de los tres cuerpos"
			               aria-describedby="nombreHelp">
			        <small id="nombreHelp" class="form-text text-muted">Nombre del libro (Caracteres: Minimo 1, Maximo 150)</small>
			    </div>
			    
			    <div class="form-group">
			        <label for="nombre">Autor</label>
			        <input type="text" 
			               class="form-control"
			               name="autor"
			               id="autor" 
			               value="${libro.autor}"
			               placeholder="Ejemplo: Cixin Liu"
			               aria-describedby="autorHelp">
			        <small id="nombreHelp" class="form-text text-muted">Nombre del autor (Anonimo por defecto)</small>
			    </div>
			    
			    <div class="form-group">
			        <label for="imagen">Portada</label>
			        <input type="url" 
			               class="form-control"
			               name="imagen"
			               id="imagen" 
			               value="${libro.imagen}"
			               placeholder="URL (.JPG, .JPEG, .PNG, etc)"
			               aria-describedby="imagenHelp">
			        <small id="nombreHelp" class="form-text text-muted">Portada del libro </small>
			    </div>
			                            
			    <div class="form-group">
			         <label for="precio">Precio</label>
			         <input type="number" 
			                class="form-control" 
			                id="precio" 
			                name="precio"
			                value="${libro.precio}"
			                placeholder="Ejemplo: 20,00€"
			                step=".01"
			                aria-describedby="precioHelp">
			         <small id="precioHelp" class="form-text text-muted">Precio en euros sin Iva, ni descuento (Minimo 1&#8364)</small>
			     </div>
			     
			     <div class="form-group">
			         <label for="descuento">Descuento</label>
			         <input type="number" 
			                class="form-control" 
			                id="descuento" 
			                name="descuento"
			                value="${libro.descuento}"
			                placeholder="Ejemplo: 10"
			                aria-describedby="descuentoHelp">
			         <small id="precioHelp" class="form-text text-muted">Descuento del libro (0-100%)</small>
			     </div>
			    	 <c:choose>
	                  	<c:when test="${libro.id != 0}">
	                  		<button type="submit" class="btn btn-block btn-primary">Modificar libro</button> 
	                  		<button type="button" class="btn btn-block btn-danger" data-toggle="modal" data-target="#modalEliminar"> Eliminar libro </button>       		
	                  	</c:when>
	                  	<c:otherwise>
	                  		<button type="submit" class="btn btn-block btn-outline-primary">Crear libro</button> 
	                  	</c:otherwise>
                     </c:choose>  
			</form> <!-- Fin del formulario del libro -->

		</div>
		
		<!-- Modal de confirmacion a la hora de eliminar un libro -->
		
		 <div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Eliminar libro</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        ¿Estas seguro de que deseas eliminar este libro?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
		        <a href="privado/libros?accion=eliminar&id=${libro.id}" class="btn btn-primary">Eliminar</a>
		      </div>
		    </div>
		  </div>
		</div>
		
	</div>  

<%@ include file="/includes/footer.jsp"%>
