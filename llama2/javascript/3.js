// Create an iframe for demonstration purposes
var iframe = document.createElement('iframe');
document.body.appendChild(iframe);

// In the parent window
window.addEventListener("message", function(event) {
  if (event.data === "getScrollTop") {
    event.source.postMessage(document.body.scrollTop, "*");
  }
});

// Simulate a message from the iframe
iframe.contentWindow.postMessage("getScrollTop", "*");

// In the iframe (for demonstration purposes)
iframe.contentWindow.addEventListener("message", function(event) {
  console.log("Received message from parent:", event.data);
});