<a href="index.jsp">Volver</a>

<h1>Calculadora</h1>



<form action="sumar" method="post">

	<label for="operacion"> Operacion </label>
	<input type="radio" name="op" value="1" checked> Sumar <br>
	<input type="radio" name="op" value="2" > Restar <br>
	<input type="radio" name="op" value="3" > Multiplicar <br>
	<input type="radio" name="op" value="4" > Dividir <br>

	<input type="text" name="op1" required pattern="[0-9]+" placeholder="numero 1">
	<br>
	<input type="text" name="op2" required pattern="[0-9]+"placeholder="numero 2">
	<br>

	<input type="submit" value="Calcular">
	
</form>