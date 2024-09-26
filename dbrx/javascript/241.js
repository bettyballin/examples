const express = require('express');
const helmet = require('helmet');

const app = express();
const PORT = 4000;

app.use(helmet());

// ... other configurations and routes

app.listen(PORT, () => {
  console.log(`Server started on port ${PORT}`);
});