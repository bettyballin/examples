
// In the parent window
window.addEventListener('message', function(event) {
    // Always check the origin of the data!
    if (event.origin !== "http://example.com") { // replace with the origin you trust
        return;
    }

    // Handle the message
    if (event.data === 'getScrollTop') {
        // Send back the scrollTop position to the iframe
        event.source.postMessage(window.scrollTop, event.origin);
    }
}, false);

