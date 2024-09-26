const env = process.env.NODE_ENV;
const rawAllowedOrigins = (process.env.ALLOWED_ORIGINS || '').split(',');
const allowedOrigins = rawAllowedOrigins.map(origin => origin.trim());