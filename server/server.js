'use strict';
var loopback = require('loopback');
var boot = require('loopback-boot');

var app = module.exports = loopback();

var pmx = require('pmx').init({
  http          : true, // HTTP routes logging (default: true)
  ignore_routes : [/socket\.io/, /notFound/], // Ignore http routes with this pattern (Default: [])
  errors        : true, // Exceptions loggin (default: true)
  custom_probes : true, // Auto expose JS Loop Latency and HTTP req/s as custom metrics
  network       : true, // Network monitoring at the application level
  ports         : true  // Shows which ports your app is listening on (default: false)
});




app.start = function() {
	// start the web server
	return app.listen(function() {
		app.emit('started');
		console.log('Web server listening at: %s', app.get('url'));
	});
};

// Bootstrap the application, configure models, datasources and middleware.
// Sub-apps like REST API are mounted via boot scripts.
boot(app, __dirname, function(err) {
	if (err) throw err;
  //Now load the PLUGINS..
  var helper = require(__dirname + '/../common/helper')(app);
  helper.initPlugins();

	// start the server if `$ node server.js`
	if (require.main === module){
        app.start();
    }
});
