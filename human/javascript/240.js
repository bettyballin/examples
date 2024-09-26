var user_input = "Hello, World!";
var escaped_input = user_input.replace(/'/g, "&#39;");
console.log(eval("'" + escaped_input + "' some more stuff '" + escaped_input + "'"));