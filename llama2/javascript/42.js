// Create an iframe to simulate the message event
var iframe = document.createElement('iframe');
iframe.src = 'http://www.example.com';
document.body.appendChild(iframe);

// Add event listener
window.addEventListener("message", function(event) {
    if (event.origin !== "http://www.example.com") return;
    var data = event.data;
    console.log('Received data:', data);
});

// Simulate sending a message from the iframe
iframe.contentWindow.postMessage('Hello from iframe!', 'http://www.example.com');