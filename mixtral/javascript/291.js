const express = require('express');
const app = express();
const http = require('http').createServer(app);

// ... your middleware and routes here

let port = process.env.PORT || 3000;

http.listen(port, () => {
   console.log(`listening on ${port}`);
});