<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Index - Curso Ipartek 2019/2020</title>

    </head>
    <body>
    	<a href="index.jsp"> Volver al index </a>
    
    	<%
			String mensaje = (String) request.getAttribute("mensaje");
			if(mensaje != null)
		%>
			<p style="color:green;"><%=mensaje%></p>
		
    	<%
			String recuerdame = (String) request.getAttribute("recuerdame");
    		if(recuerdame != null){
		%>
			<p> Recuerdame activado </p>
		<%
    		} else {
		%>
			<p> Recuerdame desactivado.
		<% } %>
    </body>
</html>