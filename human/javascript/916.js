const Cors = require('cors');
const express = require('express');
const app = express();

const allowedOrigins = process.env.ALLOWED_ORIGINS.split(',').map(origin => origin);

const cors = Cors({
  origin: (origin, callback) => {
    allowedOrigins.includes(origin) ? callback(null, true) : callback(new Error('Not allowed by CORS'))
  },
  allowedHeaders: [
    'access-control-allow-origin',
    'authorization',
    'Pragma',
    'contact',
  ],
  exposeHeaders: []
});

app.use(cors);

app.get('/', (req, res) => {
  res.send('Hello World!');
});

const port = 3000;
app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`);
});