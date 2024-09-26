function receiveMessage(event) {  
    if (event.origin !== "http://example.org:8080") return;
    console.log("Received message:", event.data);
}

window.addEventListener("message", receiveMessage, false);

// Example usage:
window.postMessage("Hello, world!", "http://example.org:8080");