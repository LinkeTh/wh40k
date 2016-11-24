application.service("CreationService", CreationService);

CreationService.$inject = [ "$rootScope", "$http" ];

function CreationService($rootScope, $http) {

	console.log("CreationService::CreationService()");

	var that = this;

	this.availableClasses = [];
	this.character = {};
	this.characteristics = [];
	this.skills = [];
	this.talents = [];
	this.wounds = {};

	this.getSkillsForRace = function($race) {
		var url = 'http://localhost:9000/api/v1/creation/races/' + $race.name + "/skills";

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.skills.push(data.data);
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};
	this.getSkillsForClass = function($class) {
		var url = 'http://localhost:9000/api/v1/creation/classes/' + $class.name + "/skills";

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.skills.push(data.data);
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};
	this.getTalentsForRace = function($race) {
		var url = 'http://localhost:9000/api/v1/creation/races/' + $race.name + "/talents";

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.talents.push(data.data);
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};
	this.getTalentsForClass = function($class) {
		var url = 'http://localhost:9000/api/v1/creation/classes/' + $class.name + "/talents";

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.talents.push(data.data);
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getWounds = function($class) {
		var url = 'http://localhost:9000/api/v1/creation/classes/' + $class.name + "/wounds";

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.wounds = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getCharacteristics = function($race) {
		var url = 'http://localhost:9000/api/v1/creation/races/' + $race.name + "/characteristics";

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.characteristics = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getAvailableClasses = function($race) {
		var url = 'http://localhost:9000/api/v1/creation/races/' + $race.name + "/classes";

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.availableClasses = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getCharacter = function($id) {
		var url = 'http://localhost:9000/api/v1/creation/character/' + $id;

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.character = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.addWounds = function($wounds) {
		var url = 'http://localhost:9000/api/v1/creation/character/' + this.character.id + '/wounds';

		$http({
			method : 'PUT',
			url : url,
			withCredentials : true,
			cache : false,
			data : $wounds,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.character = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.addClass = function($clazz) {
		var url = 'http://localhost:9000/api/v1/creation/character/' + this.character.id + '/class';

		$http({
			method : 'PUT',
			url : url,
			withCredentials : true,
			cache : false,
			data : $clazz,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.character = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.addCharacteristics = function($characteristics) {
		var url = 'http://localhost:9000/api/v1/creation/character/' + this.character.id + '/characteristics';

		$http({
			method : 'PUT',
			url : url,
			withCredentials : true,
			cache : false,
			data : $characteristics,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.character = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.createCharacter = function($race) {
		var url = 'http://localhost:9000/api/v1/creation/character';//race/' + $race.name;

		$http({
			method : 'POST',
			url : url,
			withCredentials : true,
			cache : false,
			data : $race,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.character = data.data;
			that.getAvailableClasses($race);

		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};
};
