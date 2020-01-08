<%@ include file="/includes/header.jsp" %>

		<div class="row container-barra-busqueda"> 	
		
				<form class="col d-flex flex-row" action="inicio?accion=buscar" method="post">
		
						<div class="form-group d-flex flex-row pl-5">		
							<label class="mr-3 py-1"> Categoria</label>
							<select name="categoriaId" class="custom-select">
								<c:forEach items="${categorias}" var="c">
									<option value="${c.id}">${c.nombre}</option>	
								</c:forEach>
							</select>
						</div>
						
						 <div class="form-group col">
                            <input type="text" 
                                   class="form-control"
                                   name="producto"
                                   id="producto" 
                                   value=""
                                   placeholder="Nombre del producto..."
                                   aria-describedby="nombreHelp">
                        </div>
						
				</form>
	
		</div>

        <div class="row contenedor-productos">
        
        <c:forEach items="${productos}" var="producto">
        
        	<div class="col mb-4">

                <!-- producto -->
                <div class="producto">
                    <span class="descuento">${producto.descuento}</span>
                    <img src="${producto.imagen}" alt="imagen de ${producto.nombre}">

                    <div class="body">
                        <p>
                            <span class="precio-descuento">
                            	<fmt:formatNumber minFractionDigits="2" type="currency" value="${producto.precio}" />
                            </span>
                            <span class="precio-original">
                            	<fmt:formatNumber minFractionDigits="2" type="currency" value="${producto.calcularPrecioDescuento()}" />
                            </span>
                        </p>
                        <p class="text-muted precio-unidad">($<fmt:formatNumber minFractionDigits="2" type="currency" value="${producto.precio}" /> / litro)</p>
                        <p class="nombre">${producto.nombre}</p>
                        <p class="descripcion text-truncate">${producto.descripcion}</p>
                        <p class="nombre text-truncate">Creado por: ${producto.usuario.nombre}</p>
                        <p class="descripcion text-truncate">${producto.categoria.nombre}</p>
                    </div>

                    <div class="botones">
                        <button class="minus">-</button>
                        <input type="text" value="1">
                        <button class="plus">+</button>
                    </div>

                    <button class="carro">Anadir al carro</button>

                </div>
                <!-- /.producto -->

            </div>       
        	
        </c:forEach>
        
        </div>
<%@ include file="/includes/footer.jsp"%>