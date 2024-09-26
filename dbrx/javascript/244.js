const Cors = require('cors');
const allowedOrigins = ['http://example1.com', 'http://example2.com'];

const cors = Cors({
  origin: allowedOrigins,
  methods: ['GET', 'POST'],
  credentials: true
});