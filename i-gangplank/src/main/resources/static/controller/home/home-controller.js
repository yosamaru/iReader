'use strict';
(function()
{
	var app = angular.module('ireader');
	app.controller('HomeController', ['$scope', '$state', 'checkService', HomeController]);

    	function HomeController($scope, $state, checkService)
    	{
    	    checkService.check().then(function(result){

                if(result.data.content==0) {
                    sessionStorage.setItem('userType', 0);
                }else if(result.data.content==1){
                    sessionStorage.setItem('userType', 1);
                }
            });

    	    var userType = sessionStorage.getItem('userType');
                // 普通用户
                if(userType==0 || userType==1){
                     if(userType == 0){
                        $scope.generic = true;
                        $scope.generich = true;
                        $scope.genericlogin = false;
                        $scope.genericregister = false;
                        $scope.genericloginOut = true;

                        $scope.moderator = false;

                     }else{
                        $scope.moderator = true;
                        $scope.moderatorh = true;
                        $scope.moderatorlogin = false;
                        $scope.moderatorregister = false;
                        $scope.moderatorloginOut = true;

                        $scope.generic = false;
                     }
                }

                if(userType==null || typeof(userType) == "undefined" || isNaN(userType)){
                    $scope.generic = true;
                    $scope.generich = true;
                    $scope.genericlogin = true;
                    $scope.genericregister = true;
                    $scope.genericloginOut = true;

                    $scope.moderator = true;
                    $scope.moderatorh = true;
                    $scope.moderatorlogin = true;
                    $scope.moderatorregister = true;
                    $scope.moderatorloginOut = true;
                }
    	}
	                                      
})();
