
app.controller('MyController', function($scope) {
    $scope.addValueToDB = function() {
        alert("Adding Record");
        // Your logic to add value to DB
    };

    $scope.listDBValues = function() {
        alert("Refresh Records");
        // Your logic to list DB values
    };
});

