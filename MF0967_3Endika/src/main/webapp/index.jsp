<%@ include file="includes/header.jsp" %>

        <div class="row contenedor-libros">
        
        <c:forEach items="${libros}" var="libro">
        
        	<div class="col mb-4">

                <!-- Libro -->
                <div class="libro">
                    <img src="${libro.imagen}" alt="imagen de ${libro.nombre}">

                    <div class="body">
                    	
                    	<hr>
                    	<div class="row">
                    		<div class="col-9"> <p class="nombre text-truncate">${libro.nombre}</p> </div>
                    		<div class="col-3 d-flex justify-content-center align-items-center"> <i class="far fa-heart fa-lg"></i></div>
                    	</div>              
                        <p class="autor">${libro.autor}</p>
                        <p>
                        	<span class="precio-descuento">
                            	<fmt:formatNumber minFractionDigits="2" type="currency" value="${libro.calcularPrecioDescuento()}" />
                            </span>
                            <span class="precio-original">
                            	<fmt:formatNumber minFractionDigits="2" type="currency" value="${libro.precio}" />
                            </span> 
                            <span class="descuento">-${libro.descuento}%</span>
                        </p>
                    </div>

                </div>
                <!-- Fin de libro -->

            </div>       
        	
        </c:forEach>
        
        </div>
<%@ include file="includes/footer.jsp"%>