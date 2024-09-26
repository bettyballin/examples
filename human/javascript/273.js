// Create a new iframe element
const iframe = document.createElement('iframe');
iframe.id = 'your-frame-id';
iframe.src = 'https://your-second-site.example';

// Add the iframe to the body of the HTML document
document.body.appendChild(iframe);

// Get a reference to the iframe
const frame = document.getElementById('your-frame-id');

// Define a variable or object to post to the iframe
const data = { foo: 'bar' };

// Post the data to the iframe
frame.contentWindow.postMessage(data, 'https://your-second-site.example');