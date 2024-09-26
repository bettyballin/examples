Here is the executable JavaScript code:


const express = require('express');
const axios = require('axios');

const app = express();

app.get('/gmapAPI', async (req, res) => {
  const lat = req.query.lat || 'default_fb_value';
  const long = req.query.long || 'default_fb_value';
  const apikey_gmaps = "#KEY_OR_GET_FROM_ENV";

  const url = `https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=${lat},${long}&rankby=distance&key=${apikey_gmaps}`;

  try {
    const response = await axios.get(url);
    console.log(response.data);
    res.json(response.data);
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: 'Error occurred' });
  }
});

app.listen(3000, () => {
  console.log('Server started on port 3000');
});