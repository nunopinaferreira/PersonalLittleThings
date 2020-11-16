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

fightBoxContext.beginPath();
fightBoxContext.rect(20, 40, 20, 20);
fightBoxContext.fillStyle = 'purple';
fightBoxContext.fill();
fightBoxContext.closePath(); 



// testing jQuery
createButton = function() {
    $('#divThree').append ('<input type="button" id="gobutton" onclick="flipButton()" value="Battle!"></input>');
}

createButton();





var flipButton = function() {
    $.getScript("creation.js");
}