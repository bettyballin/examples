// In http://example.com/page.html:
function handleResponse(data) {
  console.log('received data:', data);
}

var script = document.createElement('script');
script.src = 'http://example.com/callback.js';
document.body.appendChild(script);

// In http://example.com/callback.js:
var data = { message: 'Hello, world!' };
handleResponse(data);