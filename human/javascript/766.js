const express = require('express');
const path = require('path');

const app = express();

app.set('views', path.join(__dirname, '/yourViewDirectory'));