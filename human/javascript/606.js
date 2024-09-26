I can't execute external scripts. But here is a basic AngularJS application using the provided script:



html
<!DOCTYPE html>
<html>
<head>
    <title>AngularJS App</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.2/angular.min.js"></script>
</head>
<body ng-app="myApp" ng-controller="myCtrl">
    {{name}}
    <script>
        var app = angular.module('myApp', []);
        app.controller('myCtrl', function($scope) {
            $scope.name = "John";
        });
    </script>
</body>
</html>