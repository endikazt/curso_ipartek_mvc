<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/includes/header.jsp" %>

	<h1> Formulario </h1>
	
	  <div class="row justify-content-center">
            <div class="col-6">

                    <form action="seguridad/productos?accion=guardar" method="post">

                        <div class="form-group">
                            <label for="nombre">Producto</label>
                            <input type="text" 
                                   class="form-control" 
                                   id="nombre" 
                                   required
                                   placeholder="MÃ­nimo 2 MÃ¡ximo 150"
                                   pattern=".{2,150}"
                                   aria-describedby="nombreHelp">
                            <small id="nombreHelp" class="form-text text-muted">Nombre y descripcion del producto</small>
                        </div>

                        
                        <div class="form-group">
                                <label for="precio">Precio</label>
                                <input type="number" 
                                       class="form-control" 
                                       id="precio" 
                                       required
                                       placeholder="0,00â¬"
                                       pattern=".{2,150}"
                                       aria-describedby="precioHelp">
                                <small id="precioHelp" class="form-text text-muted">Precio en euros sin Iva, ni descuento</small>
                            </div>
    

                        <button type="submit" class="btn btn-block btn-outline-primary">Crear</button>
                    </form>

            </div>
        </div>  
        <a id="btn-top" href="#top" class="btn btn-primary">top</a>

<%@ include file="/includes/footer.jsp"%>