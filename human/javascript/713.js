process.env.MONGO_DB_USERNAME = 'foo';
process.env.MONGO_DB_PASSWORD = 'bar';

const app = require('./app');
app.start();