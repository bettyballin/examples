window.addEventListener('message', function(event) {
  console.log('Received message:', event.data);
}, false);

// Optionally send a response back to the parent page:
parent.postMessage('Hi there Parent Page!', '*');