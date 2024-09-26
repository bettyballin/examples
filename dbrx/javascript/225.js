import { RSocketClient, BufferEncoders } from 'rsocket-core';
import RSocketWebSocketClient from 'rsocket-websocket-client';

const client = new RSocketClient({
  setup: {
    keepAlive: 60000,
    lifetime: 180000,
    dataMimeType: 'application/json',
    metadataMimeType: 'message/x.rsocket.authentication.v0+json'
  },
  transport: new RSocketWebSocketClient({
    url: 'ws://localhost:8080',
    wsCreator: (url) => new WebSocket(url, 'echo-protocol')
  })
});

client.connect().then(() => {
  console.log('Connected to server');
}).catch((error) => {
  console.error('Error connecting to server:', error);
});