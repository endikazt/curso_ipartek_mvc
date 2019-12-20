<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>

	<h1> Seccion de libros </h1>	
		
		<div class="row justify-content-center mt-5 mb-2">
			<div class="col-6 d-flex justify-content-center text-white border border-dark rounded bg-dark"> <h2> Añadir un nuevo libro </h2> </div>
		</div>
		
		<div class="row justify-content-center mb-5 ">
			<div class="col-6 border border-dark rounded p-4">

			 <form action="libros" method="post">
			 
			<input type="hidden" name="accion" value="guardar">
			
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
			         <label for="precio">Precio</label>
			         <input type="number" 
			                class="form-control" 
			                id="precio" 
			                name="precio"
			                value="${libro.precio}"
			                placeholder="Ejemplo: 20,00€"
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
			    	<button type="submit" class="btn btn-block btn-outline-primary">Crear producto</button>   
			</form> <!-- Fin del formulario del libro -->

		</div>
	</div>  

<%@ include file="/includes/footer.jsp"%>
