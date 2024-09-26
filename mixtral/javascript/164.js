// Replace 'yourwebsite.com' and '/path' with your actual WebSocket endpoint
// Replace 'jwtToken' with your actual JWT token

const jwtToken = 'your_jwt_token_here';
var wsProtocol = 'jwt-' + jwtToken;

const socket = new WebSocket('ws://yourwebsite.com/path', wsProtocol);

socket.onopen = function(event) {
  console.log('Connection established');
};

socket.onmessage = function(event) {
  console.log('Message received: ' + event.data);
};

socket.onerror = function(event) {
  console.log('Error occurred');
};

socket.onclose = function(event) {
  console.log('Connection closed');
};