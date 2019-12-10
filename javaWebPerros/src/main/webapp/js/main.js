// Comentario 

/*

    Comentario de bloque

*/

/**
 * 
 * Comentario de bloque para documentar
 * 
 */

 console.trace("Esto es una traza de log");
 console.info("Para informar cosas");

 var a = 2;

 console.debug("la variable a = " + a);
 console.warn("tenemos un porblema");
 console.error("error en el servidor");


 function buscarVoluntario()
 {

    var alumnos = ['Iker', 'Aitor', 'Endika', 'Kiryl', 'Maria', 'Iñigo', 'Ana', 'Alejandro', 'Erlantz', 'Juan Carlos', 'Mikel', 'Cristian', 'Raul', 'Joseba'];

    var alumno = alumnos[Math.floor(Math.random()*alumnos.length)];

     console.trace('click buscarVoluntario');
     document.getElementById('nombre').innerHTML = alumno;
     
 }
 
 /* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
 function myFunction() {
   var x = document.getElementById("myTopnav");
   if (x.className === "topnav") {
     x.className += " responsive";
   } else {
     x.className = "topnav";
   }
 } 