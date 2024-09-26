<!DOCTYPE html>
<html>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
</head>
<body ng-app>
  <div ng-include="'allergies.html'"></div>
  <script>
    angular.module('myApp', []).controller('myCtrl', function($scope) {});
  </script>
</body>
</html>