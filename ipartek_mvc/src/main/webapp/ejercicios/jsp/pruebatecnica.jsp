<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>

        <!-- La base para contruir todas las rutas de la pagina -->

        <base href="/curso_ipartek_2019/">

        <!-- estilos -->
        <link rel="stylesheet" href="/ejercicios/css/stylesPrueba.css">

    </head>
    <body>

        <!-- javascript --> 
        
        <script src="/ejercicios/js/mainPrueba.js">  </script>

        <!-- Forma abreviada de crear tablas table.item-style>tr*9>td*2  -->

        <div class="parallax">

            <h1> Prueba tecnica Ipartek 2019 </h1>

            <h2> Welcome to HTML </h2>
   
        </div>

        <h1> Prueba tecnica Ipartek 2019  </h1>

        <h2> Alum@s curso </h2>

        <h3> Voluntario <span id="nombre"> X </span></h3>
        <div  class="wrapperBoton">
            <button class="botonQuienLee" onclick="buscarVoluntario()"> ¿Quien lee? </button>
        </div>

        <div class="wrapperLinkW3">
                <h3> Basic HTML table </h3>
                <a target="_blank" href="https://www.w3schools.com/html/html_tables.asp">  Documentacion y ejemplo de tablas HTML WESchools </a>  
        </div>   

        <div style="height:750px;background-color:aliceblue;font-size:26px;margin:auto"> 
        <table>
            <tr>
                <td> Aitor </td>
                <td> Iker </td>
            </tr>
            <tr>
                <td> Endika </td>
                <td> Kiryl </td>
            </tr> 
            <tr>
                <td> Iñigo </td>
                <td> Maria </td>
            </tr>
            <tr>
                <td> Juan Carlos </td>
                <td> Ana </td>
                </tr>
            <tr>
                <td> Alejandro </td>
                <td> Erlantz </td>
            </tr>
            <tr>
                <td>  Cristian </td>
                <td></td>
            </tr>
            <tr>
                <td> Raul </td>
                <td></td>
            </tr>
            <tr>
                <td> Joseba </td>
                <td> Mikel </td>
            </tr>
            <tr>
                <td colspan="2"> Ander </td>
            </tr>
        </table>    
        
        </div>
    </body>
</html>