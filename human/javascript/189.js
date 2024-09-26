const jsdom = require("jsdom");
const { JSDOM } = jsdom;

// html with two input elements
const html = `
<!DOCTYPE html>
<html>
<head>
</head>
<body>
  <input type="text" id="input1">
  <input type="button" id="input2" onclick="console.log('Button clicked!');">
</body>
</html>
`;

// create a new JSDOM instance
const dom = new JSDOM(html);

// get the second input element and simulate a click
dom.window.document.getElementsByTagName('input')[1].click();