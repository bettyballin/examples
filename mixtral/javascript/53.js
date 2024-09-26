const tls = require('tls');
const fs = require('fs');

// Load certificates
var options = {
    key: fs.readFileSync('./server-key.pem'),
    cert: fs.readFileSync('./server-cert.pem')
};

// Create a server
var server = tls.createServer(options, function (socket) {
  // Handle socket
  console.log('Client connected');

  socket.on('data', (data) => {
    console.log('Received data: %s', data);
  });

  socket.on('close', () => {
    console.log('Client disconnected');
  });
});

server.listen(8000, () => {
  console.log('TLS server listening on port 8000');
});