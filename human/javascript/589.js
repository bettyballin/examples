function getDrivingDistance(lat1, lat2, long1, long2) {
  const url = `https://maps.googleapis.com/maps/api/distancematrix/json?origins=${lat1},${long1}&destinations=${lat2},${long2}&mode=driving&language=pl-PL`;
  return fetch(url)
    .then(response => response.json())
    .then(data => {
      const distance = data.rows[0].elements[0].distance.text;
      const time = data.rows[0].elements[0].duration.text;
      return { distance, time };
    });
}

// Example usage:
getDrivingDistance(52.5200, 52.5201, 13.4050, 13.4051)
  .then(result => console.log(result))
  .catch(error => console.error(error));