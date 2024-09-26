function getCoordinates(address, city, region) {
  const url = `https://maps.googleapis.com/maps/api/geocode/json?address=${address}+${city}+${region}&key=YOUR_API_KEY`;
  const response = await fetch(url);
  const data = await response.json();
  if (data.results.length > 0) {
    return {
      lat: data.results[0].geometry.location.lat,
      lng: data.results[0].geometry.location.lng,
    };
  } else {
    return null;
  }
}

function getDrivingDistance(lat1, lat2, lng1, lng2) {
  const url = `https://maps.googleapis.com/maps/api/distancematrix/json?origins=${lat1},${lng1}&destinations=${lat2},${lng2}&mode=driving&key=YOUR_API_KEY`;
  const response = await fetch(url);
  const data = await response.json();
  if (data.rows.length > 0) {
    return {
      distance: data.rows[0].elements[0].distance.text,
      time: data.rows[0].elements[0].duration.text,
    };
  } else {
    return null;
  }
}

const city = 'Tychy';
const country = 'Poland';
const coordinates1 = getCoordinates('Jana Pawła II', city, 'Śląskie');
const coordinates2 = getCoordinates(city, country);
if (!coordinates1 || !coordinates2) {
  console.log('Bad address.');
} else {
  const dist = getDrivingDistance(coordinates1.lat, coordinates2.lat, coordinates1.lng, coordinates2.lng);
  console.log(`Distance: <b>${dist.distance}</b><br>Travel time duration: <b>${dist.time}</b>`);
}