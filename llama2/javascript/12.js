window.addEventListener('opener', function(event) {
  event.preventDefault();
  var newLocation = 'http://parent.com:8888';
  window.location.href = newLocation;
});