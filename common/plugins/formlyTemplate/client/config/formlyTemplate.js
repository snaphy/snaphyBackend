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
        name: 'multipleFileUpload',
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
        controller: ['$scope', 'Upload',  '$timeout', '$http', 'Database', function ($scope, Upload, $timeout, $http, Database) {
            //Initialize the model..
            $scope.model[$scope.options.key] = $scope.model[$scope.options.key] || [];

            var dbService;
            var url;
            if($scope.options.templateOptions.containerModel){
                console.log($scope.options.templateOptions.containerModel);
                dbService = Database.loadDb($scope.options.templateOptions.containerModel);
            }
            else if($scope.options.templateOptions.url){
                url = $scope.options.templateOptions.url;
            }
            else{
                console.error("Either url property of containerModel is required in formly templateOptions for image uploading");
            }
            var uploadUrl;
            if(dbService){
                uploadUrl = "/api/containers/"  + $scope.options.templateOptions.containerName + "/upload";

            }else{
                uploadUrl = url.upload;
            }


            // upload later on form submit or something similar
            $scope.submit = function(form) {
              if (form.file.$valid && $scope.file) {
                $scope.upload($scope.file);
              }
            };

            $scope.uploadFiles = function($files, $file, $newFiles, $duplicateFiles, $invalidFiles, $event) {
                //First initialize progress bar to zero..
                $scope.addValue(0);
                var file = $newFiles[0];
                $scope.f = file;
                var errFiles = $invalidFiles;
                $scope.errFile = errFiles && errFiles[0];
                //Only upload file if it is not a duplicate file..
                if (file && $duplicateFiles.length === 0 && errFiles.length === 0) {
                    file.upload = Upload.upload({
                        url: uploadUrl,
                        data: {file: file}
                    });

                    file.upload.then(function (response) {
                        $timeout(function () {
                            file.result = response.data;
                            //Adding data to the model.
                            $scope.model[$scope.options.key].push(file.result.result.files.file[0]);
                        });
                    }, function (response) {
                        if (response.status > 0)
                            $scope.errorMsg = response.status + ': ' + response.data;
                    }, function (evt) {
                        $timeout(function () {
                            file.progress = Math.min(100, parseInt(100.0 *
                                                     evt.loaded / evt.total));
                            $scope.addValue(file.progress);
                        }, 10);
                    });
                }
            };

            //Delete the given image...
            $scope.deleteImage = function(files, index){
                var backUpFile = files[index];
                if(backUpFile.result){
                    var fileName      = backUpFile.result.result.files.file[0].name;
                    var containerName = $scope.options.templateOptions.containerName;
                    var filePath      = '/api/containers/'+  containerName +  '/files/' + fileName;
                    //Now remove the file
                    files.splice(index, 1);
                    $scope.model[$scope.options.key].splice(index, 1);
                    console.log(backUpFile);
                    // Simple DELETE request example:
                    console.log(filePath);

                    if(dbService){
                        dbService.removeFile({
                            container:containerName,
                            file: fileName
                        }, function(values){
                            console.log("file successfully deleted");
                        }, function(err){
                            console.error("error deleting file." );
                            console.error(err);
                            //Add backup file ..
                            files.push(backUpFile);
                            $scope.model[$scope.options.key].push(backUpFile.result.result.files.file[0]);
                        });
                    }else{
                        $http({
                          method: 'DELETE',
                          url: url.delete,
                        }).then(function successCallback(response) {
                            console.log("File successfully deleted.");
                          }, function errorCallback(response) {
                            console.log(response);
                            //Add backup file ..
                            files.push(backUpFile);
                        });
                    }

                }
                else{
                    //simply remove the file
                    files.splice(index, 1);
                    $scope.model[$scope.options.key].splice(index, 1);
                }
            };

        }]
    });


}]);
