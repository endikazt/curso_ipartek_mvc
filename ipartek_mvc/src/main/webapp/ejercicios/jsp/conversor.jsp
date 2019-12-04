<%@page import="com.ipartek.formacion.controller.ConversorController"%>

<h1>Conversor</h1>

<p>Conversor de metros a pies</p>	

<p>1 metro equilave a <%=ConversorController.METROS_PIES%> pies</p>

<p style="color:red;">${mensaje}</p>

<form action="/helloweb/convertir" method="post">

	<input type="text" name="metros" value="${metros}" placeholder="Escribe los metros"/>
	
	<input type="text" name="pies" value="${(resultado == null )? 0 : resultado }"/>

	<input type="submit" value="Convetir" />

</form>

Resultado:  
<%
	// los atributos deben ser casteados, y no es obligatoriamente String
	float resultado = 0;
	if ( request.getAttribute("resultado") != null ){
		
		resultado = (float)request.getAttribute("resultado");
		
	}
	//pintar en el HTML
	out.print(resultado);
%>

<p style="color:green;">Resultado de forma abreviada ${resultado}</p>