application.service("MasterDataService", MasterDataService);
MasterDataService.$inject = [ "$rootScope", "$http" ];
function MasterDataService($rootScope, $http) {
	console.log("MasterDataService::MasterDataService()");

	var that = this;

	this.races = [];
	this.classes = [];
	this.skills = [];
	this.talents = [];
	this.motivations = [];
	this.disgraces = [];
	this.prides = [];
	this.weapons = [];
	this.armors = [];
	this.miscItems = [];
	this.spells = [];

	this.getDisgraces = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9000/api/v1/data/disgraces',
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.disgraces = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getPrides = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9000/api/v1/data/prides',
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.prides = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getMotivations = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9000/api/v1/data/motivations',
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.motivations = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getSubTalents = function($talent) {
		var url = 'http://localhost:9000/api/v1/data/talents/' + $talent.name + '/sub-talents';

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			if (data) {
				$talent.subtalents = data.data;
			}
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getSubSkills = function($skill) {
		var url = 'http://localhost:9000/api/v1/data/skills/' + $skill.name + '/sub-skills';

		$http({
			method : 'GET',
			url : url,
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			if (data) {
				$skill.subskills = data.data;
			}
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.findSubTalents = function($talent) {
		for ( var id in this.talents) {
			if (this.talents.hasOwnProperty(id)) {
				if (this.talents[id].name === $talent) {
					return this.talents[id].subtalents;
				}
			}
		}
	};

	this.findSubSkills = function($skill) {
		for ( var id in this.skills) {
			if (this.skills.hasOwnProperty(id)) {
				if (this.skills[id].name === $skill) {
					return this.skills[id].subskills;
				}
			}
		}
	};

	this.getSkills = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9000/api/v1/data/skills',
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));

			that.skills = data.data;

			for ( var skill in that.skills) {
				if (that.skills.hasOwnProperty(skill) && that.skills[skill].specialisable) {
					that.getSubSkills(that.skills[skill]);
				}
			}
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getTalents = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9000/api/v1/data/talents',
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.talents = data.data;

			for ( var talent in that.talents) {
				if (that.talents.hasOwnProperty(talent) && that.talents[talent].specialisable) {
					that.getSubTalents(that.talents[talent]);
				}
			}
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getClasses = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9000/api/v1/data/classes',
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.classes = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};

	this.getRaces = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9000/api/v1/data/races',
			withCredentials : true,
			cache : false,
		}).then(function success(data) {
			console.log("Server Response (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
			that.races = data.data;
		}, function error(data) {
			console.log("Server Error (" + data.status + ")\n" + JSON.stringify(data.data, null, "    "));
		});
	};
};
