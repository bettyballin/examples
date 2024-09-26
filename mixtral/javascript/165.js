const io = require('socket.io')();
const jwt = require('jsonwebtoken');

const verifyJWT = (token) => {
  const secretKey = 'your-secret-key'; // Replace with your secret key
  return jwt.verify(token, secretKey);
};

io.use((socket, next) => {
  const token = socket.handshake.headers['jwt_token'];

  try {
    // Verify & decode the jwt
    let decodedToken = verifyJWT(token);

    if (decodedToken && decodedToken.userId) {
      next();

      return;
    }

    throw new Error('Invalid token');

  } catch (error) {
    console.error(error);
    socket.disconnect();
  }
});

io.listen(3000, () => {
  console.log('Server listening on port 3000');
});