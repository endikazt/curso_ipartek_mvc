<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
     <base href="/helloweb/">
     
     <link rel="stylesheet" href="css/styles.css?time=<%=System.currentTimeMillis()%>">

    <link rel="stylesheet" href="ejercicios/css/game.css">

    <title>Arkanoid</title>
</head>
<body>
<%@include file="/includes/top-nav.jsp" %>

    <h1>Arkanoid</h1>
    <canvas id="byCanvas" width="900" height="480"></canvas>

    <script src="/helloweb/ejercicios/js/game.js"> </script>
    
</body>
</html>