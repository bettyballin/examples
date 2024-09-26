// Create a basic HTML document
var html = `
  <!DOCTYPE html>
  <html>
    <head>
    </head>
    <body>
      <div id="user"></div>
    </body>
  </html>
`;

// Create a DOM parser
var parser = new DOMParser();

// Parse the HTML document
var doc = parser.parseFromString(html, "text/html");

// Your original code here
var untrustedText = "John Doe"; // Replace with your own text
doc.querySelector('#user').textContent = untrustedText;

// Log the result to the console
console.log(doc.body.innerHTML);