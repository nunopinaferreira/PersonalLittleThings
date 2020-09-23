define(function() {

    var internals = {};
    var externals = {};


    internals.elements = {};
    internals.handlers = {};

    externals.render = function(joke) {

        // só pra guardar os elementos em vez de ter o jquery todas as vezes
        internals.elements.app = $('#app');


        internals.renderCategoryButton();
        internals.renderSearchBox();
        internals.renderButton();

        if(joke) {
            internals.renderJoke(joke);

        };
    };


    // binder for button click event
    externals.bind = function(event, handler) {
        internals.handlers[event] = handler;
    };



    // rendering of button
    internals.renderButton = function() {
        if (internals.elements.button) {
            return;
        }

        internals.elements.button = $(internals.createButton());
        internals.elements.button.click(internals.handlers['buttonClick']);
        internals.elements.app.append(internals.elements.button);
    };




    internals.renderJoke = function(joke) {
        if (internals.elements.jokeBox) {
            internals.elements.jokeBox.empty();
        };

        console.log("TEST delivery: " + internals.elements.delivery);

        /*
        if (internals.delivery) {
            internals.elements.app.remove(internals.delivery());
        };
        */
        internals.elements.app.remove($('#jokedelivery'));

        internals.elements.jokeBox = $(internals.createJokeBox(joke));
        internals.elements.app.append(internals.elements.jokeBox);
    };




    internals.createJokeBox = function(joke) {

        if (joke.type === 'single') {

            return (
            '<div class="jokewindow1>' +
            '<p><strong>Category: </strong>' +
            joke.category +
            '</p>' +
            '<p><strong>Joke: </strong>' +
            joke.joke +
            '</p>' +
            '</div>')
        };



        setTimeout(function() {
            internals.elements.app.append(internals.delivery(joke));
            }, 3000);


        return(

            '<div id="jokesetup" class="jokewindow2">' +
            '<p><strong>Category: </strong>' +
            joke.category +
            '</p>' +
            '<p><strong> </strong>' +
            joke.setup +
            '</p>' +
            '</div>')
    };

    internals.delivery = function(joke) {
        console.log("TIMEOUT TEST");
        return (
            '<div id="jokedelivery" class="jokewindow2">' +
            '<p><strong>' +
            joke.delivery +
            '</strong>' +
            '</p>' +
            '</div>'
            );
    };


    internals.createButton = function() {
        return '<button id="gobutton">Go!</button>'
    }



    // create radio buttons for category
    internals.createCategoryButton = function() {
        return (
            '<div id="categorymainbox">'+

            '<div id="category1button">' +
            '<input type="checkbox" id="programming" value="Programming" class="checkbox">' +
            '<label for="programming">Programming</label>' +
            '</div>' +

            '<div id="category2button">' +
            '<input type="checkbox" id="dark" value="Dark" class="checkbox">' +
            '<label for="dark">Dark Humor</label>' +
            '</div>' +

            '<div id="category3button">' +
            '<input type="checkbox" id="pun" value="Pun">' +
            '<label for="pun">Puns</label>' +
            '</div>' +

            '<div id="category4button">' +
            '<input type="checkbox" id="misc" value="Miscellaneous">' +
            '<label for="misc">Other stuff</label>' +
            '</div>' +

            '</div>'
        );
    };

    // function to render category buttons
    internals.renderCategoryButton = function() {
        if (internals.elements.categoryButton) {
            return;
        }

        internals.elements.categoryButton = $(internals.createCategoryButton());
        internals.elements.app.append(internals.elements.categoryButton);
    };


    // create search box for string inputs
    internals.createSearchBox = function() {
        return (
            '<div id="textboxarea">' +

            '<input type="text" id="searchbox" class="searchboxes" placeholder="optional words included">' +

            '</div>'
        );
    };

     // function to render searchbox
     internals.renderSearchBox = function() {
        if (internals.elements.searchBox) {
            return;
        }

        internals.elements.searchBox = $(internals.createSearchBox());
        internals.elements.app.append(internals.elements.searchBox);
    };


    return externals;
});
