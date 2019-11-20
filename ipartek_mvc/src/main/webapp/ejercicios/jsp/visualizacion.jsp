<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="/css/styles.css">

    <style>

        body
        {
            padding: 35px;
        }

        span
        {
            border: 3px dotted red;
            padding: 5px;
        }

        p
        {
            border: 3px dotted red;
            padding: 5px;;
        }
    
        p.prueba
        {
            color: teal;
            border: 5px solid green;
            margin: 10px;
            padding: 20px; /* shothand para los 4 lados de la caja */
            padding: 20px 40px ;  /* arriba y abajo 20px, izquierda derecha 40px */
            padding: 20px 40px 30px; /* arriba 20, izq der 40px, abajo 30*/
            padding: 20px 40px 30px 50px; /*arriba 20, derecha 4, abajo 30, izquierda 50 */
        }

        .box
        {
            display:  inline-block;
            box-sizing: border-box;
            width: 100px;
            height: 100px;
            border: 2px solid black;
            background-color: teal;
            color: white;
            border-radius: 10px;
            font-size: 50px;
            text-align: center;
            padding: 20px;
        }

        .box-texto
        {
            display: inline-block;
            width: 100px;
            height: 100px;
            border: 2px solid black;
        }



    
    </style>
    <title>Visualización</title>
</head>
<body>

    <nav class="menuInicial"> 
        <a class="menuItem" href="index.html"> Home </a>   
        <a class="menuItem" href="/ejercicios/html/pruebatecnica.html"> Prueba </a> 
        <a class="menuItem" href="/ejercicios/html/animaciones.html"> Animaciones </a> 
        <a class="menuItem" href="/ejercicios/html/cssespecify.html"> CSS Especificidad </a> 
        <a class="menuItem" href="/ejercicios/html/cssbasico.html"> CSS Selectores basicos </a> 
        <a class="menuItem" href="/ejercicios/html/cssavanzado.html"> CSS Selectores Avanzados </a>
        <a class="menuItem" href="/ejercicios/html/box-model.html"> Box model </a>  
    </nav>

    <h1> Visualizacion </h1>
    <p class="prueba"> Toda etiqueta de HTML tiene una estructura de caja </p>

    <section>
        <h2> Elementos en lineo o bloque </h2>
        <p><code>display</code> es el atributo para gestionar si es linea o bloque, existen muchos mas displays, ejemplo: flexbox</p> 
        <p>truco: usar el inspector para verlo</p>

        <dl>
            <dt> block </dt>
            <dd> Elemento que ocupar todo el ancho del elmento padre</dd>
            <dt> inline </dt>
            <dd> Elemento que ocupa todo lo que tenga su contenido</dd>
            <dt> inline-bloc </dt>
            <dd> Es una cosa hibrida de las dos </dd>
        </dl>

        <p> Lorem ipsum <span> dolor sit amet </span> consectetur adipisicing elit. Atque ut ea, sed magnam  laborum provident autem incidunt. doloribus ullam reiciendis, tempore doloremque vitae corporis cumque quis labore molestiae sit! </p>

        <div class="box">1</div>
        <div class="box">2</div>
    </section>

    <section>
        <h2>Visibility</h2>
        <p> Existen 2 formas de ocultar elementos de HTML </p>
        <p> Usando <code>visibility</code> </p>  
        <div class="box">1</div>
        <div class="box" style="visibility: hidden;">2</div>
        <div class="box">3</div>  
        <p> Usando <code>display: none</code></p>
        <div class="box">1</div>
        <div class="box" style="display: none;">2</div>
        <div class="box">3</div>
    </section>

    <section>
        <h2> Overflow</h2>
        <p> Como se muestran los elemntos o la informacion cuando entran en contenedor padre <code> visible | hidden | auto | inherit | scroll</code></p>
        <p> Tambien se puede utilizar <code> overflow-x</code> y <code>overflow-y</code></p>
        <!-- div.box-texto*4>lorem -->
        <div class="box-texto" style="overflow: hidden;">Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse, fugit expedita consequatur dignissimos odio est incidunt repudiandae. Cumque numquam porro officia nesciunt accusamus, cum aliquid culpa iure, magni inventore eligendi.</div>
        <div class="box-texto" style="overflow: scroll;">Voluptate magni nostrum eum. Asperiores assumenda incidunt eligendi dolorem molestiae qui sunt, quos ipsa corrupti, similique officia. Impedit molestias aliquid, id, ea eius, quo cumque qui nulla expedita voluptas velit?</div>
        <div class="box-texto" style="overflow: auto;">Quas illum rem, natus architecto quos, esse consequuntur quod dolor tempore quae perferendis voluptatum quia vitae excepturi pariatur veritatis praesentium incidunt. Ipsum optio illum eveniet ipsa voluptatum possimus, fugiat id?</div>
        <div class="box-texto" style="overflow: visible;">Mollitia earum eius ratione ab culpa error, fugit non. Earum minima quam illum pariatur repudiandae modi odio, in necessitatibus totam ex natus architecto quod fugiat hic nulla eum quasi reprehenderit!</div>
    </section>

    <section>
        <h2>Z-Indez</h2>
        <p> Se encarga de la profundidad de los elementos cuando se solapan </p>
        <div class="box">1</div>
        <div class="box" style="z-index: 1;position: relative; top: -20px; left: 20px; background-color: red;">2</div>
        <div class="box" style="z-index: 2;position: relative;" >3</div>
    </section>
    
</body>
</html>