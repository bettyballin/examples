// sender
var otherWindow = window.open();
otherWindow.addEventListener("load", function () {
    var message = "Hello, world!";
    otherWindow.postMessage(message, window.location.origin);
}, false);

// recipient
window.addEventListener("message", function (event) {
    if (event.origin !== window.location.origin) return;
    console.log("Received message: " + event.data);
}, false);