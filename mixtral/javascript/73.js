const express = require('express');
const cors = require('cors');
const cookieSession = require('cookie-session');

const app = express();

app.use(
  cors({
    origin: ["https://example.io", "https://app.example.io"],
    credentials: true
  })
);

app.set('trust proxy', 1); // trust first proxy

app.use(
  cookieSession({
    name: 'example_sid',
    keys: ['key1', 'key2'],
    // Cookie Options
    maxAge: 30 * 60 * 1000,
    httpOnly: true,
    secure: process.env.NODE_ENV === "production",
    sameSite: process.env.NODE_ENV === 'development' ? 'lax' : 'none',
    // CORS
    domain: '.example.io'
  })
);