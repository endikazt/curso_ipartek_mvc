<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Posicionamiento</title>

    <style>
        
        .contenedor
        {
            /* Los contenedores siempre relative */
            position: relative;
            width: 350px;
            height: 350px;
            overflow: hidden;
            margin: auto;
        }

        /*Posicionamos de forma absoluta sobre en contenedor*/

        .absoluta
        {
            padding: 10px;
            position: absolute;
            background-color: red;
            border-radius: 50%;
            right: 15px;
            top: 15px;
            color: white;
        }

        .contenedor:hover .texto
        {
            bottom: 0%;
            transition: 2s;
            background-color: #000000c7;
        }

        .contenedor .texto
        {
            background-color: #0000003d;
            position: absolute;
            overflow: hidden;
            bottom: -140px;
            transition-duration: 2s;
        }

        .contenedor .texto h3
        {
            color: white;
            text-transform: capitalize;
        }

        .contenedor .texto p
        {
            padding: 10px;
            text-align: justify;
            color: white;
            
        }
    
    </style>

</head>
<body>

    <h1> Posicionamiento </h1>
    <section>
        <h2>Relativo</h2>

        <p>Posicionamiento relativo: variante del posicionamiento normal que consiste en posicionar una caja según el posicionamiento normal y después desplazarla respecto de su posición original.</p>

        <div class="box">1</div>
        <div class="box" style="z-index: 1;position: relative; top: -20px; left: 20px; background-color: red;">2</div>
        <div class="box" style="z-index: 2;position: relative;" >3</div>
    </section>

    <section>
        <h2>Fixed</h2>

        <p> Posicionamiento fijo: variante del posicionamiento absoluto que convierte una caja en un elemento inamovible, de forma que su posición en la pantalla siempre es la misma independientemente del resto de elementos e independientemente de si el usuario sube o baja la página en la ventana del navegador. </p>

        <div class="box" >1</div>
        <div class="box" style="position: fixed; bottom: 480px; left: 115px;">2</div>
        <div class="box" style="position: fixed; bottom: 480px; left: 220px;" >3</div>
        
    </section>

    <section>
        <h2>Sticky - CSS3 </h2>

        <p> Cuando tienen sticky en el estilo </p>

        <div class="box" >1</div>
        <div class="box" style="position: sticky; bottom: 100px;">2</div>
        <div class="box" style="position: sticky; bottom: 50px;" >3</div>

    </section>

    <section>
        <h2>Absoluto</h2>

        <p>Posicionamiento absoluto: la posición de una caja se establece de forma absoluta respecto de <b style="color: red;"> elemento contenedor </b> y el resto de elementos de la página ignoran la nueva posición del elemento.</p>

        <div class="contenedor">
            <span class="absoluta">1</span>
            <img src="/images/awake.jpg" alt="Meme awake but a what cost" height="350" width="350">
            
            <div class="texto">
                <h3>Titulo</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Illum nihil quo minus id blanditiis recusandae voluptate modi eius alias doloribus mollitia, impedit doloremque beatae voluptas voluptates consequuntur ut rem? Provident!</p>
                </div>
        </div>        
    </section>
    
</body>
</html>