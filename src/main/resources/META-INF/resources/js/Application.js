
// Main application instance
var application = angular.module("wh40kbc", []);

function isIE () {
  var myNav = navigator.userAgent.toLowerCase();
  var vIsIE = (myNav.indexOf('msie') != -1) ? parseInt(myNav.split('msie')[1]) : false;
  
  if(!vIsIE)
  {
      vIsIE = myNav.indexOf('edge') != -1;
  }
  
  return vIsIE;
}

application.config(['$httpProvider', function($httpProvider) {
    if(isIE()) {
		//initialize get if not there
		if (!$httpProvider.defaults.headers.get) {
			$httpProvider.defaults.headers.get = {};    
		}    

		//disable IE ajax request caching
		$httpProvider.defaults.headers.get['If-Modified-Since'] = 'Mon, 26 Jul 1997 05:00:00 GMT';
		// extra
		$httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
		$httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
	}
}]);

// Caching helper
application.nocache = parseInt((new Date()).getTime().toString(), 10);

// Application startup
application.run(function($rootScope)
{

});
