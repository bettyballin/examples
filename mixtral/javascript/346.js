// server.ts
import express, { Request, Response, NextFunction } from 'express';
import cors from 'cors';

export default function createServer(container: any) {
  const app = express();
  const env = process.env.NODE_ENV;

  // Parse comma-separated string into Array
  let allowedOriginsArray = (process.env.ALLOWED_ORIGINS || '')
    .split(',')
    .map((origin: string) => origin.trim());

  const corsOptions: cors.CorsOptions = {
    // Check if the request's Origin is in our array of allowed origins
    origin: function (origin: string, callback: cors.CorsCallback) {
      if (!allowedOriginsArray?.includes(origin)) {
        return callback(new Error('Not Allowed by CORS'), false);
      }

      return callback(null, true);
    },
  };

  const corsMiddleware = cors(corsOptions);

  app.use(corsMiddleware);

  return app;
}