// In http://example.com/page.html
document.domain = 'example.com';

var iframe = document.createElement('iframe');
iframe.src = 'http://subdomain.example.com/otherpage.html';
document.body.appendChild(iframe);

// Listen for messages from the child frame
window.addEventListener('message', function(event) {
  console.log('received message:', event.data);
}, false);

// In http://subdomain.example.com/otherpage.html:
document.domain = 'example.com';

parent.postMessage('Hello parent!', '*');