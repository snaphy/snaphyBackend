(function(){'use strict';})();
/*global angular, $snaphy, $*/

angular.module($snaphy.getModuleName())

/**
 Defigning custom templates for angular-formly.
 */
.run(['formlyConfig', '$timeout', function (formlyConfig, $timeout)  {

    formlyConfig.setType({
        name: 'belongsTo',
        templateUrl: '/formlyTemplate/views/autocomplete.html',
        controller: function($scope) {
            $scope.resetCreate   = resetCreate;
            $scope.showCreate = function(){
                //model has value then put create == true
                var containValue = $.isEmptyObject($scope.model[$scope.options.key]);
                if(containValue){
                    //put $scope.create == false;
                    $scope.create = false;
                }
                else{
                    $scope.create = true;
                }
                return $scope.create;
            };



            function resetCreate(){
                $timeout(function(){
                    $scope.model[$scope.options.key] = {};
                },0);
            }

            $scope.forceDisplay = function(){
                //Just add a dummy property.
                if($scope.to.fields.length){
                    $timeout(function(){
                        $scope.model[$scope.options.key] = {};
                        $scope.model[$scope.options.key][$scope.to.fields[0].key] = "";
                    },0);

                }
            };

        }
    });

    formlyConfig.setType({
        name: 'repeatSection',
        templateUrl: '/formlyTemplate/views/hasManyTemplate.html',
        link: function(scope, element, attrs){
            // var select = $(element).find('select.selectize');
            // select = $(select[0]);
            // var selectize = select.selectize;
            // scope.addValue = function(obj, searchProp){
            //     console.log(obj, searchProp);
            //     selectize.addOption(obj);
            //     selectize.addItem(searchProp);
            // };
        },
        controller: function($scope) {

            // $scope.$watch('model[$scope.options.key]', function() {
            //     console.log("got changed");
            //     if($scope.model[$scope.options.key]){
            //         //On initialize add values to selectize forms..
            //         if($scope.model[$scope.options.key].length){
            //             //Add values to selectize forms.
            //             $scope.model[$scope.options.key].forEach(function(obj, index){
            //                 if(obj[$scope.to.searchProp]){
            //                     $scope.addValue(obj, $scope.to.searchProp);
            //                 }
            //             });
            //         }
            //     }
            // });

            var unique = 1;
            $scope.formOptions = {formState: $scope.formState};
            $scope.addNew = addNew;
            $scope.copyFields = copyFields;
            function copyFields(fields) {
                fields = angular.copy(fields);
                addRandomIds(fields);
                return fields;
            }

            function addNew() {
                $scope.model[$scope.options.key] = $scope.model[$scope.options.key] || [];
                var repeatsection = $scope.model[$scope.options.key];
                var lastSection = repeatsection[repeatsection.length - 1];
                var newsection = {};
                if (lastSection) {
                    newsection = angular.copy(lastSection);
                }
                repeatsection.push(newsection);
            }

            function addRandomIds(fields) {
                unique++;
                angular.forEach(fields, function(field, index) {
                    if (field.fieldGroup) {
                        addRandomIds(field.fieldGroup);
                        return; // fieldGroups don't need an ID
                    }
                    if (field.templateOptions && field.templateOptions.fields) {
                        addRandomIds(field.templateOptions.fields);
                    }
                    field.id = field.id || (field.key + '_' + index + '_' + unique + getRandomInt(0, 9999));
                });
            }

            function getRandomInt(min, max) {
                return Math.floor(Math.random() * (max - min)) + min;
            }
        }
    });

    formlyConfig.setType({
        name: 'arrayValue',
        templateUrl: '/formlyTemplate/views/arrayTemplate.html',
        link: function(scope, element, attrs){
        },
        controller: function($scope) {
            var unique = 1;
            $scope.formOptions = {formState: $scope.formState};

            var methods = (function(){
                function init(){
                    //Initialize the methods..
                    if($scope.model[$scope.options.key] === undefined){
                        addNew();
                    }else{
                        if($scope.model[$scope.options.key].length === 0){
                            //Add one data to the begining ..
                            addNew();
                        }
                    }
                }

                function copyFields(fields) {
                    fields = angular.copy(fields);
                    addRandomIds(fields);
                    return fields;
                }

                function addNew() {
                    $scope.model[$scope.options.key] = $scope.model[$scope.options.key] || [];
                    var repeatsection = $scope.model[$scope.options.key];
                    var lastSection = repeatsection[repeatsection.length - 1];
                    var newsection = {};
                    if (lastSection) {
                        newsection = angular.copy(lastSection);
                    }
                    repeatsection.push(newsection);
                }

                function addRandomIds(fields) {
                    unique++;
                    angular.forEach(fields, function(field, index) {
                        if (field.fieldGroup) {
                            addRandomIds(field.fieldGroup);
                            return; // fieldGroups don't need an ID
                        }
                        if (field.templateOptions && field.templateOptions.fields) {
                            addRandomIds(field.templateOptions.fields);
                        }
                        field.id = field.id || (field.key + '_' + index + '_' + unique + getRandomInt(0, 9999));
                    });
                }

                function getRandomInt(min, max) {
                    return Math.floor(Math.random() * (max - min)) + min;
                }

                //call the constructor method..
                init();

                return{
                    copyFields: copyFields,
                    addNew: addNew
                };

            })();

            $scope.addNew = methods.addNew;
            $scope.copyFields = methods.copyFields;
        }
    });

    formlyConfig.setType({
        name: 'objectValue',
        templateUrl: '/formlyTemplate/views/objectTemplate.html',
        controller: function($scope) {

        }
    });

}]);
