navigator.geolocation.getCurrentPosition(position => {
  var lat = position.coords.latitude;
  var long = position.coords.longitude;
  var targetUrl = (`https://example.com/maps_api/?lat=${lat}&long=${long}`);
  fetch(targetUrl)
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));
});