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
        },
        controller: function($scope) {

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
        controller: ['$scope', function($scope) {} ]
    });


    formlyConfig.setType({
        name: 'singleFileUpload',
        templateUrl: '/formlyTemplate/views/singleFileUpload.html',
        link: function(scope, element, attrs){
            // Randomize progress bars values
            scope.addValue = function(value){
                $(element)
                    .find('.progress-bar')
                    .each(function() {
                        var $this   = jQuery(this);
                        var $random =  value  + '%';
                        $this.css('width', $random);
                    });

            };
        },
        controller: ['$scope', 'Upload',  '$timeout', function ($scope, Upload) {
            var uploadUrl = "/api/containers/"  + $scope.options.templateOptions.containerName + "/upload";
            // upload later on form submit or something similar
            $scope.submit = function(form) {
              if (form.file.$valid && $scope.file) {
                $scope.upload($scope.file);
              }
            };

            $scope.uploadFiles = function(file, errFiles) {
                $scope.f = file;
                $scope.errFile = errFiles && errFiles[0];
                if (file) {
                    file.upload = Upload.upload({
                        url: uploadUrl,
                        data: {file: file}
                    });

                    file.upload.then(function (response) {
                        $timeout(function () {
                            file.result = response.data;
                        });
                    }, function (response) {
                        if (response.status > 0)
                            $scope.errorMsg = response.status + ': ' + response.data;
                    }, function (evt) {
                        file.progress = Math.min(100, parseInt(100.0 *
                                                 evt.loaded / evt.total));
                        $scope.addValue(file.progress);
                    });
                }
            };

            // upload on file select or drop
            $scope.upload = function (file) {
                Upload.upload({
                    url: "/api/containers/"  + $scope.options.templateOptions.containerName + "/upload",
                    data: {file: file}
                }).then(function (resp) {
                    console.log('Success ' + resp.config.data.file.name + 'uploaded. Response: ' + resp.data);
                    resp.data.result.files.file.forEach(function(fileName, index){
                        console.log(fileName);
                    });
                }, function (resp) {
                    console.log('Error status: ' + resp.status);
                }, function (evt) {
                    var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                    $scope.addValue(progressPercentage);
                    console.log('progress: ' + progressPercentage + '% ' + evt.config.data.file.name);
                });
            };
        }]
    });


}]);
