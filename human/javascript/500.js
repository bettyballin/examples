var html = '<figure class="op-tracker">' +
           '  <iframe src="http://my-url.com/tracker.php"></iframe>' +
           '</figure>';

var parser = new DOMParser();
var doc = parser.parseFromString(html, 'text/html');

// get the iframe element
var iframe = doc.querySelector('iframe');

// create a new iframe element
var newIframe = document.createElement('iframe');
newIframe.src = iframe.src;

// append the new iframe to the body of the current document
document.body.appendChild(newIframe);