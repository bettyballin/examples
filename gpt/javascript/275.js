
$scope.loadArticles = function () {
    console.log("loading articles");

    var url = "/api/article/getAll";
    $.ajax({
        type: 'GET',
        url: url,
       
