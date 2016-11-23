application.service("MasterDataService", [ "$rootScope", "$http",

function($rootScope, $http)
{
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
    
    this.getDisgraces = function()
    {
        $http(
        {
            method : 'GET',
            url : 'http://localhost:9000/api/v1/data/disgraces',
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.disgraces = data;
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.getPrides = function()
    {
        $http(
        {
            method : 'GET',
            url : 'http://localhost:9000/api/v1/data/prides',
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.prides = data;
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };    
    
    this.getMotivations = function()
    {
        $http(
        {
            method : 'GET',
            url : 'http://localhost:9000/api/v1/data/motivations',
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.motivations = data;
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.getSubSkills = function($skill)
    {
        var url = 'http://localhost:9000/api/v1/data/skills/' + $skill.name + '/sub-skills';

        $http(
        {
            method : 'GET',
            url : url,
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
        	console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
        	if(data)
        	{
        		$skill.subskills = data;
        	}
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };

    this.findSubSkills = function($skill)
    {
    	   for (var id in this.skills)
           {
               if (this.skills.hasOwnProperty(id))
               {
            	   if(this.skills[id].name === $skill)
            	   {
            		   return this.skills[id].subskills;
            	   }
               }
           }
    }
    
    this.getSkills = function()
    {
        $http(
        {
            method : 'GET',
            url : 'http://localhost:9000/api/v1/data/skills',
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));

            that.skills = data;

            for ( var skill in that.skills)
            {
                if (that.skills.hasOwnProperty(skill))
                {
                    that.getSubSkills(that.skills[skill]);
                }
            }
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.getTalents = function()
    {
        $http(
        {
            method : 'GET',
            url : 'http://localhost:9000/api/v1/data/talents',
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.talents = data;
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };
    
    this.getClasses = function()
    {
        $http(
        {
            method : 'GET',
            url : 'http://localhost:9000/api/v1/data/classes',
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.classes = data;
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };

    this.getRaces = function()
    {
        $http(
        {
            method : 'GET',
            url : 'http://localhost:9000/api/v1/data/races',
            withCredentials : true,
            cache : false,
        }).success(function(data, status, headers, config)
        {
            console.log("Server Response (" + status + ")\n" + JSON.stringify(data, null, "    "));
            that.races = data;
        }).error(function(data, status, headers, config)
        {
            console.log("Server Error (" + status + ")\n" + JSON.stringify(data, null, "    "));
        });
    };

} ]);
