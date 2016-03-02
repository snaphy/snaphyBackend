(function(){
    'use strict';
})();

/*global require, module*/


module.exports = function(server) {
  var loopback = require('loopback');
  var chalk     = require('chalk');
  //Getting the main root package file of the server..
  var mainPackageObj = require(__dirname + '/../../package.json');
  //Now getting the plugin path with respect to package.json
  var MAIN_PLUGIN_FOLDER = __dirname + "/../../" + mainPackageObj.pluginPath;
  var helper = {};
  var fs = require('fs'),
  path = require('path');

  /**
    * Method for getting all the directores
    * @param  {string} srcpath parent directory within which search is to be performed
    * @return {array}           [Array of directories names retrived]
    */
   function getDirectories(srcpath) {
    return fs.readdirSync(srcpath).filter(function(file) {
      return fs.statSync(path.join(srcpath, file)).isDirectory();
    });
  }




    /**
     * For getting the absolute plugin root path of a plugin.
     * @param pluginName
     * @returns {string}
     */
  function getPluginRootDir(pluginName){
      return path.join(MAIN_PLUGIN_FOLDER, pluginName.trim());
  }


    /**
     * Convert Camel case characters to dashed case characters.
     * @param text
     * @returns {*}
     */
  var camelToDashCase = function(text){
    text = text.replace(/([A-Z])/g, function($1){return "-"+$1.toLowerCase();});
    //Now replace first occurance of dash..
    return text.replace(/^\-?/, '');
  };


    /**
     * Retrives the path of the model.json file..
      * @param modelName Model Name is the Original Model Name of the model
     */
  function getModelPath(modelName){
      //convert to camel case..
      modelName = camelToDashCase(modelName);
      var modelJsonFile = modelName + '.json';
      //Now get the model path..
      return path.join(__dirname, '../models', modelJsonFile );
  }


  /**
   * [method for reading package file]
   * @param  {string} pluginPath Path of the plugin inside plugin folder
   * @return {object}           returns the object of file package.json
   */
  function readPackageJsonFile(pluginPath){
    var packageFile = require(pluginPath);
    return packageFile;
  }

  //Return the path of the main server file
  function getServerPath(){
    return path.join(__dirname , '../../server/server.js');
  }


  function getServerFolder(){
      return path.join(__dirname, '../../server/');
  }


    /**
     * Find the database from the model-config.json and return the database with it datasource attached.
     * @param app Application object of loopback.
     * @param sampleDatabase Database object which needs to be searched
     * @param pluginName Database object with datasource attached.
     * @returns {{}}
     */
  var getDatabase = function(app, sampleDatabase, pluginName){
    //var modelConfig = require('../../server/model-config.json');
    var requiredDatabase = {};
    var key;
    for ( key in sampleDatabase) {
      if (sampleDatabase.hasOwnProperty(key)) {
        //Now find the database in model-config with given key.
        var databaseVal = sampleDatabase[key];
        if(databaseVal){
          requiredDatabase[key] = app.models[databaseVal];
          //var modelProp = modelConfig[databaseVal];
        }else{
          throw 'Please provide a value to the '+ key + ' model property. in Plugin ' + pluginName.trim() + ' model';
        }

      }//if
    }//for
    return requiredDatabase;
  };



  /**
   * Method to getting the loopback object..
   */
  var getLoopbackObj = function(){
    return loopback;
  };




  //Add static routes for the database..
  var setStaticRoute = function(app, rootExposure, PluginName, pluginContainerPath){
    //Replace the '/' with ''
    rootExposure = rootExposure.replace(/^\//, "");
    rootExposure = '/' + rootExposure;
    //cache control
    var oneDay = 86400000;
    app.use(rootExposure, loopback.static( path.join(pluginContainerPath, PluginName.trim(), '/client'), { maxAge: oneDay }));
    console.log("Static Routes " + rootExposure);
  };



  function loadPluginsInMemory(pluginName, pluginContainerPath){
    console.log("Loading plugin " + pluginName + " in memory");
    //Now read the package  files...
    var pluginPath = path.join(pluginContainerPath, pluginName.trim(), '/package.json');
    console.log(pluginPath);
    var packageObj = readPackageJsonFile(pluginPath);
    if( packageObj.activate ){
      try{
        if(packageObj.staticFiles.css || packageObj.staticFiles.js || packageObj.moduleDependencies){
          var rootExposure =  packageObj.routeExposure || packageObj.name;
          //Now load it static route..
          setStaticRoute(server, rootExposure, packageObj.name, pluginContainerPath);
        }
      }catch (err){
        //Do nothing in this case
        console.log(chalk.red(" >> Error: ") + "In exposing plugin " + pluginName + " . Please edit info in package.json for property staticFiles carefully");
      }


      var databaseObj = getDatabase(server, packageObj.databases , pluginName);
      var pluginValue = require( path.join(pluginContainerPath, pluginName.trim()))(server, databaseObj, helper, packageObj );

      if(pluginValue){
        //Now load the corresponding plugins to the memory...
        /*try{
          server.plugins[packageObj.name] = pluginValue;
        }catch (err){
          //TODO Check why error occurs here in this case..
          console.error(chalk.red(">> Error: ") + "Error occured while adding plugin value to server variable.");
        }*/

        if(pluginValue.init){
          //TODO check whether to show warning when init variable is not present inside the plugins.
          //Now initialize the plugins..
          pluginValue.init();
        }
      }//if pluginValue
    }
  }





  //This function is called on function load.
  //Initialize all the plugins and add it to the memory..
  var initPlugins = function(){
    console.log("Loading this plugin");
    var pluginContainerPath = MAIN_PLUGIN_FOLDER;
    var pluginList = getDirectories(pluginContainerPath);
    var i;
    for(i=0; i<pluginList.length; i++){
      loadPluginsInMemory(pluginList[i].trim(), pluginContainerPath);
    }//for loop
  };


  //Require by plugins..
  //Act as a require for plugins..
  var loadPlugin = function(pluginName){
    var pluginValue = {};
    var pluginPath = path.join(MAIN_PLUGIN_FOLDER, pluginName.trim() , '/package.json');
    var packageObj = readPackageJsonFile(pluginPath);
    if( packageObj.activate ){
      var databaseObj = getDatabase(server, packageObj.databases , pluginName);
      pluginValue = require(path.join(MAIN_PLUGIN_FOLDER, pluginName.trim()) )(server, databaseObj, helper, packageObj );
    }
    return pluginValue;
  };//loadPlugin



  //TODO ADD ALL THE REQUIRED METHOD TO HELPERS VARIABLE OBJ.
  helper =  {
    initPlugins: initPlugins,
    readPackageJsonFile: readPackageJsonFile,
    getDirectories: getDirectories,
    getServerPath: getServerPath,
    loadPlugin: loadPlugin,
    getLoopbackObj: getLoopbackObj,
    getPluginRootDir: getPluginRootDir,
    getModelPath: getModelPath,
    getServerFolder: getServerFolder

  };

  return helper;
};
