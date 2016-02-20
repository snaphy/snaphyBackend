'use strict';

angular.module($snaphy.getModuleName())
    //Define your services here..
    //
    //
    .factory('Resource', ['$q', '$filter', '$timeout', 'Database', function($q, $filter, $timeout, Database) {

        //this would be the service to call your server, a standard bridge between your model an $http

        // the database (normally on your server)
        var randomsItems = [];

        function createRandomItem(id) {
            var heroes = ['Batman', 'Superman', 'Robin', 'Thor', 'Hulk', 'Niki Larson', 'Stark', 'Bob Leponge'];
            return {
                id: id,
                name: heroes[Math.floor(Math.random() * 7)],
                recipeType: Math.floor(Math.random() * 1000),
                servings: Math.floor(Math.random() * 10000)
            };

        }

        for (var i = 0; i < 1000; i++) {
            randomsItems.push(createRandomItem(i));
        }


        //fake call to the server, normally this service would serialize table state to send it to the server (with query parameters for example) and parse the response
        //in our case, it actually performs the logic which would happened in the server
        function getPage(start, number, params) {
            console.log(start, number, params);
            var recipe = Database.getDb("robustAutomata", "Recipe");
            var object = {};
            var filter = {};
            var where = {};
            //Prepare filter..
            var skip = start;
            var limit = number;
            var orderBy = [];




            if(params.sort){
                if(params.sort.predicate){
                    var sort = params.sort.predicate;
                    var reverse = params.sort.reverse;
                    reverse = reverse? "DESC" : "ASC";
                    orderBy.push("" + sort + " " + reverse);
                }
            }

            filter.order = orderBy;
            if(params.search){
                if(params.search.predicateObject){
                    for(var property in params.search.predicateObject){
                        if(params.search.predicateObject.hasOwnProperty(property)){
                            var like = params.search.predicateObject[property];
                            //add to where property..
                            //where: {title: {like: 'M.+st'}}}
                            where[property] = {
                                "like" : like
                            };
                        }
                    }
                }
            }

            filter.skip = skip;
            filter.limit = limit;
            filter.where = where;
            object.filter = filter;

            console.log(object);

            var deferred = $q.defer();
            //predicateObject

            recipe.find(object, function(value, respHeader){
                recipe.count(filter, function(count, respHeader){
                    console.log(count);
                    //Value retrived..
                    console.log(value);
                    deferred.resolve({
                        data: value,
                        numberOfPages: Math.ceil(count.count / number)
                    });
                }, function(httpResponse){
                    console.error(httpResponse);
                });

            }, function(httpResponse){
                //Error occured..
                console.error(httpResponse);
            });


            // //console.log(deferred);
            // var filtered = params.search.predicateObject ? $filter('filter')(randomsItems, params.search.predicateObject) : randomsItems;
            //
            // if (params.sort.predicate) {
            //     filtered = $filter('orderBy')(filtered, params.sort.predicate, params.sort.reverse);
            // }
            //
            // var result = filtered.slice(start, start + number);
            //
            // $timeout(function() {
            //     //note, the server passes the information about the data set size
            //     deferred.resolve({
            //         data: result,
            //         numberOfPages: Math.ceil(filtered.length / number)
            //     });
            // }, 1500);


            return deferred.promise;
        }

        return {
            getPage: getPage
        };

    }]);
