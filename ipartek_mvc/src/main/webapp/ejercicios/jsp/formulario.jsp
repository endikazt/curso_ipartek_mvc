<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
   
    <title>Formulario</title>
    
    <base href="/helloweb/">

    <link rel="stylesheet" href="css/styles.css">

    <style>
        main
        {
            max-width: 1024px;
            margin: auto;
        }

        form
        {
            border: 1px solid black;
            padding: 20px;
        }

        input[type="text"]
        {
            padding: 2px 0 2px 5px;
        }

        input[type="text"]:valid
        {
            color: green;
            border: 2px solid green;
        }

        input[type="text"]:invalid
        {
            color: red;
            border: 2px solid red;
        }

    </style>
</head>
<body>
<%@include file="/includes/nav.jsp" %>
    <main>
        <h1>Formulario</h1>
        <form method="POST" action="#">
            <p> Usar siempre etiqueta <code>form</code>form con boton de submit </p>
            <p>El atributo <code> action </code> sirve para indicar el controlador en el servidor</p>
            <p> El atributo <code>name</code> de un <code>input</code> sirven para especificar el nombre de paraemtro a enviar al servidor o controlador</p>
            <!-- 
                required -> pra indicar que es obligatorio
                placeholder -> pone un texto en gris para dar indicaciones al usuario
                autofocus -> al cargar la pagina centra la atencion en la eqiqueta
                patter -> regex para validaciones
            -->
            <fieldset>
                <legend>Datos personales</legend>
                <label for="nombre"> Nombre: </label><input type="text" name="edad" id="nombre" autofocus required pattern="^[aA-zZ]{3,10}" value="" placeholder="Dime tu nombre"> <br>
                <label for="edad"> Edad: </label><input type="number" name="edad" id="edad" min=0 max=99 required placeholder="numero de años 0-99"> <br>
                <label for="sexo">Sexo</label>
                    <select id="sexo" name="sexo">
                    <option value="h"> Hombre </option>
                    <option value="m"> Mujer </option>
                    <option value="o" selected> Otro </option>
                </select> <br>
                <label for="password">Contraseña</label>
                <input type="password" name="password" id="password" required pattern=".{5,15}" placeholder="minimo 5 palabras, maximo 15">
                <button onclick="verTexto()">Ver</button>  
                <script>
                    function verTexto()
                    {
                        console.trace("click para ver texto");
                        let iContraseña = document.getElementById('password');

                        if(iContraseña.type == "text")
                        {
                            iContraseña.type = "password";
                            event.target.innerHTML = 'Ver';
                        } 
                        else
                        {
                            iContraseña.type = "text";
                            event.target.innerHTML = 'Ocultar';
                        }
                    }                
                </script>      
            </fieldset>
            <label for="deportes">Deportes</label> <br>
                <input type="checkbox" name="deportes" id="deportes" value="1"> Surf <br>
                <input type="checkbox" name="deportes" id="deportes2" value="2"> Karate <br>
                <input type="checkbox" name="deportes" id="deportes3" value="3"> Skate <br>
                <input type="checkbox" name="deportes" id="deportes4" value="4"> Baseball <br>   
            <label for="situacion"> Situacion laboral </label>
                <input type="radio" checked name="situacion" id="situacion" value="0"> Trabajando
                <input type="radio" name="situacion" id="situacion2" value="1"> Desempleado <br>
            <label for="observaciones">Observaciones</label> <br>
            <textarea name="observaciones" id="observaciones" cols="30" rows="10"></textarea>
            <input type="submit" value="Enviar">      
        </form>
    </main>
    <footer>
    </footer>  
</body>
</html>