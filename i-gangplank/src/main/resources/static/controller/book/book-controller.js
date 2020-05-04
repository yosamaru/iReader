'use strict';
(function()
{
	var app = angular.module('ireader');
	app.controller('BookController', ['$scope', '$state', '$rootScope', 'bookService', 'authorService', 'publisherService', 'categoryService', 'checkService', BookController]);

	function BookController($scope, $state, $rootScope, bookService, authorService, publisherService, categoryService, checkService)
	{

        var userType = sessionStorage.getItem('userType');
        if(userType==null || typeof(userType) == "undefined" || isNaN(userType)){
            //$state.go('home',{cache:true},{reload: true});
            $scope.addShow=0;
        }else{
            $scope.addShow=userType;
        }

        checkService.check().then(function(result){
            if(result.data.errCode != 0000) {
//               alert(result.data.errMessage);
               sessionStorage.setItem('userType', null);
//               $state.go('home', {cache:true},{reload: true});
            }else if(result.data.content==0) {
                sessionStorage.setItem('userType', 0);
            }else {
                sessionStorage.setItem('userType', 1);
            }
        });

		$scope.refresh = function()
		{
			bookService.findAll().then(function(result)
			{
			    console.log(result.data.content);
				$scope.books = result.data.content;
			});
		};

		$scope.add = function()
		{
			bookService.add().then(function(result)
			{
				$scope.refresh();
			});
		};

		$scope.buy = function(id)
        {
            if(userType==null || typeof(userType) == "undefined" || isNaN(userType)){
                //$state.go('home',{cache:true},{reload: true});
                $state.go("home");
            }else{
                bookService.buy(id).then(function(result)
                {
                    if(result.data.errCode != 0000) {
                       alert(result.data.errMessage);
                       $scope.refresh();
                    }else{
                       alert(result.data.errMessage);
                       $state.go("contract");
                    }
                });
            }
        };

		$scope.remove = function(id)
		{
			bookService.deleteById(id).then(function(result)
			{
                $scope.refresh();
			});
		};

		$scope.searchBook = function()
        {
            console.log('$scope.searchBean'+$scope.searchBean)
            if(typeof($scope.searchBean)=="undefined"){
                $scope.searchBean.subject="";
                $scope.searchBean.author = "";
                $scope.searchBean.publisher = "";
                $scope.searchBean.category = "";
            }

            bookService.searchBook($scope.searchBean).then(function(result) {
                $scope.books = result.data.content;
            });
        };


		$scope.submitForm = function () {
          var formData = new FormData();
          var bookBean =JSON.stringify($scope.bookBean);
          console.log("bookInfo:"+bookBean);
          var bookFile = document.getElementById("bookFile").files[0];

          console.info("bookFile:"+bookFile);

          formData.append("bookFile", bookFile);
          formData.append("bookInfo", bookBean);
          bookService.newBook(formData).then(function(result)
          {
            $state.go('book');
          });
//          bookService.add($scope.bookBean).then(function(result)
//          {
//            $state.go('book');
//          });
        }

         authorService.findAll().then(function(result)
        {
            $scope.authors = result.data.content;
        });

        publisherService.findAll().then(function(result)
        {
            $scope.publishers = result.data.content;
        });


        categoryService.findAll().then(function(result)
        {
            $scope.categorys = result.data.content;
        });


         bookService.findAll().then(function(result)
        {
            console.log(result.data.content);
            $scope.books = result.data.content;
        });

         bookService.list().then(function (result) {
             console.log(result.data.content);
         });

	}


})();