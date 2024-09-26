
// Function to create an iframe and attach a load event listener
function createIframeWithLoadListener(src, callback) {
    var iframe = document.createElement('iframe');
    iframe.src = src;
    iframe.onload = function() {
        callback();
        // You can set a property or dispatch a custom event, etc.
        this.complete = true; 
    };
    document.body.appendChild(iframe); // Append iframe to the desired parent element
}

// Usage
createIframeWithLoadListener('https://example.com', function() {
    console.log('Iframe loaded!');
});

