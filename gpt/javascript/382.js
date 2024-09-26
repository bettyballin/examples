
import Cors from 'cors';

export default createServer = (container) => {
  const env = process.env.NODE_ENV;
  const allowedOriginsEnv = process.env.ALLOWED_ORIGINS || '';
  const allowedOrigins = allowedOriginsEnv.split(',').map(origin => origin.trim()); // Split the string into an array and trim whitespace

  const corsOptions = {
    origin: function (origin, callback) {
      if (!origin || allowedOrigins.indexOf(origin) !== -1) {
        callback(null, true);
      } else {
        callback(new Error('Not allowed by CORS'));
      }
    },
    allowedHeaders: [
      'Access-Control-Allow-Origin',
      'Authorization
