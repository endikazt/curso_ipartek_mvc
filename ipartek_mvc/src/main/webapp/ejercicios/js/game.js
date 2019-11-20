/*

    JS para el juego Arkanoid

*/

console.trace('Comenzamos a jugar');

var canvas = document.getElementById("byCanvas");
var ctx = canvas.getContext("2d");

// Event listeners para saber si esta pulsada la tecla y cuando no, y del movimiento del raton

document.addEventListener("keydown", keyDownHandler, false);
document.addEventListener("keyup", keyUpHandler, false);
document.addEventListener("mousemove", mouseMoveHandler, false);

/** Indica la posicion inicial en la que se dibujara la bola */

var x = canvas.width/2;
var y = canvas.height-30;

/** Valor que se le suma a x e y en cada fotograma */

var dx = 5;
var dy = -5;

/** Mantiene los calculos del radio de la bola para calcular las colisiones */

var ballRadius = 10;

/** Definimos la paleta que golpeara la bola */

var paddleHeight = 10;
var paddleWidth = 75;
var paddleX = (canvas.width-paddleWidth)/2;

//Declaramos las variables que se encargaran de decirnos si estan las teclas pulsadas

var rightPressed = false;
var leftPressed = false;

// Declaramos las variable de los ladrillos

var brickRowCount = 5;
var brickColumnCount = 10;
var brickWidth = 75;
var brickHeight = 20;
var brickPadding = 10;
var brickOffsetTop = 30;
var brickOffsetLeft = 30;

// Iniciamos la variable contador
var score = 0;

// Delcaramos un contador de vidas para el jugador

var lives = 3;

// Guardamos los ladrillos en una array en el que cada uno de los ladrillo contedra un valor x e y
// Le añadimos una variable de estado para saber si lo tenemos que dibujar o no, 1 es que si

var bricks = [];
for(c=0; c<brickColumnCount; c++) {
    bricks[c] = [];
    for(r=0; r<brickRowCount; r++) {
        bricks[c][r] = { x: 0, y: 0, status: 1 };
    }
}

/** Dibuja la bola */

function drawBall() {
    ctx.beginPath();
    ctx.arc(x, y, ballRadius, 0, Math.PI*2);
    ctx.fillStyle = "#FFF";
    ctx.fill();
    ctx.closePath();
}

//Definimos la funcion que se encargara de dibujar la paleta

function drawPaddle() {
    ctx.beginPath();
    ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight);
    ctx.fillStyle = "#FFF";
    ctx.fill();
    ctx.closePath();
}

// Funcion que dibuja los ladrillos teniendo en cuenta la posicion 
// indicada en las variables r y c de lso bucles
// Si el estado de la bola es 0 no se dibujara, en caso contrario se dibujara

function drawBricks() {
    for(c=0; c<brickColumnCount; c++) {
        for(r=0; r<brickRowCount; r++) {
            if(bricks[c][r].status == 1) {
                var brickX = (c*(brickWidth+brickPadding))+brickOffsetLeft;
                var brickY = (r*(brickHeight+brickPadding))+brickOffsetTop;
                bricks[c][r].x = brickX;
                bricks[c][r].y = brickY;
                ctx.beginPath();
                ctx.rect(brickX, brickY, brickWidth, brickHeight);
                ctx.fillStyle = "#FFF";
                ctx.fill();
                ctx.closePath();
            }
        }
    }
}

//Funcion que se encarga de dibujar en el canvas la puntuacion del jugador

function drawScore() {
    ctx.font = "16px Arial";
    ctx.fillStyle = "#FFF";
    ctx.fillText("Score: "+score, 8, 20);
}

// Funcion que se encarga de dibujar las vidas restante del jugador

function drawLives() {
    ctx.font = "16px Arial";
    ctx.fillStyle = "#FFF";
    ctx.fillText("Lives: "+lives, canvas.width-65, 20);
}

// Funciones que se encargan de poner en false o true las variables de arriba 
// cuando las teclas estan presionadas o no

function keyDownHandler(e) {
    if(e.keyCode == 39) {
        rightPressed = true;
    }
    else if(e.keyCode == 37) {
        leftPressed = true;
    }
}

function keyUpHandler(e) {
    if(e.keyCode == 39) {
        rightPressed = false;
    }
    else if(e.keyCode == 37) {
        leftPressed = false;
    }
}

// Funcion que detecta la posicion relativa del raton con los limites del canvas 
// y caso de que no este en los limites lo mueve para los lados en el eje x

function mouseMoveHandler(e) {
    var relativeX = e.clientX - canvas.offsetLeft;
    if(relativeX > 0 && relativeX < canvas.width) {
        paddleX = relativeX - paddleWidth/2;
    }
}

// Funcion que detecta la colision entre la bola y los ladrillos
// Esta funcion calcula si la posicion x e y de la bola es mayoor que las posicione x e y del ladrillo
// En caso afirmativo la bola rebotara hacia atras y se cambiara el estado del ladrillo a 0

function collisionDetection() {
    for(c=0; c<brickColumnCount; c++) {
        for(r=0; r<brickRowCount; r++) {
            var b = bricks[c][r];
            if(x > b.x && x < b.x+brickWidth && y > b.y && y < b.y+brickHeight&&b.status==1) {
                dy = -dy;
                b.status = 0;
                score++;
                if(score == brickRowCount*brickColumnCount) {
                    alert("YOU WIN, CONGRATULATIONS!");
                    document.location.reload();
                }
            }
        }
    }
}

/** Pinta de nuevo el canvas en dada fotograma con la posicion de la bola */

function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawBall();
    drawPaddle();
    drawBricks();
    collisionDetection();
    drawScore();
    drawLives();

    /** En caso de que en algun momento algun punto de la bola toque un lado de la pantalla rebotara a otro lado */

    if(x + dx > canvas.width-ballRadius || x + dx < ballRadius) {
        dx = -dx;
    }

    // Hacer que la pala golpee la bola y En caso de que la bola toque 
    // el lado de abajo se mostrara la pantalla de GAME OVER

    if(y + dy < ballRadius) {
        dy = -dy;
    }
    else if(y + dy > canvas.height-ballRadius) {
        if(x > paddleX && x < paddleX + paddleWidth) {
            dy = -dy;
        }
        else {
            lives--;
                if(!lives) {
                    alert("GAME OVER");
                    document.location.reload();
                }
                else {
                    x = canvas.width/2;
                    y = canvas.height-30;
                    dx = 2;
                    dy = -2;
                    paddleX = (canvas.width-paddleWidth)/2;
                }
            }
    }

    // En caso de que la teclas esten presionadas y la posicion sea menor 
    // a la anchura del canvas - la anchura de la pala, esta se movera a la derecha, 
    // en caso contrario a la izquierda

    if(rightPressed && paddleX < canvas.width-paddleWidth) {
        paddleX += 7;
    }
    else if(leftPressed && paddleX > 0) {
        paddleX -= 7;
    }

    // Actualizar la posicion de x e y con los valores de dx y dy

    x += dx;
    y += dy;

    requestAnimationFrame(draw);
}

draw();