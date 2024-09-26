const express = require('express');
const session = require('express-session');
const RedisStore = require('connect-redis')(session);
const redis = require('redis');

const app = express();
const client = redis.createClient();

app.use(session({
  store: new RedisStore({ client }),
  key: 'example.sid',
  secret: 'keyboard cat',
  cookie: { domain: '.example.io' }
}));