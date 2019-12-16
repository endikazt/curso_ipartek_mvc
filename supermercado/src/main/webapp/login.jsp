<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="includes/header.jsp" %>

	<div class="row justify-content-center">
		<div class="col-4 mt-5">
			
			<form action="login" method="POST">
			
				<div class="form-group">
				  <label for="nombre">Nombre</label>
				  <input type="text" class="form-control" id="nombre" name="nombre" autofocus aria-describedby="emailHelp" required placeholder="Enter email">
				  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				</div>
				<div class="form-group">
				  <label for="password">Contraseña</label>
				  <input type="password" class="form-control" id="password" name="password" required placeholder="Password">
				</div>
		
				<button type="submit" class="btn btn-block btn-primary">Submit</button>
	
			</form>
	
		</div>	
	</div>

	
<%@ include file="includes/footer.jsp" %>
