'use strict';
(function () {
  var readerRoute = angular.module('readerRoute');

  readerRoute.config(['$stateProvider', '$urlRouterProvider', config]);

  function config($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/home');
    $stateProvider.state('home',
        {
          url: '/home',
          views:
              {
                'header': {
                  templateUrl: _applicationPath + '/template/header.htm'
                },
                'footer': {
                  templateUrl: _applicationPath + '/template/footer.htm'
                },
                'content':
                    {
                      templateUrl: _applicationPath + '/home/home-content.htm',
                    }
              },
          reload: true,
        });
  }

})();
