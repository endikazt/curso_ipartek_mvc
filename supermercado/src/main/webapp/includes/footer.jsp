</main>

    <div class="footer-wrapper">
        <footer class="container py-5">
            <div class="row">
                <div class="col-12 col-md">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24" focusable="false"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
                    <small class="d-block mb-3 text-muted">&copy; 2019</small>
                </div>
    
                <div class="col-6 col-md offset-6">
                    <h5>Enlaces de Interes</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="text-muted" href="politica-privacidad.html">Politica Privacidad</a></li>
                        <li><a class="text-muted" href="localizacion.html">Localizacion</a></li>
                        <li><a class="text-muted" href="contacto.html">Contacto</a></li>                    
                    </ul>
                </div>

            </div>    
        </footer>
    </div>    

    <a id="btn-top" href="#top" class="btn btn-primary">top</a>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
    
    <script>
    
	    $(document).ready(function() {
	        $('#tabla').DataTable({
		    	responsive: true,
		    	language: {
		    			"sProcessing":     "Procesando...",
		                "sLengthMenu":     "Mostrar _MENU_ registros",
		                "sZeroRecords":    "No se encontraron resultados",
		                "sEmptyTable":     "Ning�n dato disponible en esta tabla =(",
		                "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
		                "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
		                "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
		                "sInfoPostFix":    "",
		                "sSearch":         "Buscar:",
		                "sUrl":            "",
		                "sInfoThousands":  ",",
		                "sLoadingRecords": "Cargando...",
		                "oPaginate": {
		                    "sFirst":    "Primero",
		                    "sLast":     "�ltimo",
		                    "sNext":     "Siguiente",
		                    "sPrevious": "Anterior"
		                },
		                "oAria": {
		                    "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
		                    "sSortDescending": ": Activar para ordenar la columna de manera descendente"
		                },
		                "buttons": {
		                    "copy": "Copiar",
		                    "colvis": "Visibilidad"
		                }
		    	} //language
		    });
	    } );
    
    </script>

    </body>

</html>
