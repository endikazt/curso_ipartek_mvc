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
        <link rel="stylesheet" href="ejercicios/css/stylesSpecify.css">

        <style>
        
            p
            {
                color: pink;
            }

            /* El ultimo estilo indicado es el que se aplica, el anterior se ignora*/

            p
            {
                color: brown;
            }

            /* Las clase tiene preferencia en caso de que solo sean a nivel de etiquetas*/

            .textoAmarillo
            {
                color: yellow; /* si le añadimos el atributo important entonces esta tendra mas preferencia*/
            }

            /* Las ID tiene preferencia en caso de que solo sean a nivel de etiquetas y clase*/

            #textoVerde
            {
                color: green;
            }

            .textoImportante
            {
                color: blueviolet !important;
            }

            /* Selector descendente */
            .container p 
            {
                color: orange;
            }

            .container p span
            {
                background-color: aquamarine;
            }

             /* Selecciona solo los p con la clase especial */

            p.especial 
            {
                color: purple;
                background-color: blanchedalmond;
            }

            /* Se aplica a las etiquetas que tengan como clase especial y esten dentro de un p*/

            p .especial 
            {
                font-size: 2em;
                font-weight: 600;
            }
        
        </style>

    </head>
    <body>

        <h1> Ejercicio CSS Especificidad </h1>

        <!-- Los estilos de las estiquetas tiene preferencia a la de las hojas de estilos -->

        <p style="color: aqua;">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iure quia omnis dolores et ipsam saepe consequuntur. Atque numquam maxime a placeat harum quo, officia voluptate nisi eum accusamus necessitatibus explicabo.</p>

        <p class="textoAmarillo">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Iure quia omnis dolores et ipsam saepe consequuntur. Atque numquam maxime a placeat harum quo, officia voluptate nisi eum accusamus necessitatibus explicabo.</p>
        <p class="textoImportante">Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit rem hic maxime qui doloremque tempore id laboriosam asperiores dolor nobis cumque at cupiditate vero, corporis incidunt et eum. Veritatis, voluptate?</p>
        <p id="textoVerde">Lorem ipsum dolor sit amet consectetur, adipisicing elit. Dolores debitis dolore quidem illo molestiae et, sed voluptatum iusto, magnam eius dignissimos placeat inventore qui nulla dolorem soluta numquam quia nam.</p>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quidem eligendi sequi quis. Mollitia, hic explicabo. Error fugit voluptatibus explicabo iste eveniet dignissimos maxime cupiditate voluptas harum. Repellendus quam ut repellat.</p>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. At laborum sapiente rem minima odio error quos facere natus, voluptas necessitatibus provident voluptatem eius quaerat nihil quis ex? Quas, ullam consequuntur?</p>
       
        <h2>Tipos de selectores</h2>
        <p>En este vídeo puedes ver los tipos de selectores, identificadores, clases y pseudoclases:</p>
        <iframe width="560" height="315" src="https://www.youtube.com/embed/ARaU6uGOa_k" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

        <hr>

        <h2> Selector descendente A B </h2>
        <div class="container">
            <p> <span> Vamos a darles estilos solo a los parrafos del </span> <code> div.container</code></p>
            <p class="especial">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quidem eligendi sequi quis. Mollitia, hic explicabo. Error fugit voluptatibus explicabo iste eveniet dignissimos maxime cupiditate voluptas harum. Repellendus quam ut repellat.</p>
            <p>Lorem ipsum dolor sit amet <span class="especial"> consectetur adipisicing elit. </span> At laborum sapiente rem minima odio error quos facere natus, voluptas necessitatibus provident voluptatem eius quaerat nihil quis ex? Quas, ullam consequuntur?</p>
        </div>
    </body>
</html>