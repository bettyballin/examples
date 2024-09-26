
document.addEventListener("DOMContentLoaded", function() {
    var allowedDomain = "www.mydomain.com";
    
    if (window.location.hostname !== allowedDomain) {
        document.body.innerHTML = '';
        // Optionally, you can also redirect to your domain
        // window.location.href = "http://" + allowedDomain;
    }
});

