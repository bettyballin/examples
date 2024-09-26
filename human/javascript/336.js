<div ng-app="myApp" ng-controller="myCtrl">
  <button ng-click="myFunction()">Click me!</button>
</div>

<script>
  var app = angular.module('myApp', []);

  app.controller('myCtrl', function($scope) {
    $scope.myFunction = function() {
      console.log('Button clicked!');
    }
  });
</script>