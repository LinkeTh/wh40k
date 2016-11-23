application.controller("CreationController", [ "$scope", "$window", "$rootScope", "$location", "CreationService", "MasterDataService",

function($scope, $window, $rootScope, $location, CreationService, MasterDataService)
{
    console.log("CreationController::CreationController()");
    
    MasterDataService.getRaces();
    MasterDataService.getClasses();
    MasterDataService.getSkills();
    MasterDataService.getTalents();
    MasterDataService.getDisgraces();
    MasterDataService.getMotivations();
    MasterDataService.getPrides();
    $scope.checkedSkills = 0;
    
	$scope.checkChanged = function(item, checked){
	    if(item.checked) 
	    	$scope.checkedSkills++;
	    else 
	    	$scope.checkedSkills--;
	}

    		
    $scope.acceptCharacteristicsRolls = function ()
    {
        $scope.acceptedCharacteristics = true;
        if(CreationService.character)
        {
        	CreationService.addCharacteristics(CreationService.characteristics);
        }
    };
    
    $scope.acceptWoundsRolls = function ()
    {
        $scope.acceptedWounds = true;
        if(CreationService.character)
        {
        	CreationService.addWounds(CreationService.wounds);
        }
    }
    
    $scope.debug = true;    

    $scope.debugCharacter = function ()
    {
        return JSON.stringify(CreationService.character, undefined, 2);
    }
    
    $scope.setClass = function($class)
    {
        if(CreationService.character)
        {
        	CreationService.addClass($class);

        	console.log(CreationService.character);
        	CreationService.talents = [];
        	CreationService.skills = [];
        	
            CreationService.getSkillsForRace(CreationService.character.race);
            CreationService.getTalentsForRace(CreationService.character.race);
            CreationService.getSkillsForClass($class);
            CreationService.getTalentsForClass($class);
        }
    }
        
    $scope.createNewCharacter = function($race)
    {
        CreationService.createCharacter($race);

        $scope.selectedClass = null;  
        $scope.acceptedCharacteristics = false;
        $scope.acceptedWounds = false;

        CreationService.characteristics = null;
    };
    
    $scope.masterData = function()
    {
        return MasterDataService;
    }; 
    
    $scope.creation = function()
    {
        return CreationService;
    }; 
        
} ]);