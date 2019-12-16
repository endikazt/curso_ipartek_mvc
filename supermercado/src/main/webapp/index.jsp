<%@ include file="includes/header.jsp" %>

        <div class="row contenedor-productos">
        
        <c:forEach items="${productos}" var="producto">
        
        	<div class="col">

                <!-- producto -->
                <div class="producto">
                    <span class="descuento">${producto.descuento}</span>
                    <img src="${producto.imagen}" alt="imagen de ${producto.nombre}">

                    <div class="body">
                        <p>
                            <span class="precio-descuento">
                            	<fmt:formatNumber minFractionDigits="2" type="currency" currencySymbol="€" value="${producto.precio}" />
                            </span>
                            <span class="precio-original">
                            	<fmt:formatNumber minFractionDigits="2" type="currency" currencySymbol="€" value="${producto.calcularPrecioDescuento()}" />
                            </span>
                        </p>
                        <p class="text-muted precio-unidad">($<fmt:formatNumber minFractionDigits="2" type="currency" currencySymbol="€" value="${producto.precio}" /> / litro)</p>
                        <p class="nombre">${producto.nombre}</p>
                        <p class="descripcion text-truncate">${producto.descripcion}</p>
                    </div>

                    <div class="botones">
                        <button class="minus">-</button>
                        <input type="text" value="1">
                        <button class="plus">+</button>
                    </div>

                    <button class="carro">Añadir al carro</button>

                </div>
                <!-- /.producto -->

            </div>       
        	
        </c:forEach>
        
        </div>
<%@ include file="includes/footer.jsp"%>