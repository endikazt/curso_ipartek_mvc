<h1>Resultado</h1>

<%

	int resultado = (int)request.getAttribute("resultado");
	String mensaje = (String) request.getAttribute("mensaje");
	String op1 = (String) request.getAttribute("op1");
	String op2 = (String) request.getAttribute("op2");
	String op = (String) request.getAttribute("op");
	
	if(mensaje != null) {

%>

<p><%=mensaje%></p>


<%

	} else {
		
	switch (op) {
	case "1":
%>
	<p>El resultado de <%=op1%> + <%=op2%> es <%=resultado%></p>
<%
		break;
	case "2":
%>
<p>El resultado de <%=op1%> - <%=op2%> es <%=resultado%></p>
<%
		break;
	case "3":
%>
<p>El resultado de <%=op1%> x <%=op2%> es <%=resultado%></p>
<%
		break;
	case "4":
%>
<p>El resultado de <%=op1%> / <%=op2%> es <%=resultado%></p>
<%		break;
	default:
		break;
	}
}
%>