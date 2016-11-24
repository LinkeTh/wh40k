//application instance
var application = angular.module("wh40kbc", []);

//ie helper
function isIE() {
	var myNav = navigator.userAgent.toLowerCase();
	var vIsIE = (myNav.indexOf('msie') != -1) ? parseInt(myNav.split('msie')[1]) : false;

	if (!vIsIE) {
		vIsIE = myNav.indexOf('edge') != -1;
	}

	return vIsIE;
};

//init config
application.config(config);
config.$inject = [ '$httpProvider' ];
function config($httpProvider) {
	console.log('Application::config()');

	if (isIE()) {
		//initialize get if not there
		if (!$httpProvider.defaults.headers.get) {
			$httpProvider.defaults.headers.get = {};
		}

		//disable IE ajax request caching
		$httpProvider.defaults.headers.get['If-Modified-Since'] = 'Mon, 26 Jul 1997 05:00:00 GMT';
		$httpProvider.defaults.headers.get['Cache-Control'] = 'no-cache';
		$httpProvider.defaults.headers.get['Pragma'] = 'no-cache';
	}
};

// Caching helper
application.nocache = parseInt((new Date()).getTime().toString(), 10);

//start app
application.run(startup);
startup.$inject = [ "$rootScope" ];
function startup($rootScope) {
	console.log('Application::startup()');
};


application.filter('totalFilter', function () {
    return function (input, property) {
        var i = input instanceof Array ? input.length : 0;
//if property is not defined, returns length of array
//if array has zero length or if it is not an array, return zero
        if (typeof property === 'undefined' || i === 0) {
            return i;
//test if property is number so it can be counted
        } else if (isNaN(input[0][property])) {
            throw 'filter total can count only numeric values';
//finaly, do the counting and return total
        } else {
            var total = 0;
            while (i--)
                total += input[i][property];
            return total;
        }
    };
});
