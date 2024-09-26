<!DOCTYPE html>
<html ng-app="plunker">
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular.min.js"></script>
</head>
<body>
  <div ng-controller="MainCtrl">
    <div ng-bind-html="x"></div>
  </div>
  <script>
    var app = angular.module('plunker', []);

    angular.module('plunker').config(function ($sceProvider) {
      $sceProvider.enabled(false);
    });

    app.controller('MainCtrl', function($scope) {
      $scope.name = 'World';
      $scope.x ='&lt;img src="wrongUrl" onerror="alert(1)"/&gt;';
    });
  </script>
</body>
</html>