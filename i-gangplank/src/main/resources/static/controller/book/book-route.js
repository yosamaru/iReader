'use strict';
(function()
{
	var readerRoute = angular.module('readerRoute');

  readerRoute.config(['$stateProvider','$urlRouterProvider', config]);
	
	function config($stateProvider, $urlRouterProvider, $scope,)
	{
	    $urlRouterProvider.otherwise('/page/book');
		$stateProvider.state('book',
		{
			url: '/page/book',
            views:
            {
         		'header': { templateUrl: _applicationPath + '/template/header.htm' },
				'footer': { templateUrl: _applicationPath + '/template/footer.htm' },
				'content' : 
				{ 
					templateUrl: _applicationPath + '/book/book-content.htm',
				}
			},
			resolve:
			{
				books:function(bookService){
					return bookService.findAll();
				}
			}
		});

		$stateProvider.state('book-add',
        {
        	url: '/page/book/add',
            views:
            {
			    'footer': { templateUrl: _applicationPath + '/template/footer.htm' },
                'content' :
                {
                    templateUrl: _applicationPath + '/book/book-add.htm',
                }
            },
        });

	}
	                    

	
})();
