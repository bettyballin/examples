
// Function to check the Do Not Track status
function doNotTrackEnabled() {
    if (window.doNotTrack || navigator.doNotTrack || navigator.msDoNotTrack || 'msTrackingProtectionEnabled' in window.external) {
        // The browser supports Do Not Track!
        if (window.doNotTrack == "1" || navigator.doNotTrack == "yes" || navigator.doNotTrack == "1" || navigator.msDoNotTrack == "1" || window.external.msTrackingProtectionEnabled()) {
            // Do Not Track is enabled!
            return true;
        }
    }
    return false;
}

// Load Google Analytics if Do Not Track is not enabled
if (!doNotTrackEnabled()) {
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).
