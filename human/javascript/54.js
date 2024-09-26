var randomNumber = Math.floor(Math.random() * 1000000);
var url = "http://example.com/foo.html?q=" + randomNumber;
window.location.href = url;