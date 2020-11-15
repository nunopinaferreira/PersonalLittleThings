console.log('testing setup');

// testing jQuery
createButton = function() {
    $('body').append ('<input type="button" id="gobutton" onclick="flipButton()" value="flip"></input>');
}

createButton();


var flipButton = function() {
    $.getScript("individual.js");
}