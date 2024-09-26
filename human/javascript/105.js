var otherWindow = window.open("http://example.org:8080");
var message = "Hello, world!";
otherWindow.postMessage(message, "http://example.org:8080");