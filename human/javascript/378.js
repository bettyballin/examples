angular.module('app', [])
  .controller('Ctrl', function($scope) {
    $scope.array1 = [];
    $scope.$on('$destroy', function() {
      // $scope.array1.$destroy(); // $destroy is not a method of JavaScript array
      // assuming array1 is not being used anywhere else
      $scope.array1 = null;
    });
  });