(function(){
    'use strict';
})();
/*global, __dirname */
module.exports = function(server) {
  var chalk = require('chalk');
  var loopback = require('loopback');
  var helper   = require(__dirname + '/../../common/helper')(server);
  var config   = require(__dirname + '/../config.json');
  var path     = require('path');

  //Now setting up the static files..
  //TODO ADD CACHE TIME AFTER PRODUCTION MODE
  server.use(path.join(config.adminApiRoot, '/static'), loopback.static(path.join(__dirname, '/../../.views/static') ));
  // set the view engine to ejs
  server.set('view engine', 'ejs');


  //Adding properties to an object..
  var concatObject = function(targetObj, containerObj){
    for (var property in targetObj) {
        if (targetObj.hasOwnProperty(property)) {
            // do stuff
            //Add its property and its values..
            containerObj[property] = targetObj[property];
        }
    }
    return containerObj;
  };

  //Load the required plugins script and styles in the memory..
  var loadPluginsData = function(data){
    var i;
    //get the list of plugins..
    var pluginList = helper.getDirectories(path.join(__dirname, '/../../common/plugins'));
    for(i=0; i<pluginList.length; i++){
      var pluginName = pluginList[i];
      var pluginPath = path.join(__dirname, '/../../common/plugins/', pluginName.trim(),  '/package.json');
      var packageObj = helper.readPackageJsonFile(pluginPath);
      if(packageObj.activate){
        //If the plugin has declared staticFiles
        if(packageObj.staticFiles) {
          if (packageObj.staticFiles.css) {
            data.pluginStyles = concatObject(packageObj.staticFiles.css, data.pluginStyles);
          }

          if (packageObj.staticFiles.js) {
            data.pluginScripts = concatObject(packageObj.staticFiles.js, data.pluginScripts);
          }


          //Load module dependencies..
          if(packageObj.staticFiles.moduleDependencies){
            data.moduleDependencies = concatObject(packageObj.staticFiles.moduleDependencies, data.moduleDependencies);
          }

          //Load plugin settings file....
          if(packageObj.staticFiles.settings){
            data.clientSettings = data.clientSettings.concat(packageObj.staticFiles.settings);
          }

          //Now getting the html templates...hooks..
          if(packageObj.bodystructure){
            data.asidebarHook = data.asidebarHook.concat(packageObj.bodystructure.asidebarHook);
            data.sidebarHook  = data.sidebarHook.concat(packageObj.bodystructure.sidebarHook);
            data.headerHook   = data.headerHook.concat(packageObj.bodystructure.headerHook);
            if(packageObj.bodystructure.footerHook !== undefined){
              data.footerHook = data.footerHook.concat(packageObj.bodystructure.footerHook);
            }
          }//if
        }// if staticFiles..

        //If databases is not undefined.
        if(packageObj.databases){
          data.databaseObj = getDatabaseObjFormat(packageObj.name.trim(), packageObj.databases, data.databaseObj);
        }
      }//if activate

    }//for loop
    return data;
  };


  /**
   * Format the database object
   * {                                          {
   *   databases: {                                pluginName: {databaseName: databaseMappedName}
   *     databaseName: DatabaseMappedName   ==>
   *   }                                        }
   * }
   */
  var getDatabaseObjFormat = function(pluginName, oldDatabaseObj, targetObjDatabase){
      targetObjDatabase[pluginName] = oldDatabaseObj;
      return targetObjDatabase;
  };


  //Loads the title, desc of the app given in the package.json file.
  var loadAppData = function(data){
    var packageObj = helper.readPackageJsonFile(path.join(__dirname, '/../../package.json'));
    data.title = packageObj.title;
    data.description = packageObj.description;
    data.author = packageObj.author;
    data.module = packageObj.angularModuleName;
    data.version = packageObj.version;
    return data;
  };


  //Changing the view folder
  server.set('views', path.join(__dirname, '/../../.views'));


  var apiRoot = config.adminApiRoot === '/' ? '/static' : path.join(config.adminApiRoot, '/static' );


  //Now render the index page..
  //index page
  server.get(config.adminApiRoot, function(req, res) {
    //Read the main package file..
    var data = {
      title: '',
      author: '',
      description: '',
      pluginStyles:{},
      pluginScripts: {},
      moduleDependencies:{},
      asidebarHook:[],
      sidebarHook:[],
      headerHook:[],
      footerHook:[],
      //For mapping the defined database in the plugins..
      databaseObj:{},
      staticRoute: apiRoot,
      clientSettings: []
    };
    data = loadPluginsData(data);
    data = loadAppData(data);
    //console.log( data);

    res.render('index', data);

  });

 server.once('started', function() {
    console.log("Explore admin console at " + chalk.cyan("http://" +  config.host + ':' + config.port + config.adminApiRoot));
  });


};
