// todo o nosso código vai estar aqui dentro.
// pode receber 2 argumentos, as dependências que eu recebo e uma função define
// o que retornar vai ser o objecto passado para o outro lado
// o define é uma função do "require"
define(function() {

    var internals = {};
    var externals = {};

    internals.routes = {
        list: {
            hash: '#list',
            controller: 'list-controller'
        },
        variableRoute: {
            hash: '#joke',
            controller:'idManager'
        },
    };

    internals.defaultRoute = 'list';
    internals.currentHash = '';


    internals.loadDefaultRoute = function() {
        window.location.hash = internals.routes[internals.defaultRoute].hash;
        internals.loadController(internals.routes[internals.defaultRoute].controller);
    };


    internals.variableRoutesHash = [];

    externals.addVariableRoutesHash = function (hashId) {
        internals.variableRoutesHash.push(hashId);
    };



    internals.hashCheck = function() {

        // nothing to do if route has not changed
        if (window.location.hash === internals.currentHash) {
            return;
        }

        // find the current route name
        // you iterate through the object using the keys, find will return the first to pass the test
        var routeName = Object.keys(internals.routes).find(function(element) {
            return window.location.hash === internals.routes[element].hash;
        });

        // load default route if invalid
        if (!routeName) {
            internals.loadDefaultRoute();
            return;
        }

        internals.loadController(internals.routes[routeName].controller);
    };


    internals.loadController = function(controllerName) {
        internals.currentHash = window.location.hash;

        // controllerName vai ser um ficheiro
        require(['controllers/' + controllerName], function (controller) {

            try {
            controller.start();
            } catch (err) {
                console.log(err.stack);
                window.location.hash = internals.routes[internals.defaultRoute].hash;
            }
        });
    }

    externals.start = function() {
        window.location.hash =
            window.location.hash || internals.routes[internals.defaultRoute].hash;

        setInterval(internals.hashCheck, 150);
    };


    return externals;

});
