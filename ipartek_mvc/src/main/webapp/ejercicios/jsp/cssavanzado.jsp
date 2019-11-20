<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>

        <!-- La base para contruir todas las rutas de la pagina -->

        <base href="/helloweb/">

        <!-- estilos -->
        <link rel="stylesheet" href="ejercicios/css/stylesCssAvanzado.css">

    </head>
    <body>
    <%@include file="/includes/nav.jsp" %>        
        <table class="tablaEjemplos">
            <tr>
                <td colspan="2" style="height: 100px;text-align: center;"><h1> Selectores avanzados </h1></td>
            </tr>
            <tr>
                <td>
                    Ejemplo adyacente
                </td>
                <td>
                    <h1> Ejemplo adyacente </h1>
                    <h2> Ejemplo adyacente </h2>             
                </td>
            </tr>
            <tr>
                <td>
                    Ejemplo selector de hijos
                </td>
                <td>
                    <p> Ejemplo de selector de hijos </p>
                    <p><span> Ejemplo de selector de hijos </span></p>             
                </td>
            </tr>
            <tr>
                <td>
                    Ejemplo selector de atributos
                </td>
                <td>
                    <p> Ejemplo de selector de hijos </p>
                    <p><span> Ejemplo de selector de hijos </span></p>             
                </td>
                </tr>
        </table>
    </body>
</html>