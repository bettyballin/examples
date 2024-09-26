const express = require('express');
const axios = require('axios');

const app = express();

app.get('/proxy', async (req, res) => {
  const url = req.query.url;

  try {
    const response = await axios(url);

    // Send the fetched data back to your client-side JavaScript
    return res.send(response.data);

  } catch (error) {

    console.log('Error fetching URL:', error);

    // Return an appropriate HTTP status code and message
    return res
      .status(502)
      .json({
        success: false,
        reason: 'Bad Gateway'
      });
  }
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});