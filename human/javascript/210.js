var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-3.6.0.min.js';
document.body.appendChild(script);
script.onload = function() {
  $("<a>").attr("href", 'http://www.mydomain.com/application.html'+location.search).text("Apply now").appendTo(document.body);
};