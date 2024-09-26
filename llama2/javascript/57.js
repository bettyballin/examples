const WebSocket = require('ws');
const fs = require('fs');

const ws_uri = 'wss://XYZ:8433/';
const ws_ca = fs.readFileSync('/path/to/fullchain.pem');

const options = {
  rejectUnauthorized: true,
  ca: [ws_ca]
};

const ws = new WebSocket(ws_uri, options);

ws.on('open', function open() {
  console.log('connected');
});

ws.on('message', function incoming(data) {
  console.log(data);
});

ws.on('error', function error(err) {
  console.log(err);
});

ws.on('close', function close() {
  console.log('disconnected');
});