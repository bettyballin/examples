// Create an iframe for demonstration purposes
var iframe = document.createElement('iframe');
iframe.src = 'about:blank';
iframe.id = 'my-iframe';
document.body.appendChild(iframe);

// For parent frame
document.domain = 'domain.com';

// For child iframe
window.frames[0].document.domain = 'domain.com';

// Or for a specific named iframe
var myIframe = document.getElementById('my-iframe');
myIframe.contentWindow.document.domain = 'domain.com';