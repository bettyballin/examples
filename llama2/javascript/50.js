// Create a new HTML document
var html = document.createElement('html');

// Create a new script element
var script = document.createElement('script');

// Add the JavaScript code to the script element
script.textContent = `
  window.addEventListener("message", function(event) {
    console.log(event);
  });
`;

// Add the script element to the HTML document
html.appendChild(script);

// Create a new iframe element
var iframe = document.createElement('iframe');

// Set the srcdoc attribute of the iframe to the HTML document
iframe.srcdoc = html.outerHTML;

// Add the iframe to the current document
document.body.appendChild(iframe);

// Send a message to the iframe
iframe.contentWindow.postMessage('Hello, world!', '*');