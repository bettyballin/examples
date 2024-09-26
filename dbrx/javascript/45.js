// Create iframe with content from another origin
var iframe = document.createElement('iframe');
iframe.src = 'http://another.origin.example.com/';
document.body.appendChild(iframe);

// Listen for messages
window.addEventListener('message', function(event) {
  console.log('received message:', event.data);
}, false);

// Send a message to the iframe
iframe.contentWindow.postMessage('Hello from origin: ' + window.location.href, '*');