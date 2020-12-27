console.log('testing setup');



$('#divOne').append('<img id="streetTest" src="lib/street.jpg" width="800" height="550">');
console.log('1st one');

const canvas = document.getElementById('fightBox');
const fightBoxContext = canvas.getContext('2d');


/*
const mario = new Image();
mario.src = 'lib/mario-grid.png';
mario.onload = () => {
    fightBoxContext.drawImage(mario, 0, 0, 50, 50);
};
*/

var currentX = 40;
var currentY = 90;
var sizeX = 20;
var sizeY = 20;

var drawRect = function() {
    fightBoxContext.beginPath();
    fightBoxContext.rect(currentX, currentY, sizeX, sizeY);
    fightBoxContext.fillStyle = 'white';
    fightBoxContext.fill();
    fightBoxContext.closePath();
}

var moveLeft = function() {
    fightBoxContext.clearRect(currentX, currentY, sizeX, sizeY)
    currentX--;
    drawRect();
}

var moveRight = function() {
    fightBoxContext.clearRect(currentX, currentY, sizeX, sizeY)
    currentX++;
    drawRect();
}

var jump = function() {
    var jumpDistance = 20;
    var jumpTimes = 5;
    var jumpInterval = 5000; // in milliseconds
    
    // set the interval with a check in the "go up" function to clear the interval
    // after reaching the 0 in jumpTimes counter
    // upon clearing the interval, it calls the intervalDown function.
    let intervalUp = setTimeout(function() {
        clear();
        currentY -= jumpDistance;
        drawRect();
        console.log('jumpTimes is ' + jumpTimes); // INFO
        
            if (jumpTimes === 0) {
                //intervalDown();
                console.log('jumpUP interval 0'); // INFO
                return;
            };
        
        jumpTimes--;
        intervalUp();
    }, jumpInterval);

    let intervalDown = setTimeout(function() {
        clear();
        currentY += jumpDistance;
        drawRect();
        console.log('jumpTimes is ' + jumpTimes); // INFO

            if (jumpTimes === -4) { // -4 since it's a mirror of the jump up
                console.log('jumpDOWN interval is 0'); // INFO
            };
        
        jumpTimes--;
    }, jumpInterval);
    
    console.log('END OF JUMP');
};



var clear = () => fightBoxContext.clearRect(currentX, currentY, sizeX, sizeY);

// testing jQuery
createButton = function() {
    $('#divThree').append ('<input type="button" id="gobutton" onclick="flipButton()" value="Battle!"></input>');
}


createButton();

var flipButton = function() {
    $.getScript("creation.js");
}


drawRect();


document.addEventListener("keydown", function(event) {
    let key = event.key;
    switch(key) {
        case 'ArrowLeft':
            moveLeft();
            break;
        case 'ArrowRight': 
            moveRight();
            break;
        case 'ArrowUp':
            jump();
            break;
    }
});
