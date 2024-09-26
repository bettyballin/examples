window.addEventListener("message", function(e) {
    if (window.location.href.indexOf(e.origin) === 0 && e.source === window) {
        // passed safety check, OK to process here
        console.log("passed");
    }
});

// Test the code
window.postMessage("Test", window.location.origin);