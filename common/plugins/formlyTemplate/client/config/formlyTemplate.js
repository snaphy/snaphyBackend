(function() {
    'use strict';
})();
/*global angular, $snaphy, $*/

angular.module($snaphy.getModuleName())

/**
 Defigning custom templates for angular-formly.
 */
.run(['formlyConfig', '$timeout', function(formlyConfig, $timeout) {

    formlyConfig.setType({
        name: 'belongsTo',
        templateUrl: '/formlyTemplate/views/autocomplete.html',
        controller: function($scope) {
            //Set the value initially to hide position..
            $scope.hide = true;
            $scope.showOrHide = function(){
                if($scope.hide){
                    //Show opposite
                    return "show";
                }else{
                    return "hide";
                }
            };

            $scope.isHidden = function(){
                return $scope.hide;
            };


            $scope.toggleShow = function(){
                $scope.hide = !$scope.hide;
                return $scope.hide;
            };


            $scope.resetCreate = resetCreate;
            $scope.showCreate = function() {
                //if create is true then show only
                if($scope.to.create || $scope.to.create === undefined){
                    //model has value then put create == true
                    var containValue = $.isEmptyObject($scope.model[$scope.options.key]);
                    if (containValue) {
                        //put $scope.create == false;
                        $scope.create = false;
                    } else {
                        $scope.create = true;
                    }
                    return $scope.create;
                }
                else{
                    return false;
                }

            };



            function resetCreate() {
                $timeout(function() {
                    $scope.model[$scope.options.key] = {};
                }, 0);
            }

            $scope.forceDisplay = function() {
                //Just add a dummy property.
                if ($scope.to.fields.length) {
                    $timeout(function() {
                        $scope.model[$scope.options.key] = {};
                        $scope.model[$scope.options.key][$scope.to.fields[0].key] = "";
                    }, 0);

                }
            };

        }
    });

    formlyConfig.setType({
        name: 'repeatSection',
        templateUrl: '/formlyTemplate/views/hasManyTemplate.html',
        controller: function($scope) {
            //Set the value initially to hide position..
            $scope.hide = true;
            $scope.showOrHide = function(){
                if($scope.hide){
                    //Show opposite
                    return "show";
                }else{
                    return "hide";
                }
            };

            $scope.isHidden = function(){
                return $scope.hide;
            };


            $scope.toggleShow = function(){
                $scope.hide = !$scope.hide;
                return $scope.hide;
            };


            var unique = 1;
            $scope.formOptions = {
                formState: $scope.formState
            };
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
                //var lastSection = repeatsection[repeatsection.length - 1];
                var newsection = {};
                // if (lastSection) {
                //     newsection = angular.copy(lastSection);
                // }

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
        link: function(scope, element, attrs) {},
        controller: function($scope) {
            var unique = 1;
            $scope.formOptions = {
                formState: $scope.formState
            };

            var methods = (function() {
                function init() {
                    //Initialize the methods..
                    if ($scope.model[$scope.options.key] === undefined) {
                        addNew();
                    } else {
                        if ($scope.model[$scope.options.key].length === 0) {
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
                    //var lastSection = repeatsection[repeatsection.length - 1];
                    var newsection = {};
                    // if (lastSection) {
                    //     newsection = angular.copy(lastSection);
                    // }

                    //console.log(newsection);
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

                return {
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
        controller: ['$scope', function($scope) {}]
    });


    formlyConfig.setType({
        name: 'multipleFileUpload',
        templateUrl: '/formlyTemplate/views/multiFileUpload.html',
        link: function(scope, element) {
            // Randomize progress bars values
            scope.addValue = function(value) {
                $(element)
                    .find('.progress-bar')
                    .each(function() {
                        var $this = jQuery(this);
                        var $random = value + '%';
                        $this.css('width', $random);
                    });

            };

        },
        controller: ['$scope', 'Upload', '$timeout', '$http', 'Database', 'SnaphyTemplate',
            function($scope, Upload, $timeout, $http, Database, SnaphyTemplate) {
                //Initialize the model..
                $scope.model[$scope.options.key] = $scope.model[$scope.options.key] || [];
                $scope.files = [];


                var dbService;
                var url;
                if ($scope.options.templateOptions.containerModel) {
                    dbService = Database.loadDb($scope.options.templateOptions.containerModel);
                } else if ($scope.options.templateOptions.url) {
                    url = $scope.options.templateOptions.url;
                } else {
                    console.error("Either url property of containerModel is required in formly templateOptions for image uploading");
                }
                var uploadUrl;
                if (dbService) {
                    uploadUrl = "/api/containers/" + $scope.options.templateOptions.containerName + "/upload";

                } else {
                    uploadUrl = url.upload;
                }


                $scope.checkData = function() {
                    if ($scope.files.length) {
                        if ($scope.model[$scope.options.key] === undefined) {
                            $scope.model[$scope.options.key] = [];
                        }

                        return true;
                    } else {
                        return false;
                    }
                };


                $scope.loadFromServer = function(file) {
                    if (file.result) {
                        //Check if file really has one params..
                        var count = 0;
                        for (var key in file) {
                            if (file.hasOwnProperty(key)) {
                                count++;
                            }
                        }
                        if (count <= 4) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return false;
                };


                $scope.loadUrl = function(file) {
                    var url = "/api/containers/" + file.result.container + "/download/" + file.result.name;
                    return url;
                };


                $scope.$watch('model[options.key].length', function(value) {
                    if ($scope.model[$scope.options.key]) {
                        $scope.model[$scope.options.key].forEach(function(modelData, index) {
                            if ($scope.files.length !== 0) {
                                var matchFound = false;
                                $scope.files.forEach(function(dataObj, index) {
                                    if (dataObj.result.name === modelData.name) {
                                        matchFound = true;
                                    }
                                });
                                if (!matchFound) {
                                    $scope.files.push({
                                        result: modelData
                                    });
                                }
                            } else {
                                $scope.files.push({
                                    result: modelData
                                });
                            }
                        }); //model loop
                    } else {
                        //Clean files data too..
                        $scope.files = [];
                    }
                }); //$watch



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
                            data: {
                                file: file
                            }
                        });

                        file.upload.then(function(response) {
                            $timeout(function() {
                                file.result = response.data.result.files.file[0];
                                if ($scope.model[$scope.options.key] === undefined) {
                                    $scope.model[$scope.options.key] = [];
                                }

                                //Adding data to the model.
                                $scope.model[$scope.options.key].push(file.result);
                            });
                            SnaphyTemplate.notify({
                                message: "Image successfully saved to server.",
                                type: 'success',
                                icon: 'fa fa-check',
                                align: 'right'
                            });

                        }, function(response) {
                            if (response.status > 0) {
                                SnaphyTemplate.notify({
                                    message: "Error saving image to server. Please remove that image and try again.",
                                    type: 'danger',
                                    icon: 'fa fa-times',
                                    align: 'right'
                                });
                                $scope.errorMsg = response.status + ': ' + response.data;
                            }

                        }, function(evt) {
                            $timeout(function() {
                                file.progress = Math.min(100, parseInt(100.0 *
                                    evt.loaded / evt.total));
                                $scope.addValue(file.progress);
                            }, 10);
                        });
                    }
                };

                //Delete the given image...
                $scope.deleteImage = function(files, index) {
                    var backUpFile = files[index];
                    if (backUpFile.result) {
                        var fileName = backUpFile.result.name;
                        var containerName = $scope.options.templateOptions.containerName;
                        var filePath = '/api/containers/' + containerName + '/files/' + fileName;
                        //Now remove the file
                        files.splice(index, 1);
                        $scope.model[$scope.options.key].splice(index, 1);
                        //console.log(backUpFile);
                        // Simple DELETE request example:
                        //console.log(filePath);

                        if (dbService) {
                            dbService.removeFile({
                                container: containerName,
                                file: fileName
                            }, function(values) {
                                console.log("file successfully deleted");
                                SnaphyTemplate.notify({
                                    message: "Image successfully deleted from server.",
                                    type: 'success',
                                    icon: 'fa fa-check',
                                    align: 'right'
                                });

                            }, function(err) {
                                console.error("error deleting file.");
                                SnaphyTemplate.notify({
                                    message: "Error deleting image from server. Please try again.",
                                    type: 'danger',
                                    icon: 'fa fa-times',
                                    align: 'right'
                                });
                                console.error(err);
                                //Add backup file ..
                                files.push(backUpFile);
                                $scope.model[$scope.options.key].push(backUpFile.result);
                            });
                        } else {
                            $http({
                                method: 'DELETE',
                                url: url.delete,
                            }).then(function successCallback(response) {
                                console.log("File successfully deleted.");
                                SnaphyTemplate.notify({
                                    message: "Image successfully deleted from server.",
                                    type: 'success',
                                    icon: 'fa fa-check',
                                    align: 'right'
                                });
                            }, function errorCallback(response) {
                                console.log(response);
                                SnaphyTemplate.notify({
                                    message: "Error deleting image from server. Please try again.",
                                    type: 'danger',
                                    icon: 'fa fa-times',
                                    align: 'right'
                                });
                                //Add backup file ..
                                files.push(backUpFile);
                            });
                        }

                    } else {
                        //simply remove the file
                        files.splice(index, 1);
                        $scope.model[$scope.options.key].splice(index, 1);
                    }
                };

            }
        ]
    });


    formlyConfig.setType({
        name: 'dummy',
        template:
        '<div style="display:none" class="form-group">'+
        '<div  ng-class="[options.templateOptions.colSize, options.templateOptions.color]">'+
        '<div class="form-material" ng-class="options.templateOptions.color">'+
        '<input  class="form-control" type="{{options.templateOptions.type}}"  ng-class="options.templateOptions.class" name="{{options.templateOptions.id}}" id="{{options.templateOptions.id}}" ng-model="model[options.key]">'+
        '<label for="{{options.templateOptions.id}}">{{options.templateOptions.label}}</label>'+
        '</div>'+
        '</div>'+
        '</div>',

        link: function(scope, element, attrs) {
            // ID PROPERTY IS NEEDED FOR VALIDATE TO WORK
            if(scope.options.templateOptions){
                if(!scope.options.templateOptions.colSize){
                    scope.options.templateOptions.colSize = 'col-xs-12';
                }
            }//if

            if(scope.model[scope.options.key] === ""){
                //remove the option..
                delete scope.model[scope.options.key];
            }
        }//link function..
    });


    formlyConfig.setType({
        name: 'singleFileUpload',
        templateUrl: '/formlyTemplate/views/singleFileUpload.html',
        link: function(scope, element, attrs) {
            // Randomize progress bars values
            scope.addValue = function(value) {
                $(element)
                    .find('.progress-bar')
                    .each(function() {
                        var $this = jQuery(this);
                        var $random = value + '%';
                        $this.css('width', $random);
                    });

            };

        },


        controller: ['$scope', 'Upload', '$timeout', '$http', 'Database', 'SnaphyTemplate',
            function($scope, Upload, $timeout, $http, Database, SnaphyTemplate) {
                //Initialize the model..
                $scope.model[$scope.options.key] = $scope.model[$scope.options.key] || {};
                $scope.file = {};

                var dbService;
                var url;
                if ($scope.options.templateOptions.containerModel) {
                    dbService = Database.loadDb($scope.options.templateOptions.containerModel);
                } else if ($scope.options.templateOptions.url) {
                    url = $scope.options.templateOptions.url;
                } else {
                    console.error("Either url property of containerModel is required in formly templateOptions for image uploading");
                }
                var uploadUrl;
                if (dbService) {
                    uploadUrl = "/api/containers/" + $scope.options.templateOptions.containerName + "/upload";
                } else {
                    uploadUrl = url.upload;
                }


                $scope.checkData = function() {
                    if ($scope.file) {
                        if ($scope.model[$scope.options.key] === undefined) {
                            $scope.model[$scope.options.key] = {};
                        }
                        return true;
                    } else {
                        return false;
                    }
                };


                $scope.loadFromServer = function(file) {
                    if (file.result) {
                        //Check if file really has one params..
                        var count = 0;
                        for (var key in file) {
                            if (file.hasOwnProperty(key)) {
                                count++;
                            }
                        }
                        if (count === 3) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return false;
                };

                $scope.loadUrl = function(file) {
                    var url = "/api/containers/" + file.result.container + "/download/" + file.result.name;
                    return url;
                };


                $scope.$watch('model[options.key]', function() {
                    if (!$.isEmptyObject($scope.model[$scope.options.key])) {
                        var modelData = $scope.model[$scope.options.key];
                        if ($.isEmptyObject($scope.file)) {
                            //Just add the data..
                            $scope.file = $scope.file || {};
                            $scope.file.result = modelData;
                        } else {
                            if ($scope.file.result) {
                                if ($scope.file.result.name !== modelData.name) {
                                    $scope.file = {};
                                    $scope.file.result = modelData;
                                }
                            } else {
                                $scope.file = $scope.file || {};
                                $scope.file.result = modelData;
                            }
                        }
                    } else {
                        //Clean files data too..
                        $scope.file = {};
                    }
                }); //$watch



                $scope.uploadFiles = function($files, $file, $newFiles, $duplicateFiles, $invalidFiles, $event) {
                    if ($newFiles === null) {
                        return false;
                    }
                    //console.log($files);

                    //First initialize progress bar to zero..
                    $scope.addValue(0);
                    var file = $newFiles[0];
                    $scope.file = file;
                    var errFiles = $invalidFiles;
                    $scope.errFile = errFiles && errFiles[0];
                    //Only upload file if it is not a duplicate file..
                    if (file && $duplicateFiles.length === 0 && errFiles.length === 0) {
                        file.upload = Upload.upload({
                            url: uploadUrl,
                            data: {
                                file: file
                            }
                        });

                        file.upload.then(function(response) {
                            $timeout(function() {
                                file.result = response.data.result.files.file[0];
                                if ($scope.model[$scope.options.key] === undefined) {
                                    $scope.model[$scope.options.key] = {};
                                }
                                //Adding data to the model.
                                $scope.model[$scope.options.key] = file.result;
                            });
                            SnaphyTemplate.notify({
                                message: "Image successfully saved to server.",
                                type: 'success',
                                icon: 'fa fa-check',
                                align: 'right'
                            });
                        }, function(response) {
                            if (response.status > 0) {
                                SnaphyTemplate.notify({
                                    message: "Error saving image to server. Please remove the image and try again.",
                                    type: 'danger',
                                    icon: 'fa fa-times',
                                    align: 'right'
                                });
                                $scope.errorMsg = response.status + ': ' + response.data;
                            }

                        }, function(evt) {
                            $timeout(function() {
                                file.progress = Math.min(100, parseInt(100.0 *
                                    evt.loaded / evt.total));
                                $scope.addValue(file.progress);
                            }, 10);
                        });
                    }
                };

                //Delete the given image...
                $scope.deleteImage = function(file) {
                    var backUpFile = angular.copy(file);
                    if (backUpFile.result) {
                        var fileName = backUpFile.result.name;
                        var containerName = $scope.options.templateOptions.containerName;
                        //var filePath = '/api/containers/' + containerName + '/files/' + fileName;
                        //Now remove the file
                        file = {};
                        $scope.model[$scope.options.key] = {};
                        //console.log(backUpFile);
                        // Simple DELETE request example:
                        //console.log(filePath);

                        if (dbService) {
                            dbService.removeFile({
                                container: containerName,
                                file: fileName
                            }, function() {
                                //console.log("file successfully deleted");
                                SnaphyTemplate.notify({
                                    message: "Image successfully deleted from server.",
                                    type: 'success',
                                    icon: 'fa fa-check',
                                    align: 'right'
                                });
                            }, function() {
                                //console.error("error deleting file.");
                                //console.error(err);
                                $timeout(function() {
                                    //Add backup file ..
                                    $scope.file = backUpFile;
                                    $scope.model[$scope.options.key] = backUpFile.result;
                                }, 0);

                                SnaphyTemplate.notify({
                                    message: "Error deleting image from server. Please try again.",
                                    type: 'danger',
                                    icon: 'fa fa-times',
                                    align: 'right'
                                });
                            });
                        } else {
                            $http({
                                method: 'DELETE',
                                url: url.delete,
                            }).then(function successCallback() {
                                // console.log("File successfully deleted.");
                                SnaphyTemplate.notify({
                                    message: "Image successfully deleted from server.",
                                    type: 'success',
                                    icon: 'fa fa-check',
                                    align: 'right'
                                });
                            }, function errorCallback(response) {
                                //console.log(response);
                                //Add backup file ..
                                $scope.file = backUpFile;
                                SnaphyTemplate.notify({
                                    message: "Error deleting image from server. Please try again.",
                                    type: 'danger',
                                    icon: 'fa fa-times',
                                    align: 'right'
                                });
                            });
                        }

                    } else {
                        //simply remove the file
                        $scope.files = {};
                        $scope.model[$scope.options.key] = {};
                    }
                };

            }
        ]
    });



    formlyConfig.setType({
        name: 'youTubeVideo',
        templateUrl: '/formlyTemplate/views/loadYouTubeVideo.html',
        link: function(scope) {
            // ID PROPERTY IS NEEDED FOR VALIDATE TO WORK
            if(scope.options.templateOptions){
                if(!scope.options.templateOptions.colSize){
                    scope.options.templateOptions.colSize = 'col-xs-12';
                }
            }//if


            scope.trackModelValue = function(){
                if(scope.youTubeUrl){
                    //Now the video id.
                    var video_id = scope.youTubeUrl.split('v=')[1];
                    if(!video_id){
                        scope.model[scope.options.key] = "";
                        return false;
                    }
                    scope.model[scope.options.key] = video_id;
                }
            };


            scope.parseUrl = function(){
                if(scope.youTubeUrl){
                    scope.trackModelValue();
                }
            };



            scope.$watch('model[options.key]', function(){
                if(!scope.model[scope.options.key]){
                    //Clear the value..
                    scope.youTubeUrl = "";
                }
            });

        }//link function..
    });


}]);
