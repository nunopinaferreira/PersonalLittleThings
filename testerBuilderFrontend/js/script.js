// ESM doesn't seem to be working properly. To investigate. 
//const Elements = require('./js/render.js');
//import { render } from './js/render.js';
console.log("test5555");


let Elements = {};

// to pick a function that returns html code and inject it in a given div id 
Elements.render = function(injectionFunction, divId) {
    console.log("button rendered");
    $(divId).append(injectionFunction);
};


Elements.getQuestion = () => $.getScript("/js/getQuestion.js");


Elements.create = {};

// function to create button
Elements.create.createButton = () => '<button id="buttonGetQuestion">Get Question!</button>'; 


// creating and rendering the button
Elements.render(Elements.create.createButton(), "#boxOne");


// note: getElementById doesn't use the # for id selector
// note: the function passed doesn't contain (), or it will be immediately called and "closed"  
document.getElementById('buttonGetQuestion').addEventListener("click", Elements.getQuestion);




