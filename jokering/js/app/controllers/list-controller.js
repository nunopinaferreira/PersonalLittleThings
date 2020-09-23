
define(['services/joke-service', 'views/list-view'], function(jokeService, listView) {

    var internals = {};
    var externals = {};


    externals.start = function() {
        internals.bindEventHandlers();
        listView.render();
    };




    internals.bindEventHandlers = function() {
        listView.bind('buttonClick', internals.onButtonClickHandler);
    };




    internals.processJoke = function (joke) {
        console.log('Controller: Joke category -' + joke.category);
    };

    internals.getCategories = function() {

        var categoryButtonInputs = [
            $('#programming:checked').val() || "empty",
            $('#dark:checked').val() || "empty",
            $('#pun:checked').val() || "empty",
            $('#misc:checked').val() || "empty"
            ];

        var category = [];

        categoryButtonInputs.filter(function(element) {
                if (!element.includes("empty")) {
                    category.push(element);
                }
            });

        return category;

    };

    internals.getSearchBox = function() {

        console.log("#######searchbox raw: " + $('#searchbox').val());

        if ($('#searchbox').val() == 0) {
            return "";
        };

        return "?contains=" + $('#searchbox').val();
    };

    internals.onButtonClickHandler = function() {

        //internals.getSearchBox();

        var categories = internals.getCategories().toString() || "Any";

        query = categories.concat(internals.getSearchBox());

        console.log("########query: " + query);

        jokeService.getJoke(listView.render, query);

    };


    return externals;
});
