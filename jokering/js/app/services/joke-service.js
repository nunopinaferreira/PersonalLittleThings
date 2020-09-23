define(function() {

    var internals = {};
    var externals = {};

    internals.queryDetails = 'Any';

    function getJokesFromApi(cb) {
        //$.support.cors = true;
        $.ajax({
            url: "https://sv443.net/jokeapi/v2/joke/" + internals.queryDetails,
            type: 'GET',
            dataType: 'json',
            crossDomain:'true',
            success: function(results) {cb(null, results)},
            error: function(request, statusText, httpError) { cb(httpError || statusText)}
        });
    }


    function processResults(error, data) {
        console.log(data);
        internals.joke = data;

        router.internals.addVariableRoutesHash(internals.joke.id);
        window.location.hash = internals.joke.id;
        //window.history.pushState("object or string", "Title", "/www.google.com");

        console.log("error: " + internals.joke.error);
        console.log("category: " + internals.joke.category);
        console.log('type: ' + internals.joke.type);
        console.log('joke: ' + internals.joke.joke);
        console.log('setup: ' + internals.joke.setup);
        console.log('delivery:' + internals.joke.delivery);
        console.log('id: ' + internals.joke.id);
        console.log('lang: ' + internals.joke.lang);

        if (error) {
            console.log("Sorry, our database isn't working");
        }
        //process data
    };


          externals.getJoke = function(cb, details) {

            internals.queryDetails = details;


            console.log("#######toString: " + details.toString());
            console.log("######queryDetails: "+ internals.queryDetails);



            getJokesFromApi(processResults);


            setTimeout(cb(internals.joke));
          };


    return externals;

});
