
var expectedOrigin = 'https://www.somedomain.com';

window.addEventListener("message", function(event) {
    if (event.origin !== expectedOrigin) {
        // The message does not come from the expected origin.
        return;
    }

    // Assuming you trust the source and have validated the
