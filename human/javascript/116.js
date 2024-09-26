// Create a HTML document
const html = `
  <html>
    <body>
      <div id="secureWarn">Secure Warning</div>
    </body>
  </html>
`;

// Create a jQuery object
const $ = require('jquery')(html);

// Your code here
$(document).ready(function(e) {
    $("#secureWarn").remove();
});

// Print the result
console.log($.html());