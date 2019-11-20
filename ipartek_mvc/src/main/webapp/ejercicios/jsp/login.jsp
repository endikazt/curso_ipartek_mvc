<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Login</title>
    
    <base href="/helloweb/">

    <link rel="stylesheet" href="css/styles.css">

    <style>
        body
        {
            background-image: url("images/loginbackground.jpg");
        }

        main
        {
            max-width: 500px;
            margin: auto;
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
        }

        h1
        {
            color: white;
            margin: 0.75em;
            font-size: 75px;
            text-align: center;
        }

        form
        {
            border: 1px solid black;
            padding: 20px;
            text-align: center;
            border: 5px solid white;
            border-radius: 15px;
        }   
        
        fieldset
        {
            margin: 1em;
            text-align: left;
            color: white;
            border-radius: 15px;
            font-size: 20px;
        }

        label
        {
            color: white;
        }

        select
        {
            margin: 1em;
            width: 100px;
        }

        #nombre, #contrasena
        {
            margin: auto;
            border: 0px;
            width: 100%;
            border-radius: 10px;
            height: 20px;
            padding: 5px 0px 5px 10px;
            font-size: 15px;
        }

        #botonLogin
        {
            margin-top: 0.5em;
            width: 15em;
            border-radius: 5px;
            height: 2em;
            font-size: 15px;
            background-color: white;
        }
		
		 input[type="submit"]:hover 
        {
            background-color: #000;
        }

    </style>
</head>
<body>
<%
	String mensaje = (String) request.getAttribute("mensaje");
	if(mensaje != null){
%>
	<p style="color:red;"><%=mensaje%></p>
<%} %>
    <main>
        <h1> Login </h1>
        <form action="login" method="post">
            <fieldset>
                <legend> Usuarios </legend>
                <input type="text" name="nombre" id="contrasena" required>   
            </fieldset>
            <fieldset>
                <legend> Contraseña </legend>
                <input type="password" name="contrasena" id="contrasena" required>   
            </fieldset>
            <label for="idioma"> Idioma </label>
                <select id="idioma" name="idioma">
                    <option value="esp"> Español </option>
                    <option value="eus"> Euskera </option>
                    <option value="eng" selected> Ingles </option>
                    <option value="ita"> Italiano </option>
                    <option value="fra" selected> Frances </option>
           <input type="checkbox" name="recuerdame" id="recuerdame" value="1"> <label for="recuerdame"> Recuerdame </label><br>
           <input type="submit" id="botonLogin" value="Login">
        </form>
    </main>
    <footer>

    </footer>
</body>
</html>