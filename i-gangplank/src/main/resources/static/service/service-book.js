'use strict';
(function () {
  var serviceApp = angular.module('readerService');
  serviceApp.factory('bookService', ['$log', '$http', BookService]);

  function BookService($log, $http) {
    var ret = {};

    ret.findAll = function () {
      return $http({
        method: 'GET',
        url: _contextPath + '/book/findAll',
      });
    };

    ret.add = function (book) {
      return $http({
        method: 'POST',
        url: _contextPath + '/book/create',
        data: book
      });
    };

    ret.deleteById = function (id) {
      return $http({
        method: 'GET',
        url: _contextPath + '/book/delete/',
        params: {id: id},
      });
    };

    ret.buy = function (id) {
      return $http({
        method: 'GET',
        url: _contextPath + '/book/buy/',
        params: {id: id},
      });
    };

    ret.newBook = function (formData) {
      return $http({
        method: 'POST',
        url: _contextPath + '/book/newBook/',
        data: formData,
        headers: {'Content-Type': undefined},
        transformRequest: angular.identity,
      });
    };

    ret.searchBook = function (searchBean) {
      return $http({
        method: 'POST',
        url: _contextPath + '/book/search/',
        data: searchBean
      });
    };

    ret.list = function (page, size) {
      return $http({
        method: 'GET',
        url: _contextPath + '/book/list/',
        params: {page: page, size: size}
      });
    };

    return ret;
  }
})();