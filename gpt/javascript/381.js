
const express = require('express');
const helmet = require('helmet');

const app = express();

// Define your CSP
const cspConfig = {
  directives: {
    defaultSrc: ["'self'"],
    scriptSrc: ["'self'", 'https://stackpath.bootstrapcdn.com'], // Add your CDN's URL here
    styleSrc: ["'self'", 'https://stackpath.bootstrapcdn.com', 'https://use.fontawesome.com'], // And here
    // add other resource directives as needed
  },
};

