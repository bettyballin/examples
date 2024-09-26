// Use a real URL for demonstration purposes
var url = 'https://api.github.com/users/octocat';

$.getJSON(url, function(data){
    alert(data.login);
});