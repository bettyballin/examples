
if ("geolocation" in navigator) {
  navigator.geolocation.getCurrentPosition(function(position) {
    getCountryCode(position.coords.latitude, position.coords.longitude);
  }, function(error) {
   
