
var getUrl = function() {
    // Call some endpoint to get the URL, then on success:
    var newWindow = $window.open(url, '_blank');

    // If the window was successfully opened
    if (newWindow) {
        // This disowns the new window, similar to rel="noopener"
        newWindow.opener = null;
        
        // For extra security, you could also set the referrer to no-referrer
        newWindow.document.referrer = 'no-referrer';
