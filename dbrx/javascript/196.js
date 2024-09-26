navigator.geolocation.getCurrentPosition(position => {
  const lat  = position.coords.latitude;
  const long  = position.coords.longitude;

  fetch(`/api/geocode?lat=${lat}&long=${long}`)
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));
});