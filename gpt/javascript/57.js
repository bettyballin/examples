
function canAccessIframe(iframe) {
    var html = null;

    try {
        // Browser security will throw an error if the iframe is from another domain.
        var doc = iframe.contentDocument || iframe.contentWindow.document;
        html = doc.body.innerHTML; // Try to access iframe content.
    } catch (e) {
        // We can't access the iframe content due to Same-Origin Policy.
        return false;
    }

    // If no error was thrown, we should have access to the iframe content.
    return true;
}

var iframe = document.getElementById('myiframe');
iframe.onload = function() {
    if (canAccessIframe(iframe)) {
        // Safe to access iframe properties here.
    } else {
        // Handle the case where we
