application.service("CreationService", [ "$rootScope", "$http",

function($rootScope, $http)
{
    console.log("CreationService::CreationService()");

    var that = this;

    this.availableClasses = [];
    this.character = {};
    this.characteristics = [];
    this.skills = [];
    this.talents = [];
    this.wounds = {};
        
    this.getSkillsForRace = function($race)
    {
        var url = 'http://localhost:9000/api/v1/creation/races/' + $race.name + "/skills";

        $http(
        {
            method : 'GET',
            url : url,
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.skills.push(data);
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    this.getSkillsForClass = function($class)
    {
        var url = 'http://localhost:9000/api/v1/creation/classes/' + $class.name + "/skills";

        $http(
        {
            method : 'GET',
            url : url,
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.skills.push(data);
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    this.getTalentsForRace = function($race)
    {
        var url = 'http://localhost:9000/api/v1/creation/races/' + $race.name + "/talents";

        $http(
        {
            method : 'GET',
            url : url,
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.talents.push(data);
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    this.getTalentsForClass = function($class)
    {
        var url = 'http://localhost:9000/api/v1/creation/classes/' + $class.name + "/talents";

        $http(
        {
            method : 'GET',
            url : url,
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.talents.push(data);
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.getWounds = function($class)
    {
        var url = 'http://localhost:9000/api/v1/creation/classes/' + $class.name + "/wounds";

        $http(
        {
            method : 'GET',
            url : url,
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.wounds = data;
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.getCharacteristics = function($race)
    {
        var url = 'http://localhost:9000/api/v1/creation/races/' + $race.name + "/characteristics";

        $http(
        {
            method : 'GET',
            url : url,
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.characteristics = data;
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.getAvailableClasses = function($race)
    {
        var url = 'http://localhost:9000/api/v1/creation/races/' + $race.name + "/classes";

        $http(
        {
            method : 'GET',
            url : url,
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.availableClasses = data;
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.getCharacter = function($id)
    {
        var url = 'http://localhost:9000/api/v1/creation/character/' + $id;

        $http(
        {
            method : 'GET',
            url : url,
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.character = data;            
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.addWounds = function($wounds)
    {
        var url = 'http://localhost:9000/api/v1/creation/character/' + this.character.id + '/wounds';

        $http(
        {
            method : 'PUT',
            url : url,
            withCredentials : true,
            cache : false,
            data : $wounds,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.character = data;                      
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.addClass = function($clazz)
    {
        var url = 'http://localhost:9000/api/v1/creation/character/' + this.character.id + '/class';

        $http(
        {
            method : 'PUT',
            url : url,
            withCredentials : true,
            cache : false,
            data : $clazz,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.character = data;                      
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.addCharacteristics = function($characteristics)
    {
        var url = 'http://localhost:9000/api/v1/creation/character/' + this.character.id + '/characteristics';

        $http(
        {
            method : 'PUT',
            url : url,
            withCredentials : true,
            cache : false,
            data : $characteristics,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.character = data;                      
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.createCharacter = function($race)
    {
        var url = 'http://localhost:9000/api/v1/creation/character';//race/' + $race.name;

        $http(
        {
            method : 'POST',
            url : url,
            withCredentials : true,
            cache : false,
            data : $race,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.character = data;            
            that.getAvailableClasses($race);       
            
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
} ]);
